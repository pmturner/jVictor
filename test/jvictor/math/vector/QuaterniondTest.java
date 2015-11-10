package jvictor.math.vector;

import jvictor.math.matrix.Matrix3d;
import jvictor.math.matrix.Matrix4d;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuaterniondTest extends VectordTest {

    Quaterniond q1;
    Quaterniond q2;
    Vector3d inputAxis;
    Vector3d outputAxis;

    @Test
    public void testAngleBetween() throws Exception {
        q1 = new Quaterniond().setFromAxisAngle(new Vector3d(1, 0, 0), Math.PI / 2);
        q2 = new Quaterniond().setFromAxisAngle(new Vector3d(1, 0, 0), Math.PI);
        targetAngle = Math.PI / 2;
        angle = new Quaterniond().angleBetween(q1, q2);

        assertTrue(similar(angle, targetAngle));
    }

    @Test
    public void testAngleTo() throws Exception {
        q1 = new Quaterniond().setFromAxisAngle(new Vector3d(1, 0, 0), 0);
        q2 = new Quaterniond().setFromAxisAngle(new Vector3d(1, 0, 0), Math.PI / 2f);
        targetAngle = Math.PI / 2;
        angle = q1.angleTo(q2);

        assertTrue(similar(angle, targetAngle));
    }

    @Test
    public void testDot() throws Exception {
        q1 = new Quaterniond(1, 2, 3, 4);
        q2 = new Quaterniond(1, 1, 1, 1);

        dot = q1.dot(q2);
        targetDot = 10;

        assertTrue(dot == targetDot);
    }

    @Test
    public void testDotQuaternions() throws Exception {
        q1 = new Quaterniond(1, 2, 3, 4);
        q2 = new Quaterniond(1, 1, 1, 1);

        dot = new Quaterniond().dotQuaternions(q1, q2);
        targetDot = 10;

        assertTrue(dot == targetDot);
    }

    @Test
    public void testGetAngle() throws Exception {
        inputAxis = new Vector3d(1, 5, -10);
        inputAngle = Math.PI / 2;

        q1 = new Quaterniond().setFromAxisAngle(inputAxis, inputAngle);

        outputAngle = q1.getAngle();

        assertTrue(inputAngle == outputAngle);

        inputAxis = new Vector3d(1, 5, -10);
        inputAngle = Math.PI / 2.63; // some weird angle

        q1 = new Quaterniond().setFromAxisAngle(inputAxis, inputAngle);

        outputAngle = q1.getAngle();

        assertTrue(inputAngle == outputAngle);
    }

    @Test
    public void testGetAxis() throws Exception {
        inputAxis = new Vector3d(1, 5, -10);
        inputAngle = Math.PI / 2;

        q1 = new Quaterniond().setFromAxisAngle(inputAxis, inputAngle);

        /**
         * An axis normalization will happen when the quaternion is created.
         * this means we need to normalize the vector that was input to see
         * if the axes are the same.
         */
        inputAxis.normalize();
        outputAxis = q1.getAxis();

        assertTrue(similar(inputAxis, outputAxis));
    }

    @Test
    public void testLength() throws Exception {
        q1 = new Quaterniond(1, 0, 0, 0);

        length = q1.length();
        targetLength = 1;

        assertTrue(length == targetLength);

        q1 = new Quaterniond(0, 0, 10, 0);

        length = q1.length();
        targetLength = 10;

        assertTrue(length == targetLength);
    }

    @Test
    public void testLengthSquared() throws Exception {
        q1 = new Quaterniond(1, 0, 0, 0);

        lengthSq = q1.lengthSquared();
        targetLengthSq = 1;

        assertTrue(lengthSq == targetLengthSq);

        q1 = new Quaterniond(0, 0, 10, 0);

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
        q1 = new Quaterniond(1, 2, 3, 4);

        q2 = q1.negate();

        assertTrue(q1.w == 1 && q1.x == -2 && q1.y == -3 && q1.z == -4);
        assertTrue(q2.w == 1 && q2.x == -2 && q2.y == -3 && q2.z == -4);
    }

    @Test
    public void testNegateCopy() throws Exception {
        q1 = new Quaterniond(1, 2, 3, 4);

        q2 = q1.negateCopy();

        assertTrue(q1.w == 1 && q1.x == 2 && q1.y == 3 && q1.z == 4);
        assertTrue(q2.w == 1 && q2.x == -2 && q2.y == -3 && q2.z == -4);
    }

    @Test
    public void testNormalize() throws Exception {
        q1 = new Quaterniond(1, 1, 1, 1);

        q1.normalize();
        length = q1.length();
        targetLength = 1;

        assertTrue(similar(targetLength, length));

        q1 = new Quaterniond(25, -10, 13, 1);

        q1.normalize();
        length = q1.length();
        targetLength = 1;

        assertTrue(similar(targetLength, length));
    }

    @Test
    public void testNormalizeCopy() throws Exception {
        q1 = new Quaterniond(1, 1, 1, 1);

        q2 = q1.normalizeCopy();
        length = q2.length();
        targetLength = 1;

        assertTrue(similar(targetLength, length));
        assertTrue(q1.w == 1 && q1.x == 1 && q1.y == 1 && q1.z == 1);

        q1 = new Quaterniond(25, -10, 13, 1);

        q2 = q1.normalizeCopy();
        length = q2.length();
        targetLength = 1;

        assertTrue(similar(targetLength, length));
        assertTrue(q1.w == 25 && q1.x == -10 && q1.y == 13 && q1.z == 1);
    }

    @Test
    public void testRotateBy() throws Exception {
        q1 = new Quaterniond();
        q2 = new Quaterniond(q1);

        Quaterniond rot = new Quaterniond();
        rot.setFromAxisAngle(new Vector3d(1, 0, 0), Math.PI / 2);

        q2.rotateBy(rot);
        angle = q1.angleTo(q2);
        targetAngle = Math.PI / 2;

        assertTrue(similar(angle, targetAngle));
    }

    @Test
    public void testSetFromAxisAngle() throws Exception {
        inputAxis = new Vector3d(1, 5, -10);
        inputAngle = Math.PI / 2;

        q1 = new Quaterniond().setFromAxisAngle(inputAxis, inputAngle);

        /**
         * An axis normalization will happen when the quaternion is created.
         * this means we need to normalize the vector that was input to see
         * if the axes are the same.
         */
        inputAxis.normalize();
        outputAxis = q1.getAxis();
        outputAngle = q1.getAngle();

        assertTrue(similar(inputAxis, outputAxis));
        assertTrue(inputAngle == outputAngle);
    }

    @Test
    public void testSetFromMatrix3d() throws Exception {
        Matrix3d in;
        Matrix4d out;
        Matrix4d in4;

        /**
         * 90 degree rotation around x-axis:
         * 1 0  0
         * 0 0 -1
         * 0 1  0
         */
        in = new Matrix3d();
        in.m00 = 1; in.m01 = 0; in.m02 = 0;
        in.m10 = 0; in.m11 = 0; in.m12 = -1;
        in.m20 = 0; in.m21 = 1; in.m22 = 0;

        q1 = new Quaterniond().setFromMatrix(in);
        out = q1.toRotationMatrix();
        in4 = new Matrix4d(in);

        assertTrue(similar(in4, out));

        /**
         * 90 degree rotation around z-axis:
         * 0 -1 0
         * 1  0 0
         * 0  0 1
         */
        in = new Matrix3d();
        in.m00 = 0; in.m01 = -1; in.m02 = 0;
        in.m10 = 1; in.m11 = 0;  in.m12 = 0;
        in.m20 = 0; in.m21 = 0;  in.m22 = 1;

        q1 = new Quaterniond().setFromMatrix(in);
        out = q1.toRotationMatrix();
        in4 = new Matrix4d(in);

        assertTrue(similar(in4, out));
    }

    @Test
    public void testSetFromMatrix4d() throws Exception {
        Matrix4d in;
        Matrix4d out;
        /**
         * 90 degree rotation around x-axis:
         * 1 0  0 0
         * 0 0 -1 0
         * 0 1  0 0
         * 0 0  0 1
         */
        in = new Matrix4d();
        in.m00 = 1; in.m01 = 0; in.m02 = 0;  in.m03 = 0;
        in.m10 = 0; in.m11 = 0; in.m12 = -1; in.m13 = 0;
        in.m20 = 0; in.m21 = 1; in.m22 = 0;  in.m23 = 0;
        in.m30 = 0; in.m31 = 0; in.m32 = 0;  in.m33 = 1;

        q1 = new Quaterniond().setFromMatrix(in);
        out = q1.toRotationMatrix();

        assertTrue(similar(in, out));

        /**
         * 90 degree rotation around z-axis:
         * 0 -1 0 0
         * 1  0 0 0
         * 0  0 1 0
         * 0  0 0 1
         */
        in = new Matrix4d();
        in.m00 = 0; in.m01 = -1; in.m02 = 0; in.m03 = 0;
        in.m10 = 1; in.m11 = 0;  in.m12 = 0; in.m13 = 0;
        in.m20 = 0; in.m21 = 0;  in.m22 = 1; in.m23 = 0;
        in.m30 = 0; in.m31 = 0;  in.m32 = 0; in.m33 = 1;

        q1 = new Quaterniond().setFromMatrix(in);
        out = q1.toRotationMatrix();

        assertTrue(similar(in, out));
    }

    @Test
    public void testSetIdentity() throws Exception {
        q1 = new Quaterniond(1, 2, 3, 4);

        q1.setIdentity();

        assertTrue(q1.w == 1 && q1.x == 0 && q1.y == 0 && q1.z == 0);
    }

    @Test
    public void testToRotationMatrix() throws Exception {
        double cos;
        double sin;
        Matrix4d r;
        Matrix4d r2;

        //===============================
        //rotation around x by 90 degrees
        //===============================
        inputAxis = new Vector3d(1, 0, 0);
        inputAngle = Math.PI / 2;
        cos = Math.cos(inputAngle);
        sin = Math.sin(inputAngle);

        q1 = new Quaterniond().setFromAxisAngle(inputAxis, inputAngle);
        r = q1.toRotationMatrix();
        /**
         * rotation of "d" degrees around x-axis should look like this:
         * 1     0       0  0
         * 0 cos(d) -sin(d) 0
         * 0 sin(d)  cos(d) 0
         * 0     0       0  1
         */
        r2 = new Matrix4d();
        r2.m00 = 1; r2.m01 = 0;   r2.m02 =    0; r2.m03 = 0;
        r2.m10 = 0; r2.m11 = cos; r2.m12 = -sin; r2.m13 = 0;
        r2.m20 = 0; r2.m21 = sin; r2.m22 =  cos; r2.m23 = 0;
        r2.m30 = 0; r2.m31 = 0;   r2.m32 =    0; r2.m33 = 1;

        assertTrue(similar(r, r2));

        //===============================
        //rotation around y by 90 degrees
        //===============================
        inputAxis = new Vector3d(0, 1, 0);
        inputAngle = Math.PI / 2;
        cos = Math.cos(inputAngle);
        sin = Math.sin(inputAngle);

        q1 = new Quaterniond().setFromAxisAngle(inputAxis, inputAngle);
        r = q1.toRotationMatrix();
        /**
         * rotation of "d" degrees around y-axis should look like this:
         *  cos(d) 0 sin(d) 0
         *      0  1     0  0
         * -sin(d) 0 cos(d) 0
         *      0  0     0  1
         */
        r2 = new Matrix4d();
        r2.m00 =  cos; r2.m01 = 0; r2.m02 = sin; r2.m03 = 0;
        r2.m10 =    0; r2.m11 = 1; r2.m12 =   0; r2.m13 = 0;
        r2.m20 = -sin; r2.m21 = 0; r2.m22 = cos; r2.m23 = 0;
        r2.m30 =    0; r2.m31 = 0; r2.m32 =   0; r2.m33 = 1;

        assertTrue(similar(r, r2));

        //===============================
        //rotation around z by 90 degrees
        //===============================
        inputAxis = new Vector3d(0, 0, 1);
        inputAngle = Math.PI / 2;
        cos = Math.cos(inputAngle);
        sin = Math.sin(inputAngle);

        q1 = new Quaterniond().setFromAxisAngle(inputAxis, inputAngle);
        r = q1.toRotationMatrix();
        /**
         * rotation of "d" degrees around y-axis should look like this:
         *  cos(d) -sin(d) 0 0
         *  sin(d)  cos(d) 0 0
         *      0       0  1 0
         *      0       0  0 1
         */
        r2 = new Matrix4d();
        r2.m00 =  cos; r2.m01 = -sin; r2.m02 = 0; r2.m03 = 0;
        r2.m10 =  sin; r2.m11 =  cos; r2.m12 = 0; r2.m13 = 0;
        r2.m20 =    0; r2.m21 =    0; r2.m22 = 1; r2.m23 = 0;
        r2.m30 =    0; r2.m31 =    0; r2.m32 = 0; r2.m33 = 1;

        assertTrue(similar(r, r2));
    }

    private boolean similar(Matrix4d a, Matrix4d b) {
        return  similar(a.m00, b.m00) && similar(a.m01, b.m01) && similar(a.m02, b.m02) && similar(a.m03, b.m03) &&
                similar(a.m10, b.m10) && similar(a.m11, b.m11) && similar(a.m12, b.m12) && similar(a.m13, b.m13) &&
                similar(a.m20, b.m20) && similar(a.m21, b.m21) && similar(a.m22, b.m22) && similar(a.m23, b.m23) &&
                similar(a.m30, b.m30) && similar(a.m31, b.m31) && similar(a.m32, b.m32) && similar(a.m33, b.m33);
    }
}