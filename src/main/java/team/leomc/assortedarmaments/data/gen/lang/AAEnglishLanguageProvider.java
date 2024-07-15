package team.leomc.assortedarmaments.data.gen.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import team.leomc.assortedarmaments.AssortedArmaments;
import team.leomc.assortedarmaments.registry.AAItems;

public class AAEnglishLanguageProvider extends LanguageProvider {
	public AAEnglishLanguageProvider(PackOutput output) {
		super(output, AssortedArmaments.ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		add(AAItems.WOODEN_CLAYMORE.get(), "Wooden Claymore");
	}
}
