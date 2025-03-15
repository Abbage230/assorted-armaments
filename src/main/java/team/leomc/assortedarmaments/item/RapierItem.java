package team.leomc.assortedarmaments.item;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import team.leomc.assortedarmaments.entity.ConcentratedAttacker;

public class RapierItem extends SwordItem {
	public RapierItem(Tier tier, Properties properties) {
		super(tier, properties);
	}

	public static ItemAttributeModifiers createAttributes(Tier tier, float attackDamage, float attackSpeed) {
		return ItemAttributeModifiers.builder()
			.add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, attackDamage + tier.getAttackDamageBonus(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
			.add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, attackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
			.build();
	}

	@Override
	public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (attacker instanceof ConcentratedAttacker concentrated) {
			if (target == concentrated.getConcentratedTarget() && stack == concentrated.getConcentratedWeapon()) {
				concentrated.setLastConcentratedAttackTime(attacker.tickCount);
				concentrated.setConcentrationLevel(Math.min(concentrated.getConcentrationLevel() + 1, 4));
			} else {
				concentrated.setConcentratedTarget(target);
				concentrated.setConcentratedWeapon(stack);
				concentrated.setLastConcentratedAttackTime(attacker.tickCount);
				concentrated.setConcentrationLevel(0);
			}
		}
		super.postHurtEnemy(stack, target, attacker);
	}


	@Override
	public float getAttackDamageBonus(Entity target, float damage, DamageSource damageSource) {
		Entity directEntity = damageSource.getDirectEntity();
		if (directEntity instanceof ConcentratedAttacker concentrated && concentrated.getConcentratedTarget() == target) {
			return concentrated.getConcentrationLevel() * 0.5f;
		}
		return super.getAttackDamageBonus(target, damage, damageSource);
	}
}
