package team.leomc.assortedarmaments.data.gen.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import team.leomc.assortedarmaments.AssortedArmaments;
import team.leomc.assortedarmaments.registry.AAItems;

public class AAChineseLanguageProvider extends LanguageProvider {
	public AAChineseLanguageProvider(PackOutput output) {
		super(output, AssortedArmaments.ID, "zh_cn");
	}

	@Override
	protected void addTranslations() {
		add("name." + AssortedArmaments.ID, "百般武艺");

		add("desc." + AssortedArmaments.ID + ".shift", "按[SHIFT]查看更多信息");
		add("desc." + AssortedArmaments.ID + ".can_block", "可以格挡武器伤害一半大小的近战伤害");
		add("desc." + AssortedArmaments.ID + ".efficient_sweep", "横扫攻击时范围内所有目标受到与直接攻击一致的伤害");
		add("desc." + AssortedArmaments.ID + ".two_handed", "拿在主手时禁用副手物品");
		add("desc." + AssortedArmaments.ID + ".armor_based_damage", "对有护甲的敌人造成额外伤害");
		add("desc." + AssortedArmaments.ID + ".disables_blocking_on_attack", "攻击被格挡时使目标失去格挡能力");
		add("desc." + AssortedArmaments.ID + ".extra_knockback", "可造成额外击退");

		add(AAItems.WOODEN_CLAYMORE.get(), "木大剑");
		add(AAItems.STONE_CLAYMORE.get(), "石大剑");
		add(AAItems.IRON_CLAYMORE.get(), "铁大剑");
		add(AAItems.DIAMOND_CLAYMORE.get(), "钻石大剑");
		add(AAItems.GOLDEN_CLAYMORE.get(), "金大剑");
		add(AAItems.NETHERITE_CLAYMORE.get(), "下界合金大剑");

		add(AAItems.WOODEN_MACE.get(), "木钉头锤");
		add(AAItems.STONE_MACE.get(), "石钉头锤");
		add(AAItems.IRON_MACE.get(), "铁钉头锤");
		add(AAItems.DIAMOND_MACE.get(), "钻石钉头锤");
		add(AAItems.GOLDEN_MACE.get(), "金钉头锤");
		add(AAItems.NETHERITE_MACE.get(), "下界合金钉头锤");
	}
}
