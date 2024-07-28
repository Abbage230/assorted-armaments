package team.leomc.assortedarmaments.data.gen.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import team.leomc.assortedarmaments.AssortedArmaments;
import team.leomc.assortedarmaments.registry.AAEntityTypes;
import team.leomc.assortedarmaments.registry.AAItems;

public class AAEnglishLanguageProvider extends LanguageProvider {
	public AAEnglishLanguageProvider(PackOutput output) {
		super(output, AssortedArmaments.ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		add("name." + AssortedArmaments.ID, "Assorted Armaments");
		add("fml.menu.mods.info.description." + AssortedArmaments.ID, "A Minecraft mod that adds more types of weapons");

		add(AssortedArmaments.ID + ".configuration.blockWalkSpeedModifier", "Block Walk Speed Modifier");
		add(AssortedArmaments.ID + ".configuration.armorBasedAttackDamagePercentage", "Armor Based Attack Damage Percentage");
		add(AssortedArmaments.ID + ".configuration.flailMaxUseDuration", "Maximum Flail Use Duration");
		add(AssortedArmaments.ID + ".configuration.flailThrowMinUseDuration", "Minimum Use Duration to Throw a Flail");
		add(AssortedArmaments.ID + ".configuration.flailSpinCooldown", "Flail Spin Cooldown");
		add(AssortedArmaments.ID + ".configuration.flailSpinDamageFactor", "Flail Spin Damage Factor");
		add(AssortedArmaments.ID + ".configuration.flailSpinKnockbackFactor", "Flail Spin Knockback Factor");
		add(AssortedArmaments.ID + ".configuration.zombieUseWeaponChance", "Chance of a Zombie Using a Modded Weapon");
		add(AssortedArmaments.ID + ".configuration.piglinUseWeaponChance", "Chance of a Piglin Using a Modded Weapon");

		add("desc." + AssortedArmaments.ID + ".shift", "Hold [SHIFT] for more information");
		add("desc." + AssortedArmaments.ID + ".can_block", "Can be used to block melee damage that is equal to half of the weapon's damage");
		add("desc." + AssortedArmaments.ID + ".efficient_sweep", "All targets in range on a sweeping attack take the same damage as a direct melee attack");
		add("desc." + AssortedArmaments.ID + ".two_handed", "Disables offhand items when held in main hand");
		add("desc." + AssortedArmaments.ID + ".armor_based_damage", "Deals extra damage to enemies with armor");
		add("desc." + AssortedArmaments.ID + ".disables_blocking_on_attack", "Disables the target's ability to block");
		add("desc." + AssortedArmaments.ID + ".extra_knockback", "Deals extra knockback");

		add("desc." + AssortedArmaments.ID + ".flails", "Can be thrown");

		add(AAItems.WOODEN_CLAYMORE.get(), "Wooden Claymore");
		add(AAItems.STONE_CLAYMORE.get(), "Stone Claymore");
		add(AAItems.IRON_CLAYMORE.get(), "Iron Claymore");
		add(AAItems.DIAMOND_CLAYMORE.get(), "Diamond Claymore");
		add(AAItems.GOLDEN_CLAYMORE.get(), "Golden Claymore");
		add(AAItems.NETHERITE_CLAYMORE.get(), "Netherite Claymore");

		add(AAItems.WOODEN_MACE.get(), "Wooden Mace");
		add(AAItems.STONE_MACE.get(), "Stone Mace");
		add(AAItems.IRON_MACE.get(), "Iron Mace");
		add(AAItems.DIAMOND_MACE.get(), "Diamond Mace");
		add(AAItems.GOLDEN_MACE.get(), "Golden Mace");
		add(AAItems.NETHERITE_MACE.get(), "Netherite Mace");

		add(AAItems.WOODEN_FLAIL.get(), "Wooden Flail");
		add(AAItems.STONE_FLAIL.get(), "Stone Flail");
		add(AAItems.IRON_FLAIL.get(), "Iron Flail");
		add(AAItems.DIAMOND_FLAIL.get(), "Diamond Flail");
		add(AAItems.GOLDEN_FLAIL.get(), "Golden Flail");
		add(AAItems.NETHERITE_FLAIL.get(), "Netherite Flail");
		add(AAEntityTypes.FLAIL.get(), "Flail");
	}
}
