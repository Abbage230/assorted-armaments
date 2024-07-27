package team.leomc.assortedarmaments.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import team.leomc.assortedarmaments.registry.AAEntityTypes;
import team.leomc.assortedarmaments.registry.AAItems;

public class ThrownFlail extends ThrowableItemProjectile {
	private boolean hitTarget;

	public ThrownFlail(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
		super(entityType, level);
	}

	public ThrownFlail(Level level, LivingEntity shooter) {
		super(AAEntityTypes.FLAIL.get(), shooter, level);
		updateOwnerInfo(this);
	}

	@Override
	protected Item getDefaultItem() {
		return AAItems.WOODEN_FLAIL.get();
	}

	@Override
	public void tick() {
		super.tick();
		Entity owner = getOwner();
		if (owner != null) {
			if (owner.distanceTo(this) > 8 || tickCount > 200) {
				hitTarget = true;
			}
			if (hitTarget) {
				noPhysics = true;
				Vec3 vec3 = owner.getEyePosition().subtract(this.position());
				this.setPosRaw(this.getX(), this.getY() + vec3.y * 0.045, this.getZ());
				this.setDeltaMovement(this.getDeltaMovement().scale(0.95).add(vec3.normalize().scale(0.15)));
			}
		}
	}

	@Override
	public void playerTouch(Player player) {
		if (hitTarget) {
			discard();
		}
	}

	@Nullable
	@Override
	public ItemStack getWeaponItem() {
		return getItem();
	}

	@Override
	protected void onHit(HitResult result) {
		super.onHit(result);
		hitTarget = true;
	}

	@Override
	protected void onHitEntity(EntityHitResult result) {
		super.onHitEntity(result);
		Entity entity = result.getEntity();
		if (entity != getOwner()) {
			DamageSource source = getPlayerOwner() != null ? this.damageSources().playerAttack(this.getPlayerOwner()) : (getOwner() instanceof LivingEntity living ? this.damageSources().mobAttack(living) : this.damageSources().thrown(this, getOwner()));
			float damage = getOwner() instanceof LivingEntity living && living.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? (float) living.getAttributeValue(Attributes.ATTACK_DAMAGE) : 5;
			float knockback = getOwner() instanceof LivingEntity living && living.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK) ? living.getKnockback(entity, source) : 1;
			damage *= 2;
			knockback *= 2;
			if (level() instanceof ServerLevel serverLevel && getWeaponItem() != null) {
				damage = EnchantmentHelper.modifyDamage(serverLevel, getWeaponItem(), entity, source, damage);
			}
			if (entity.hurt(source, damage) && level() instanceof ServerLevel serverLevel) {
				EnchantmentHelper.doPostAttackEffectsWithItemSource(serverLevel, entity, source, getWeaponItem());
			}
			if (knockback > 0.0F && entity instanceof LivingEntity living && getOwner() != null) {
				double x = getOwner().getX() - entity.getX();
				double z = getOwner().getZ() - entity.getZ();
				double d = x * x + z * z;
				if (d != 0) {
					living.knockback(knockback * 0.5F, x / d, z / d);
				}
			}
		}
	}

	@Override
	protected void onHitBlock(BlockHitResult result) {
		super.onHitBlock(result);
		if (!hitTarget) {
			setDeltaMovement(Vec3.ZERO);
		}
	}

	@Override
	public void remove(Entity.RemovalReason removalReason) {
		this.updateOwnerInfo(null);
		super.remove(removalReason);
	}

	@Override
	public void onClientRemoval() {
		this.updateOwnerInfo(null);
	}

	@Override
	public void setOwner(@Nullable Entity entity) {
		super.setOwner(entity);
		this.updateOwnerInfo(this);
	}

	@Override
	public void recreateFromPacket(ClientboundAddEntityPacket packet) {
		super.recreateFromPacket(packet);
		if (this.getPlayerOwner() == null) {
			this.kill();
		}
	}

	private void updateOwnerInfo(@Nullable ThrownFlail flail) {
		Player player = this.getPlayerOwner();
		if (player instanceof FlailOwner owner) {
			owner.setFlail(flail);
		}
	}

	@Nullable
	public Player getPlayerOwner() {
		Entity entity = this.getOwner();
		return entity instanceof Player ? (Player) entity : null;
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.hitTarget = compound.getBoolean("HitTarget");
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("HitTarget", this.hitTarget);
	}
}
