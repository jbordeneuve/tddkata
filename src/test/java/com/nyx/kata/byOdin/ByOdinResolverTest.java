package com.nyx.kata.byOdin;

import com.nyx.kata.byOdin.units.MortalDice;
import com.nyx.kata.tools.TimingExtension;
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

import static com.nyx.kata.byOdin.units.MortalDice.*;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

@ExtendWith(TimingExtension.class)
public class ByOdinResolverTest {

    private static final Function<MortalDice[], String> enumToStr = (dices) ->
            stream(dices).map(Enum::name).collect(joining(","));

    private static Stream<Arguments> strengthOfTwoArmies() {

        return Stream.of(
                of(true,
                        enumToStr.apply(new MortalDice[]{HEROES, SOLDIER, MAGICIAN, TRAITOR, CURSED}),
                        enumToStr.apply(new MortalDice[]{SOLDIER, LEADER, HEROES, CURSED})),

                of(false,
                        enumToStr.apply(new MortalDice[]{SOLDIER, MAGICIAN, CURSED}),
                        enumToStr.apply(new MortalDice[]{LEADER, HEROES, CURSED})));
    }

    private static Stream<Arguments> odinDiceSumParam() {

        return Stream.of(
                of(5, enumToStr.apply(new MortalDice[]{SOLDIER, LEADER, HEROES, CURSED})),
                of(5, enumToStr.apply(new MortalDice[]{HEROES, SOLDIER, MAGICIAN, TRAITOR, CURSED})),
                of(5, enumToStr.apply(new MortalDice[]{HEROES, HEROES, HEROES, TRAITOR, TRAITOR})),
                of(10, enumToStr.apply(new MortalDice[]{LEADER, HEROES, HEROES, TRAITOR, TRAITOR, TRAITOR, TRAITOR, TRAITOR, TRAITOR, TRAITOR, TRAITOR})),
                of(20, enumToStr.apply(new MortalDice[]{MAGICIAN, TRAITOR, HEROES, HEROES, HEROES, LEADER, MAGICIAN, CURSED, TRAITOR})));
    }

    @ParameterizedTest(name = "{index} => Check the sum of : ''{1}'', should be ''{0}''.")
    @MethodSource("odinDiceSumParam")
    @DisplayName("Should be able to compute the sum of collection of Odin dice.")
    void shouldComputeStrengthOfArmy(int result, @ConvertWith(StToArrays.class) List<MortalDice> dices) {

        assertEquals(result, new OdinDiceResolver(dices).compute());
    }

    @ParameterizedTest(name = "{index} => Check the strength of : ''{1}'', and ''{2}''.")
    @MethodSource("strengthOfTwoArmies")
    @DisplayName("Should be able to compare the strength of two armies.")
    void shouldCompareStrengthTwoArmies(boolean isBalanced,
                                        @ConvertWith(StToArrays.class) List<MortalDice> left,
                                        @ConvertWith(StToArrays.class) List<MortalDice> right) {

        assertEquals(isBalanced, new OdinArmyComparator(left, right).isBalanced());
    }

    private static class StToArrays extends SimpleArgumentConverter {

        @Override
        protected List<MortalDice> convert(Object source, Class<?> targetType) throws ArgumentConversionException {

            return stream(((String) source).split(",")).map(MortalDice::valueOf).collect(toList());
        }
    }

}
