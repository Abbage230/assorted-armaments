package team.leomc.assortedarmaments.client.event;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.model.BakedModelWrapper;
import team.leomc.assortedarmaments.AssortedArmaments;
import team.leomc.assortedarmaments.registry.AAItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = AssortedArmaments.ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class AAClientSetupEvents {
	public static final Map<ModelResourceLocation, ModelResourceLocation> ITEMS_WITH_INV_ICON = Map.of(
		ModelResourceLocation.inventory(AssortedArmaments.id("wooden_claymore")), ModelResourceLocation.standalone(AssortedArmaments.id("item/wooden_claymore_inventory")),
		ModelResourceLocation.inventory(AssortedArmaments.id("stone_claymore")), ModelResourceLocation.standalone(AssortedArmaments.id("item/stone_claymore_inventory")),
		ModelResourceLocation.inventory(AssortedArmaments.id("iron_claymore")), ModelResourceLocation.standalone(AssortedArmaments.id("item/iron_claymore_inventory")),
		ModelResourceLocation.inventory(AssortedArmaments.id("diamond_claymore")), ModelResourceLocation.standalone(AssortedArmaments.id("item/diamond_claymore_inventory")),
		ModelResourceLocation.inventory(AssortedArmaments.id("golden_claymore")), ModelResourceLocation.standalone(AssortedArmaments.id("item/golden_claymore_inventory")),
		ModelResourceLocation.inventory(AssortedArmaments.id("netherite_claymore")), ModelResourceLocation.standalone(AssortedArmaments.id("item/netherite_claymore_inventory"))
	);

	public static final Map<ModelResourceLocation, BakedModel> BAKED_MODELS = new HashMap<>();

	@SubscribeEvent
	private static void onClientSetup(FMLClientSetupEvent event) {
		ItemProperties.register(AAItems.WOODEN_CLAYMORE.get(), AssortedArmaments.id("blocking"), (itemStack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1 : 0);
		ItemProperties.register(AAItems.STONE_CLAYMORE.get(), AssortedArmaments.id("blocking"), (itemStack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1 : 0);
		ItemProperties.register(AAItems.IRON_CLAYMORE.get(), AssortedArmaments.id("blocking"), (itemStack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1 : 0);
		ItemProperties.register(AAItems.DIAMOND_CLAYMORE.get(), AssortedArmaments.id("blocking"), (itemStack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1 : 0);
		ItemProperties.register(AAItems.GOLDEN_CLAYMORE.get(), AssortedArmaments.id("blocking"), (itemStack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1 : 0);
		ItemProperties.register(AAItems.NETHERITE_CLAYMORE.get(), AssortedArmaments.id("blocking"), (itemStack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1 : 0);
	}

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
				BakedModel model = event.getModels().get(location);
				List<ItemOverrides.BakedOverride> overrides = new ArrayList<>();
				for (ItemOverrides.BakedOverride bakedOverride : model.getOverrides().getOverrides()) {
					if (bakedOverride.model != null) {
						overrides.add(new ItemOverrides.BakedOverride(bakedOverride.matchers, new BakedModelWrapper<>(bakedOverride.model) {
							@Override
							public BakedModel applyTransform(ItemDisplayContext cameraTransformType, PoseStack poseStack, boolean applyLeftHandTransform) {
								if (cameraTransformType == ItemDisplayContext.GUI) {
									return BAKED_MODELS.get(ITEMS_WITH_INV_ICON.get(location));
								}
								return super.applyTransform(cameraTransformType, poseStack, applyLeftHandTransform);
							}
						}));
					}
				}
				event.getModels().put(location, new BakedModelWrapper<>(model) {
					@Override
					public BakedModel applyTransform(ItemDisplayContext cameraTransformType, PoseStack poseStack, boolean applyLeftHandTransform) {
						if (cameraTransformType == ItemDisplayContext.GUI) {
							return BAKED_MODELS.get(ITEMS_WITH_INV_ICON.get(location));
						}
						return super.applyTransform(cameraTransformType, poseStack, applyLeftHandTransform);
					}

					@Override
					public ItemOverrides getOverrides() {
						ItemOverrides itemOverrides = super.getOverrides();
						itemOverrides.overrides = overrides.toArray(new ItemOverrides.BakedOverride[itemOverrides.overrides.length]);
						return itemOverrides;
					}
				});
			}
		}
	}
}
