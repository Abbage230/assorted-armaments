package team.leomc.assortedarmaments;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = AssortedArmaments.ID, bus = EventBusSubscriber.Bus.MOD)
public class Config {
	private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

	private static final ModConfigSpec.DoubleValue CLAYMORE_BLOCK_WALK_SPEED_MODIFIER = BUILDER
		.comment("Player's walk speed when blocking using a claymore = claymoreBlockWalkSpeedModifier * originalSpeed")
		.defineInRange("claymoreBlockWalkSpeedModifier", 0.75, 0, Integer.MAX_VALUE);

	public static final ModConfigSpec SPEC = BUILDER.build();

	public static double claymoreBlockWalkSpeedModifier;

	@SubscribeEvent
	private static void onLoad(final ModConfigEvent event) {
		claymoreBlockWalkSpeedModifier = CLAYMORE_BLOCK_WALK_SPEED_MODIFIER.get();
	}
}
