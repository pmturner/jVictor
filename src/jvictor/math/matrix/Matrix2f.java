package jvictor.math.matrix;

import jvictor.math.matrix.interfaces.Matrixf;

public class Matrix2f implements Matrixf<Matrix2f> {

    public float m00, m01;
    public float m10, m11;

    public Matrix2f() {
        m00 = m11 = 1;
    }

    public Matrix2f(Matrix2f m) {
        this.m00 = m.m00;
        this.m01 = m.m01;

        this.m10 = m.m10;
        this.m11 = m.m11;
    }

    @Override
    public Matrix2f add(Matrix2f m) {
        return null;
    }
}
