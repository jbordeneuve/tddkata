package com.nyx.kata.conway;

public class ConwayAccu {

    private final Character left;
    private int right = 1;

    public ConwayAccu(Character left) {

        this.left = left;
    }

    public String concatenate() {
        return String.valueOf(right) + left;
    }

    public boolean exist(Character chIte) {
        return left.equals(chIte);
    }

    public void inc() {
        this.right++;
    }

}
