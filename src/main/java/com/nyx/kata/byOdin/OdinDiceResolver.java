package com.nyx.kata.byOdin;

import com.nyx.kata.byOdin.units.Dice;
import com.nyx.kata.byOdin.units.DivinityDice;
import com.nyx.kata.byOdin.units.MortalDice;
import com.nyx.kata.byOdin.units.WarriorUnit;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class OdinDiceResolver {

    private final List<WarriorUnit> warriorUnits;

    public OdinDiceResolver(List<MortalDice> unitDices) {

        this.warriorUnits = new OdinDiceDeckBuilder(unitDices).resolve();
    }

    public int compute() {

        return this.warriorUnits.stream().map(WarriorUnit::getAttackStrength).reduce(0, Integer::sum);
    }

    public void enhanced(List<DivinityDice> divinityDices) {

        List<WarriorUnit> warriorEnhancedUnits = (new OdinDiceEnhancer(divinityDices).resolve(warriorUnits));
        warriorUnits.clear();
        warriorUnits.addAll(warriorEnhancedUnits);
    }

    public List<Dice> rawUnits() {

        return warriorUnits.stream().map(WarriorUnit::rawUnit).collect(toList());
    }

}
