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
		largeHandheld(AAItems.WOODEN_CLAYMORE.get());
		inventoryModel(AAItems.WOODEN_CLAYMORE.get());
	}

	private ItemModelBuilder largeHandheld(Item item) {
		return handheld(item, itemTexture(item), true);
	}

	private ItemModelBuilder handheld(Item item) {
		return handheld(item, itemTexture(item), false);
	}

	private ItemModelBuilder handheld(Item item, ResourceLocation texture, boolean large) {
		return getBuilder(item.toString())
			.parent(large ? new ModelFile.UncheckedModelFile(AssortedArmaments.strId("item/large_handheld")) : new ModelFile.UncheckedModelFile("item/handheld"))
			.texture("layer0", texture);
	}

	public ResourceLocation itemTexture(Item item) {
		ResourceLocation name = key(item);
		return texture(name, ModelProvider.ITEM_FOLDER);
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
}
