package com.nyx.kata.conway;

import java.util.Stack;

import static java.util.stream.Collectors.joining;

class ConwaySequence {

    private Stack<ConwayAccu> stack;

    public ConwaySequence(String actual) {

        this.stack = new Stack<>();

        this.countOccurrenceIte(actual.toCharArray());
        // countOccurrenceRec(actual.toCharArray(), 0);
    }

    public ConwaySequence next() {
        return new ConwaySequence(print());
    }

    public String print() {
        return stack.stream().map(ConwayAccu::concatenate).collect(joining());
    }

//    private void countOccurrenceRec(char[] chArray, int i) {
//
//        incCharOrAddNewOne(chArray[i]);
//
//        if (chArray.length == 1 || chArray.length - 1 == i) {
//            return;
//        }
//
//        countOccurrenceRec(chArray, ++i);
//    }

    private void countOccurrenceIte(char[] chArray) {
//        new String(chArray).chars().forEach(c -> incCharOrAddNewOne((char) c));

        for (char c : chArray) {
            incCharOrAddNewOne(c);
        }
    }

    private boolean charExitOnLastSequence(char c) {
        return stack.size() != 0 && stack.peek().exist(c);
    }

    private void incCharOrAddNewOne(char c) {

        if (charExitOnLastSequence(c)) {
            incChar();
            return;
        }

        addNewChar(c);
    }

    private void incChar() {
        stack.peek().inc();
    }

    private void addNewChar(char c) {
        stack.push(new ConwayAccu(c));
    }

}
