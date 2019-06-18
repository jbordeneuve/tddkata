package com.nyx.kata.byOdin.units;

import com.nyx.kata.byOdin.effects.divinity.*;

import java.util.List;

public enum DivinityDice implements Dice, Comparable<DivinityDice> {

    FENRIR(false, new NeedMorePowerEffect()),
    JORMUNGAND(false, new ExhaustPowerEffect()),
    SLEIPNIR(false, new StrengthenPowerEffect()),
    FAFNIR(false, new WeakeningPowerEffect()),
    GULLINBURSTI(true, new SharpenPowerEffect()),
    HRAESVEIG(true, new ThickenPowerEffect());

    private final DivityEffect enhancedEffect;
    private final boolean isMiddle;

    DivinityDice(boolean isMiddle, DivityEffect effect) {

        this.isMiddle = isMiddle;
        this.enhancedEffect = effect;
    }

    public void enhanceWarrior(List<WarriorUnit> refWarriorUnit) {

        this.enhancedEffect.apply(this, refWarriorUnit);
    }

    public boolean isMiddle() {
        return isMiddle;
    }

}
