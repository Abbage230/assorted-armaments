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
		tag(AAItemTags.FLAILS).add(
			AAItems.WOODEN_FLAIL.get(),
			AAItems.STONE_FLAIL.get(),
			AAItems.IRON_FLAIL.get(),
			AAItems.DIAMOND_FLAIL.get(),
			AAItems.GOLDEN_FLAIL.get(),
			AAItems.NETHERITE_FLAIL.get()
		);
		tag(AAItemTags.JAVELINS).add(
			AAItems.WOODEN_JAVELIN.get(),
			AAItems.STONE_JAVELIN.get(),
			AAItems.IRON_JAVELIN.get(),
			AAItems.DIAMOND_JAVELIN.get(),
			AAItems.GOLDEN_JAVELIN.get(),
			AAItems.NETHERITE_JAVELIN.get()
		);
		tag(AAItemTags.PIKES).add(
			AAItems.WOODEN_PIKE.get(),
			AAItems.STONE_PIKE.get(),
			AAItems.IRON_PIKE.get(),
			AAItems.DIAMOND_PIKE.get(),
			AAItems.GOLDEN_PIKE.get(),
			AAItems.NETHERITE_PIKE.get()
		);
		tag(AAItemTags.TWO_HANDED)
			.addTag(AAItemTags.CLAYMORES)
			.addTag(AAItemTags.FLAILS)
			.addTag(AAItemTags.PIKES);
		tag(AAItemTags.CAN_BLOCK)
			.addTag(AAItemTags.CLAYMORES)
			.addTag(AAItemTags.PIKES);
		tag(AAItemTags.STRONG_SWEEP)
			.addTag(AAItemTags.CLAYMORES);
		tag(AAItemTags.ARMOR_BASED_DAMAGE)
			.addTag(AAItemTags.MACES)
			.addTag(AAItemTags.FLAILS);
		tag(AAItemTags.DISABLES_BLOCKING_ON_ATTACK)
			.addTag(AAItemTags.MACES)
			.addTag(AAItemTags.FLAILS);
		tag(AAItemTags.DISABLED_WHEN_DISABLING_BLOCKING)
			.addTag(AAItemTags.CAN_BLOCK)
			.addTag(Tags.Items.TOOLS_SHIELD);
		tag(AAItemTags.EXTRA_KNOCKBACK).addTag(AAItemTags.MACES).
			addTag(AAItemTags.FLAILS);
		tag(AAItemTags.ZOMBIES_CAN_USE).add(
			AAItems.IRON_CLAYMORE.get(),
			AAItems.IRON_MACE.get(),
			AAItems.IRON_FLAIL.get(),
			AAItems.IRON_JAVELIN.get(),
			AAItems.IRON_PIKE.get()
		);
		tag(AAItemTags.PIGLINS_CAN_USE).add(
			AAItems.GOLDEN_CLAYMORE.get(),
			AAItems.GOLDEN_MACE.get(),
			AAItems.GOLDEN_FLAIL.get(),
			AAItems.GOLDEN_JAVELIN.get(),
			AAItems.GOLDEN_PIKE.get()
		);
		tag(ItemTags.SWORDS).addTag(AAItemTags.CLAYMORES);
		tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).addTag(AAItemTags.MACES).addTag(AAItemTags.FLAILS).addTag(AAItemTags.JAVELINS).addTag(AAItemTags.PIKES);
		tag(ItemTags.SWORD_ENCHANTABLE).addTag(AAItemTags.MACES).addTag(AAItemTags.FLAILS).addTag(AAItemTags.JAVELINS).addTag(AAItemTags.PIKES);
		tag(ItemTags.DURABILITY_ENCHANTABLE).addTag(AAItemTags.MACES).addTag(AAItemTags.FLAILS).addTag(AAItemTags.JAVELINS).addTag(AAItemTags.PIKES);
		tag(ItemTags.PIGLIN_LOVED).add(
			AAItems.GOLDEN_CLAYMORE.get(),
			AAItems.GOLDEN_MACE.get(),
			AAItems.GOLDEN_FLAIL.get(),
			AAItems.GOLDEN_JAVELIN.get(),
			AAItems.GOLDEN_PIKE.get()
		);
	}
}
