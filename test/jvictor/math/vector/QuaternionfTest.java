package jvictor.math.vector;

import jvictor.math.matrix.Matrix3f;
import jvictor.math.matrix.Matrix4f;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuaternionfTest {

    /**
     * We need this for all functions that involve normalization because normalization introduces floating point errors
     * into those calculations.
     */
    final float NORMALIZATION_TOLERANCE = 0.000001f;

    Quaternionf q1;
    Quaternionf q2;
    float angle;
    float targetAngle;
    float dot;
    float targetDot;
    float length;
    float targetLength;
    float lengthSq;
    float targetLengthSq;
    Vector3f inputAxis;
    Vector3f outputAxis;
    float inputAngle;
    float outputAngle;

    @Test
    public void testAngleBetween() throws Exception {
        q1 = new Quaternionf().setFromAxisAngle(new Vector3f(1, 0, 0), (float) Math.PI / 2f);
        q2 = new Quaternionf().setFromAxisAngle(new Vector3f(1, 0, 0), (float) Math.PI);
        targetAngle = (float) Math.PI / 2f;
        angle = new Quaternionf().angleBetween(q1, q2);

        assertTrue(similar(angle, targetAngle));
    }

    @Test
    public void testAngleTo() throws Exception {
        q1 = new Quaternionf().setFromAxisAngle(new Vector3f(1, 0, 0), 0);
        q2 = new Quaternionf().setFromAxisAngle(new Vector3f(1, 0, 0), (float) Math.PI / 2f);
        targetAngle = (float) Math.PI / 2f;
        angle = q1.angleTo(q2);

        assertTrue(similar(angle, targetAngle));
    }

    @Test
    public void testDot() throws Exception {
        q1 = new Quaternionf(1, 2, 3, 4);
        q2 = new Quaternionf(1, 1, 1, 1);

        dot = q1.dot(q2);
        targetDot = 10;

        assertTrue(dot == targetDot);
    }

    @Test
    public void testDotQuaternions() throws Exception {
        q1 = new Quaternionf(1, 2, 3, 4);
        q2 = new Quaternionf(1, 1, 1, 1);

        dot = new Quaternionf().dotQuaternions(q1, q2);
        targetDot = 10;

        assertTrue(dot == targetDot);
    }

    @Test
    public void testGetAngle() throws Exception {
        inputAxis = new Vector3f(1, 5, -10);
        inputAngle = (float) Math.PI / 2;

        q1 = new Quaternionf().setFromAxisAngle(inputAxis, inputAngle);

        outputAngle = q1.getAngle();

        assertTrue(inputAngle == outputAngle);

        inputAxis = new Vector3f(1, 5, -10);
        inputAngle = (float) Math.PI / 2.63f; // some weird angle

        q1 = new Quaternionf().setFromAxisAngle(inputAxis, inputAngle);

        outputAngle = q1.getAngle();

        assertTrue(inputAngle == outputAngle);
    }

    @Test
    public void testGetAxis() throws Exception {
        inputAxis = new Vector3f(1, 5, -10);
        inputAngle = (float) Math.PI / 2;

        q1 = new Quaternionf().setFromAxisAngle(inputAxis, inputAngle);

        /**
         * An axis normalization will happen when the quaternion is created.
         * this means we need to normalize the vector that was input to see
         * if the axes are the same.
        */
        inputAxis.normalize();
        outputAxis = q1.getAxis();

        assertTrue(Math.abs(inputAxis.x - outputAxis.x) < NORMALIZATION_TOLERANCE);
        assertTrue(Math.abs(inputAxis.y - outputAxis.y) < NORMALIZATION_TOLERANCE);
        assertTrue(Math.abs(inputAxis.z - outputAxis.z) < NORMALIZATION_TOLERANCE);
    }

    @Test
    public void testLength() throws Exception {
        q1 = new Quaternionf(1, 0, 0, 0);

        length = q1.length();
        targetLength = 1;

        assertTrue(length == targetLength);

        q1 = new Quaternionf(0, 0, 10, 0);

        length = q1.length();
        targetLength = 10;

        assertTrue(length == targetLength);
    }

    @Test
    public void testLengthSquared() throws Exception {
        q1 = new Quaternionf(1, 0, 0, 0);

        lengthSq = q1.lengthSquared();
        targetLengthSq = 1;

        assertTrue(lengthSq == targetLengthSq);

        q1 = new Quaternionf(0, 0, 10, 0);

        lengthSq = q1.lengthSquared();
        targetLengthSq = 100;

        assertTrue(lengthSq == targetLengthSq);
    }

    @Test
    public void testMul() throws Exception {
        /**
         * Tests for mul() and mulQuaternions() are omitted here because this functionality is already tested in
         * "testRotateBy" and similar tests; there are no straightforward ways to test multiplication by itself.
         */
    }

    @Test
    public void testMulQuaternions() throws Exception {
        /**
         * See "testMul".
         */
    }

    @Test
    public void testNegate() throws Exception {
        q1 = new Quaternionf(1, 2, 3, 4);

        q2 = q1.negate();

        assertTrue(q1.w == 1 && q1.x == -2 && q1.y == -3 && q1.z == -4);
        assertTrue(q2.w == 1 && q2.x == -2 && q2.y == -3 && q2.z == -4);
    }

    @Test
    public void testNegateCopy() throws Exception {
        q1 = new Quaternionf(1, 2, 3, 4);

        q2 = q1.negateCopy();

        assertTrue(q1.w == 1 && q1.x == 2 && q1.y == 3 && q1.z == 4);
        assertTrue(q2.w == 1 && q2.x == -2 && q2.y == -3 && q2.z == -4);
    }

    @Test
    public void testNormalize() throws Exception {
        /**
         * Normalization causes some error.  This cannot be avoided, so we will check if it is close to the target
         * length instead of strict equality.
         */
        q1 = new Quaternionf(1, 1, 1, 1);

        q1.normalize();
        length = q1.length();
        targetLength = 1;

        assertTrue(Math.abs(targetLength - length) < NORMALIZATION_TOLERANCE);

        q1 = new Quaternionf(25, -10, 13, 1);

        q1.normalize();
        length = q1.length();
        targetLength = 1;

        assertTrue(Math.abs(targetLength - length) < NORMALIZATION_TOLERANCE);
    }

    @Test
    public void testNormalizeCopy() throws Exception {
        /**
         * Normalization causes some error.  This cannot be avoided, so we will check if it is close to the target
         * length instead of strict equality.
         */
        q1 = new Quaternionf(1, 1, 1, 1);

        q2 = q1.normalizeCopy();
        length = q2.length();
        targetLength = 1;

        assertTrue(Math.abs(targetLength - length) < NORMALIZATION_TOLERANCE);
        assertTrue(q1.w == 1 && q1.x == 1 && q1.y == 1 && q1.z == 1);

        q1 = new Quaternionf(25, -10, 13, 1);

        q2 = q1.normalizeCopy();
        length = q2.length();
        targetLength = 1;

        assertTrue(Math.abs(targetLength - length) < NORMALIZATION_TOLERANCE);
        assertTrue(q1.w == 25 && q1.x == -10 && q1.y == 13 && q1.z == 1);
    }

    @Test
    public void testRotateBy() throws Exception {
        q1 = new Quaternionf();
        q2 = new Quaternionf(q1);

        Quaternionf rot = new Quaternionf();
        rot.setFromAxisAngle(new Vector3f(1, 0, 0), (float)Math.PI / 2f);

        q2.rotateBy(rot);
        angle = q1.angleTo(q2);
        targetAngle = (float) Math.PI / 2f;

        assertTrue(similar(angle, targetAngle));
    }

    @Test
    public void testSetFromAxisAngle() throws Exception {
        inputAxis = new Vector3f(1, 5, -10);
        inputAngle = (float) Math.PI / 2;

        q1 = new Quaternionf().setFromAxisAngle(inputAxis, inputAngle);

        /**
         * An axis normalization will happen when the quaternion is created.
         * this means we need to normalize the vector that was input to see
         * if the axes are the same.
         */
        inputAxis.normalize();
        outputAxis = q1.getAxis();
        outputAngle = q1.getAngle();

        assertTrue(Math.abs(inputAxis.x - outputAxis.x) < NORMALIZATION_TOLERANCE);
        assertTrue(Math.abs(inputAxis.y - outputAxis.y) < NORMALIZATION_TOLERANCE);
        assertTrue(Math.abs(inputAxis.z - outputAxis.z) < NORMALIZATION_TOLERANCE);
        assertTrue(inputAngle == outputAngle);
    }

    @Test
    public void testSetFromMatrix3f() throws Exception {

        Matrix3f in;
        Matrix4f out;
        Matrix4f in4;

        /**
         * 90 degree rotation around x-axis:
         * 1 0  0
         * 0 0 -1
         * 0 1  0
         */
        in = new Matrix3f();
        in.m00 = 1; in.m01 = 0; in.m02 = 0;
        in.m10 = 0; in.m11 = 0; in.m12 = -1;
        in.m20 = 0; in.m21 = 1; in.m22 = 0;

        q1 = new Quaternionf().setFromMatrix(in);
        out = q1.toRotationMatrix();
        in4 = new Matrix4f(in);

        assertTrue(similar(in4, out));

        /**
         * 90 degree rotation around z-axis:
         * 0 -1 0
         * 1  0 0
         * 0  0 1
         */
        in = new Matrix3f();
        in.m00 = 0; in.m01 = -1; in.m02 = 0;
        in.m10 = 1; in.m11 = 0;  in.m12 = 0;
        in.m20 = 0; in.m21 = 0;  in.m22 = 1;

        q1 = new Quaternionf().setFromMatrix(in);
        out = q1.toRotationMatrix();
        in4 = new Matrix4f(in);

        assertTrue(similar(in4, out));
    }

    @Test
    public void testSetFromMatrix4f() throws Exception {

        Matrix4f in;
        Matrix4f out;
        /**
         * 90 degree rotation around x-axis:
         * 1 0  0 0
         * 0 0 -1 0
         * 0 1  0 0
         * 0 0  0 1
         */
        in = new Matrix4f();
        in.m00 = 1; in.m01 = 0; in.m02 = 0;  in.m03 = 0;
        in.m10 = 0; in.m11 = 0; in.m12 = -1; in.m13 = 0;
        in.m20 = 0; in.m21 = 1; in.m22 = 0;  in.m23 = 0;
        in.m30 = 0; in.m31 = 0; in.m32 = 0;  in.m33 = 1;

        q1 = new Quaternionf().setFromMatrix(in);
        out = q1.toRotationMatrix();

        assertTrue(similar(in, out));

        /**
         * 90 degree rotation around z-axis:
         * 0 -1 0 0
         * 1  0 0 0
         * 0  0 1 0
         * 0  0 0 1
         */
        in = new Matrix4f();
        in.m00 = 0; in.m01 = -1; in.m02 = 0; in.m03 = 0;
        in.m10 = 1; in.m11 = 0;  in.m12 = 0; in.m13 = 0;
        in.m20 = 0; in.m21 = 0;  in.m22 = 1; in.m23 = 0;
        in.m30 = 0; in.m31 = 0;  in.m32 = 0; in.m33 = 1;

        q1 = new Quaternionf().setFromMatrix(in);
        out = q1.toRotationMatrix();

        assertTrue(similar(in, out));
    }

    @Test
    public void testSetIdentity() throws Exception {
        q1 = new Quaternionf(1, 2, 3, 4);

        q1.setIdentity();

        assertTrue(q1.w == 1 && q1.x == 0 && q1.y == 0 && q1.z == 0);
    }

    @Test
    public void testToRotationMatrix() throws Exception {

        float cos;
        float sin;
        Matrix4f r;

        //===============================
        //rotation around x by 90 degrees
        //===============================
        inputAxis = new Vector3f(1, 0, 0);
        inputAngle = (float) Math.PI / 2f;
        q1 = new Quaternionf().setFromAxisAngle(inputAxis, inputAngle);

        r = q1.toRotationMatrix();

        cos = (float) Math.cos(inputAngle);
        sin = (float) Math.sin(inputAngle);
        /**
         * rotation of "d" degrees around x-axis should look like this:
         * 1     0       0  0
         * 0 cos(d) -sin(d) 0
         * 0 sin(d)  cos(d) 0
         * 0     0       0  1
         */
        assertTrue(similar(r.m00, 1) && similar(r.m01,   0) && similar(r.m02,    0) && similar(r.m03, 0));
        assertTrue(similar(r.m10, 0) && similar(r.m11, cos) && similar(r.m12, -sin) && similar(r.m13, 0));
        assertTrue(similar(r.m20, 0) && similar(r.m21, sin) && similar(r.m22,  cos) && similar(r.m23, 0));
        assertTrue(similar(r.m30, 0) && similar(r.m31,   0) && similar(r.m32,    0) && similar(r.m33, 1));

        //===============================
        //rotation around y by 90 degrees
        //===============================
        inputAxis = new Vector3f(0, 1, 0);
        inputAngle = (float) Math.PI / 2f;
        q1 = new Quaternionf().setFromAxisAngle(inputAxis, inputAngle);

        r = q1.toRotationMatrix();

        cos = (float) Math.cos(inputAngle);
        sin = (float) Math.sin(inputAngle);
        /**
         * rotation of "d" degrees around y-axis should look like this:
         *  cos(d) 0 sin(d) 0
         *      0  1     0  0
         * -sin(d) 0 cos(d) 0
         *      0  0     0  1
         */
        assertTrue(similar(r.m00,  cos) && similar(r.m01, 0) && similar(r.m02, sin) && similar(r.m03, 0));
        assertTrue(similar(r.m10,    0) && similar(r.m11, 1) && similar(r.m12,   0) && similar(r.m13, 0));
        assertTrue(similar(r.m20, -sin) && similar(r.m21, 0) && similar(r.m22, cos) && similar(r.m23, 0));
        assertTrue(similar(r.m30,    0) && similar(r.m31, 0) && similar(r.m32,   0) && similar(r.m33, 1));

        //===============================
        //rotation around z by 90 degrees
        //===============================
        inputAxis = new Vector3f(0, 0, 1);
        inputAngle = (float) Math.PI / 2f;
        q1 = new Quaternionf().setFromAxisAngle(inputAxis, inputAngle);

        r = q1.toRotationMatrix();

        cos = (float) Math.cos(inputAngle);
        sin = (float) Math.sin(inputAngle);
        /**
         * rotation of "d" degrees around y-axis should look like this:
         *  cos(d) -sin(d) 0 0
         *  sin(d)  cos(d) 0 0
         *      0       0  1 0
         *      0       0  0 1
         */
        assertTrue(similar(r.m00, cos) && similar(r.m01, -sin) && similar(r.m02, 0) && similar(r.m03, 0));
        assertTrue(similar(r.m10, sin) && similar(r.m11,  cos) && similar(r.m12, 0) && similar(r.m13, 0));
        assertTrue(similar(r.m20,   0) && similar(r.m21,    0) && similar(r.m22, 1) && similar(r.m23, 0));
        assertTrue(similar(r.m30,   0) && similar(r.m31,    0) && similar(r.m32, 0) && similar(r.m33, 1));
    }

    private boolean similar(float a, float b) {
        return Math.abs(a - b) < NORMALIZATION_TOLERANCE;
    }

    private boolean similar(Matrix3f a, Matrix3f b) {
        return  similar(a.m00, b.m00) && similar(a.m01, b.m01) && similar(a.m02, b.m02) &&
                similar(a.m10, b.m10) && similar(a.m11, b.m11) && similar(a.m12, b.m12) &&
                similar(a.m20, b.m20) && similar(a.m21, b.m21) && similar(a.m22, b.m22);
    }

    private boolean similar(Matrix4f a, Matrix4f b) {
        return  similar(a.m00, b.m00) && similar(a.m01, b.m01) && similar(a.m02, b.m02) && similar(a.m03, b.m03) &&
                similar(a.m10, b.m10) && similar(a.m11, b.m11) && similar(a.m12, b.m12) && similar(a.m13, b.m13) &&
                similar(a.m20, b.m20) && similar(a.m21, b.m21) && similar(a.m22, b.m22) && similar(a.m23, b.m23) &&
                similar(a.m30, b.m30) && similar(a.m31, b.m31) && similar(a.m32, b.m32) && similar(a.m33, b.m33);
    }

    private boolean similar(float a, float b, float tolerance) {
        return Math.abs(a - b) < tolerance;
    }
}