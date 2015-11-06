package jvictor.math.matrix;

import jvictor.math.matrix.interfaces.Matrixd;
import jvictor.math.vector.Vector2d;

public class Matrix2d implements Matrixd<Matrix2d, Vector2d> {

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

    @Override
    public Matrix2d addMatrices(Matrix2d m1, Matrix2d m2) {
        return null;
    }

    @Override
    public double determinant() {
        return 0;
    }

    @Override
    public Matrix2d invert() {
        return null;
    }

    @Override
    public Matrix2d invertCopy() {
        return null;
    }

    @Override
    public Matrix2d mul(Matrix2d m) {
        return null;
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
        return null;
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
}
