package team.leomc.assortedarmaments.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import team.leomc.assortedarmaments.AssortedArmaments;

public class AAItemTags {
	public static final TagKey<Item> CLAYMORES = create("claymores");

	private static TagKey<Item> create(String id) {
		return TagKey.create(Registries.ITEM, AssortedArmaments.id(id));
	}
}
