package jvictor.math.matrix;

import jvictor.math.matrix.interfaces.Matrixf;

public class Matrix2f implements Matrixf<Matrix2f> {

    public float m00 = 1;
    public float m01 = 0;
    public float m10 = 0;
    public float m11 = 1;

    public Matrix2f () {}

    public Matrix2f (Matrix2f src) {
        this.m00 = src.m00;
        this.m01 = src.m01;
        this.m10 = src.m10;
        this.m11 = src.m11;
    }

    @Override
    public Matrix2f add(Matrix2f m) {
        return null;
    }
}
