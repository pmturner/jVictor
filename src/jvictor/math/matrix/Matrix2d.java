package jvictor.math.matrix;

import jvictor.math.matrix.interfaces.Matrixd;

public class Matrix2d implements Matrixd<Matrix2d> {

    public double m00 = 1;
    public double m01 = 0;
    public double m10 = 0;
    public double m11 = 1;

    public Matrix2d() {
    }

    public Matrix2d(Matrix2f src) {
        this.m00 = src.m00;
        this.m01 = src.m01;
        this.m10 = src.m10;
        this.m11 = src.m11;
    }

    @Override
    public Matrix2d add(Matrix2d m) {
        return null;
    }
}
