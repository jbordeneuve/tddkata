package com.nyx.kata.byOdin.effects.mortal;

import com.nyx.kata.byOdin.units.CommonUnit;
import com.nyx.kata.byOdin.units.MortalDice;
import com.nyx.kata.byOdin.units.WarriorUnit;

import java.util.List;

public class HireEffect implements MortalEffect {

    @Override
    public void apply(MortalDice dice, List<WarriorUnit> refWarriorUnit) {

        refWarriorUnit.add(new CommonUnit(dice));
    }
}
