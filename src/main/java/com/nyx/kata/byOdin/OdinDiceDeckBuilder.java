package com.nyx.kata.byOdin;

import com.google.common.collect.Lists;
import com.nyx.kata.byOdin.units.MortalDice;
import com.nyx.kata.byOdin.units.WarriorUnit;

import java.util.Collections;
import java.util.List;

public class OdinDiceDeckBuilder {

    private final List<MortalDice> unitDices;

    public OdinDiceDeckBuilder(List<MortalDice> unitDices) {
        this.unitDices = unitDices;
    }

    public List<WarriorUnit> resolve() {

        Collections.sort(unitDices);

        List<WarriorUnit> warriorEnhanced = Lists.newArrayListWithCapacity(unitDices.size());
        this.unitDices.forEach(it -> applyEffect(it, warriorEnhanced));

        return Lists.newArrayList(warriorEnhanced);
    }

    private void applyEffect(MortalDice it, List<WarriorUnit> refWarriorUnit) {

        it.hireWarrior(refWarriorUnit);
    }

}
