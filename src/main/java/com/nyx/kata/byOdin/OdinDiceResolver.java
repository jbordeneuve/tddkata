package com.nyx.kata.byOdin;

import com.google.common.collect.Lists;
import com.nyx.kata.byOdin.units.Dice;
import com.nyx.kata.byOdin.units.DivinityDice;
import com.nyx.kata.byOdin.units.MortalDice;
import com.nyx.kata.byOdin.units.WarriorUnit;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class OdinDiceResolver {

    private final List<WarriorUnit> warriorUnits;

    private List<DivinityDice> divinityDices = Lists.newArrayListWithCapacity(2);

    public OdinDiceResolver(List<MortalDice> unitDices) {

        this.warriorUnits = new OdinDiceDeckBuilder(unitDices).resolve();
    }

    public int compute() {

        enhanced();

        return this.warriorUnits.stream().map(WarriorUnit::getAttackStrength).reduce(0, Integer::sum);
    }

    private void enhanced() {

        Collections.sort(divinityDices);

        List<WarriorUnit> warriorEnhancedUnits = (new OdinDiceEnhancer(divinityDices).resolve(warriorUnits));
        warriorUnits.clear();
        warriorUnits.addAll(warriorEnhancedUnits);
    }

    public List<Dice> rawUnits() {

        Collections.sort(warriorUnits);

        final List<Dice> collect = warriorUnits.stream().map(WarriorUnit::rawUnit).collect(toList());
        collect.addAll(divinityDices);

        return collect;
    }

    public void blessing(DivinityDice divinityDice) {

        divinityDices.add(divinityDice);
    }

}
