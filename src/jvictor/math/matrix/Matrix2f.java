package jvictor.math.matrix;

import jvictor.math.matrix.interfaces.Matrixf;
import jvictor.math.vector.Vector2f;

public class Matrix2f implements Matrixf<Matrix2f, Vector2f> {

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

    @Override
    public Matrix2f addMatrices(Matrix2f m1, Matrix2f m2) {
        return null;
    }

    @Override
    public float determinant() {
        return 0;
    }

    public boolean equals(Matrix2f m) {
        return (m00 == m.m00) && (m01 == m.m01) &&
                (m10 == m.m10) && (m11 == m.m11);
    }

    @Override
    public Matrix2f invert() {
        return null;
    }

    @Override
    public Matrix2f invertCopy() {
        return null;
    }

    @Override
    public Matrix2f mul(Matrix2f m) {
        return null;
    }

    @Override
    public Matrix2f mulMatrices(Matrix2f m1, Matrix2f m2) {
        return null;
    }

    @Override
    public Matrix2f negate() {
        return null;
    }

    @Override
    public Matrix2f negateCopy() {
        return null;
    }

    @Override
    public Matrix2f setIdentity() {
        return null;
    }

    @Override
    public Matrix2f setZero() {
        return null;
    }

    @Override
    public Matrix2f sub(Matrix2f m) {
        return null;
    }

    @Override
    public Matrix2f subMatrices(Matrix2f m1, Matrix2f m2) {
        return null;
    }

    @Override
    public String toString() {
        String s = "";
        s += "[[" + m00 + ", " + m01 + "]\n";
        s += " [" + m10 + ", " + m11 + "]]";
        return s;
    }

    @Override
    public Vector2f transformVector(Vector2f v) {
        return null;
    }

    @Override
    public Vector2f transformVectorCopy(Vector2f v) {
        return null;
    }

    @Override
    public Matrix2f transpose() {
        return null;
    }

    @Override
    public Matrix2f transposeCopy() {
        return null;
    }
}
