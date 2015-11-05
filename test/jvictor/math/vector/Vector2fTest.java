package jvictor.math.vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Vector2fTest {

    /**
     * We need this for all functions that involve normalization because normalization introduces floating point errors
     * into those calculations.
     */
    final float NORMALIZATION_TOLERANCE = 0.000001f;

    Vector2f v1;
    Vector2f v2;
    float angle;
    float targetAngle;
    float dot;
    float targetDot;
    float length;
    float targetLength;
    float lengthSq;
    float targetLengthSq;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {
        v1 = new Vector2f(1, 1);
        v2 = new Vector2f(1, 1);
        Vector2f result = v1.add(v2);

        assertTrue(result.x == 2 && result.y == 2);
        assertTrue(v1.x == 2 && v1.y == 2);
        assertTrue(v2.x == 1 && v2.y == 1);
    }

    @Test
    public void testAddVectors() throws Exception {
        v1 = new Vector2f(1, 1);
        v2 = new Vector2f(1, 1);
        Vector2f result = new Vector2f().addVectors(v1, v2);

        assertTrue(result.x == 2f && result.y == 2f);
        assertTrue(v1.x == 1f && v1.y == 1f);
        assertTrue(v2.x == 1f && v2.y == 1f);
    }

    @Test
    public void testAngleBetween() throws Exception {
        v1 = new Vector2f(1, 1);
        v2 = new Vector2f(1, 1);

        angle = new Vector2f().angleBetween(v1, v2);
        targetAngle = 0;

        assertTrue(angle == targetAngle);

        v1 = new Vector2f(1, 0);
        v2 = new Vector2f(0, 1);

        angle = new Vector2f().angleBetween(v1, v2);
        targetAngle = (float) Math.PI / 2; //  90 degrees

        assertTrue(angle == targetAngle);

        v1 = new Vector2f(1, 0);
        v2 = new Vector2f(0, -1);

        angle = new Vector2f().angleBetween(v1, v2);
        targetAngle = (float) -Math.PI / 2; // -90 degrees

        assertTrue(angle == targetAngle);
    }

    @Test
    public void testAngleTo() throws Exception {
        v1 = new Vector2f(1, 1);
        v2 = new Vector2f(1, 1);

        angle = v1.angleTo(v2);
        targetAngle = 0;

        assertTrue(angle == targetAngle);

        v1 = new Vector2f(1, 0);
        v2 = new Vector2f(0, 1);

        angle = v1.angleTo(v2);
        targetAngle = (float) Math.PI / 2; //  90 degrees

        assertTrue(angle == targetAngle);

        v1 = new Vector2f(1, 0);
        v2 = new Vector2f(0, -1);

        angle = v1.angleTo(v2);
        targetAngle = (float) -Math.PI / 2; // -90 degrees

        assertTrue(angle == targetAngle);
    }

    @Test
    public void testDot() throws Exception {
        v1 = new Vector2f(1, 1);
        v2 = new Vector2f(2, 2);

        dot = v1.dot(v2);
        targetDot = 4;

        assertTrue(dot == targetDot);

        v1 = new Vector2f(-1, 1);
        v2 = new Vector2f(2, 2);

        dot = v1.dot(v2);
        targetDot = 0;

        assertTrue(dot == targetDot);
    }

    @Test
    public void testDotVectors() throws Exception {
        v1 = new Vector2f(1, 1);
        v2 = new Vector2f(2, 2);

        dot = new Vector2f().dotVectors(v1, v2);
        targetDot = 4;

        assertTrue(dot == targetDot);

        v1 = new Vector2f(-1, 1);
        v2 = new Vector2f(2, 2);

        dot = new Vector2f().dotVectors(v1, v2);
        targetDot = 0;

        assertTrue(dot == targetDot);
    }

    @Test
    public void testLength() throws Exception {
        v1 = new Vector2f(1, 0);

        length = v1.length();
        targetLength = 1;

        assertTrue(length == targetLength);

        v1 = new Vector2f(0, -10);

        length = v1.length();
        targetLength = 10;

        assertTrue(length == targetLength);
    }

    @Test
    public void testLengthSquared() throws Exception {
        v1 = new Vector2f(1, 0);

        lengthSq = v1.lengthSquared();
        targetLengthSq = 1;

        assertTrue(lengthSq == targetLengthSq);

        v1 = new Vector2f(0, -10);

        lengthSq = v1.lengthSquared();
        targetLengthSq = 100;

        assertTrue(lengthSq == targetLengthSq);
    }

    @Test
    public void testNegate() throws Exception {
        v1 = new Vector2f(1, -2);

        v1.negate();

        assertTrue(v1.x == -1);
        assertTrue(v1.y == 2);
    }

    @Test
    public void testNegateCopy() throws Exception {
        v1 = new Vector2f(1, -2);

        v2 = v1.negateCopy();

        assertTrue(v1.x == 1);
        assertTrue(v1.y == -2);
        assertTrue(v2.x == -1);
        assertTrue(v2.y == 2);
    }

    @Test
    public void testNormalize() throws Exception {
        /**
         * Normalization causes some error.  This cannot be avoided, so we will check if it is close to the target
         * length instead of strict equality.
         */
        v1 = new Vector2f(1, 1);

        v1.normalize();
        length = v1.length();
        targetLength = 1;

        assertTrue(targetLength - length < NORMALIZATION_TOLERANCE);

        v1 = new Vector2f(25, -10);

        v1.normalize();
        length = v1.length();
        targetLength = 1;

        assertTrue(targetLength - length < NORMALIZATION_TOLERANCE);
    }

    @Test
    public void testNormalizeCopy() throws Exception {
        /**
         * Normalization causes some error.  This cannot be avoided, so we will check if it is close to the target
         * length instead of strict equality.
         */
        v1 = new Vector2f(1, 1);

        v2 = v1.normalizeCopy();
        length = v2.length();
        targetLength = 1;

        assertTrue(length < targetLength + NORMALIZATION_TOLERANCE && length > targetLength - NORMALIZATION_TOLERANCE);
        assertTrue(v1.x == 1 && v1.y == 1);

        v1 = new Vector2f(25, -10);

        v2 = v1.normalizeCopy();
        length = v2.length();
        targetLength = 1;

        assertTrue(length < targetLength + NORMALIZATION_TOLERANCE && length > targetLength - NORMALIZATION_TOLERANCE);
        assertTrue(v1.x == 25 && v1.y == -10);
    }

    @Test
    public void testScale() throws Exception {
        v1 = new Vector2f(1, 0);

        v1.scale(5);

        assertTrue(v1.x == 5 && v1.y == 0);

        v1 = new Vector2f(1, -2);

        v1.scale(3);

        assertTrue(v1.x == 3 && v1.y == -6);
    }

    @Test
    public void testScaleCopy() throws Exception {
        v1 = new Vector2f(1, 0);

        v2 = v1.scaleCopy(5);

        assertTrue(v1.x == 1 && v1.y == 0);
        assertTrue(v2.x == 5 && v2.y == 0);

        v1 = new Vector2f(1, -2);

        v2 = v1.scaleCopy(3);

        assertTrue(v1.x == 1 && v1.y == -2);
        assertTrue(v2.x == 3 && v2.y == -6);
    }

    @Test
    public void testScaleCopyTo() throws Exception {
        /**
         * Normalization causes some error.  This cannot be avoided, so we will check if it is close to the target
         * length instead of strict equality.
         *
         * ScaleCopyTo involves normalization, so this must be handled here as well.
         */
        float scaledTolerance;

        v1 = new Vector2f(1, 1);
        targetLength = 5;
        v2 = v1.scaleCopyTo(targetLength);
        length = v2.length();
        scaledTolerance = NORMALIZATION_TOLERANCE * targetLength;

        assertTrue(length < targetLength + scaledTolerance && length > targetLength - scaledTolerance);
        assertTrue(v1.x == 1 && v1.y == 1);

        v1 = new Vector2f(25, -10);
        targetLength = 2;
        v2 = v1.scaleCopyTo(targetLength);
        length = v2.length();
        scaledTolerance = NORMALIZATION_TOLERANCE * targetLength;

        assertTrue(length < targetLength + scaledTolerance && length > targetLength - scaledTolerance);
        assertTrue(v1.x == 25 && v1.y == -10);
    }

    @Test
    public void testScaleTo() throws Exception {
        /**
         * Normalization causes some error.  This cannot be avoided, so we will check if it is close to the target
         * length instead of strict equality.
         *
         * ScaleTo involves normalization, so this must be handled here as well.
         */
        float scaledTolerance;

        v1 = new Vector2f(1, 1);
        targetLength = 5;
        v1.scaleTo(targetLength);
        length = v1.length();
        scaledTolerance = NORMALIZATION_TOLERANCE * targetLength;

        assertTrue(length < targetLength + scaledTolerance && length > targetLength - scaledTolerance);

        v1 = new Vector2f(25, -10);
        targetLength = 2;
        v1.scaleTo(targetLength);
        length = v1.length();
        scaledTolerance = NORMALIZATION_TOLERANCE * targetLength;

        assertTrue(length < targetLength + scaledTolerance && length > targetLength - scaledTolerance);
    }

    @Test
    public void testSub() throws Exception {
        v1 = new Vector2f(-1, 1);
        v2 = new Vector2f(1, 2);

        v1.sub(v2);

        assertTrue(v1.x == -2 && v1.y == -1);
        assertTrue(v2.x == 1 && v2.y == 2);
    }

    @Test
    public void testSubVectors() throws Exception {
        v1 = new Vector2f(-1, 1);
        v2 = new Vector2f(1, 2);

        Vector2f diff = new Vector2f().subVectors(v1, v2);

        assertTrue(v1.x == -1 && v1.y == 1);
        assertTrue(v2.x == 1 && v2.y == 2);
        assertTrue(diff.x == -2 && diff.y == -1);
    }
}