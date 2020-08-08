package com.klibisz.elastiknn.models;

public class ExactModel {

    public interface DenseFloat {
        float similarity(float[] V1, float[] V2);
    }

    public interface SparseBool {
        float similarity(int[] trueIndices1, int[] trueIndices2, int totalIndices);
    }


}
