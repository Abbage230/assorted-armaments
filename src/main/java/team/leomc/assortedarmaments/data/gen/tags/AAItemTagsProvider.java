package team.leomc.assortedarmaments.data.gen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import team.leomc.assortedarmaments.AssortedArmaments;
import team.leomc.assortedarmaments.registry.AAItems;
import team.leomc.assortedarmaments.tags.AAItemTags;

import java.util.concurrent.CompletableFuture;

public class AAItemTagsProvider extends ItemTagsProvider {
	public AAItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> future, CompletableFuture<TagLookup<Block>> provider, ExistingFileHelper helper) {
		super(output, future, provider, AssortedArmaments.ID, helper);
	}

	@Override
	protected void addTags(HolderLookup.Provider lookupProvider) {
		tag(AAItemTags.CLAYMORES).add(
			AAItems.WOODEN_CLAYMORE.get(),
			AAItems.STONE_CLAYMORE.get(),
			AAItems.IRON_CLAYMORE.get(),
			AAItems.DIAMOND_CLAYMORE.get(),
			AAItems.GOLDEN_CLAYMORE.get(),
			AAItems.NETHERITE_CLAYMORE.get()
		);
		tag(AAItemTags.MACES).add(
			AAItems.WOODEN_MACE.get(),
			AAItems.STONE_MACE.get(),
			AAItems.IRON_MACE.get(),
			AAItems.DIAMOND_MACE.get(),
			AAItems.GOLDEN_MACE.get(),
			AAItems.NETHERITE_MACE.get()
		);
		tag(AAItemTags.TWO_HANDED).addTag(AAItemTags.CLAYMORES);
		tag(AAItemTags.CAN_BLOCK).addTag(AAItemTags.CLAYMORES);
		tag(AAItemTags.EFFICIENT_SWEEP).addTag(AAItemTags.CLAYMORES);
		tag(AAItemTags.ARMOR_BASED_DAMAGE).addTag(AAItemTags.MACES);
		tag(AAItemTags.DISABLES_BLOCKING_ON_ATTACK).addTag(AAItemTags.MACES);
		tag(AAItemTags.DISABLED_WHEN_DISABLING_BLOCKING).addTag(AAItemTags.CAN_BLOCK).addTag(Tags.Items.TOOLS_SHIELD);
		tag(AAItemTags.EXTRA_KNOCKBACK).addTag(AAItemTags.MACES);
		tag(AAItemTags.ZOMBIES_CAN_USE).add(
			AAItems.IRON_CLAYMORE.get(),
			AAItems.IRON_MACE.get()
		);
		tag(AAItemTags.PIGLINS_CAN_USE).add(
			AAItems.GOLDEN_CLAYMORE.get(),
			AAItems.GOLDEN_MACE.get()
		);
		tag(ItemTags.SWORDS).addTag(AAItemTags.CLAYMORES);
		tag(ItemTags.SWORD_ENCHANTABLE).addTag(AAItemTags.MACES);
		tag(ItemTags.DURABILITY_ENCHANTABLE).addTag(AAItemTags.MACES);
		tag(ItemTags.PIGLIN_LOVED).add(
			AAItems.GOLDEN_CLAYMORE.get(),
			AAItems.GOLDEN_MACE.get()
		);
	}
}
