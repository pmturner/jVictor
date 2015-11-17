package jvictor.math.matrix;

import jvictor.math.matrix.interfaces.Matrixd;
import jvictor.math.vector.Vector3d;

public class Matrix3d implements Matrixd<Matrix3d, Vector3d> {

    public double m00, m01, m02;
    public double m10, m11, m12;
    public double m20, m21, m22;

    public Matrix3d() {
        this(1, 0, 0,
                0, 1, 0,
                0, 0, 1);
    }

    public Matrix3d(Matrix3d src) {
        this(src.m00, src.m01, src.m02,
                src.m10, src.m11, src.m12,
                src.m20, src.m21, src.m22);
    }

    public Matrix3d(double m00, double m01, double m02,
                    double m10, double m11, double m12,
                    double m20, double m21, double m22) {

        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
    }

    @Override
    public Matrix3d add(Matrix3d m) {
        m00 += m.m00;
        m01 += m.m01;
        m02 += m.m02;
        m10 += m.m10;
        m11 += m.m11;
        m12 += m.m12;
        m20 += m.m20;
        m21 += m.m21;
        m22 += m.m22;
        return this;
    }

    @Override
    public Matrix3d addMatrices(Matrix3d m1, Matrix3d m2) {
        Matrix3d m1Copy = new Matrix3d(m1);
        return m1Copy.add(m2);
    }

    private Matrix3d cofactor() {
        Matrix3d minors = new Matrix3d();
        Matrix2d temp = new Matrix2d();

        //---row 1 of minors---//
        temp.m00 = m11;
        temp.m01 = m12;
        temp.m10 = m21;
        temp.m11 = m22;
        minors.m00 = temp.determinant();

        temp.m00 = m10;
        temp.m01 = m12;
        temp.m10 = m20;
        temp.m11 = m22;
        minors.m01 = temp.determinant();

        temp.m00 = m10;
        temp.m01 = m11;
        temp.m10 = m20;
        temp.m11 = m21;
        minors.m02 = temp.determinant();

        //---row 2 of minors---//
        temp.m00 = m01;
        temp.m01 = m02;
        temp.m10 = m21;
        temp.m11 = m22;
        minors.m10 = temp.determinant();

        temp.m00 = m00;
        temp.m01 = m02;
        temp.m10 = m20;
        temp.m11 = m22;
        minors.m11 = temp.determinant();

        temp.m00 = m00;
        temp.m01 = m01;
        temp.m10 = m20;
        temp.m11 = m21;
        minors.m12 = temp.determinant();

        //---row 3 of minors---//
        temp.m00 = m01;
        temp.m01 = m02;
        temp.m10 = m11;
        temp.m11 = m12;
        minors.m20 = temp.determinant();

        temp.m00 = m00;
        temp.m01 = m02;
        temp.m10 = m10;
        temp.m11 = m12;
        minors.m21 = temp.determinant();

        temp.m00 = m00;
        temp.m01 = m01;
        temp.m10 = m10;
        temp.m11 = m11;
        minors.m22 = temp.determinant();

        //convert to CoFactor matrix
        minors.m01 *= -1;
        minors.m10 *= -1;
        minors.m12 *= -1;
        minors.m21 *= -1;

        return minors;
    }

    @Override
    public double determinant() {
        //down-to-right diagonals
        double d1 = m00 * m11 * m22;
        double d2 = m01 * m12 * m20;
        double d3 = m02 * m10 * m21;

        //up-to-right diagonals
        double d4 = m20 * m11 * m02;
        double d5 = m21 * m12 * m00;
        double d6 = m22 * m10 * m01;

        return (d1 + d2 + d3) - (d4 + d5 + d6);
    }

    public boolean equals(Matrix3d m) {
        return (m00 == m.m00) && (m01 == m.m01) && (m02 == m.m02) &&
                (m10 == m.m10) && (m11 == m.m11) && (m12 == m.m12) &&
                (m20 == m.m20) && (m21 == m.m21) && (m22 == m.m22);
    }

    @Override
    public Matrix3d invert() {
        Matrix3d inverse = invertCopy();

        m00 = inverse.m00;
        m01 = inverse.m01;
        m02 = inverse.m02;
        m10 = inverse.m10;
        m11 = inverse.m11;
        m12 = inverse.m12;
        m20 = inverse.m20;
        m21 = inverse.m21;
        m22 = inverse.m22;

        return this;
    }

    @Override
    public Matrix3d invertCopy() {
        double det = determinant();
        if (det == 0) {
            throw new UnsupportedOperationException("Cannot invert a matrix with a determinant of 0.");
        }

        return cofactor().transpose().mul(1.0 / det);
    }

    @Override
    public Matrix3d mul(double d) {

        m00 *= d;
        m01 *= d;
        m02 *= d;
        m10 *= d;
        m11 *= d;
        m12 *= d;
        m20 *= d;
        m21 *= d;
        m22 *= d;

        return this;
    }

    @Override
    public Matrix3d mul(Matrix3d m2) {

        Matrix3d m1 = new Matrix3d(this);

        m00 = (m1.m00 * m2.m00) + (m1.m01 * m2.m10) + (m1.m02 * m2.m20);
        m01 = (m1.m00 * m2.m01) + (m1.m01 * m2.m11) + (m1.m02 * m2.m21);
        m02 = (m1.m00 * m2.m02) + (m1.m01 * m2.m12) + (m1.m02 * m2.m22);

        m10 = (m1.m10 * m2.m00) + (m1.m11 * m2.m10) + (m1.m12 * m2.m20);
        m11 = (m1.m10 * m2.m01) + (m1.m11 * m2.m11) + (m1.m12 * m2.m21);
        m12 = (m1.m10 * m2.m02) + (m1.m11 * m2.m12) + (m1.m12 * m2.m22);

        m20 = (m1.m20 * m2.m00) + (m1.m21 * m2.m10) + (m1.m22 * m2.m20);
        m21 = (m1.m20 * m2.m01) + (m1.m21 * m2.m11) + (m1.m22 * m2.m21);
        m22 = (m1.m20 * m2.m02) + (m1.m21 * m2.m12) + (m1.m22 * m2.m22);

        return this;
    }

    @Override
    public Matrix3d mulMatrices(Matrix3d m1, Matrix3d m2) {
        Matrix3d m1Copy = new Matrix3d(m1);
        return m1Copy.mul(m2);
    }

    @Override
    public Matrix3d negate() {
        m00 = -m00;
        m01 = -m01;
        m02 = -m02;
        m10 = -m10;
        m11 = -m11;
        m12 = -m12;
        m20 = -m20;
        m21 = -m21;
        m22 = -m22;
        return this;
    }

    @Override
    public Matrix3d negateCopy() {
        return new Matrix3d(this).negate();
    }

    @Override
    public Matrix3d setIdentity() {
        m00 = 1;
        m01 = 0;
        m02 = 0;
        m10 = 0;
        m11 = 1;
        m12 = 0;
        m20 = 0;
        m21 = 0;
        m22 = 1;
        return this;
    }

    @Override
    public Matrix3d setZero() {
        m00 = 0;
        m01 = 0;
        m02 = 0;
        m10 = 0;
        m11 = 0;
        m12 = 0;
        m20 = 0;
        m21 = 0;
        m22 = 0;
        return this;
    }

    @Override
    public Matrix3d sub(Matrix3d m) {
        m00 -= m.m00;
        m01 -= m.m01;
        m02 -= m.m02;
        m10 -= m.m10;
        m11 -= m.m11;
        m12 -= m.m12;
        m20 -= m.m20;
        m21 -= m.m21;
        m22 -= m.m22;
        return this;
    }

    @Override
    public Matrix3d subMatrices(Matrix3d m1, Matrix3d m2) {
        Matrix3d m1Copy = new Matrix3d(m1);
        return m1Copy.sub(m2);
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
        Vector3d v1 = new Vector3d(v);

        v.x = (m00 * v1.x) + (m01 * v1.y) + (m02 * v1.z);
        v.y = (m10 * v1.x) + (m11 * v1.y) + (m12 * v1.z);
        v.z = (m20 * v1.x) + (m21 * v1.y) + (m22 * v1.z);

        return v;
    }

    @Override
    public Vector3d transformVectorCopy(Vector3d v) {
        return transformVector(new Vector3d(v));
    }

    @Override
    public Matrix3d transpose() {
        double temp;

        //swap all m[i][j] with m[j][i]

        // m00 doesn't change

        temp = m01;
        m01 = m10;
        m10 = temp;

        // m11 doesn't change

        temp = m02;
        m02 = m20;
        m20 = temp;

        temp = m12;
        m12 = m21;
        m21 = temp;

        // m22 doesn't change

        return this;
    }

    @Override
    public Matrix3d transposeCopy() {
        return new Matrix3d(this).transpose();
    }
}
