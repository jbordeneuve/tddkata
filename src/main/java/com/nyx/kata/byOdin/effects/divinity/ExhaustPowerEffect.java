package com.nyx.kata.byOdin.effects.divinity;

import com.nyx.kata.byOdin.units.DivinityDice;
import com.nyx.kata.byOdin.units.EnhancedUnit;
import com.nyx.kata.byOdin.units.WarriorUnit;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ExhaustPowerEffect implements DivityEffect {

    @Override
    public void apply(DivinityDice divinityDice, List<WarriorUnit> refWarriorUnit) {

        final Optional<WarriorUnit> mawPowerful = refWarriorUnit
                .stream().max(Comparator.comparing(WarriorUnit::getAttackStrength));

        mawPowerful.ifPresent(it -> {
            refWarriorUnit.remove(it);
            refWarriorUnit.add(new EnhancedUnit(it, it.getAttackStrength() * -1));
        });
    }
}
