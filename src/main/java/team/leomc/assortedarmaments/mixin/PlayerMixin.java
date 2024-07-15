package team.leomc.assortedarmaments.mixin;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.player.CriticalHitEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import team.leomc.assortedarmaments.tags.AAItemTags;

import javax.annotation.Nonnull;

@Mixin(Player.class)
public abstract class PlayerMixin {
	@Shadow
	@Nonnull
	public abstract ItemStack getWeaponItem();

	@Unique
	private float aa$originalAttackDamage;

	@Inject(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;getEntitiesOfClass(Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;)Ljava/util/List;", shift = At.Shift.BEFORE), locals = LocalCapture.CAPTURE_FAILHARD)
	private void captureOriginalDamage(Entity target, CallbackInfo ci, float f, ItemStack itemstack, DamageSource damagesource, float f1, float f2, boolean flag4, boolean flag, boolean flag1, CriticalHitEvent critEvent, float f3, boolean flag2, double d0, float f6, Vec3 vec3, boolean flag3, float f4, float f7) {
		aa$originalAttackDamage = f;
	}

	@ModifyArg(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;getEnchantedDamage(Lnet/minecraft/world/entity/Entity;FLnet/minecraft/world/damagesource/DamageSource;)F", ordinal = 1), index = 1)
	private float modifySweepDamage(float damage) {
		if (getWeaponItem().is(AAItemTags.CLAYMORES)) {
			return aa$originalAttackDamage;
		}
		return damage;
	}
}
