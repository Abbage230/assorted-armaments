package team.leomc.assortedarmaments;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = AssortedArmaments.ID, bus = EventBusSubscriber.Bus.MOD)
public class AACommonConfig {
	private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

	private static final ModConfigSpec.DoubleValue BLOCK_WALK_SPEED_MODIFIER = BUILDER
		.comment("Player's walk speed when blocking with a weapon = (1 - blockWalkSpeedModifier) * originalSpeed")
		.defineInRange("blockWalkSpeedModifier", 0.25, 0, 1);

	private static final ModConfigSpec.DoubleValue ARMOR_BASED_ATTACK_DAMAGE_PERCENTAGE = BUILDER
		.comment("Damage caused when attacking with a weapon that deals damage according to the target's armor value = originalDamage + armorBasedAttackDamagePercentage * target's armorValue")
		.defineInRange("armorBasedAttackDamagePercentage", 0.25, 0, Integer.MAX_VALUE);

	private static final ModConfigSpec.DoubleValue ZOMBIE_USE_WEAPON_CHANCE = BUILDER
		.comment("What is the probability that a zombie will use a weapon from assorted armaments?")
		.defineInRange("zombieUseWeaponChance", 0.1, 0, 1);

	private static final ModConfigSpec.DoubleValue PIGLIN_USE_WEAPON_CHANCE = BUILDER
		.comment("What is the probability that a piglin will use a weapon from assorted armaments?")
		.defineInRange("piglinUseWeaponChance", 0.1, 0, 1);

	public static final ModConfigSpec SPEC = BUILDER.build();

	public static double blockWalkSpeedModifier;
	public static double armorBasedAttackDamagePercentage;
	public static double zombieUseWeaponChance;
	public static double piglinUseWeaponChance;

	@SubscribeEvent
	private static void onLoad(final ModConfigEvent event) {
		blockWalkSpeedModifier = BLOCK_WALK_SPEED_MODIFIER.get();
		armorBasedAttackDamagePercentage = ARMOR_BASED_ATTACK_DAMAGE_PERCENTAGE.get();
		zombieUseWeaponChance = ZOMBIE_USE_WEAPON_CHANCE.get();
		piglinUseWeaponChance = PIGLIN_USE_WEAPON_CHANCE.get();
	}
}
