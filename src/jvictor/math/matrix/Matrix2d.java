package jvictor.math.matrix;

import jvictor.math.matrix.interfaces.Matrixd;
import jvictor.math.vector.Vector2d;

public class Matrix2d implements Matrixd<Matrix2d, Vector2d> {

    public double m00;
    public double m01;
    public double m10;
    public double m11;

    public Matrix2d() {
        this(1, 0, 0, 1);
    }

    public Matrix2d(Matrix2d src) {
        this (src.m00, src.m01, src.m10, src.m11);
    }

    public Matrix2d(double m00, double m01, double m10, double m11) {
        this.m00 = m00; this.m01 = m01;
        this.m10 = m10; this.m11 = m11;
    }

    @Override
    public Matrix2d add(Matrix2d m) {
        m00 += m.m00; m01 += m.m01;
        m10 += m.m10; m11 += m.m11;
        return this;
    }

    @Override
    public Matrix2d addMatrices(Matrix2d m1, Matrix2d m2) {
        Matrix2d m1Copy = new Matrix2d(m1);
        return m1Copy.add(m2);
    }

    @Override
    public double determinant() {
        return (m00 * m11) - (m01 * m10);
    }

    @Override
    public Matrix2d invert() {
        double det = determinant();
        if (det == 0) {
            throw new UnsupportedOperationException("Cannot invert a matrix with a determinant of 0.");
        }

        double invDet = 1.0 / det;
        double temp = m00;

        m00 =  m11 *  invDet;
        m01 =  m01 * -invDet;
        m10 =  m10 * -invDet;
        m11 = temp *  invDet;

        return this;
    }

    @Override
    public Matrix2d invertCopy() {
        return new Matrix2d(this).invert();
    }

    @Override
    public Matrix2d mul(Matrix2d m2) {
        Matrix2d m1 = new Matrix2d(this);

        m00 = (m1.m00 * m2.m00) + (m1.m01 * m2.m10);
        m01 = (m1.m00 * m2.m01) + (m1.m01 * m2.m11);
        m10 = (m1.m10 * m2.m00) + (m1.m11 * m2.m10);
        m11 = (m1.m10 * m2.m01) + (m1.m11 * m2.m11);

        return this;
    }

    @Override
    public Matrix2d mulMatrices(Matrix2d m1, Matrix2d m2) {
        return null;
    }

    @Override
    public Matrix2d negate() {
        return null;
    }

    @Override
    public Matrix2d negateCopy() {
        return null;
    }

    @Override
    public Matrix2d setIdentity() {
        m00 = 1; m01 = 0;
        m10 = 0; m11 = 1;
        return this;
    }

    @Override
    public Matrix2d setZero() {
        return null;
    }

    @Override
    public Matrix2d sub(Matrix2d m) {
        return null;
    }

    @Override
    public Matrix2d subMatrices(Matrix2d m1, Matrix2d m2) {
        return null;
    }

    @Override
    public Vector2d transformVector(Vector2d v) {
        return null;
    }

    @Override
    public Vector2d transformVectorCopy(Vector2d v) {
        return null;
    }

    @Override
    public Matrix2d transpose() {
        return null;
    }

    @Override
    public Matrix2d transposeCopy() {
        return null;
    }

    public boolean equals(Matrix2d m) {
        return  (m00 == m.m00) && (m01 == m.m01) &&
                (m10 == m.m10) && (m11 == m.m11);
    }
}
