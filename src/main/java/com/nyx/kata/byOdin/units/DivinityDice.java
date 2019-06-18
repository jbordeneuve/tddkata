package com.nyx.kata.byOdin.units;

import com.nyx.kata.byOdin.effects.divinity.DivityEffect;
import com.nyx.kata.byOdin.effects.divinity.NeedMorePowerEffect;

import java.util.List;

public enum DivinityDice implements Dice, Comparable<DivinityDice> {

    FENRIR,
    JORMUNGAND,
    SLEIPNIR,
    FAFNIR,
    GULLINBURSTI,
    HRAESVEIG;

    private final DivityEffect enhancedEffect;

    DivinityDice() {
        enhancedEffect = new NeedMorePowerEffect();
    }

    public void enhanceWarrior(List<WarriorUnit> refWarriorUnit) {

        this.enhancedEffect.apply(this, refWarriorUnit);
    }
}
