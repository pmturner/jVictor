package jvictor.math.matrix;

import jvictor.math.matrix.interfaces.Matrixd;
import jvictor.math.vector.Vector2d;
import org.junit.Test;

import static org.junit.Assert.*;

public class Matrix2dTest {

    Matrix2d m1;
    Matrix2d m2;

    @Test
    public void testAdd() throws Exception {
        m1 = new Matrix2d();
        m2 = new Matrix2d();

        m1.add(m2);

        assertTrue(m1.m00 == 2 && m1.m01 == 0);
        assertTrue(m1.m10 == 0 && m1.m11 == 2);

        assertTrue(m2.m00 == 1 && m2.m01 == 0);
        assertTrue(m2.m10 == 0 && m2.m11 == 1);
    }

    @Test
    public void testAddMatrices() throws Exception {
        m1 = new Matrix2d();
        m2 = new Matrix2d();

        Matrix2d sum = new Matrix2d().addMatrices(m1, m2);

        assertTrue(sum.m00 == 2 && sum.m01 == 0);
        assertTrue(sum.m10 == 0 && sum.m11 == 2);

        assertTrue(m1.m00 == 1 && m1.m01 == 0);
        assertTrue(m1.m10 == 0 && m1.m11 == 1);

        assertTrue(m2.m00 == 1 && m2.m01 == 0);
        assertTrue(m2.m10 == 0 && m2.m11 == 1);
    }

    @Test
    public void testDeterminant() throws Exception {
        m1 = new Matrix2d();
        m1.m00 = 1;
        m1.m01 = 2;
        m1.m10 = 3;
        m1.m11 = 4;

        double targetDet = (1 * 4) - (3 * 2);
        double det = m1.determinant();

        assertTrue(det == targetDet);
    }

    @Test
    public void testInvert() throws Exception {
        m1 = new Matrix2d();
        m1.m00 = 1;
        m1.m01 = 2;
        m1.m10 = 3;
        m1.m11 = 4;

        m2 = new Matrix2d(m1);
        m2.invert();

        m2.mul(m1);

        assertTrue(m2.equals(new Matrix2d().setIdentity()));

        m1 = new Matrix2d();
        m1.m00 = -1;
        m1.m01 = 2;
        m1.m10 = -3;
        m1.m11 = 4;

        m2 = new Matrix2d(m1);
        m2.invert();

        m2 = new Matrix2d().mulMatrices(m2, m1);

        assertTrue(m2.equals(new Matrix2d().setIdentity()));
    }

    @Test
    public void testInvertCopy() throws Exception {
        Matrix2d m1Copy;
        m1 = new Matrix2d();
        m1.m00 = 1;
        m1.m01 = 2;
        m1.m10 = 3;
        m1.m11 = 4;
        m1Copy = new Matrix2d(m1);

        m2 = m1.invertCopy();

        m2.mul(m1);

        assertTrue(m2.equals(new Matrix2d().setIdentity()));
        assertTrue(m1.equals(m1Copy));

        m1 = new Matrix2d();
        m1.m00 = -1;
        m1.m01 = 2;
        m1.m10 = -3;
        m1.m11 = 4;
        m1Copy = new Matrix2d(m1);

        m2 = m1.invertCopy();

        m2.mul(m1);

        assertTrue(m2.equals(new Matrix2d().setIdentity()));
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
    public void testMulD() throws Exception {
        m1 = new Matrix2d();

        m1.mul(5);
        m2 = new Matrix2d(5, 0, 0, 5);

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
        m1 = new Matrix2d();
        m1.m00 = 1;
        m1.m01 = 2;
        m1.m10 = 3;
        m1.m11 = 4;

        m2 = m1.negate();

        assertTrue(m2.equals(m1));
        assertTrue(m2.m00 == -1 && m2.m01 == -2);
        assertTrue(m2.m10 == -3 && m2.m11 == -4);
    }

    @Test
    public void testNegateCopy() throws Exception {
        m1 = new Matrix2d();
        m1.m00 = 1;
        m1.m01 = 2;
        m1.m10 = 3;
        m1.m11 = 4;

        m2 = m1.negateCopy();

        assertFalse(m2.equals(m1));
        assertTrue(m1.m00 == 1 && m1.m01 == 2);
        assertTrue(m1.m10 == 3 && m1.m11 == 4);
        assertTrue(m2.m00 == -1 && m2.m01 == -2);
        assertTrue(m2.m10 == -3 && m2.m11 == -4);
    }

    @Test
    public void testSetIdentity() throws Exception {
        m1 = new Matrix2d(1, 2, 3, 4);

        m1.setIdentity();
        m2 = new Matrix2d(1, 0, 0, 1);

        assertTrue(m1.equals(m2));
    }

    @Test
    public void testSetZero() throws Exception {
        m1 = new Matrix2d(1, 2, 3, 4);

        m1.setZero();
        m2 = new Matrix2d(0, 0, 0, 0);

        assertTrue(m1.equals(m2));
    }

    @Test
    public void testSub() throws Exception {
        m1 = new Matrix2d(1, 2, 3, 4);
        m2 = new Matrix2d(0, 1, 2, 3);
        Matrix2d m2Copy = new Matrix2d(m2);

        Matrix2d targetDiff = new Matrix2d(1, 1, 1, 1);
        Matrix2d diff = m1.sub(m2);

        assertTrue(diff.equals(targetDiff));
        assertTrue(m1.equals(diff));
        assertTrue(m2.equals(m2Copy));
    }

    @Test
    public void testSubMatrices() throws Exception {
        m1 = new Matrix2d(1, 2, 3, 4);
        Matrix2d m1Copy = new Matrix2d(m1);
        m2 = new Matrix2d(0, 1, 2, 3);
        Matrix2d m2Copy = new Matrix2d(m2);

        Matrix2d targetDiff = new Matrix2d(1, 1, 1, 1);
        Matrix2d diff = new Matrix2d().subMatrices(m1, m2);

        assertTrue(diff.equals(targetDiff));
        assertTrue(m1.equals(m1Copy));
        assertTrue(m2.equals(m2Copy));
    }

    @Test
    public void testTransformVector() throws Exception {
        Vector2d result;
        Vector2d targetResult;

        m1 = new Matrix2d();
        Vector2d v = new Vector2d(1, 2);
        Vector2d vCopy = new Vector2d(v);

        result = m1.transformVector(v);

        assertTrue(result.equals(vCopy)); // because m1 was the identity this time
        assertTrue(v.equals(result));

        m1 = new Matrix2d(1, 1, 0, 1);
        v = new Vector2d(1, 2);
        vCopy = new Vector2d(v);

        result = m1.transformVector(v);
        targetResult = new Vector2d(3, 2); // this is the real transformation

        assertTrue(result.equals(targetResult));
        assertTrue(v.equals(result));
        assertTrue(!v.equals(vCopy));
    }

    @Test
    public void testTransformVectorCopy() throws Exception {
        Vector2d result;
        Vector2d targetResult;

        m1 = new Matrix2d();
        Vector2d v = new Vector2d(1, 2);
        Vector2d vCopy = new Vector2d(v);

        result = m1.transformVectorCopy(v);

        assertTrue(result.equals(vCopy)); // because m1 was the identity this time
        assertTrue(v.equals(result));

        m1 = new Matrix2d(1, 1, 0, 1);
        v = new Vector2d(1, 2);
        vCopy = new Vector2d(v);

        result = m1.transformVectorCopy(v);
        targetResult = new Vector2d(3, 2); // this is the real transformation

        assertTrue(result.equals(targetResult));
        assertTrue(v.equals(vCopy));
    }

    @Test
    public void testTranspose() throws Exception {
        m1 = new Matrix2d(1, 2, 3, 4);
        m2 = new Matrix2d(1, 3, 2, 4); //transpose of m1

        Matrix2d m1Transpose = m1.transpose();

        assertTrue(m1Transpose.equals(m2));
        assertTrue(m1.equals(m1Transpose));
    }

    @Test
    public void testTransposeCopy() throws Exception {
        m1 = new Matrix2d(1, 2, 3, 4);
        m2 = new Matrix2d(1, 3, 2, 4); //transpose of m1
        Matrix2d m1Copy = new Matrix2d(m1);

        Matrix2d m1Transpose = m1.transposeCopy();

        assertTrue(m1Transpose.equals(m2));
        assertTrue(m1.equals(m1Copy));
    }
}