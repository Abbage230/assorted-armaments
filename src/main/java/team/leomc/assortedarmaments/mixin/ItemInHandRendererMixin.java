package team.leomc.assortedarmaments.mixin;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import team.leomc.assortedarmaments.tags.AAItemTags;

@OnlyIn(Dist.CLIENT)
@Mixin(ItemInHandRenderer.class)
public abstract class ItemInHandRendererMixin {
	@Inject(method = "evaluateWhichHandsToRender", at = @At("RETURN"), cancellable = true)
	private static void evaluateWhichHandsToRender(LocalPlayer player, CallbackInfoReturnable<ItemInHandRenderer.HandRenderSelection> cir) {
		if (player.getMainHandItem().is(AAItemTags.TWO_HANDED) && cir.getReturnValue().renderMainHand) {
			cir.setReturnValue(ItemInHandRenderer.HandRenderSelection.RENDER_MAIN_HAND_ONLY);
		}
	}
}
