package jvictor.math.matrix;

import jvictor.math.matrix.interfaces.Matrixf;
import jvictor.math.vector.Vector2f;

public class Matrix2f implements Matrixf<Matrix2f, Vector2f> {

    public float m00, m01;
    public float m10, m11;

    public Matrix2f() {
        this(1, 0,
                0, 1);
    }

    public Matrix2f(Matrix2f src) {
        this(src.m00, src.m01,
                src.m10, src.m11);
    }

    public Matrix2f(float m00, float m01,
                    float m10, float m11) {

        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
    }

    @Override
    public Matrix2f add(Matrix2f m) {
        m00 += m.m00;
        m01 += m.m01;
        m10 += m.m10;
        m11 += m.m11;
        return this;
    }

    @Override
    public Matrix2f addMatrices(Matrix2f m1, Matrix2f m2) {
        Matrix2f m1Copy = new Matrix2f(m1);
        return m1Copy.add(m2);
    }

    @Override
    public float determinant() {
        return (m00 * m11) - (m01 * m10);
    }

    public boolean equals(Matrix2f m) {
        return (m00 == m.m00) && (m01 == m.m01) &&
                (m10 == m.m10) && (m11 == m.m11);
    }

    @Override
    public Matrix2f invert() {
        float det = determinant();
        if (det == 0) {
            throw new UnsupportedOperationException("Cannot invert a matrix with a determinant of 0.");
        }

        float invDet = 1.0f / det;
        float temp = m00;

        m00 = m11 * invDet;
        m01 = m01 * -invDet;
        m10 = m10 * -invDet;
        m11 = temp * invDet;

        return this;
    }

    @Override
    public Matrix2f invertCopy() {
        return new Matrix2f(this).invert();
    }

    @Override
    public Matrix2f mul(float f) {
        m00 *= f;
        m01 *= f;
        m10 *= f;
        m11 *= f;

        return this;
    }

    @Override
    public Matrix2f mul(Matrix2f m2) {
        Matrix2f m1 = new Matrix2f(this);

        m00 = (m1.m00 * m2.m00) + (m1.m01 * m2.m10);
        m01 = (m1.m00 * m2.m01) + (m1.m01 * m2.m11);
        m10 = (m1.m10 * m2.m00) + (m1.m11 * m2.m10);
        m11 = (m1.m10 * m2.m01) + (m1.m11 * m2.m11);

        return this;
    }

    @Override
    public Matrix2f mulMatrices(Matrix2f m1, Matrix2f m2) {
        return new Matrix2f(m1).mul(m2);
    }

    @Override
    public Matrix2f negate() {
        m00 = -m00;
        m01 = -m01;
        m10 = -m10;
        m11 = -m11;
        return this;
    }

    @Override
    public Matrix2f negateCopy() {
        return new Matrix2f(this).negate();
    }

    @Override
    public Matrix2f setIdentity() {
        m00 = 1;
        m01 = 0;
        m10 = 0;
        m11 = 1;
        return this;
    }

    @Override
    public Matrix2f setZero() {
        m00 = 0;
        m01 = 0;
        m10 = 0;
        m11 = 0;
        return this;
    }

    @Override
    public Matrix2f sub(Matrix2f m) {
        m00 -= m.m00;
        m01 -= m.m01;
        m10 -= m.m10;
        m11 -= m.m11;
        return this;
    }

    @Override
    public Matrix2f subMatrices(Matrix2f m1, Matrix2f m2) {
        Matrix2f m1Copy = new Matrix2f(m1);
        return m1Copy.sub(m2);
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
        Vector2f v1 = new Vector2f(v);

        v.x = (m00 * v1.x) + (m01 * v1.y);
        v.y = (m10 * v1.x) + (m11 * v1.y);

        return v;
    }

    @Override
    public Vector2f transformVectorCopy(Vector2f v) {
        return transformVector(new Vector2f(v));
    }

    @Override
    public Matrix2f transpose() {
        float temp;

        //swap all m[i][j] with m[j][i]

        // m00 doesn't change

        temp = m01;
        m01 = m10;
        m10 = temp;

        // m11 doesn't change

        return this;
    }

    @Override
    public Matrix2f transposeCopy() {
        return new Matrix2f(this).transpose();
    }
}
