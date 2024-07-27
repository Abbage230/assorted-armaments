package team.leomc.assortedarmaments.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import team.leomc.assortedarmaments.AssortedArmaments;

import java.util.List;

public class AAItemTags {
	public static final TagKey<Item> TWO_HANDED = create("two_handed");
	public static final TagKey<Item> CAN_BLOCK = create("can_block");
	public static final TagKey<Item> EFFICIENT_SWEEP = create("efficient_sweep");
	public static final TagKey<Item> ARMOR_BASED_DAMAGE = create("armor_based_damage");
	public static final TagKey<Item> DISABLES_BLOCKING_ON_ATTACK = create("disables_blocking_on_attack");
	public static final TagKey<Item> DISABLED_WHEN_DISABLING_BLOCKING = create("disabled_when_disabling_blocking");
	public static final TagKey<Item> EXTRA_KNOCKBACK = create("extra_knockback");

	public static final TagKey<Item> CLAYMORES = create("claymores");
	public static final TagKey<Item> MACES = create("maces");
	public static final TagKey<Item> FLAILS = create("flails");

	public static final TagKey<Item> ZOMBIES_CAN_USE = create("zombies_can_use");
	public static final TagKey<Item> PIGLINS_CAN_USE = create("piglins_can_use");

	public static final List<TagKey<Item>> TOOLTIP_TAGS = List.of(
		TWO_HANDED,
		CAN_BLOCK,
		EFFICIENT_SWEEP,
		ARMOR_BASED_DAMAGE,
		DISABLES_BLOCKING_ON_ATTACK,
		EXTRA_KNOCKBACK,
		FLAILS
	);

	private static TagKey<Item> create(String id) {
		return TagKey.create(Registries.ITEM, AssortedArmaments.id(id));
	}
}
