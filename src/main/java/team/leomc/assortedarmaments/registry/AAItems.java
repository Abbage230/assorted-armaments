package team.leomc.assortedarmaments.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import team.leomc.assortedarmaments.AssortedArmaments;
import team.leomc.assortedarmaments.item.ClaymoreItem;
import team.leomc.assortedarmaments.item.MaceItem;

public class AAItems {
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AssortedArmaments.ID);

	// claymores
	public static final DeferredItem<ClaymoreItem> WOODEN_CLAYMORE = ITEMS.register("wooden_claymore", () -> new ClaymoreItem(Tiers.WOOD, new Item.Properties().attributes(ClaymoreItem.createAttributes(Tiers.WOOD, 5f, -2.9f, 0.5f))));
	public static final DeferredItem<ClaymoreItem> STONE_CLAYMORE = ITEMS.register("stone_claymore", () -> new ClaymoreItem(Tiers.STONE, new Item.Properties().attributes(ClaymoreItem.createAttributes(Tiers.STONE, 5f, -2.9f, 0.5f))));
	public static final DeferredItem<ClaymoreItem> IRON_CLAYMORE = ITEMS.register("iron_claymore", () -> new ClaymoreItem(Tiers.IRON, new Item.Properties().attributes(ClaymoreItem.createAttributes(Tiers.IRON, 5f, -2.9f, 0.5f))));
	public static final DeferredItem<ClaymoreItem> DIAMOND_CLAYMORE = ITEMS.register("diamond_claymore", () -> new ClaymoreItem(Tiers.DIAMOND, new Item.Properties().attributes(ClaymoreItem.createAttributes(Tiers.DIAMOND, 5f, -2.9f, 0.5f))));
	public static final DeferredItem<ClaymoreItem> GOLDEN_CLAYMORE = ITEMS.register("golden_claymore", () -> new ClaymoreItem(Tiers.GOLD, new Item.Properties().attributes(ClaymoreItem.createAttributes(Tiers.GOLD, 5f, -2.9f, 0.5f))));
	public static final DeferredItem<ClaymoreItem> NETHERITE_CLAYMORE = ITEMS.register("netherite_claymore", () -> new ClaymoreItem(Tiers.NETHERITE, new Item.Properties().attributes(ClaymoreItem.createAttributes(Tiers.NETHERITE, 5f, -2.9f, 0.5f))));

	// maces
	public static final DeferredItem<MaceItem> WOODEN_MACE = ITEMS.register("wooden_mace", () -> new MaceItem(Tiers.WOOD, new Item.Properties().attributes(MaceItem.createAttributes(Tiers.WOOD, 4.5f, -3f))));
	public static final DeferredItem<MaceItem> STONE_MACE = ITEMS.register("stone_mace", () -> new MaceItem(Tiers.STONE, new Item.Properties().attributes(MaceItem.createAttributes(Tiers.STONE, 4.5f, -3f))));
	public static final DeferredItem<MaceItem> IRON_MACE = ITEMS.register("iron_mace", () -> new MaceItem(Tiers.IRON, new Item.Properties().attributes(MaceItem.createAttributes(Tiers.IRON, 4.5f, -3f))));
	public static final DeferredItem<MaceItem> DIAMOND_MACE = ITEMS.register("diamond_mace", () -> new MaceItem(Tiers.DIAMOND, new Item.Properties().attributes(MaceItem.createAttributes(Tiers.DIAMOND, 4.5f, -3f))));
	public static final DeferredItem<MaceItem> GOLDEN_MACE = ITEMS.register("golden_mace", () -> new MaceItem(Tiers.GOLD, new Item.Properties().attributes(MaceItem.createAttributes(Tiers.GOLD, 4.5f, -3f))));
	public static final DeferredItem<MaceItem> NETHERITE_MACE = ITEMS.register("netherite_mace", () -> new MaceItem(Tiers.NETHERITE, new Item.Properties().attributes(MaceItem.createAttributes(Tiers.NETHERITE, 4.5f, -3f))));
}
