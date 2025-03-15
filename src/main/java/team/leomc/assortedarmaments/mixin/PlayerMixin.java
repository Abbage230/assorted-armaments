package team.leomc.assortedarmaments.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.leomc.assortedarmaments.entity.ConcentratedAttacker;
import team.leomc.assortedarmaments.entity.FlailOwner;
import team.leomc.assortedarmaments.entity.ThrownFlail;
import team.leomc.assortedarmaments.tags.AAItemTags;

@Mixin(Player.class)
public abstract class PlayerMixin implements FlailOwner, ConcentratedAttacker {
	@Shadow
	public abstract ItemStack getWeaponItem();

	@Unique
	private float aa$originalAttackDamage;

	@Unique
	private ThrownFlail aa$flail;

	@Unique
	private LivingEntity aa$concentratedTarget;

	@Unique
	private ItemStack aa$concentratedWeapon;

	@Unique
	private int aa$lastConcentratedAttackTime;

	@Unique
	private int aa$concentrationLevel;

	@Inject(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;getEntitiesOfClass(Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;)Ljava/util/List;"))
	private void captureOriginalDamage(Entity target, CallbackInfo ci, @Local(ordinal = 0) float originalDamage) {
		aa$originalAttackDamage = originalDamage;
	}

	@ModifyArg(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;getEnchantedDamage(Lnet/minecraft/world/entity/Entity;FLnet/minecraft/world/damagesource/DamageSource;)F", ordinal = 1), index = 1)
	private float modifySweepDamage(float damage) {
		if (getWeaponItem().is(AAItemTags.STRONG_SWEEP)) {
			return (float) (aa$originalAttackDamage * (1 + ((Player) (Object) this).getAttributeValue(Attributes.SWEEPING_DAMAGE_RATIO) * 0.1));
		}
		return damage;
	}

	@Override
	public ThrownFlail getFlail() {
		return aa$flail;
	}

	@Override
	public void setFlail(ThrownFlail flail) {
		this.aa$flail = flail;
	}

	@Override
	public LivingEntity getConcentratedTarget() {
		return aa$concentratedTarget;
	}

	@Override
	public void setConcentratedTarget(LivingEntity concentratedTarget) {
		this.aa$concentratedTarget = concentratedTarget;
	}

	@Override
	public ItemStack getConcentratedWeapon() {
		return aa$concentratedWeapon;
	}

	@Override
	public void setConcentratedWeapon(ItemStack concentratedWeapon) {
		this.aa$concentratedWeapon = concentratedWeapon;
	}

	@Override
	public int getLastConcentratedAttackTime() {
		return aa$lastConcentratedAttackTime;
	}

	@Override
	public void setLastConcentratedAttackTime(int time) {
		this.aa$lastConcentratedAttackTime = time;
	}

	@Override
	public int getConcentrationLevel() {
		return aa$concentrationLevel;
	}

	@Override
	public void setConcentrationLevel(int level) {
		this.aa$concentrationLevel = level;
	}
}
