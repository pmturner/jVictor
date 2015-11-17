package jvictor.math.matrix;

import jvictor.math.matrix.Matrix2d;
import jvictor.math.matrix.Matrix3d;
import jvictor.math.matrix.Matrix4d;

public class MatrixdTest {

    final double TOLERANCE = 0.000000000000001;


    public boolean similar(double a, double b) {
        return Math.abs(a - b) < TOLERANCE;
    }

    public boolean similar(double a, double b, double tolerance) {
        return Math.abs(a - b) < tolerance;
    }

    public boolean similar(Matrix2d a, Matrix2d b) {
        return similar(a.m00, b.m00) && similar(a.m01, b.m01) &&
               similar(a.m10, b.m10) && similar(a.m11, b.m11);
    }

    public boolean similar(Matrix3d a, Matrix3d b) {
        return similar(a.m00, b.m00) && similar(a.m01, b.m01) && similar(a.m02, b.m02) &&
               similar(a.m10, b.m10) && similar(a.m11, b.m11) && similar(a.m12, b.m12) &&
               similar(a.m20, b.m20) && similar(a.m21, b.m21) && similar(a.m22, b.m22);
    }

    public boolean similar(Matrix4d a, Matrix4d b) {
        return similar(a.m00, b.m00) && similar(a.m01, b.m01) && similar(a.m02, b.m02) && similar(a.m03, b.m03) &&
               similar(a.m10, b.m10) && similar(a.m11, b.m11) && similar(a.m12, b.m12) && similar(a.m13, b.m13) &&
               similar(a.m20, b.m20) && similar(a.m21, b.m21) && similar(a.m22, b.m22) && similar(a.m23, b.m23) &&
               similar(a.m30, b.m30) && similar(a.m31, b.m31) && similar(a.m32, b.m32) && similar(a.m33, b.m33);
    }
}
