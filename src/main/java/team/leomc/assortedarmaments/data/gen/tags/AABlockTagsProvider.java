package team.leomc.assortedarmaments.data.gen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import team.leomc.assortedarmaments.AssortedArmaments;

import java.util.concurrent.CompletableFuture;

public class AABlockTagsProvider extends BlockTagsProvider {
	public AABlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> future, ExistingFileHelper helper) {
		super(output, future, AssortedArmaments.ID, helper);
	}

	@Override
	protected void addTags(HolderLookup.Provider lookupProvider) {

	}
}
