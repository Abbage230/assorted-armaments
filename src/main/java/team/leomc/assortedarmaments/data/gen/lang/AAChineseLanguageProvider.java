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
		add(AAItems.WOODEN_CLAYMORE.get(), "木大剑");
	}
}
