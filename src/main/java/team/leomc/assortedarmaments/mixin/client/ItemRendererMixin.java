package team.leomc.assortedarmaments.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.leomc.assortedarmaments.entity.FlailOwner;
import team.leomc.assortedarmaments.tags.AAItemTags;

@OnlyIn(Dist.CLIENT)
@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
	@Inject(method = "render", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;translate(FFF)V"))
	private void render(ItemStack itemStack, ItemDisplayContext displayContext, boolean leftHand, PoseStack poseStack, MultiBufferSource bufferSource, int combinedLight, int combinedOverlay, BakedModel bakedModel, CallbackInfo ci) {
		LocalPlayer player = Minecraft.getInstance().player;
		if (player != null && itemStack.is(AAItemTags.FLAILS) && player.isUsingItem() && player.getUseItem() == itemStack && (displayContext == ItemDisplayContext.THIRD_PERSON_LEFT_HAND || displayContext == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND || displayContext == ItemDisplayContext.FIRST_PERSON_LEFT_HAND || displayContext == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)) {
			poseStack.mulPose(new Quaternionf().rotateY((player.tickCount + Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(Minecraft.getInstance().level != null && Minecraft.getInstance().level.tickRateManager().runsNormally())) * 0.7f));
		}
	}

	@Inject(method = "render", at = @At("HEAD"), cancellable = true)
	private void renderHead(ItemStack itemStack, ItemDisplayContext displayContext, boolean leftHand, PoseStack poseStack, MultiBufferSource bufferSource, int combinedLight, int combinedOverlay, BakedModel bakedModel, CallbackInfo ci) {
		LocalPlayer player = Minecraft.getInstance().player;
		if (player instanceof FlailOwner owner && itemStack.is(AAItemTags.FLAILS) && (player.getMainHandItem() == itemStack || player.getOffhandItem() == itemStack) && owner.getFlail() != null && displayContext != ItemDisplayContext.GUI) {
			ci.cancel();
		}
	}
}
