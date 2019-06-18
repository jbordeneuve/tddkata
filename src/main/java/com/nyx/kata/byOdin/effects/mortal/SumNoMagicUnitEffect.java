package com.nyx.kata.byOdin.effects.mortal;

import com.nyx.kata.byOdin.units.MagicianUnit;
import com.nyx.kata.byOdin.units.MortalDice;
import com.nyx.kata.byOdin.units.WarriorUnit;

import java.util.List;

import static com.nyx.kata.byOdin.units.MortalDice.MAGICIAN;

public class SumNoMagicUnitEffect implements MortalEffect {

    @Override
    public void apply(MortalDice curWarriorUnit, List<WarriorUnit> refWarriorUnit) {

        long otherMember = refWarriorUnit.stream()
                .filter(it -> !it.isSameTypeOfUnit(MAGICIAN))
                .count();

        refWarriorUnit.add(new MagicianUnit((int) otherMember));
    }

}
