package jvictor.math.vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Vector2dTest extends VectordTest {

    Vector2d v1;
    Vector2d v2;

    @Test
    public void testEquals() throws Exception {
        v1 = new Vector2d(1, 2);
        v2 = new Vector2d(v1);

        assertTrue(v1.equals(v2));
    }

    @Test
    public void testAdd() throws Exception {
        v1 = new Vector2d(1, 2);
        v2 = new Vector2d(1, 1);

        v1.add(v2);

        assertTrue(v1.x == 2 && v1.y == 3);
        assertTrue(v2.x == 1 && v2.y == 1);
    }

    @Test
    public void testAddVectors() throws Exception {
        v1 = new Vector2d(1, 2);
        v2 = new Vector2d(1, 1);

        Vector2d sum = new Vector2d().addVectors(v1, v2);

        assertTrue(sum.x == 2 && sum.y == 3);
        assertTrue(v1.x == 1 && v1.y == 2);
        assertTrue(v2.x == 1 && v2.y == 1);
    }

    @Test
    public void testAngleBetween() throws Exception {
        v1 = new Vector2d(1, 1);
        v2 = new Vector2d(1, 1);

        angle = new Vector2d().angleBetween(v1, v2);
        targetAngle = 0;

        assertTrue(angle == targetAngle);

        v1 = new Vector2d(1, 0);
        v2 = new Vector2d(0, 1);

        angle = new Vector2d().angleBetween(v1, v2);
        targetAngle = Math.PI / 2; //  90 degrees

        assertTrue(angle == targetAngle);

        v1 = new Vector2d(1, 0);
        v2 = new Vector2d(0, -1);

        angle = new Vector2d().angleBetween(v1, v2);
        targetAngle = -Math.PI / 2; // -90 degrees

        assertTrue(angle == targetAngle);
    }

    @Test
    public void testAngleTo() throws Exception {
        v1 = new Vector2d(1, 1);
        v2 = new Vector2d(1, 1);

        angle = v1.angleTo(v2);
        targetAngle = 0;

        assertTrue(angle == targetAngle);

        v1 = new Vector2d(1, 0);
        v2 = new Vector2d(0, 1);

        angle = v1.angleTo(v2);
        targetAngle = Math.PI / 2; //  90 degrees

        assertTrue(angle == targetAngle);

        v1 = new Vector2d(1, 0);
        v2 = new Vector2d(0, -1);

        angle = v1.angleTo(v2);
        targetAngle = -Math.PI / 2; // -90 degrees

        assertTrue(angle == targetAngle);
    }

    @Test
    public void testDot() throws Exception {
        v1 = new Vector2d(1, 2);
        v2 = new Vector2d(3, 4);

        dot = v1.dot(v2);

        assertTrue(dot == 11);
    }

    @Test
    public void testDotVectors() throws Exception {
        v1 = new Vector2d(1, 2);
        v2 = new Vector2d(3, 4);

        dot = new Vector2d().dotVectors(v1, v2);
        targetDot = 11;

        assertTrue(dot == targetDot);
    }

    @Test
    public void testLength() throws Exception {
        v1 = new Vector2d(1, 0);

        length = v1.length();
        targetLength = 1;

        assertTrue(length == targetLength);

        v1 = new Vector2d(0, -10);

        length = v1.length();
        targetLength = 10;

        assertTrue(length == targetLength);
    }

    @Test
    public void testLengthSquared() throws Exception {
        v1 = new Vector2d(1, 0);

        lengthSq = v1.lengthSquared();
        targetLengthSq = 1;

        assertTrue(lengthSq == targetLengthSq);

        v1 = new Vector2d(0, -10);

        lengthSq = v1.lengthSquared();
        targetLengthSq = 100;

        assertTrue(lengthSq == targetLengthSq);
    }

    @Test
    public void testNegate() throws Exception {
        v1 = new Vector2d(1, 2);

        v1.negate();

        assertTrue(v1.x == -1 && v1.y == -2);
    }

    @Test
    public void testNegateCopy() throws Exception {
        v1 = new Vector2d(1, 2);

        v2 = v1.negateCopy();

        assertTrue(v1.x == 1 && v1.y == 2);
        assertTrue(v2.x == -1 && v2.y == -2);
    }

    @Test
    public void testNormalize() throws Exception {
        v1 = new Vector2d(1, 1);

        v1.normalize();
        length = v1.length();
        targetLength = 1;

        assertTrue(similar(targetLength, length));

        v1 = new Vector2d(25, -10);

        v1.normalize();
        length = v1.length();
        targetLength = 1;

        assertTrue(similar(targetLength, length));
    }

    @Test
    public void testNormalizeCopy() throws Exception {
        v1 = new Vector2d(1, 1);

        v2 = v1.normalizeCopy();
        length = v2.length();
        targetLength = 1;

        assertTrue(similar(targetLength, length));
        assertTrue(v1.x == 1 && v1.y == 1);

        v1 = new Vector2d(25, -10);

        v2 = v1.normalizeCopy();
        length = v2.length();
        targetLength = 1;

        assertTrue(similar(targetLength, length));
        assertTrue(v1.x == 25 && v1.y == -10);
    }

    @Test
    public void testScale() throws Exception {
        v1 = new Vector2d(1, 2);

        v1.scale(5);

        assertTrue(v1.x == 5 && v1.y == 10);
    }

    @Test
    public void testScaleCopy() throws Exception {
        v1 = new Vector2d(1, 2);

        v2 = v1.scaleCopy(5);

        assertTrue(v1.x == 1 && v1.y == 2);
        assertTrue(v2.x == 5 && v2.y == 10);
    }

    @Test
    public void testScaleCopyTo() throws Exception {
        double scaledTolerance;

        v1 = new Vector2d(1, 1);
        targetLength = 5;
        v2 = v1.scaleCopyTo(targetLength);
        length = v2.length();
        scaledTolerance = TOLERANCE * targetLength;

        assertTrue(similar(targetLength, length, scaledTolerance));
        assertTrue(v1.x == 1 && v1.y == 1);

        v1 = new Vector2d(25, -10);
        targetLength = 2;
        v2 = v1.scaleCopyTo(targetLength);
        length = v2.length();
        scaledTolerance = TOLERANCE * targetLength;

        assertTrue(similar(targetLength, length, scaledTolerance));
        assertTrue(v1.x == 25 && v1.y == -10);
    }

    @Test
    public void testScaleTo() throws Exception {
        double scaledTolerance;

        v1 = new Vector2d(1, 1);
        targetLength = 5;
        v1.scaleTo(targetLength);
        length = v1.length();
        scaledTolerance = TOLERANCE * targetLength;

        assertTrue(similar(targetLength, length, scaledTolerance));

        v1 = new Vector2d(25, -10);
        targetLength = 2;
        v1.scaleTo(targetLength);
        length = v1.length();
        scaledTolerance = TOLERANCE * targetLength;

        assertTrue(similar(targetLength, length, scaledTolerance));
    }

    @Test
    public void testSub() throws Exception {
        v1 = new Vector2d(1, 2);
        v2 = new Vector2d(1, 1);

        v1.sub(v2);

        assertTrue(v1.x == 0 && v1.y == 1);
        assertTrue(v2.x == 1 && v2.y == 1);
    }

    @Test
    public void testSubVectors() throws Exception {
        v1 = new Vector2d(1, 2);
        v2 = new Vector2d(1, 1);

        Vector2d diff = new Vector2d().subVectors(v1, v2);

        assertTrue(diff.x == 0 && diff.y == 1);
        assertTrue(v1.x == 1 && v1.y == 2);
        assertTrue(v2.x == 1 && v2.y == 1);
    }
}