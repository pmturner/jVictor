package jvictor.math.matrix;

import jvictor.math.matrix.interfaces.Matrixd;
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
        m1.m00 = 1; m1.m01 = 2;
        m1.m10 = 3; m1.m11 = 4;

        double targetDet = (1 * 4) - (3 * 2);
        double det = m1.determinant();

        assertTrue(det == targetDet);
    }

    @Test
    public void testInvert() throws Exception {
        m1 = new Matrix2d();
        m1.m00 = 1; m1.m01 = 2;
        m1.m10 = 3; m1.m11 = 4;

        m2 = new Matrix2d(m1);
        m2.invert();

        m2.mul(m1);

        assertTrue(m2.equals(new Matrix2d().setIdentity()));

        m1 = new Matrix2d();
        m1.m00 = -1; m1.m01 = 2;
        m1.m10 = -3; m1.m11 = 4;

        m2 = new Matrix2d(m1);
        m2.invert();

        m2.mul(m1);

        assertTrue(m2.equals(new Matrix2d().setIdentity()));
    }

    @Test
    public void testInvertCopy() throws Exception {
        m1 = new Matrix2d();
        m1.m00 = 1; m1.m01 = 2;
        m1.m10 = 3; m1.m11 = 4;

        m2 = m1.invertCopy();

        m2.mul(m1);

        assertTrue(m2.equals(new Matrix2d().setIdentity()));

        m1 = new Matrix2d();
        m1.m00 = -1; m1.m01 = 2;
        m1.m10 = -3; m1.m11 = 4;

        m2 = m1.invertCopy();

        m2.mul(m1);

        assertTrue(m2.equals(new Matrix2d().setIdentity()));
    }

    @Test
    public void testMul() throws Exception {

    }

    @Test
    public void testMulMatrices() throws Exception {

    }

    @Test
    public void testNegate() throws Exception {

    }

    @Test
    public void testNegateCopy() throws Exception {

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

    }

    @Test
    public void testSub() throws Exception {

    }

    @Test
    public void testSubMatrices() throws Exception {

    }

    @Test
    public void testTransformVector() throws Exception {

    }

    @Test
    public void testTransformVectorCopy() throws Exception {

    }

    @Test
    public void testTranspose() throws Exception {

    }

    @Test
    public void testTransposeCopy() throws Exception {

    }
}