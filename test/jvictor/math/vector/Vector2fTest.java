package jvictor.math.vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Vector2fTest {

    Vector2f v1;
    Vector2f v2;

    @Before
    public void setUp() throws Exception {
        v1 = new Vector2f();
        v2 = new Vector2f();
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
    public void testAngleTo() throws Exception {
        float angle;
        float targetAngle;

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
    public void testAngleBetween() throws Exception {

    }

    @Test
    public void testDot() throws Exception {

    }

    @Test
    public void testDotVectors() throws Exception {

    }

    @Test
    public void testLength() throws Exception {

    }

    @Test
    public void testLengthSquared() throws Exception {

    }

    @Test
    public void testNegate() throws Exception {

    }

    @Test
    public void testNegateCopy() throws Exception {

    }

    @Test
    public void testNormalize() throws Exception {

    }

    @Test
    public void testNormalizeCopy() throws Exception {

    }

    @Test
    public void testScale() throws Exception {

    }

    @Test
    public void testScaleCopy() throws Exception {

    }

    @Test
    public void testScaleTo() throws Exception {

    }

    @Test
    public void testScaleCopyTo() throws Exception {

    }

    @Test
    public void testSub() throws Exception {

    }

    @Test
    public void testSubVectors() throws Exception {

    }
}