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
		add("desc." + AssortedArmaments.ID + ".claymore1", "可以格挡武器伤害一半大小的近战伤害");
		add("desc." + AssortedArmaments.ID + ".claymore2", "横扫攻击时，范围内所有目标受到100%的伤害");
		add("desc." + AssortedArmaments.ID + ".claymore3", "拿在主手时，禁用副手物品");
		add(AAItems.WOODEN_CLAYMORE.get(), "木大剑");
		add(AAItems.STONE_CLAYMORE.get(), "石大剑");
		add(AAItems.IRON_CLAYMORE.get(), "铁大剑");
		add(AAItems.DIAMOND_CLAYMORE.get(), "钻石大剑");
		add(AAItems.GOLDEN_CLAYMORE.get(), "金大剑");
		add(AAItems.NETHERITE_CLAYMORE.get(), "下界合金大剑");
	}
}
