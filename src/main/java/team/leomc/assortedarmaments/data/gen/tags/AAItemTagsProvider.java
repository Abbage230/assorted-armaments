package team.leomc.assortedarmaments.data.gen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
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
		tag(ItemTags.SWORDS).addTags(AAItemTags.CLAYMORES);
	}
}
