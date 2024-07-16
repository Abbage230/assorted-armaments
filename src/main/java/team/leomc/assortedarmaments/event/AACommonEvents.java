package team.leomc.assortedarmaments.event;

import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingShieldBlockEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import team.leomc.assortedarmaments.AssortedArmaments;
import team.leomc.assortedarmaments.item.ClaymoreItem;
import team.leomc.assortedarmaments.tags.AAItemTags;

@EventBusSubscriber(modid = AssortedArmaments.ID)
public class AACommonEvents {
	@SubscribeEvent
	private static void onShieldBlock(LivingShieldBlockEvent event) {
		if (event.getEntity().isUsingItem() && event.getEntity().getUseItem().is(AAItemTags.CLAYMORES)) {
			double damage = 0;
			AttributeInstance damageInstance = event.getEntity().getAttribute(Attributes.ATTACK_DAMAGE);
			if (damageInstance != null) {
				damage = damageInstance.getValue();
			}
			event.setBlockedDamage(event.getDamageSource().getDirectEntity() instanceof LivingEntity ? (float) (damage / 2) : 0);
		}
	}

	@SubscribeEvent
	private static void onPostEntityTick(EntityTickEvent.Post event) {
		if (event.getEntity() instanceof LivingEntity living && !living.level().isClientSide) {
			AttributeInstance speedInstance = living.getAttribute(Attributes.MOVEMENT_SPEED);
			if (speedInstance != null) {
				if (living.isUsingItem() && living.getUseItem().is(AAItemTags.CLAYMORES)) {
					if (!speedInstance.hasModifier(ClaymoreItem.getBlockSpeedModifier().id())) {
						speedInstance.addPermanentModifier(ClaymoreItem.getBlockSpeedModifier());
						LogUtils.getLogger().warn("Claymore amount: {}", ClaymoreItem.getBlockSpeedModifier().amount());
					}
				} else {
					if (speedInstance.hasModifier(ClaymoreItem.getBlockSpeedModifier().id())) {
						speedInstance.removeModifier(ClaymoreItem.getBlockSpeedModifier().id());
					}
				}
			}
		}
	}
}
