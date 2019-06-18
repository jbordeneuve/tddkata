package com.nyx.kata.byOdin.effects.mortal;

import com.nyx.kata.byOdin.units.CommonUnit;
import com.nyx.kata.byOdin.units.HeroKilledUnit;
import com.nyx.kata.byOdin.units.MortalDice;
import com.nyx.kata.byOdin.units.WarriorUnit;

import java.util.List;
import java.util.Optional;

import static com.nyx.kata.byOdin.units.MortalDice.HEROES;
import static com.nyx.kata.byOdin.units.MortalDice.TRAITOR;

public class KillHeroEffect implements MortalEffect {

    @Override
    public void apply(MortalDice dice, List<WarriorUnit> refWarriorUnit) {

        final Optional<WarriorUnit> heroesKilled = refWarriorUnit.stream()
                .filter(it -> it.isSameTypeOfUnit(HEROES) && it instanceof CommonUnit).findFirst();

        heroesKilled.ifPresent(it -> {
            refWarriorUnit.remove(it);
            refWarriorUnit.add(new HeroKilledUnit());
        });

        refWarriorUnit.add(new CommonUnit(TRAITOR));
    }

}
