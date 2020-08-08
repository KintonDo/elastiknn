package com.klibisz.elastiknn.models;

public class L2LshJava implements HashingModel.DenseFloat {
    @Override
    public HashAndFreq[] hash(float[] values) {
        return new HashAndFreq[0];
    }
}
