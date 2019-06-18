package com.nyx.kata.byOdin.units;

import static com.nyx.kata.byOdin.units.MortalDice.MAGICIAN;

public class MagicianUnit extends WarriorUnit {

    private final int computedStrength;

    public MagicianUnit(int computedStrength) {
        super(MAGICIAN);

        this.computedStrength = computedStrength;
    }

    @Override
    public int getAttackStrength() {
        return computedStrength;
    }

}

