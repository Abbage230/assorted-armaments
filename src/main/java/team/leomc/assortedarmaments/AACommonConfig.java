package team.leomc.assortedarmaments;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = AssortedArmaments.ID, bus = EventBusSubscriber.Bus.MOD)
public class AACommonConfig {
	private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

	private static final ModConfigSpec.DoubleValue WEAPON_BLOCK_WALK_SPEED_MODIFIER = BUILDER
		.comment("Player's walk speed when blocking with a weapon = (1 - weaponBlockWalkSpeedModifier) * originalSpeed")
		.defineInRange("weaponBlockWalkSpeedModifier", 0.25, 0, 1);

	public static final ModConfigSpec SPEC = BUILDER.build();

	public static double weaponBlockWalkSpeedModifier;

	@SubscribeEvent
	private static void onLoad(final ModConfigEvent event) {
		weaponBlockWalkSpeedModifier = WEAPON_BLOCK_WALK_SPEED_MODIFIER.get();
	}
}
