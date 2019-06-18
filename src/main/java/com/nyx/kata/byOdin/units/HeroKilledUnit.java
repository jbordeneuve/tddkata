package com.nyx.kata.byOdin.units;

import static com.nyx.kata.byOdin.units.MortalDice.HEROES;

public class HeroKilledUnit extends WarriorUnit {

    public HeroKilledUnit() {
        super(HEROES);
    }

    public int getAttackStrength() {
        return 0;
    }

}

