package com.nyx.kata.byOdin;

import com.google.common.collect.Lists;
import com.nyx.kata.byOdin.units.Dice;
import com.nyx.kata.byOdin.units.DivinityDice;
import com.nyx.kata.byOdin.units.MortalDice;
import com.nyx.kata.tools.TimingExtension;
import io.vavr.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static com.google.common.collect.ImmutableList.copyOf;
import static com.nyx.kata.byOdin.units.DivinityDice.*;
import static com.nyx.kata.byOdin.units.MortalDice.*;
import static java.text.MessageFormat.format;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

@ExtendWith(TimingExtension.class)
public class ByOdinChallengeTest {

    private static final Function<Enum[], String> enumToStr = (dices) -> stream(dices).map(Enum::name).collect(joining(","));

    private static Stream<Arguments> odinArmyLoadBalancer() {

        return Stream.of(
                // Custom
                // of(false, enumToStr.apply(new MortalDice[]{HEROES, HEROES, HEROES, HEROES, HEROES, HEROES, HEROES}), null),
                // of(false, enumToStr.apply(new MortalDice[]{LEADER, LEADER, LEADER, LEADER, LEADER, LEADER, LEADER}), null),
                // of(false, enumToStr.apply(new MortalDice[]{SOLDIER, SOLDIER, SOLDIER, SOLDIER, SOLDIER, SOLDIER, SOLDIER}), null),
                // of(false, enumToStr.apply(new MortalDice[]{TRAITOR, TRAITOR, TRAITOR, TRAITOR, TRAITOR, TRAITOR, TRAITOR}), null),
                // of(false, enumToStr.apply(new MortalDice[]{CURSED, CURSED, CURSED, CURSED, CURSED, CURSED, CURSED}), null),
                // of(true, enumToStr.apply(new MortalDice[]{MAGICIAN, MAGICIAN, MAGICIAN, MAGICIAN, MAGICIAN, MAGICIAN, MAGICIAN}), null),

                // BROK
                of(true, enumToStr.apply(new MortalDice[]{HEROES, HEROES, HEROES, LEADER, SOLDIER, SOLDIER, SOLDIER}), null),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, HEROES, LEADER, LEADER, LEADER, LEADER, TRAITOR}), null),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, HEROES, HEROES, LEADER, LEADER, LEADER, CURSED}), null),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, HEROES, HEROES, HEROES, SOLDIER, TRAITOR, CURSED}), null),
                of(true, enumToStr.apply(new MortalDice[]{SOLDIER, SOLDIER, SOLDIER, SOLDIER, SOLDIER, SOLDIER, MAGICIAN}), null),

                // LOKI
                of(true, enumToStr.apply(new MortalDice[]{HEROES, HEROES, LEADER, SOLDIER, SOLDIER, SOLDIER, MAGICIAN}), null),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, HEROES, LEADER, SOLDIER, SOLDIER, CURSED, MAGICIAN}), null),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, LEADER, LEADER, LEADER, CURSED, CURSED, MAGICIAN}), null),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, HEROES, LEADER, LEADER, SOLDIER, TRAITOR, MAGICIAN}), null),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, HEROES, LEADER, TRAITOR, TRAITOR, TRAITOR, MAGICIAN}), null),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, HEROES, LEADER, LEADER, TRAITOR, CURSED, MAGICIAN}), null),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, HEROES, SOLDIER, SOLDIER, TRAITOR, MAGICIAN, MAGICIAN}), null),
                of(true, enumToStr.apply(new MortalDice[]{SOLDIER, CURSED, CURSED, MAGICIAN, MAGICIAN, MAGICIAN, MAGICIAN}), null),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, LEADER, LEADER, CURSED, MAGICIAN, MAGICIAN, MAGICIAN}), null),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, SOLDIER, TRAITOR, TRAITOR, MAGICIAN, MAGICIAN, MAGICIAN}), null),

                // FRIGG
                // --> FENRIR
                of(true, enumToStr.apply(new MortalDice[]{HEROES, HEROES, HEROES, LEADER, SOLDIER, SOLDIER, MAGICIAN}), enumToStr.apply(new DivinityDice[]{FENRIR})),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, LEADER, LEADER, LEADER, SOLDIER, TRAITOR, MAGICIAN}), enumToStr.apply(new DivinityDice[]{FENRIR})),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, SOLDIER, SOLDIER, SOLDIER, TRAITOR, MAGICIAN, MAGICIAN}), enumToStr.apply(new DivinityDice[]{FENRIR})),

                // --> JORMUNGAND
                of(true, enumToStr.apply(new MortalDice[]{HEROES, SOLDIER, SOLDIER, CURSED, CURSED, CURSED, MAGICIAN}), enumToStr.apply(new DivinityDice[]{JORMUNGAND})),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, TRAITOR, TRAITOR, CURSED, MAGICIAN, MAGICIAN, MAGICIAN}), enumToStr.apply(new DivinityDice[]{JORMUNGAND})),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, HEROES, LEADER, TRAITOR, CURSED, MAGICIAN, MAGICIAN}), enumToStr.apply(new DivinityDice[]{JORMUNGAND})),

                // --> SLEIPNIR
                of(true, enumToStr.apply(new MortalDice[]{HEROES, LEADER, LEADER, LEADER, SOLDIER, SOLDIER, MAGICIAN}), enumToStr.apply(new DivinityDice[]{SLEIPNIR})),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, HEROES, LEADER, LEADER, SOLDIER, TRAITOR, MAGICIAN}), enumToStr.apply(new DivinityDice[]{SLEIPNIR})),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, LEADER, TRAITOR, CURSED, MAGICIAN, MAGICIAN, MAGICIAN}), enumToStr.apply(new DivinityDice[]{SLEIPNIR})),

                // --> FAFNIR
                of(true, enumToStr.apply(new MortalDice[]{SOLDIER, SOLDIER, SOLDIER, CURSED, CURSED, CURSED, MAGICIAN}), enumToStr.apply(new DivinityDice[]{FAFNIR})),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, HEROES, HEROES, HEROES, TRAITOR, CURSED, MAGICIAN}), enumToStr.apply(new DivinityDice[]{FAFNIR})),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, HEROES, LEADER, SOLDIER, TRAITOR, MAGICIAN, MAGICIAN}), enumToStr.apply(new DivinityDice[]{FAFNIR})),

                // --> GULLINBURSTI
                of(true, enumToStr.apply(new MortalDice[]{LEADER, LEADER, LEADER, SOLDIER, CURSED, CURSED, MAGICIAN}), enumToStr.apply(new DivinityDice[]{GULLINBURSTI})),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, HEROES, TRAITOR, CURSED, CURSED, MAGICIAN, MAGICIAN}), enumToStr.apply(new DivinityDice[]{GULLINBURSTI})),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, TRAITOR, TRAITOR, CURSED, MAGICIAN, MAGICIAN, MAGICIAN}), enumToStr.apply(new DivinityDice[]{GULLINBURSTI})),

                // --> HRAESVEIG
                of(true, enumToStr.apply(new MortalDice[]{HEROES, HEROES, LEADER, SOLDIER, CURSED, CURSED, MAGICIAN}), enumToStr.apply(new DivinityDice[]{HRAESVEIG})),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, HEROES, LEADER, SOLDIER, SOLDIER, TRAITOR, MAGICIAN}), enumToStr.apply(new DivinityDice[]{HRAESVEIG})),
                of(true, enumToStr.apply(new MortalDice[]{HEROES, HEROES, HEROES, SOLDIER, TRAITOR, MAGICIAN, MAGICIAN}), enumToStr.apply(new DivinityDice[]{HRAESVEIG})),

                // --> THOR
                of(true, enumToStr.apply(new MortalDice[]{HEROES, HEROES, SOLDIER, SOLDIER, TRAITOR, MAGICIAN, MAGICIAN}), enumToStr.apply(new DivinityDice[]{SLEIPNIR, GULLINBURSTI}))
        );
    }

    @ParameterizedTest(name = "Challenge n°{index} => the solution of : ''{1}'', should found ''{0}''.")
    @MethodSource("odinArmyLoadBalancer")
    @DisplayName("Should be able to found a solution of Odin challenge.")
    void shouldBalanceStrengthOfArmy(boolean result,
                                     @ConvertWith(StToArrayOfWarrior.class) List<MortalDice> mortalDices,
                                     @ConvertWith(StToArrayOfDivinity.class) List<DivinityDice> divinityDices) {

        // https://en.wikipedia.org/wiki/Partition_problem
        // https://en.wikipedia.org/wiki/Partition_(number_theory)

        final OdinArmyLoadBalancer odinArmyLoadBalancer = new OdinArmyLoadBalancer(copyOf(mortalDices), copyOf(divinityDices));

        assertEquals(result, odinArmyLoadBalancer.balancedArmy().isDefined());

        if (!odinArmyLoadBalancer.balancedArmy().isDefined()) {
            return;
        }

        final Tuple2<List<Dice>, List<Dice>> listListTuple2 = odinArmyLoadBalancer.balancedArmy().get();

        System.out.println(format("left army {0} vs right {1}.", listListTuple2._1, listListTuple2._2));
    }

    private static class StToArrayOfWarrior extends SimpleArgumentConverter {

        @Override
        protected List<MortalDice> convert(Object source, Class<?> targetType) throws ArgumentConversionException {

            return stream(((String) source).split(",")).map(MortalDice::valueOf).collect(toList());
        }
    }

    private static class StToArrayOfDivinity extends SimpleArgumentConverter {

        @Override
        protected List<DivinityDice> convert(Object source, Class<?> targetType) throws ArgumentConversionException {

            if (null == source || ((String) source).length() == 0) {
                return Lists.newArrayList();
            }

            return stream(((String) source).split(",")).map(DivinityDice::valueOf).collect(toList());
        }
    }

}
