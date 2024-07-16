package team.leomc.assortedarmaments.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import team.leomc.assortedarmaments.AssortedArmaments;

public class AACreativeModeTabs {
	public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AssortedArmaments.ID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ASSORTED_ARMAMENTS = TABS.register("assorted_armaments", () -> CreativeModeTab.builder().title(Component.translatable("name." + AssortedArmaments.ID)).icon(() -> AAItems.DIAMOND_CLAYMORE.get().getDefaultInstance()).displayItems((parameters, output) -> {
		for (Item item : BuiltInRegistries.ITEM.stream().filter(i -> BuiltInRegistries.ITEM.getKey(i).getNamespace().equals(AssortedArmaments.ID)).toList()) {
			output.accept(item);
		}
	}).build());
}
