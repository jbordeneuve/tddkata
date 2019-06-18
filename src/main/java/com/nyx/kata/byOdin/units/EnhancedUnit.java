package com.nyx.kata.byOdin.units;

public class EnhancedUnit extends WarriorUnit {

    private final int computedStrength;

    private WarriorUnit warriorUnit;

    public EnhancedUnit(WarriorUnit warriorUnit, int computedStrength) {
        super(warriorUnit.rawUnit());

        this.computedStrength = computedStrength;
    }

    @Override
    public int getAttackStrength() {
        return computedStrength;
    }

}
