package com.nyx.kata.byOdin.effects.divinity;

import com.nyx.kata.byOdin.units.DivinityDice;
import com.nyx.kata.byOdin.units.EnhancedUnit;
import com.nyx.kata.byOdin.units.MortalDice;
import com.nyx.kata.byOdin.units.WarriorUnit;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class SharpenPowerEffect implements DivityEffect {

    @Override
    public void apply(DivinityDice divinityDice, List<WarriorUnit> refWarriorUnit) {

        final Map<MortalDice, List<WarriorUnit>> warriorGroupByType = refWarriorUnit.stream().collect(groupingBy(WarriorUnit::rawUnit));

        final List<WarriorUnit> warriorToEnhanced = warriorGroupByType.entrySet()
                .stream().filter(e -> e.getValue().size() != 1)
                .flatMap(e -> e.getValue().stream()).collect(toList());

        warriorToEnhanced.forEach(it -> {
            refWarriorUnit.set(refWarriorUnit.indexOf(it), new EnhancedUnit(it, it.getAttackStrength() + 1));
        });

    }
}
