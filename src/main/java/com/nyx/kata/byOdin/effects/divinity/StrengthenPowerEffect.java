package com.nyx.kata.byOdin.effects.divinity;

import com.nyx.kata.byOdin.units.DivinityDice;
import com.nyx.kata.byOdin.units.EnhancedUnit;
import com.nyx.kata.byOdin.units.WarriorUnit;

import java.util.List;

public class StrengthenPowerEffect implements DivityEffect {

    @Override
    public void apply(DivinityDice divinityDice, List<WarriorUnit> refWarriorUnit) {

        refWarriorUnit.replaceAll(it -> new EnhancedUnit(it, it.getAttackStrength() + 1));
    }
}
