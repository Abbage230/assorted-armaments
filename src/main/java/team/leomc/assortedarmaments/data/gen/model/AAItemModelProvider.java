package team.leomc.assortedarmaments.data.gen.model;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import team.leomc.assortedarmaments.AssortedArmaments;
import team.leomc.assortedarmaments.registry.AAItems;

public class AAItemModelProvider extends ItemModelProvider {
	public AAItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, AssortedArmaments.ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		claymore(AAItems.WOODEN_CLAYMORE.get());
		inventoryModel(AAItems.WOODEN_CLAYMORE.get());
		claymore(AAItems.STONE_CLAYMORE.get());
		inventoryModel(AAItems.STONE_CLAYMORE.get());
		claymore(AAItems.IRON_CLAYMORE.get());
		inventoryModel(AAItems.IRON_CLAYMORE.get());
		claymore(AAItems.DIAMOND_CLAYMORE.get());
		inventoryModel(AAItems.DIAMOND_CLAYMORE.get());
		claymore(AAItems.GOLDEN_CLAYMORE.get());
		inventoryModel(AAItems.GOLDEN_CLAYMORE.get());
		claymore(AAItems.NETHERITE_CLAYMORE.get());
		inventoryModel(AAItems.NETHERITE_CLAYMORE.get());

		handheld(AAItems.WOODEN_MACE.get());
		handheld(AAItems.STONE_MACE.get());
		handheld(AAItems.IRON_MACE.get());
		handheld(AAItems.DIAMOND_MACE.get());
		handheld(AAItems.GOLDEN_MACE.get());
		handheld(AAItems.NETHERITE_MACE.get());

		flail(AAItems.WOODEN_FLAIL.get());
		spinningFlail(AAItems.WOODEN_FLAIL.get());
		flail(AAItems.STONE_FLAIL.get());
		spinningFlail(AAItems.STONE_FLAIL.get());
		flail(AAItems.IRON_FLAIL.get());
		spinningFlail(AAItems.IRON_FLAIL.get());
		flail(AAItems.DIAMOND_FLAIL.get());
		spinningFlail(AAItems.DIAMOND_FLAIL.get());
		flail(AAItems.GOLDEN_FLAIL.get());
		spinningFlail(AAItems.GOLDEN_FLAIL.get());
		flail(AAItems.NETHERITE_FLAIL.get());
		spinningFlail(AAItems.NETHERITE_FLAIL.get());
	}

	private void claymore(Item item) {
		ModelFile blocking = withExistingParent(name(item) + "_blocking", AssortedArmaments.id("item/large_handheld_blocking"))
			.texture("layer0", itemTexture(item));
		withExistingParent(name(item), AssortedArmaments.id("item/large_handheld"))
			.texture("layer0", itemTexture(item))
			.override().predicate(AssortedArmaments.id("blocking"), 1).model(blocking).end();
	}

	private void flail(Item item) {
		ModelFile spinning = spinningFlail(item);
		withExistingParent(name(item), AssortedArmaments.id("item/flail"))
			.texture("layer0", itemTexture(item))
			.override().predicate(AssortedArmaments.id("spinning"), 1).model(spinning).end();
	}

	private ItemModelBuilder handheld(Item item) {
		return handheld(item, itemTexture(item), false);
	}

	private ItemModelBuilder handheld(Item item, ResourceLocation texture, boolean large) {
		return getBuilder(item.toString())
			.parent(large ? new ModelFile.UncheckedModelFile(AssortedArmaments.id("item/large_handheld")) : new ModelFile.UncheckedModelFile("item/handheld"))
			.texture("layer0", texture);
	}

	public ResourceLocation itemTexture(Item item) {
		ResourceLocation name = key(item);
		return texture(name, ModelProvider.ITEM_FOLDER);
	}

	private ItemModelBuilder spinningFlail(Item item) {
		return getBuilder(item.toString() + "_spinning")
			.parent(new ModelFile.UncheckedModelFile(AssortedArmaments.id("item/spinning_flail")))
			.texture("flail", itemTexture(item) + "_spinning")
			.texture("particle", itemTexture(item));
	}

	private ItemModelBuilder inventoryModel(Item item) {
		return getBuilder(item.toString() + "_inventory")
			.parent(new ModelFile.UncheckedModelFile("item/generated"))
			.texture("layer0", itemTexture(item) + "_inventory");
	}

	public ResourceLocation texture(ResourceLocation key, String prefix) {
		return ResourceLocation.fromNamespaceAndPath(key.getNamespace(), prefix + "/" + key.getPath());
	}

	private ResourceLocation key(Item item) {
		return BuiltInRegistries.ITEM.getKey(item);
	}

	private String name(Item item) {
		return key(item).getPath();
	}
}
