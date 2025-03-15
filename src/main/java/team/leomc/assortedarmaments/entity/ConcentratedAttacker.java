package team.leomc.assortedarmaments.entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public interface ConcentratedAttacker {
	LivingEntity getConcentratedTarget();

	void setConcentratedTarget(LivingEntity concentratedTarget);

	ItemStack getConcentratedWeapon();

	void setConcentratedWeapon(ItemStack concentratedWeapon);

	int getLastConcentratedAttackTime();

	void setLastConcentratedAttackTime(int time);

	int getConcentrationLevel();

	void setConcentrationLevel(int level);

	default void clearConcentrationData() {
		setConcentratedTarget(null);
		setConcentratedWeapon(null);
		setLastConcentratedAttackTime(Integer.MIN_VALUE);
		setConcentrationLevel(0);
	}
}
