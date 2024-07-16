package team.leomc.assortedarmaments.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import team.leomc.assortedarmaments.AACommonConfig;
import team.leomc.assortedarmaments.AssortedArmaments;

import java.util.List;

public class ClaymoreItem extends SwordItem {
	public ClaymoreItem(Tier tier, Properties properties) {
		super(tier, properties);
	}

	public static ItemAttributeModifiers createAttributes(Tier tier, float attackDamage, float attackSpeed, float interactionRange) {
		return ItemAttributeModifiers.builder()
			.add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, attackDamage + tier.getAttackDamageBonus(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
			.add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, attackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
			.add(Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(AssortedArmaments.id("base_interaction_range"), interactionRange, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
			.build();
	}

	public static AttributeModifier getBlockSpeedModifier() {
		return new AttributeModifier(AssortedArmaments.id("claymore_block_speed"), -AACommonConfig.claymoreBlockWalkSpeedModifier, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.BLOCK;
	}

	@Override
	public int getUseDuration(ItemStack stack, LivingEntity entity) {
		return 72000;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		player.startUsingItem(hand);
		return InteractionResultHolder.consume(itemstack);
	}

	@Override
	public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
		return super.canPerformAction(stack, itemAbility) || itemAbility == ItemAbilities.SHIELD_BLOCK;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
		if (FMLLoader.getDist() == Dist.CLIENT) {
			if (AssortedArmaments.ClientHelper.isShiftKeyDown()) {
				tooltipComponents.add(Component.translatable("desc." + AssortedArmaments.ID + ".claymore1").withStyle(ChatFormatting.YELLOW));
				tooltipComponents.add(Component.translatable("desc." + AssortedArmaments.ID + ".claymore2").withStyle(ChatFormatting.YELLOW));
				tooltipComponents.add(Component.translatable("desc." + AssortedArmaments.ID + ".claymore3").withStyle(ChatFormatting.YELLOW));
			} else {
				tooltipComponents.add(Component.translatable("desc." + AssortedArmaments.ID + ".shift").withStyle(ChatFormatting.YELLOW));
			}
		}
	}
}
