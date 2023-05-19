package dev.auramc.auraskills.api.skill;

import com.google.common.collect.ImmutableList;
import dev.auramc.auraskills.api.ability.Ability;
import dev.auramc.auraskills.api.annotation.Inject;
import dev.auramc.auraskills.api.mana.ManaAbility;
import dev.auramc.auraskills.api.util.NamespacedId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;

public enum Skills implements Skill {

    FARMING,
    FORAGING,
    MINING,
    FISHING,
    EXCAVATION,
    ARCHERY,
    FIGHTING,
    DEFENSE,
    AGILITY,
    ENDURANCE,
    ALCHEMY,
    ENCHANTING,
    SORCERY,
    HEALING,
    FORGING;

    @Inject
    private SkillProvider provider;

    private final NamespacedId id;

    Skills() {
        this.id = NamespacedId.from(NamespacedId.AURASKILLS, this.name().toLowerCase(Locale.ROOT));
    }

    @Override
    public NamespacedId getId() {
        return id;
    }

    @Override
    public @NotNull ImmutableList<Ability> getAbilities() {
        validate();
        return provider.getAbilities(this);
    }

    @Override
    public @Nullable ManaAbility getManaAbility() {
        validate();
        return provider.getManaAbility(this);
    }

    @Override
    public String getDisplayName(Locale locale) {
        validate();
        return provider.getDisplayName(this, locale);
    }

    @Override
    public String getDescription(Locale locale) {
        validate();
        return provider.getDescription(this, locale);
    }

    private void validate() {
        if (provider == null) {
            throw new IllegalStateException("Attempting to access skill provider before it has been injected!");
        }
    }

}