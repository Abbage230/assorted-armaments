package team.leomc.assortedarmaments.event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingShieldBlockEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import team.leomc.assortedarmaments.AACommonConfig;
import team.leomc.assortedarmaments.AssortedArmaments;
import team.leomc.assortedarmaments.tags.AAItemTags;

@EventBusSubscriber(modid = AssortedArmaments.ID)
public class AACommonEvents {
	@SubscribeEvent
	private static void onShieldBlock(LivingShieldBlockEvent event) {
		if (event.getEntity().isUsingItem() && event.getEntity().getUseItem().is(AAItemTags.CAN_BLOCK)) {
			double damage = 0;
			AttributeInstance damageInstance = event.getEntity().getAttribute(Attributes.ATTACK_DAMAGE);
			if (damageInstance != null) {
				damage = damageInstance.getValue();
			}
			event.setBlockedDamage(event.getDamageSource().getDirectEntity() instanceof LivingEntity ? (float) (damage / 2) : 0);
		}
	}

	public static AttributeModifier getBlockSpeedModifier() {
		return new AttributeModifier(AssortedArmaments.id("block_speed"), -AACommonConfig.weaponBlockWalkSpeedModifier, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
	}

	@SubscribeEvent
	private static void onPostEntityTick(EntityTickEvent.Post event) {
		if (event.getEntity() instanceof LivingEntity living && !living.level().isClientSide) {
			AttributeInstance speedInstance = living.getAttribute(Attributes.MOVEMENT_SPEED);
			if (speedInstance != null) {
				if (living.isUsingItem() && living.getUseItem().is(AAItemTags.CAN_BLOCK)) {
					if (!speedInstance.hasModifier(getBlockSpeedModifier().id())) {
						speedInstance.addPermanentModifier(getBlockSpeedModifier());
					}
				} else {
					if (speedInstance.hasModifier(getBlockSpeedModifier().id())) {
						speedInstance.removeModifier(getBlockSpeedModifier().id());
					}
				}
			}
		}
	}
}
