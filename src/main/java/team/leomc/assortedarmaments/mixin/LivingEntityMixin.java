package team.leomc.assortedarmaments.mixin;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import team.leomc.assortedarmaments.tags.AAItemTags;

import javax.annotation.Nonnull;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
	@Shadow
	@Nonnull
	public abstract ItemStack getWeaponItem();

	@Inject(method = "getKnockback", at = @At("RETURN"), cancellable = true)
	private void getKnockback(Entity target, DamageSource damageSource, CallbackInfoReturnable<Float> cir) {
		if (getWeaponItem().is(AAItemTags.EXTRA_KNOCKBACK)) {
			cir.setReturnValue(cir.getReturnValue() + 1);
		}
	}
}
