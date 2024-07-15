package team.leomc.assortedarmaments.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.model.BakedModelWrapper;
import team.leomc.assortedarmaments.AssortedArmaments;

import java.util.HashMap;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = AssortedArmaments.ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class AAClientSetupEvents {
	public static final Map<ModelResourceLocation, ModelResourceLocation> ITEMS_WITH_INV_ICON = Map.of(
		ModelResourceLocation.inventory(AssortedArmaments.id("wooden_claymore")), ModelResourceLocation.standalone(AssortedArmaments.id("item/wooden_claymore_inventory"))
	);

	public static final Map<ModelResourceLocation, BakedModel> BAKED_MODELS = new HashMap<>();

	@SubscribeEvent
	private static void onRegisterAdditionalModels(ModelEvent.RegisterAdditional event) {
		for (Map.Entry<ModelResourceLocation, ModelResourceLocation> entry : ITEMS_WITH_INV_ICON.entrySet()) {
			event.register(entry.getValue());
		}
	}

	@SubscribeEvent
	private static void onModifyBakingResult(ModelEvent.ModifyBakingResult event) {
		BAKED_MODELS.clear();
		BAKED_MODELS.putAll(event.getModels());
		for (ModelResourceLocation location : event.getModels().keySet()) {
			if (ITEMS_WITH_INV_ICON.containsKey(location)) {
				event.getModels().put(location, new BakedModelWrapper<>(event.getModels().get(location)) {
					@Override
					public BakedModel applyTransform(ItemDisplayContext cameraTransformType, PoseStack poseStack, boolean applyLeftHandTransform) {
						if (cameraTransformType == ItemDisplayContext.GUI) {
							return BAKED_MODELS.get(ITEMS_WITH_INV_ICON.get(location));
						}
						return super.applyTransform(cameraTransformType, poseStack, applyLeftHandTransform);
					}
				});
			}
		}
	}
}
