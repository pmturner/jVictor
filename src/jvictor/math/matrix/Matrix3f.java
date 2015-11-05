package jvictor.math.matrix;

import jvictor.math.matrix.interfaces.Matrixf;

public class Matrix3f implements Matrixf<Matrix3f> {

    public float m00, m01, m02;
    public float m10, m11, m12;
    public float m20, m21, m22;

    public Matrix3f() {
        m00 = m11 = m22 = 1;
    }

    public Matrix3f(Matrix3f m) {
        this.m00 = m.m00;
        this.m01 = m.m01;
        this.m02 = m.m02;

        this.m10 = m.m10;
        this.m11 = m.m11;
        this.m12 = m.m12;

        this.m20 = m.m20;
        this.m21 = m.m21;
        this.m22 = m.m22;
    }

    @Override
    public Matrix3f add(Matrix3f m) {
        return null;
    }
}
