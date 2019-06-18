package com.nyx.kata.byOdin.units;

import com.nyx.kata.byOdin.effects.Effect;
import com.nyx.kata.byOdin.effects.mortal.HireEffect;
import com.nyx.kata.byOdin.effects.mortal.KillHeroEffect;
import com.nyx.kata.byOdin.effects.mortal.MortalEffect;
import com.nyx.kata.byOdin.effects.mortal.SumNoMagicUnitEffect;

import java.util.List;

public enum MortalDice implements Dice, Comparable<MortalDice> {

    HEROES(3),
    LEADER(2),
    SOLDIER(1),

    CURSED(-1),
    TRAITOR(1, new KillHeroEffect()),
    MAGICIAN(0, new SumNoMagicUnitEffect());

    private final int basicStrength;

    private final MortalEffect enhancedEffect;

    MortalDice(int basicStrength) {
        this.basicStrength = basicStrength;
        this.enhancedEffect = new HireEffect();
    }

    MortalDice(int basicStrength, MortalEffect effect) {
        this.basicStrength = basicStrength;
        this.enhancedEffect = effect;
    }

    public void hireWarrior(List<WarriorUnit> refWarriorUnit) {
        this.enhancedEffect.apply(this, refWarriorUnit);
    }

    public int getBasicStrength() {
        return this.basicStrength;
    }

}
