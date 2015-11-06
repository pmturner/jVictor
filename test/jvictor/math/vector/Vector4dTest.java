package jvictor.math.vector;

import org.junit.Test;

import static org.junit.Assert.*;

public class Vector4dTest {

    /**
     * We need this for all functions that involve normalization because normalization introduces floating point errors
     * into those calculations.
     */
    final double NORMALIZATION_TOLERANCE = 0.000000000000001;

    Vector4d v1;
    Vector4d v2;
    double angle;
    double targetAngle;
    double dot;
    double targetDot;
    double length;
    double targetLength;
    double lengthSq;
    double targetLengthSq;

    @Test
    public void testAdd() throws Exception {
        v1 = new Vector4d(1, 1, 1, 1);
        v2 = new Vector4d(1, 1, 1, 1);
        Vector4d sum = v1.add(v2);

        assertTrue(sum.x == 2 && sum.y == 2 && sum.z == 2 && sum.w == 2);
        assertTrue(v1.x == 2 && v1.y == 2 && v1.z == 2 && v1.w == 2);
        assertTrue(v2.x == 1 && v2.y == 1 && v2.z == 1 && v2.w == 1);
    }

    @Test
    public void testAddVectors() throws Exception {
        v1 = new Vector4d(1, 1, 1, 1);
        v2 = new Vector4d(1, 1, 1, 1);
        Vector4d sum = new Vector4d().addVectors(v1, v2);

        assertTrue(sum.x == 2 && sum.y == 2 && sum.z == 2 && sum.w == 2);
        assertTrue(v1.x == 1 && v1.y == 1 && v1.z == 1 && v1.w == 1);
        assertTrue(v2.x == 1 && v2.y == 1 && v2.z == 1 && v2.w == 1);
    }

    @Test
    public void testAngleBetween() throws Exception {
        v1 = new Vector4d(1, 1, 1, 0);
        v2 = new Vector4d(1, 1, 1, 0);

        angle = new Vector4d().angleBetween(v1, v2);
        targetAngle = 0;

        assertTrue(angle == targetAngle);

        v1 = new Vector4d(1, 0, 0, 0);
        v2 = new Vector4d(0, 1, 0, 0);

        angle = new Vector4d().angleBetween(v1, v2);
        targetAngle = Math.PI / 2; //  90 degrees

        assertTrue(angle == targetAngle);

        v1 = new Vector4d(1, 0, 0, 0);
        v2 = new Vector4d(0, -1, 0, 0);

        angle = new Vector4d().angleBetween(v1, v2);
        targetAngle = Math.PI / 2; // 90 degrees

        assertTrue(angle == targetAngle);
    }

    @Test
    public void testAngleTo() throws Exception {
        v1 = new Vector4d(1, 1, 1, 0);
        v2 = new Vector4d(1, 1, 1, 0);

        angle = v1.angleTo(v2);
        targetAngle = 0;

        assertTrue(angle == targetAngle);

        v1 = new Vector4d(1, 0, 0, 0);
        v2 = new Vector4d(0, 1, 0, 0);

        angle = v1.angleTo(v2);
        targetAngle = Math.PI / 2; //  90 degrees

        assertTrue(angle == targetAngle);

        v1 = new Vector4d(1, 0, 0, 0);
        v2 = new Vector4d(0, -1, 0, 0);

        angle = v1.angleTo(v2);
        targetAngle = Math.PI / 2; // 90 degrees

        assertTrue(angle == targetAngle);
    }

    @Test
    public void testDot() throws Exception {
        v1 = new Vector4d(1, 1, 1, 1);
        v2 = new Vector4d(2, 2, 2, 1);

        dot = v1.dot(v2);
        targetDot = 7;

        assertTrue(dot == targetDot);

        v1 = new Vector4d(-1, 1, 1, 1);
        v2 = new Vector4d(2, 2, 2, 1);

        dot = v1.dot(v2);
        targetDot = 3;

        assertTrue(dot == targetDot);
    }

    @Test
    public void testDotVectors() throws Exception {
        v1 = new Vector4d(1, 1, 1, 1);
        v2 = new Vector4d(2, 2, 2, 1);

        dot = new Vector4d().dotVectors(v1, v2);
        targetDot = 7;

        assertTrue(dot == targetDot);

        v1 = new Vector4d(-1, 1, 1, 1);
        v2 = new Vector4d(2, 2, 2, 1);

        dot = new Vector4d().dotVectors(v1, v2);
        targetDot = 3;

        assertTrue(dot == targetDot);
    }

    @Test
    public void testLength() throws Exception {
        v1 = new Vector4d(1, 0, 0, 0);
        length = v1.length();
        targetLength = 1;

        assertTrue(length == targetLength);

        v1 = new Vector4d(0, 0, -10, 0);
        length = v1.length();
        targetLength = 10;

        assertTrue(length == targetLength);
    }

    @Test
    public void testLengthSquared() throws Exception {
        v1 = new Vector4d(1, 0, 0, 0);
        lengthSq = v1.lengthSquared();
        targetLengthSq = 1;

        assertTrue(lengthSq == targetLengthSq);

        v1 = new Vector4d(0, 0, -10, 0);
        lengthSq = v1.lengthSquared();
        targetLengthSq = 100;

        assertTrue(lengthSq == targetLengthSq);
    }

    @Test
    public void testNegate() throws Exception {
        v1 = new Vector4d(1, 2, 3, 4);
        v2 = v1.negate();

        assertTrue(v1.x == -1 && v1.y == -2 && v1.z == -3 && v1.w == -4);
        assertTrue(v2.x == -1 && v2.y == -2 && v2.z == -3 && v2.w == -4);
    }

    @Test
    public void testNegateCopy() throws Exception {
        v1 = new Vector4d(1, 2, 3, 4);
        v2 = v1.negateCopy();

        assertTrue(v1.x == 1 && v1.y == 2 && v1.z == 3 && v1.w == 4);
        assertTrue(v2.x == -1 && v2.y == -2 && v2.z == -3 && v2.w == -4);
    }

    @Test
    public void testNormalize() throws Exception {
        /**
         * Normalization causes some error.  This cannot be avoided, so we will check if it is close to the target
         * length instead of strict equality.
         */
        v1 = new Vector4d(1, 1, 1, 1);

        v1.normalize();
        length = v1.length();
        targetLength = 1;

        assertTrue(Math.abs(targetLength - length) < NORMALIZATION_TOLERANCE);

        v1 = new Vector4d(25, -10, 13, 1);

        v1.normalize();
        length = v1.length();
        targetLength = 1;

        assertTrue(Math.abs(targetLength - length) < NORMALIZATION_TOLERANCE);
    }

    @Test
    public void testNormalizeCopy() throws Exception {
        /**
         * Normalization causes some error.  This cannot be avoided, so we will check if it is close to the target
         * length instead of strict equality.
         */
        v1 = new Vector4d(1, 1, 1, 1);

        v2 = v1.normalizeCopy();
        length = v2.length();
        targetLength = 1;

        assertTrue(Math.abs(targetLength - length) < NORMALIZATION_TOLERANCE);
        assertTrue(v1.x == 1 && v1.y == 1 && v1.z == 1 && v1.w == 1);

        v1 = new Vector4d(25, -10, 13, 1);

        v2 = v1.normalizeCopy();
        length = v2.length();
        targetLength = 1;

        assertTrue(Math.abs(targetLength - length) < NORMALIZATION_TOLERANCE);
        assertTrue(v1.x == 25 && v1.y == -10 && v1.z == 13 && v1.w == 1);
    }

    @Test
    public void testScale() throws Exception {
        v1 = new Vector4d(1, 0, 1, 1);

        v1.scale(5);

        assertTrue(v1.x == 5 && v1.y == 0 && v1.z == 5 && v1.w == 5);

        v1 = new Vector4d(1, -2, 5, 1);

        v1.scale(3);

        assertTrue(v1.x == 3 && v1.y == -6 && v1.z == 15 && v1.w == 3);
    }

    @Test
    public void testScaleCopy() throws Exception {
        v1 = new Vector4d(1, 0, 1, 1);

        v2 = v1.scaleCopy(5);

        assertTrue(v1.x == 1 && v1.y == 0 && v1.z == 1 && v1.w == 1);
        assertTrue(v2.x == 5 && v2.y == 0 && v2.z == 5 && v2.w == 5);

        v1 = new Vector4d(1, -2, 5, 1);

        v2 = v1.scaleCopy(3);

        assertTrue(v1.x == 1 && v1.y == -2 && v1.z == 5 && v1.w == 1);
        assertTrue(v2.x == 3 && v2.y == -6 && v2.z == 15 && v2.w == 3);
    }

    @Test
    public void testScaleCopyTo() throws Exception {
        /**
         * Normalization causes some error.  This cannot be avoided, so we will check if it is close to the target
         * length instead of strict equality.
         *
         * ScaleTo involves normalization, so this must be handled here as well.
         */
        double scaledTolerance;

        v1 = new Vector4d(1, 1, 1, 1);
        targetLength = 5;
        v2 = v1.scaleCopyTo(targetLength);
        length = v2.length();
        scaledTolerance = NORMALIZATION_TOLERANCE * targetLength;

        assertTrue(Math.abs(targetLength - length) < scaledTolerance);
        assertTrue(v1.x == 1 && v1.y == 1 && v1.z == 1 && v1.w == 1);

        v1 = new Vector4d(25, -10, 13, 1);
        targetLength = 2;
        v2 = v1.scaleCopyTo(targetLength);
        length = v2.length();
        scaledTolerance = NORMALIZATION_TOLERANCE * targetLength;

        assertTrue(Math.abs(targetLength - length) < scaledTolerance);
        assertTrue(v1.x == 25 && v1.y == -10 && v1.z == 13 && v1.w == 1);
    }

    @Test
    public void testScaleTo() throws Exception {
        /**
         * Normalization causes some error.  This cannot be avoided, so we will check if it is close to the target
         * length instead of strict equality.
         *
         * ScaleTo involves normalization, so this must be handled here as well.
         */
        double scaledTolerance;

        v1 = new Vector4d(1, 1, 1, 1);
        targetLength = 5;
        v1.scaleTo(targetLength);
        length = v1.length();
        scaledTolerance = NORMALIZATION_TOLERANCE * targetLength;

        assertTrue(Math.abs(targetLength - length) < scaledTolerance);

        v1 = new Vector4d(25, -10, 13, 1);
        targetLength = 2;
        v1.scaleTo(targetLength);
        length = v1.length();
        scaledTolerance = NORMALIZATION_TOLERANCE * targetLength;

        assertTrue(Math.abs(targetLength - length) < scaledTolerance);
    }

    @Test
    public void testSub() throws Exception {
        v1 = new Vector4d(-1, 1, 2, 2);
        v2 = new Vector4d(1, 2, 5, 2);

        v1.sub(v2);

        assertTrue(v1.x == -2 && v1.y == -1 && v1.z == -3 && v1.w == 0);
        assertTrue(v2.x == 1 && v2.y == 2 && v2.z == 5 && v2.w == 2);
    }

    @Test
    public void testSubVectors() throws Exception {
        v1 = new Vector4d(-1, 1, 2, 2);
        v2 = new Vector4d(1, 2, 5, 2);

        Vector4d diff = new Vector4d().subVectors(v1, v2);

        assertTrue(v1.x == -1 && v1.y == 1 && v1.z == 2 && v1.w == 2);
        assertTrue(v2.x == 1 && v2.y == 2 && v2.z == 5 && v2.w == 2);
        assertTrue(diff.x == -2 && diff.y == -1 && diff.z == -3 && diff.w == 0);
    }
}