package com.nyx.kata.byOdin;

import com.google.common.collect.ImmutableList;
import com.nyx.kata.byOdin.units.Dice;
import com.nyx.kata.byOdin.units.DivinityDice;
import com.nyx.kata.byOdin.units.MortalDice;
import io.vavr.Tuple2;
import io.vavr.control.Option;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class OdinArmyLoadBalancer {

    private Option<Tuple2<List<Dice>, List<Dice>>> balancedArmy = Option.none();

    public OdinArmyLoadBalancer(List<MortalDice> mortalDices, List<DivinityDice> divinityDices) {

        this.partition(mortalDices, null != divinityDices && divinityDices.size() != 0 ? divinityDices : ImmutableList.of());
    }

    public Option<Tuple2<List<Dice>, List<Dice>>> balancedArmy() {
        return this.balancedArmy;
    }

    private void partition(List<MortalDice> mortalDices, List<DivinityDice> divinityDices) {

        boolean[] flags = new boolean[mortalDices.size()];

        for (int i = 0; i != mortalDices.size(); ) {

            if (spreadWarrior(mortalDices, flags, divinityDices)) return;

            for (i = 0; i < mortalDices.size() && !(flags[i] = !flags[i]); i++) ;
        }
    }

    private boolean spreadWarrior(List<MortalDice> mortalDices, boolean[] mortalSpreadFlag, List<DivinityDice> divinityDices) {

        List<MortalDice> left = new ArrayList<>(), right = new ArrayList<>();

        IntStream.range(0, mortalDices.size())
                .forEach(it -> chooseSide(mortalSpreadFlag[it], mortalDices.get(it), left, right));

        if (divinityDices.isEmpty()) {

            final OdinArmyComparator odinArmyComparator = new OdinArmyComparator(left, right);

            if (odinArmyComparator.isBalanced()) {
                this.balancedArmy = Option.of(odinArmyComparator.warring());
                return true;
            }

        } else {

            boolean[] divinitySpreadFlag = new boolean[divinityDices.size()];

            for (int i = 0; i != divinityDices.size(); ) {

                final OdinArmyComparator odinArmyComparator = new OdinArmyComparator(left, right);

                IntStream.range(0, divinityDices.size())
                        .forEach(it -> chooseSide(divinitySpreadFlag[it], divinityDices.get(it), odinArmyComparator));

                for (i = 0; i < divinityDices.size() && !(divinitySpreadFlag[i] = !divinitySpreadFlag[i]); i++) ;

                if (odinArmyComparator.isBalanced()) {
                    this.balancedArmy = Option.of(odinArmyComparator.warring());
                    return true;
                }
            }
        }

        return false;
    }

    private void chooseSide(boolean flags, DivinityDice divinityDice, OdinArmyComparator odinArmyComparator) {

        if (divinityDice.isMiddle()) {
            odinArmyComparator.enhancedLeft(divinityDice);
            odinArmyComparator.enhancedRight(divinityDice);

            return;
        }

        if (flags) {
            odinArmyComparator.enhancedLeft(divinityDice);
            return;
        }

        odinArmyComparator.enhancedRight(divinityDice);
    }

    private void chooseSide(boolean flags, MortalDice mortalDice, List<MortalDice> left, List<MortalDice> right) {

        if (flags) {
            left.add(mortalDice);
            return;
        }

        right.add(mortalDice);
    }

}