package jvictor.math.vector;

import org.junit.Test;

import static org.junit.Assert.*;

public class Vector3dTest {

    /**
     * We need this for all functions that involve normalization because normalization introduces floating point errors
     * into those calculations.
     */
    final double NORMALIZATION_TOLERANCE = 0.000000000000001;

    Vector3d v1;
    Vector3d v2;
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
        v1 = new Vector3d(1, 2, 3);
        v2 = new Vector3d(1, 2, 3);

        v1.add(v2);

        assertTrue(v1.x == 2 && v1.y == 4 && v1.z == 6);
        assertTrue(v2.x == 1 && v2.y == 2 && v2.z == 3);
    }

    @Test
    public void testAddVectors() throws Exception {
        v1 = new Vector3d(1, 2, 3);
        v2 = new Vector3d(1, 2, 3);

        Vector3d sum = new Vector3d().addVectors(v1, v2);

        assertTrue(sum.x == 2 && sum.y == 4 && sum.z == 6);
        assertTrue(v1.x == 1 && v1.y == 2 && v1.z == 3);
        assertTrue(v2.x == 1 && v2.y == 2 && v2.z == 3);
    }

    @Test
    public void testAngleBetween() throws Exception {
        v1 = new Vector3d(1, 1, 1);
        v2 = new Vector3d(1, 1, 1);

        angle = new Vector3d().angleBetween(v1, v2);
        targetAngle = 0;

        assertTrue(angle == targetAngle);

        v1 = new Vector3d(1, 0, 0);
        v2 = new Vector3d(0, 1, 0);

        angle = new Vector3d().angleBetween(v1, v2);
        targetAngle = Math.PI / 2; //  90 degrees

        assertTrue(angle == targetAngle);

        v1 = new Vector3d(1, 0, 0);
        v2 = new Vector3d(0, -1, 0);

        angle = new Vector3d().angleBetween(v1, v2);
        targetAngle = Math.PI / 2; // 90 degrees

        assertTrue(angle == targetAngle);
    }

    @Test
    public void testAngleTo() throws Exception {
        v1 = new Vector3d(1, 1, 1);
        v2 = new Vector3d(1, 1, 1);

        angle = v1.angleTo(v2);
        targetAngle = 0;

        assertTrue(angle == targetAngle);

        v1 = new Vector3d(1, 0, 0);
        v2 = new Vector3d(0, 1, 0);

        angle = v1.angleTo(v2);
        targetAngle = Math.PI / 2; //  90 degrees

        assertTrue(angle == targetAngle);

        v1 = new Vector3d(1, 0, 0);
        v2 = new Vector3d(0, -1, 0);

        angle = v1.angleTo(v2);
        targetAngle = Math.PI / 2; // 90 degrees

        assertTrue(angle == targetAngle);
    }

    @Test
    public void testCross() throws Exception {
        v1 = new Vector3d(1, 2, 3);
        v2 = new Vector3d(1, 5, 2);

        Vector3d cross = v1.cross(v2);

        targetAngle = Math.PI / 2;

        angle = cross.angleTo(v1);
        assertTrue(Math.abs(targetAngle - angle) < NORMALIZATION_TOLERANCE);
        angle = cross.angleTo(v2);
        assertTrue(Math.abs(targetAngle - angle) < NORMALIZATION_TOLERANCE);
    }

    @Test
    public void testCrossVectors() throws Exception {
        v1 = new Vector3d(1, 2, 3);
        v2 = new Vector3d(1, 5, 2);

        Vector3d cross = new Vector3d().crossVectors(v1, v2);

        targetAngle = Math.PI / 2;

        angle = cross.angleTo(v1);
        assertTrue(Math.abs(targetAngle - angle) < NORMALIZATION_TOLERANCE);
        angle = cross.angleTo(v2);
        assertTrue(Math.abs(targetAngle - angle) < NORMALIZATION_TOLERANCE);
    }

    @Test
    public void testDot() throws Exception {
        v1 = new Vector3d(1, 1, 1);
        v2 = new Vector3d(2, 2, 2);

        dot = v1.dot(v2);
        targetDot = 6;

        assertTrue(dot == targetDot);

        v1 = new Vector3d(-1, 1, 1);
        v2 = new Vector3d(2, 2, 2);

        dot = v1.dot(v2);
        targetDot = 2;

        assertTrue(dot == targetDot);
    }

    @Test
    public void testDotVectors() throws Exception {
        v1 = new Vector3d(1, 1, 1);
        v2 = new Vector3d(2, 2, 2);

        dot = new Vector3d().dotVectors(v1, v2);
        targetDot = 6;

        assertTrue(dot == targetDot);

        v1 = new Vector3d(-1, 1, 1);
        v2 = new Vector3d(2, 2, 2);

        dot = new Vector3d().dotVectors(v1, v2);
        targetDot = 2;

        assertTrue(dot == targetDot);
    }

    @Test
    public void testLength() throws Exception {
        v1 = new Vector3d(1, 0, 0);

        length = v1.length();
        targetLength = 1;

        assertTrue(length == targetLength);

        v1 = new Vector3d(0, -10, 0);

        length = v1.length();
        targetLength = 10;

        assertTrue(length == targetLength);
    }

    @Test
    public void testLengthSquared() throws Exception {
        v1 = new Vector3d(1, 0, 0);

        lengthSq = v1.lengthSquared();
        targetLengthSq = 1;

        assertTrue(lengthSq == targetLengthSq);

        v1 = new Vector3d(0, -10, 0);

        lengthSq = v1.lengthSquared();
        targetLengthSq = 100;

        assertTrue(lengthSq == targetLengthSq);
    }

    @Test
    public void testNegate() throws Exception {
        v1 = new Vector3d(1, -5, 2);

        v1.negate();

        assertTrue(v1.x == -1 && v1.y == 5 && v1.z == -2);
    }

    @Test
    public void testNegateCopy() throws Exception {
        v1 = new Vector3d(1, -5, 2);

        v2 = v1.negateCopy();

        assertTrue(v1.x == 1 && v1.y == -5 && v1.z == 2);
        assertTrue(v2.x == -1 && v2.y == 5 && v2.z == -2);
    }

    @Test
    public void testNormalize() throws Exception {
        /**
         * Normalization causes some error.  This cannot be avoided, so we will check if it is close to the target
         * length instead of strict equality.
         */
        v1 = new Vector3d(1, 1, 1);

        v1.normalize();
        length = v1.length();
        targetLength = 1;

        assertTrue(Math.abs(targetLength - length) < NORMALIZATION_TOLERANCE);

        v1 = new Vector3d(25, -10, 13);

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
        v1 = new Vector3d(1, 1, 1);

        v2 = v1.normalizeCopy();
        length = v2.length();
        targetLength = 1;

        assertTrue(Math.abs(targetLength - length) < NORMALIZATION_TOLERANCE);
        assertTrue(v1.x == 1 && v1.y == 1 && v1.z == 1);

        v1 = new Vector3d(25, -10, 13);

        v2 = v1.normalizeCopy();
        length = v2.length();
        targetLength = 1;

        assertTrue(Math.abs(targetLength - length) < NORMALIZATION_TOLERANCE);
        assertTrue(v1.x == 25 && v1.y == -10 && v1.z == 13);
    }

    @Test
    public void testScale() throws Exception {
        v1 = new Vector3d(1, 2, 3);

        v1.scale(5);

        assertTrue(v1.x == 5 && v1.y == 10 && v1.z == 15);
    }

    @Test
    public void testScaleCopy() throws Exception {
        v1 = new Vector3d(1, 2, 3);

        v2 = v1.scaleCopy(5);

        assertTrue(v1.x == 1 && v1.y == 2 && v1.z == 3);
        assertTrue(v2.x == 5 && v2.y == 10 && v2.z == 15);
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

        v1 = new Vector3d(1, 1, 1);
        targetLength = 5;
        v2 = v1.scaleCopyTo(targetLength);
        length = v2.length();
        scaledTolerance = NORMALIZATION_TOLERANCE * targetLength;

        assertTrue(Math.abs(targetLength - length) < scaledTolerance);
        assertTrue(v1.x == 1 && v1.y == 1 && v1.z == 1);

        v1 = new Vector3d(25, -10, 13);
        targetLength = 2;
        v2 = v1.scaleCopyTo(targetLength);
        length = v2.length();
        scaledTolerance = NORMALIZATION_TOLERANCE * targetLength;

        assertTrue(Math.abs(targetLength - length) < scaledTolerance);
        assertTrue(v1.x == 25 && v1.y == -10 && v1.z == 13);
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

        v1 = new Vector3d(1, 1, 1);
        targetLength = 5;
        v1.scaleTo(targetLength);
        length = v1.length();
        scaledTolerance = NORMALIZATION_TOLERANCE * targetLength;

        assertTrue(Math.abs(targetLength - length) < scaledTolerance);

        v1 = new Vector3d(25, -10, 13);
        targetLength = 2;
        v1.scaleTo(targetLength);
        length = v1.length();
        scaledTolerance = NORMALIZATION_TOLERANCE * targetLength;

        assertTrue(Math.abs(targetLength - length) < scaledTolerance);
    }

    @Test
    public void testSub() throws Exception {
        v1 = new Vector3d(1, 2, 3);
        v2 = new Vector3d(0, 1, 2);

        v1.sub(v2);

        assertTrue(v1.x == 1 && v1.y == 1 && v1.z == 1);
        assertTrue(v2.x == 0 && v2.y == 1 && v2.z == 2);
    }

    @Test
    public void testSubVectors() throws Exception {
        v1 = new Vector3d(1, 2, 3);
        v2 = new Vector3d(0, 1, 2);

        Vector3d diff = new Vector3d().subVectors(v1, v2);

        assertTrue(diff.x == 1 && diff.y == 1 && diff.z == 1);
        assertTrue(v1.x == 1 && v1.y == 2 && v1.z == 3);
        assertTrue(v2.x == 0 && v2.y == 1 && v2.z == 2);
    }
}