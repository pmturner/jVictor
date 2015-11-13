package jvictor.math.matrix;

import jvictor.math.vector.Vector2d;
import jvictor.math.vector.Vector3d;
import jvictor.math.vector.Vector4d;

public class Matrix4d implements jvictor.math.matrix.interfaces.Matrix4d<Matrix4d, Vector4d> {

    public double m00, m01, m02, m03;
    public double m10, m11, m12, m13;
    public double m20, m21, m22, m23;
    public double m30, m31, m32, m33;

    public Matrix4d() {
        m00 = m11 = m22 = m33 = 1;
    }

    public Matrix4d(Matrix4d m) {
        this.m00 = m.m00;
        this.m01 = m.m01;
        this.m02 = m.m02;
        this.m03 = m.m03;

        this.m10 = m.m10;
        this.m11 = m.m11;
        this.m12 = m.m12;
        this.m13 = m.m13;

        this.m20 = m.m20;
        this.m21 = m.m21;
        this.m22 = m.m22;
        this.m23 = m.m23;

        this.m30 = m.m30;
        this.m31 = m.m31;
        this.m32 = m.m32;
        this.m33 = m.m33;
    }

    public Matrix4d(Matrix3d m) {
        this.m00 = m.m00;
        this.m01 = m.m01;
        this.m02 = m.m02;
        this.m03 = 0;

        this.m10 = m.m10;
        this.m11 = m.m11;
        this.m12 = m.m12;
        this.m13 = 0;

        this.m20 = m.m20;
        this.m21 = m.m21;
        this.m22 = m.m22;
        this.m23 = 0;

        this.m30 = 0;
        this.m31 = 0;
        this.m32 = 0;
        this.m33 = 1;
    }

    @Override
    public Matrix4d add(Matrix4d m) {
        return null;
    }

    @Override
    public Matrix4d addMatrices(Matrix4d m1, Matrix4d m2) {
        return null;
    }

    @Override
    public double determinant() {
        return 0;
    }

    public boolean equals(Matrix4d m) {
        return (m00 == m.m00) && (m01 == m.m01) && (m02 == m.m02) && (m03 == m.m03) &&
                (m10 == m.m10) && (m11 == m.m11) && (m12 == m.m12) && (m13 == m.m13) &&
                (m20 == m.m20) && (m21 == m.m21) && (m22 == m.m22) && (m23 == m.m23) &&
                (m30 == m.m30) && (m31 == m.m31) && (m32 == m.m32) && (m33 == m.m33);
    }

    @Override
    public Matrix4d invert() {
        return null;
    }

    @Override
    public Matrix4d invertCopy() {
        return null;
    }

    @Override
    public Matrix4d mul(Matrix4d m) {
        return null;
    }

    @Override
    public Matrix4d mulMatrices(Matrix4d m1, Matrix4d m2) {
        return null;
    }

    @Override
    public Matrix4d negate() {
        return null;
    }

    @Override
    public Matrix4d negateCopy() {
        return null;
    }

    @Override
    public Matrix4d rotate(double angle, Vector3d axis) {
        return null;
    }

    @Override
    public Matrix4d rotateCopy(double angle, Vector3d axis) {
        return null;
    }

    @Override
    public Matrix4d setIdentity() {
        return null;
    }

    @Override
    public Matrix4d setZero() {
        return null;
    }

    @Override
    public Matrix4d sub(Matrix4d m) {
        return null;
    }

    @Override
    public Matrix4d subMatrices(Matrix4d m1, Matrix4d m2) {
        return null;
    }

    @Override
    public String toString() {
        String s = "";
        s += "[[" + m00 + ", " + m01 + ", " + m02 + ", " + m03 + "]\n";
        s += " [" + m10 + ", " + m11 + ", " + m12 + ", " + m13 + "]\n";
        s += " [" + m20 + ", " + m21 + ", " + m22 + ", " + m23 + "]\n";
        s += " [" + m30 + ", " + m31 + ", " + m32 + ", " + m33 + "]]";
        return s;
    }

    @Override
    public Vector4d transformVector(Vector4d v) {
        return null;
    }

    @Override
    public Vector4d transformVectorCopy(Vector4d v) {
        return null;
    }

    @Override
    public Matrix4d translateBy(Vector2d v) {
        return null;
    }

    @Override
    public Matrix4d translateBy(Vector3d v) {
        return null;
    }

    @Override
    public Matrix4d translateCopyBy(Vector2d v) {
        return null;
    }

    @Override
    public Matrix4d translateCopyBy(Vector3d v) {
        return null;
    }

    @Override
    public Matrix4d transpose() {
        return null;
    }

    @Override
    public Matrix4d transposeCopy() {
        return null;
    }
}
