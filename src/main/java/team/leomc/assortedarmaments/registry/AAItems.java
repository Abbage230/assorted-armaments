package team.leomc.assortedarmaments.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import team.leomc.assortedarmaments.AssortedArmaments;
import team.leomc.assortedarmaments.item.ClaymoreItem;

public class AAItems {
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AssortedArmaments.ID);

	// claymores
	public static final DeferredItem<ClaymoreItem> WOODEN_CLAYMORE = ITEMS.register("wooden_claymore", () -> new ClaymoreItem(Tiers.WOOD, new Item.Properties().attributes(ClaymoreItem.createAttributes(Tiers.WOOD, 5f, -2.9f, 0.5f))));
}
