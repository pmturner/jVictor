package jvictor.math.matrix;

import jvictor.math.matrix.interfaces.Matrixf;
import jvictor.math.vector.Vector3f;

public class Matrix3f implements Matrixf<Matrix3f, Vector3f> {

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

    @Override
    public Matrix3f addMatrices(Matrix3f m1, Matrix3f m2) {
        return null;
    }

    @Override
    public float determinant() {
        return 0;
    }

    @Override
    public Matrix3f invert() {
        return null;
    }

    @Override
    public Matrix3f invertCopy() {
        return null;
    }

    @Override
    public Matrix3f mul(Matrix3f m) {
        return null;
    }

    @Override
    public Matrix3f mulMatrices(Matrix3f m1, Matrix3f m2) {
        return null;
    }

    @Override
    public Matrix3f negate() {
        return null;
    }

    @Override
    public Matrix3f negateCopy() {
        return null;
    }

    @Override
    public Matrix3f setIdentity() {
        return null;
    }

    @Override
    public Matrix3f setZero() {
        return null;
    }

    @Override
    public Matrix3f sub(Matrix3f m) {
        return null;
    }

    @Override
    public Matrix3f subMatrices(Matrix3f m1, Matrix3f m2) {
        return null;
    }

    @Override
    public Vector3f transformVector(Vector3f v) {
        return null;
    }

    @Override
    public Vector3f transformVectorCopy(Vector3f v) {
        return null;
    }

    @Override
    public Matrix3f transpose() {
        return null;
    }

    @Override
    public Matrix3f transposeCopy() {
        return null;
    }

    @Override
    public String toString() {
        String s = "";
        s += "[[" + m00 + ", " + m01 + ", " + m02 + "]\n";
        s += " [" + m10 + ", " + m11 + ", " + m12 + "]\n";
        s += " [" + m20 + ", " + m21 + ", " + m22 + "]]";
        return s;
    }
}
