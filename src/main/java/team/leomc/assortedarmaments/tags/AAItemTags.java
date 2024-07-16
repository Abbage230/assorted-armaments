package team.leomc.assortedarmaments.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import team.leomc.assortedarmaments.AssortedArmaments;

public class AAItemTags {
	public static final TagKey<Item> TWO_HANDED = create("two_handed");
	public static final TagKey<Item> CAN_BLOCK = create("can_block");
	public static final TagKey<Item> EFFICIENT_SWEEP = create("efficient_sweep");
	public static final TagKey<Item> CLAYMORES = create("claymores");

	private static TagKey<Item> create(String id) {
		return TagKey.create(Registries.ITEM, AssortedArmaments.id(id));
	}
}
