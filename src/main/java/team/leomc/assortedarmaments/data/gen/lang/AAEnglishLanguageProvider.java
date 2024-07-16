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
		add("name." + AssortedArmaments.ID, "Assorted Armaments");

		add("desc." + AssortedArmaments.ID + ".shift", "Hold [SHIFT] for more information");
		add("desc." + AssortedArmaments.ID + ".claymore1", "Can be used to block melee damage that is equal to half of the weapon's damage");
		add("desc." + AssortedArmaments.ID + ".claymore2", "On a sweeping attack, all targets in range take 100% damage");
		add("desc." + AssortedArmaments.ID + ".claymore3", "Disables offhand items when held in main hand");
		add(AAItems.WOODEN_CLAYMORE.get(), "Wooden Claymore");
		add(AAItems.STONE_CLAYMORE.get(), "Stone Claymore");
		add(AAItems.IRON_CLAYMORE.get(), "Iron Claymore");
		add(AAItems.DIAMOND_CLAYMORE.get(), "Diamond Claymore");
		add(AAItems.GOLDEN_CLAYMORE.get(), "Golden Claymore");
		add(AAItems.NETHERITE_CLAYMORE.get(), "Netherite Claymore");
	}
}
