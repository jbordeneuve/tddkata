package com.nyx.kata.byOdin.units;

public abstract class WarriorUnit {

    private final MortalDice unitDice;

    public WarriorUnit(MortalDice unitDice) {
        this.unitDice = unitDice;
    }

    public boolean isSameTypeOfUnit(MortalDice unitDice) {
        return this.unitDice == unitDice;
    }

    public int getAttackStrength() {
        return unitDice.getBasicStrength();
    }

    public MortalDice rawUnit() {
        return unitDice;
    }

}

