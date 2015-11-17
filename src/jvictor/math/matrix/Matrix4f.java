package jvictor.math.matrix;

import jvictor.math.vector.Vector2f;
import jvictor.math.vector.Vector3f;
import jvictor.math.vector.Vector4f;

public class Matrix4f implements jvictor.math.matrix.interfaces.Matrix4f<Matrix4f, Vector4f> {

    public float m00, m01, m02, m03;
    public float m10, m11, m12, m13;
    public float m20, m21, m22, m23;
    public float m30, m31, m32, m33;

    public Matrix4f() {
        m00 = m11 = m22 = m33 = 1;
    }

    public Matrix4f(Matrix4f m) {
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

    public Matrix4f(Matrix3f m) {
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
    public Matrix4f add(Matrix4f m) {
        return null;
    }

    @Override
    public Matrix4f addMatrices(Matrix4f m1, Matrix4f m2) {
        return null;
    }

    @Override
    public float determinant() {
        return 0;
    }

    public boolean equals(Matrix4f m) {
        return (m00 == m.m00) && (m01 == m.m01) && (m02 == m.m02) && (m03 == m.m03) &&
                (m10 == m.m10) && (m11 == m.m11) && (m12 == m.m12) && (m13 == m.m13) &&
                (m20 == m.m20) && (m21 == m.m21) && (m22 == m.m22) && (m23 == m.m23) &&
                (m30 == m.m30) && (m31 == m.m31) && (m32 == m.m32) && (m33 == m.m33);
    }

    @Override
    public Matrix4f invert() {
        return null;
    }

    @Override
    public Matrix4f invertCopy() {
        return null;
    }

    @Override
    public Matrix4f mul(float f) {
        return null;
    }

    @Override
    public Matrix4f mul(Matrix4f m) {
        return null;
    }

    @Override
    public Matrix4f mulMatrices(Matrix4f m1, Matrix4f m2) {
        return null;
    }

    @Override
    public Matrix4f negate() {
        return null;
    }

    @Override
    public Matrix4f negateCopy() {
        return null;
    }

    @Override
    public Matrix4f rotate(float angle, Vector3f axis) {
        return null;
    }

    @Override
    public Matrix4f rotateCopy(float angle, Vector3f axis) {
        return null;
    }

    @Override
    public Matrix4f setIdentity() {
        return null;
    }

    @Override
    public Matrix4f setZero() {
        return null;
    }

    @Override
    public Matrix4f sub(Matrix4f m) {
        return null;
    }

    @Override
    public Matrix4f subMatrices(Matrix4f m1, Matrix4f m2) {
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
    public Vector4f transformVector(Vector4f v) {
        return null;
    }

    @Override
    public Vector4f transformVectorCopy(Vector4f v) {
        return null;
    }

    @Override
    public Matrix4f translateBy(Vector2f v) {
        return null;
    }

    @Override
    public Matrix4f translateBy(Vector3f v) {
        return null;
    }

    @Override
    public Matrix4f translateCopyBy(Vector2f v) {
        return null;
    }

    @Override
    public Matrix4f translateCopyBy(Vector3f v) {
        return null;
    }

    @Override
    public Matrix4f transpose() {
        return null;
    }

    @Override
    public Matrix4f transposeCopy() {
        return null;
    }
}
