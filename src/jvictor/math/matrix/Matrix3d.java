package jvictor.math.matrix;

import jvictor.math.matrix.interfaces.Matrixd;
import jvictor.math.vector.Vector3d;

public class Matrix3d implements Matrixd<Matrix3d, Vector3d> {

    public double m00, m01, m02;
    public double m10, m11, m12;
    public double m20, m21, m22;

    public Matrix3d() {
        m00 = m11 = m22 = 1;
    }

    public Matrix3d(Matrix3d m) {
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
    public Matrix3d add(Matrix3d m) {
        return null;
    }

    @Override
    public Matrix3d addMatrices(Matrix3d m1, Matrix3d m2) {
        return null;
    }

    @Override
    public double determinant() {
        return 0;
    }

    public boolean equals(Matrix3d m) {
        return  (m00 == m.m00) && (m01 == m.m01) && (m02 == m.m02) &&
                (m10 == m.m10) && (m11 == m.m11) && (m12 == m.m12) &&
                (m20 == m.m20) && (m21 == m.m21) && (m22 == m.m22);
    }

    @Override
    public Matrix3d invert() {
        return null;
    }

    @Override
    public Matrix3d invertCopy() {
        return null;
    }

    @Override
    public Matrix3d mul(Matrix3d m) {
        return null;
    }

    @Override
    public Matrix3d mulMatrices(Matrix3d m1, Matrix3d m2) {
        return null;
    }

    @Override
    public Matrix3d negate() {
        return null;
    }

    @Override
    public Matrix3d negateCopy() {
        return null;
    }

    @Override
    public Matrix3d setIdentity() {
        return null;
    }

    @Override
    public Matrix3d setZero() {
        return null;
    }

    @Override
    public Matrix3d sub(Matrix3d m) {
        return null;
    }

    @Override
    public Matrix3d subMatrices(Matrix3d m1, Matrix3d m2) {
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

    @Override
    public Vector3d transformVector(Vector3d v) {
        return null;
    }

    @Override
    public Vector3d transformVectorCopy(Vector3d v) {
        return null;
    }

    @Override
    public Matrix3d transpose() {
        return null;
    }

    @Override
    public Matrix3d transposeCopy() {
        return null;
    }
}
