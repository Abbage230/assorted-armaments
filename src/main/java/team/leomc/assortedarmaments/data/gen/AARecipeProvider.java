package team.leomc.assortedarmaments.data.gen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import team.leomc.assortedarmaments.AssortedArmaments;
import team.leomc.assortedarmaments.registry.AAItems;

import java.util.concurrent.CompletableFuture;

public class AARecipeProvider extends RecipeProvider {
	public AARecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries);
	}

	@Override
	protected void buildRecipes(RecipeOutput recipeOutput) {
		claymore(recipeOutput, AAItems.WOODEN_CLAYMORE.get(), ItemTags.PLANKS);
		claymore(recipeOutput, AAItems.STONE_CLAYMORE.get(), ItemTags.STONE_TOOL_MATERIALS);
		claymore(recipeOutput, AAItems.IRON_CLAYMORE.get(), Items.IRON_INGOT);
		claymore(recipeOutput, AAItems.DIAMOND_CLAYMORE.get(), Items.DIAMOND);
		claymore(recipeOutput, AAItems.GOLDEN_CLAYMORE.get(), Items.GOLD_INGOT);
		netheriteSmithing(recipeOutput, AAItems.DIAMOND_CLAYMORE.get(), RecipeCategory.COMBAT, AAItems.NETHERITE_CLAYMORE.get());

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(
				AAItems.GOLDEN_CLAYMORE.get()
			), RecipeCategory.MISC, Items.GOLD_NUGGET, 0.1F, 200)
			.unlockedBy("has_golden_claymore", has(AAItems.GOLDEN_CLAYMORE.get()))
			.save(recipeOutput, AssortedArmaments.id(getSmeltingRecipeName(Items.GOLD_NUGGET)));
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(
				AAItems.IRON_CLAYMORE.get()
			), RecipeCategory.MISC, Items.IRON_NUGGET, 0.1F, 200)
			.unlockedBy("has_iron_claymore", has(AAItems.IRON_CLAYMORE.get()))
			.save(recipeOutput, AssortedArmaments.id(getSmeltingRecipeName(Items.IRON_NUGGET)));
	}

	protected static void netheriteSmithing(RecipeOutput recipeOutput, Item ingredientItem, RecipeCategory category, Item resultItem) {
		SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(ingredientItem), Ingredient.of(Items.NETHERITE_INGOT), category, resultItem).unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT)).save(recipeOutput, AssortedArmaments.id(getItemName(resultItem) + "_smithing"));
	}

	protected void claymore(RecipeOutput recipeOutput, ItemLike output, TagKey<Item> input) {
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, output)
			.define('#', Tags.Items.RODS_WOODEN)
			.define('X', input)
			.pattern(" XX")
			.pattern("XXX")
			.pattern("#X ")
			.unlockedBy("has_item", has(input))
			.save(recipeOutput);
	}

	protected void claymore(RecipeOutput recipeOutput, ItemLike output, ItemLike input) {
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, output)
			.define('#', Tags.Items.RODS_WOODEN)
			.define('X', input)
			.pattern(" XX")
			.pattern("XXX")
			.pattern("#X ")
			.unlockedBy(getHasName(input), has(input))
			.save(recipeOutput);
	}
}
