package com.nyx.kata.byOdin;

import com.nyx.kata.byOdin.units.Dice;
import com.nyx.kata.byOdin.units.MortalDice;
import io.vavr.Tuple2;
import io.vavr.control.Option;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class OdinArmyLoadBalancer {

    private Option<Tuple2<List<Dice>, List<Dice>>> balancedArmy = Option.none();

    public OdinArmyLoadBalancer(List<MortalDice> mortalDices) {

        this.partition(mortalDices);
    }

    public Option<Tuple2<List<Dice>, List<Dice>>> balancedArmy() {
        return this.balancedArmy;
    }

    private void partition(List<MortalDice> mortalDices) {

        boolean[] flags = new boolean[mortalDices.size()];

        for (int i = 0; i != mortalDices.size(); ) {

            if (spreadWarrior(mortalDices, flags)) return;

            for (i = 0; i < mortalDices.size() && !(flags[i] = !flags[i]); i++) ;
        }
    }

    private boolean spreadWarrior(List<MortalDice> mortalDices, boolean[] flags) {

        List<MortalDice> left = new ArrayList<>(), right = new ArrayList<>();

        IntStream.range(0, mortalDices.size())
                .forEach(it -> chooseSide(flags[it], mortalDices.get(it), left, right));

        final OdinArmyComparator odinArmyComparator = new OdinArmyComparator(left, right);

        if (odinArmyComparator.isBalanced()) {
            this.balancedArmy = Option.of(odinArmyComparator.warring());
            return true;
        }

        return false;
    }

    private void chooseSide(boolean flags, MortalDice mortalDice, List<MortalDice> left, List<MortalDice> right) {

        if (flags) {
            left.add(mortalDice);
            return;
        }

        right.add(mortalDice);
    }

}