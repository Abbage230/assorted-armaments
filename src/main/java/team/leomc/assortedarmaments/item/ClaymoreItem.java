package team.leomc.assortedarmaments.item;

import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import team.leomc.assortedarmaments.AssortedArmaments;

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
}
