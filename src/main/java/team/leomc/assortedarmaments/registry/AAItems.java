package team.leomc.assortedarmaments.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import team.leomc.assortedarmaments.AssortedArmaments;
import team.leomc.assortedarmaments.item.ClaymoreItem;
import team.leomc.assortedarmaments.item.FlailItem;
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

	// flails
	public static final DeferredItem<FlailItem> WOODEN_FLAIL = ITEMS.register("wooden_flail", () -> new FlailItem(Tiers.WOOD, new Item.Properties().attributes(FlailItem.createAttributes(Tiers.WOOD, 6f, -3.2f))));
	public static final DeferredItem<FlailItem> STONE_FLAIL = ITEMS.register("stone_flail", () -> new FlailItem(Tiers.STONE, new Item.Properties().attributes(FlailItem.createAttributes(Tiers.STONE, 6f, -3.2f))));
	public static final DeferredItem<FlailItem> IRON_FLAIL = ITEMS.register("iron_flail", () -> new FlailItem(Tiers.IRON, new Item.Properties().attributes(FlailItem.createAttributes(Tiers.IRON, 6f, -3.2f))));
	public static final DeferredItem<FlailItem> DIAMOND_FLAIL = ITEMS.register("diamond_flail", () -> new FlailItem(Tiers.DIAMOND, new Item.Properties().attributes(FlailItem.createAttributes(Tiers.DIAMOND, 6f, -3.2f))));
	public static final DeferredItem<FlailItem> GOLDEN_FLAIL = ITEMS.register("golden_flail", () -> new FlailItem(Tiers.GOLD, new Item.Properties().attributes(FlailItem.createAttributes(Tiers.GOLD, 6f, -3.2f))));
	public static final DeferredItem<FlailItem> NETHERITE_FLAIL = ITEMS.register("netherite_flail", () -> new FlailItem(Tiers.NETHERITE, new Item.Properties().attributes(FlailItem.createAttributes(Tiers.NETHERITE, 6f, -3.2f))));
}
