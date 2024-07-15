package team.leomc.assortedarmaments;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import team.leomc.assortedarmaments.registry.AAItems;

@Mod(AssortedArmaments.ID)
public class AssortedArmaments {
	public static final String ID = "assorted_armaments";

	public AssortedArmaments(IEventBus modBus, ModContainer container) {
		AAItems.ITEMS.register(modBus);
		container.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
	}

	public static ResourceLocation id(String string) {
		return ResourceLocation.fromNamespaceAndPath(ID, string);
	}

	public static String strId(String string) {
		return ID + ":" + string;
	}
}
