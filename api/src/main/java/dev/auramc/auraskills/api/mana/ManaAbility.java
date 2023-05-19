package dev.auramc.auraskills.api.mana;

import dev.auramc.auraskills.api.ability.AbstractAbility;

import java.util.Locale;

public interface ManaAbility extends AbstractAbility {

    String getDisplayName(Locale locale);

    String getDescription(Locale locale);

    String getInfo(Locale locale);

    double getBaseValue();

    double getValuePerLevel();

    double getBaseCooldown();

    double getCooldownPerLevel();

    double getBaseManaCost();

    double getManaCostPerLevel();

    int getUnlock();

    int getLevelUp();

    int getMaxLevel();

}