package com.nyx.kata.byOdin;

import com.nyx.kata.byOdin.units.Dice;
import com.nyx.kata.byOdin.units.DivinityDice;
import com.nyx.kata.byOdin.units.MortalDice;
import io.vavr.Tuple2;

import java.util.List;

public class OdinArmyComparator {

    private final OdinDiceResolver left;

    private final OdinDiceResolver right;

    public OdinArmyComparator(List<MortalDice> left, List<MortalDice> right) {

        this.left = new OdinDiceResolver(left);
        this.right = new OdinDiceResolver(right);
    }

    public void enhancedLeft(DivinityDice divinityDice) {

        this.left.blessing(divinityDice);
    }

    public void enhancedRight(DivinityDice divinityDice) {

        this.right.blessing(divinityDice);
    }

    public boolean isBalanced() {

        return left.compute() == right.compute();
    }

    public Tuple2<List<Dice>, List<Dice>> warring() {

        return new Tuple2<>(this.left.rawUnits(), this.right.rawUnits());
    }


}