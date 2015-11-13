package jvictor.math.vector;

import jvictor.math.matrix.Matrix3f;
import jvictor.math.matrix.Matrix4f;

public class Quaternionf implements jvictor.math.vector.interfaces.Quaternionf<Quaternionf> {

    private static final float TOLERANCE = 0.000001f;

    public float w;
    public float x;
    public float y;
    public float z;

    public Quaternionf(float w, float x, float y, float z) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Quaternionf(Quaternionf q) {
        this(q.w, q.x, q.y, q.z);
    }

    public Quaternionf() {
        this(1, 0, 0, 0);
    }

    @Override
    public float angleBetween(Quaternionf q1, Quaternionf q2) {
        return q1.angleTo(q2);
    }

    @Override
    public float angleTo(Quaternionf q) {
        Quaternionf thisConjugate = negateCopy();
        Quaternionf diff = new Quaternionf().mulQuaternions(q, thisConjugate);
        return diff.getAngle();
    }

    @Override
    public float dot(Quaternionf q) {
        return (w * q.w) + (x * q.x) + (y * q.y) + (z * q.z);
    }

    @Override
    public float dotQuaternions(Quaternionf q1, Quaternionf q2) {
        return q1.dot(q2);
    }

    public boolean equals(Quaternionf q) {
        return (w == q.w) && (x == q.x) && (y == q.y) && (z == q.z);
    }

    @Override
    public float getAngle() {
        return 2f * (float) Math.acos(w);
    }

    @Override
    public Vector3f getAxis() {
        if (w > 1) {
            // avoid errors in Sqrt
            normalize();
        }
        float div = (float) Math.sqrt(1 - (w * w));

        Vector3f axis = new Vector3f();

        if (div < 0.001f) { //TODO: might need a better value for this
            axis.x = x;
            axis.y = y;
            axis.z = z;
        } else {
            axis.x = x / div;
            axis.y = y / div;
            axis.z = z / div;
        }

        return axis;
    }

    @Override
    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    @Override
    public float lengthSquared() {
        return (w * w) + (x * x) + (y * y) + (z * z);
    }

    @Override
    public Quaternionf mul(Quaternionf q2) {
        Quaternionf q1 = new Quaternionf(this);

        w = (q1.w * q2.w) - (q1.x * q2.x) - (q1.y * q2.y) - (q1.z * q2.z);
        x = (q1.w * q2.x) + (q1.x * q2.w) + (q1.y * q2.z) - (q1.z * q2.y);
        y = (q1.w * q2.y) - (q1.x * q2.z) + (q1.y * q2.w) + (q1.z * q2.x);
        z = (q1.w * q2.z) + (q1.x * q2.y) - (q1.y * q2.x) + (q1.z * q2.w);

        return this;
    }

    @Override
    public Quaternionf mulQuaternions(Quaternionf q1, Quaternionf q2) {
        Quaternionf q1Copy = new Quaternionf(q1);
        return q1Copy.mul(q2);
    }

    @Override
    public Quaternionf negate() {
        x = -x;
        y = -y;
        z = -z;
        return this;
    }

    @Override
    public Quaternionf negateCopy() {
        return new Quaternionf(this).negate();
    }

    @Override
    public Quaternionf normalize() {
        float length = length();
        w /= length;
        x /= length;
        y /= length;
        z /= length;
        return this;
    }

    @Override
    public Quaternionf normalizeCopy() {
        return new Quaternionf(this).normalize();
    }

    @Override
    public Quaternionf rotateBy(Quaternionf q) {
        Quaternionf result = new Quaternionf().mulQuaternions(q, this);
        w = result.w;
        x = result.x;
        y = result.y;
        z = result.z;
        return this;
    }

    @Override
    public Quaternionf setFromAxisAngle(Vector3f axis, float angle) {
        Vector3f thisAxis = axis.normalizeCopy();

        float halfAngle = angle * 0.5f;
        float sinHalfAngle = (float) Math.sin(halfAngle);

        w = (float) Math.cos(halfAngle);
        x = sinHalfAngle * thisAxis.x;
        y = sinHalfAngle * thisAxis.y;
        z = sinHalfAngle * thisAxis.z;
        return this;
    }

    @Override
    public Quaternionf setFromMatrix(Matrix3f m) {
        return setFromMatrix(new Matrix4f(m));
    }

    @Override
    public Quaternionf setFromMatrix(Matrix4f m) {

        float tr = m.m00 + m.m11 + m.m22;
        float s;

        if (tr > TOLERANCE) {

            s = (float) (Math.sqrt(1.0 + tr) * 2.0);
            w = 0.25f * s;
            x = (m.m21 - m.m12) / s;
            y = (m.m02 - m.m20) / s;
            z = (m.m10 - m.m01) / s;

        } else if ((m.m00 > m.m11) && (m.m00 > m.m22)) {

            s = (float) (Math.sqrt(1.0 + m.m00 - m.m11 - m.m22) * 2.0);
            w = (m.m21 - m.m12) / s;
            x = 0.25f * s;
            y = (m.m01 + m.m10) / s;
            z = (m.m02 + m.m20) / s;

        } else if ((m.m11 > m.m22)) {

            s = (float) (Math.sqrt(1.0 + m.m11 - m.m00 - m.m22) * 2.0);
            w = (m.m02 - m.m20) / s;
            x = (m.m01 + m.m10) / s;
            y = 0.25f * s;
            z = (m.m12 + m.m21) / s;

        } else {

            s = (float) (Math.sqrt(1.0 + m.m22 - m.m00 - m.m11) * 2.0);
            w = (m.m10 - m.m01) / s;
            x = (m.m02 + m.m20) / s;
            y = (m.m12 + m.m21) / s;
            z = 0.25f * s;
        }
        return this;
    }

    @Override
    public Quaternionf setIdentity() {
        w = 1;
        x = y = z = 0;
        return this;
    }

    @Override
    public Matrix4f toRotationMatrix() {
        /*
            TODO: possibly normalize the quaternion here (it MUST be normalized, but we don't know if it has already
            TODO: been done or not yet).
        */
        normalize();

        float xSq = x * x;
        float ySq = y * y;
        float zSq = z * z;
        float xy = x * y;
        float xz = x * z;
        float xw = x * w;
        float yz = y * z;
        float yw = y * w;
        float zw = z * w;

        Matrix4f rot = new Matrix4f();

        rot.m00 = 1 - 2 * (ySq + zSq);
        rot.m01 = 2 * (xy - zw);
        rot.m02 = 2 * (xz + yw);
        // new Matrix4d() sets this by default
//        rot.m03 = 0;

        rot.m10 = 2 * (xy + zw);
        rot.m11 = 1 - 2 * (xSq + zSq);
        rot.m12 = 2 * (yz - xw);
        // new Matrix4d() sets this by default
//        rot.m13 = 0;

        rot.m20 = 2 * (xz - yw);
        rot.m21 = 2 * (yz + xw);
        rot.m22 = 1 - 2 * (xSq + ySq);
        // new Matrix4d() sets this by default
//        rot.m23 = 0;

        // new Matrix4d() sets this by default
//        rot.m30 = 0;
//        rot.m31 = 0;
//        rot.m32 = 0;
//        rot.m33 = 1;
        return rot;
    }

    @Override
    public String toString() {
        return "[" + w + ", " + x + ", " + y + ", " + z + "]";
    }
}
