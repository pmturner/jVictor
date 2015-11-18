package jvictor.math.matrix;

import jvictor.math.vector.Vector3f;
import org.junit.Test;

import static org.junit.Assert.*;

public class Matrix3fTest extends MatrixfTest {

    Matrix3f m1;
    Matrix3f m2;

    @Test
    public void testAdd() throws Exception {
        m1 = new Matrix3f();
        m2 = new Matrix3f();

        m1.add(m2);

        assertTrue(m1.m00 == 2 && m1.m01 == 0 && m1.m02 == 0);
        assertTrue(m1.m10 == 0 && m1.m11 == 2 && m1.m12 == 0);
        assertTrue(m1.m20 == 0 && m1.m21 == 0 && m1.m22 == 2);

        assertTrue(m2.m00 == 1 && m2.m01 == 0 && m2.m02 == 0);
        assertTrue(m2.m10 == 0 && m2.m11 == 1 && m2.m12 == 0);
        assertTrue(m2.m20 == 0 && m2.m21 == 0 && m2.m22 == 1);
    }

    @Test
    public void testAddMatrices() throws Exception {
        m1 = new Matrix3f();
        m2 = new Matrix3f();

        Matrix3f sum = new Matrix3f().addMatrices(m1, m2);

        assertTrue(sum.m00 == 2 && sum.m01 == 0 && sum.m02 == 0);
        assertTrue(sum.m10 == 0 && sum.m11 == 2 && sum.m12 == 0);
        assertTrue(sum.m20 == 0 && sum.m21 == 0 && sum.m22 == 2);

        assertTrue(m1.m00 == 1 && m1.m01 == 0 && m1.m02 == 0);
        assertTrue(m1.m10 == 0 && m1.m11 == 1 && m1.m12 == 0);
        assertTrue(m1.m20 == 0 && m1.m21 == 0 && m1.m22 == 1);

        assertTrue(m2.m00 == 1 && m2.m01 == 0 && m2.m02 == 0);
        assertTrue(m2.m10 == 0 && m2.m11 == 1 && m2.m12 == 0);
        assertTrue(m2.m20 == 0 && m2.m21 == 0 && m2.m22 == 1);
    }

    @Test
    public void testDeterminant() throws Exception {
        m1 = new Matrix3f();
        m1.m00 = 2;
        m1.m01 = 2;
        m1.m02 = 3;
        m1.m10 = 4;
        m1.m11 = 5;
        m1.m12 = 6;
        m1.m20 = 7;
        m1.m21 = 8;
        m1.m22 = 9;

        float targetDet = ((2 * 5 * 9) + (2 * 6 * 7) + (3 * 4 * 8)) -
                ((7 * 5 * 3) + (8 * 6 * 2) + (9 * 4 * 2));
        float det = m1.determinant();

        assertTrue(det == targetDet);
    }

    @Test
    public void testInvert() throws Exception {
        m1 = new Matrix3f();
        m1.m00 = 1;
        m1.m01 = 2;
        m1.m02 = 3;
        m1.m10 = 4;
        m1.m11 = 1;
        m1.m12 = 6;
        m1.m20 = 7;
        m1.m21 = 8;
        m1.m22 = 1;

        m2 = new Matrix3f(m1);
        m2.invert();

        m2.mul(m1);

        assertTrue(similar(m2, new Matrix3f().setIdentity()));

        m1 = new Matrix3f();
        m1.m00 = -1;
        m1.m01 = 2;
        m1.m02 = 3;
        m1.m10 = -4;
        m1.m11 = 1;
        m1.m12 = 6;
        m1.m20 = -7;
        m1.m21 = 8;
        m1.m22 = 1;

        m2 = new Matrix3f(m1);
        m2.invert();

        m2 = new Matrix3f().mulMatrices(m2, m1);

        assertTrue(similar(m2, new Matrix3f().setIdentity()));
    }

    @Test
    public void testInvertCopy() throws Exception {
        Matrix3f m1Copy;
        m1 = new Matrix3f();
        m1.m00 = 1;
        m1.m01 = 2;
        m1.m10 = 3;
        m1.m11 = 4;
        m1Copy = new Matrix3f(m1);

        m2 = m1.invertCopy();

        m2.mul(m1);

        assertTrue(similar(m2, new Matrix3f().setIdentity()));
        assertTrue(m1.equals(m1Copy));

        m1 = new Matrix3f();
        m1.m00 = -1;
        m1.m01 = 2;
        m1.m10 = -3;
        m1.m11 = 4;
        m1Copy = new Matrix3f(m1);

        m2 = m1.invertCopy();

        m2.mul(m1);

        assertTrue(similar(m2, new Matrix3f().setIdentity()));
        assertTrue(m1.equals(m1Copy));
    }

    @Test
    public void testMul() throws Exception {
        /**
         * Tests for mul() and mulMatrices() are omitted here because there are no straightforward ways to test
         * multiplication by itself.
         */
    }

    @Test
    public void testMulF() throws Exception {
        m1 = new Matrix3f();

        m2 = new Matrix3f(
                2, 0, 0,
                0, 2, 0,
                0, 0, 2);

        m1.mul(2);

        assertTrue(m1.equals(m2));
    }

    @Test
    public void testMulMatrices() throws Exception {
        /**
         * See "testMul".
         */
    }

    @Test
    public void testNegate() throws Exception {
        m1 = new Matrix3f();
        m1.m00 = 1;
        m1.m01 = 2;
        m1.m02 = 3;
        m1.m10 = 4;
        m1.m11 = 5;
        m1.m12 = 6;
        m1.m20 = 7;
        m1.m21 = 8;
        m1.m22 = 9;

        m2 = m1.negate();

        assertTrue(m2.equals(m1));
        assertTrue(m2.m00 == -1 && m2.m01 == -2 && m2.m02 == -3);
        assertTrue(m2.m10 == -4 && m2.m11 == -5 && m2.m12 == -6);
        assertTrue(m2.m20 == -7 && m2.m21 == -8 && m2.m22 == -9);
    }

    @Test
    public void testNegateCopy() throws Exception {
        m1 = new Matrix3f();
        m1.m00 = 1;
        m1.m01 = 2;
        m1.m02 = 3;
        m1.m10 = 4;
        m1.m11 = 5;
        m1.m12 = 6;
        m1.m20 = 7;
        m1.m21 = 8;
        m1.m22 = 9;

        m2 = m1.negateCopy();

        assertFalse(m2.equals(m1));
        assertTrue(m1.m00 == 1 && m1.m01 == 2 && m1.m02 == 3);
        assertTrue(m1.m10 == 4 && m1.m11 == 5 && m1.m12 == 6);
        assertTrue(m1.m20 == 7 && m1.m21 == 8 && m1.m22 == 9);

        assertTrue(m2.m00 == -1 && m2.m01 == -2 && m2.m02 == -3);
        assertTrue(m2.m10 == -4 && m2.m11 == -5 && m2.m12 == -6);
        assertTrue(m2.m20 == -7 && m2.m21 == -8 && m2.m22 == -9);
    }

    @Test
    public void testSetIdentity() throws Exception {
        m1 = new Matrix3f(1, 2, 3,
                4, 5, 6,
                7, 8, 9);

        m1.setIdentity();
        m2 = new Matrix3f(1, 0, 0,
                0, 1, 0,
                0, 0, 1);

        assertTrue(m1.equals(m2));
    }

    @Test
    public void testSetZero() throws Exception {
        m1 = new Matrix3f(1, 2, 3,
                4, 5, 6,
                7, 8, 9);

        m1.setZero();
        m2 = new Matrix3f(0, 0, 0,
                0, 0, 0,
                0, 0, 0);

        assertTrue(m1.equals(m2));
    }

    @Test
    public void testSub() throws Exception {
        m1 = new Matrix3f(1, 2, 3,
                4, 5, 6,
                7, 8, 9);
        m2 = new Matrix3f(0, 1, 2,
                3, 4, 5,
                6, 7, 8);
        Matrix3f m2Copy = new Matrix3f(m2);

        Matrix3f targetDiff = new Matrix3f(1, 1, 1,
                1, 1, 1,
                1, 1, 1);
        Matrix3f diff = m1.sub(m2);

        assertTrue(diff.equals(targetDiff));
        assertTrue(m1.equals(diff));
        assertTrue(m2.equals(m2Copy));
    }

    @Test
    public void testSubMatrices() throws Exception {
        m1 = new Matrix3f(1, 2, 3,
                4, 5, 6,
                7, 8, 9);
        Matrix3f m1Copy = new Matrix3f(m1);
        m2 = new Matrix3f(0, 1, 2,
                3, 4, 5,
                6, 7, 8);
        Matrix3f m2Copy = new Matrix3f(m2);

        Matrix3f targetDiff = new Matrix3f(1, 1, 1,
                1, 1, 1,
                1, 1, 1);
        Matrix3f diff = new Matrix3f().subMatrices(m1, m2);

        assertTrue(diff.equals(targetDiff));
        assertTrue(m1.equals(m1Copy));
        assertTrue(m2.equals(m2Copy));
    }

    @Test
    public void testTransformVector() throws Exception {
        Vector3f result;
        Vector3f targetResult;

        m1 = new Matrix3f();
        Vector3f v = new Vector3f(1, 2, 3);
        Vector3f vCopy = new Vector3f(v);

        result = m1.transformVector(v);

        assertTrue(result.equals(vCopy)); // because m1 was the identity this time
        assertTrue(v.equals(result));

        m1 = new Matrix3f(
                2, 0, 0,
                0, 1, 0,
                0, 0, 3);
        v = new Vector3f(1, 2, 3);
        vCopy = new Vector3f(v);

        result = m1.transformVector(v);
        targetResult = new Vector3f(2, 2, 9); // this is the real transformation

        assertTrue(result.equals(targetResult));
        assertTrue(v.equals(result));
        assertTrue(!v.equals(vCopy));
    }

    @Test
    public void testTransformVectorCopy() throws Exception {
        Vector3f result;
        Vector3f targetResult;

        m1 = new Matrix3f();
        Vector3f v = new Vector3f(1, 2, 3);
        Vector3f vCopy = new Vector3f(v);

        result = m1.transformVectorCopy(v);

        assertTrue(result.equals(vCopy)); // because m1 was the identity this time
        assertTrue(v.equals(result));

        m1 = new Matrix3f(
                2, 0, 0,
                0, 1, 0,
                0, 0, 3);
        v = new Vector3f(1, 2, 3);
        vCopy = new Vector3f(v);

        result = m1.transformVectorCopy(v);
        targetResult = new Vector3f(2, 2, 9); // this is the real transformation

        assertTrue(result.equals(targetResult));
        assertTrue(v.equals(vCopy));
    }

    @Test
    public void testTranspose() throws Exception {
        m1 = new Matrix3f(
                1, 2, 3,
                4, 5, 6,
                7, 8, 9);
        m2 = new Matrix3f(
                1, 4, 7,
                2, 5, 8,
                3, 6, 9);

        Matrix3f m1Transpose = m1.transpose();

        assertTrue(m1Transpose.equals(m2));
        assertTrue(m1.equals(m1Transpose));
    }

    @Test
    public void testTransposeCopy() throws Exception {
        m1 = new Matrix3f(
                1, 2, 3,
                4, 5, 6,
                7, 8, 9);
        m2 = new Matrix3f(
                1, 4, 7,
                2, 5, 8,
                3, 6, 9);
        Matrix3f m1Copy = new Matrix3f(m1);

        Matrix3f m1Transpose = m1.transposeCopy();

        assertTrue(m1Transpose.equals(m2));
        assertTrue(m1.equals(m1Copy));
    }
}