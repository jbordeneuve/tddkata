package com.nyx.kata.byOdin;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.nyx.kata.byOdin.units.DivinityDice;
import com.nyx.kata.byOdin.units.WarriorUnit;

import java.util.List;

public class OdinDiceEnhancer {

    private final List<DivinityDice> divinityDices;

    public OdinDiceEnhancer(List<DivinityDice> divinityDices) {

        this.divinityDices = ImmutableList.copyOf(divinityDices);
    }

    public List<WarriorUnit> resolve(List<WarriorUnit> refWarriorUnit) {

        this.divinityDices.forEach(it -> applyEffect(it, refWarriorUnit));

        return Lists.newArrayList(refWarriorUnit);
    }

    private void applyEffect(DivinityDice it, List<WarriorUnit> refWarriorUnit) {

        it.enhanceWarrior(refWarriorUnit);
    }

}
