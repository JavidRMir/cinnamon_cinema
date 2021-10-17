package com.elitespectra.helper;

import java.util.Random;

public class RandomStub extends Random {
    private final int stubValue;

    public RandomStub(int value) {
        this.stubValue = value;
    }

    @Override
    public int nextInt(int value) {
        return this.stubValue;
    }
}
