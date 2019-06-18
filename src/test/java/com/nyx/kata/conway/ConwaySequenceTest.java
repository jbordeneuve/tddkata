package com.nyx.kata.conway;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConwaySequenceTest {

    @DisplayName("Should be able print the next conway sequence.")
    @CsvSource(value = {"1:11", "2:12", "11:21", "21:1211", "1211:111221", "111221:312211"}, delimiter = ':')
    @ParameterizedTest(name = "{index} => Check the next sequence of : ''{0}'', should be ''{1}''.")
    void shouldPrintNextConwaySequence(String actual, String expected) {

        assertEquals(expected, new ConwaySequence(actual).print());
    }

    @Test
    @DisplayName("Should be able to chain the next conway sequence.")
    void shouldChainNextConwaySequence() {

        assertEquals("312211", new ConwaySequence("1").next().next().next().next().print());
    }

}
