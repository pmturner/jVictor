package jvictor.math.vector;

import jvictor.math.matrix.Matrix3d;
import jvictor.math.matrix.Matrix4d;
import jvictor.math.matrix.Matrix4f;

public class Quaterniond implements jvictor.math.vector.interfaces.Quaterniond<Quaterniond> {

    private static final double TOLERANCE = 0.000000000000001;

    public double w;
    public double x;
    public double y;
    public double z;

    public Quaterniond(double w, double x, double y, double z) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Quaterniond(Quaterniond q) {
        this(q.w, q.x, q.y, q.z);
    }

    public Quaterniond() {
        this(1, 0, 0, 0);
    }

    @Override
    public double angleBetween(Quaterniond q1, Quaterniond q2) {
        return q1.angleTo(q2);
    }

    @Override
    public double angleTo(Quaterniond q) {
        Quaterniond thisConjugate = negateCopy();
        Quaterniond diff = new Quaterniond().mulQuaternions(q, thisConjugate);
        return diff.getAngle();
    }

    @Override
    public double dot(Quaterniond q) {
        return (w * q.w) + (x * q.x) + (y * q.y) + (z * q.z);
    }

    @Override
    public double dotQuaternions(Quaterniond q1, Quaterniond q2) {
        return q1.dot(q2);
    }

    public boolean equals(Quaterniond q) {
        return (w == q.w) && (x == q.x) && (y == q.y) && (z == q.z);
    }

    @Override
    public double getAngle() {
        return 2 * Math.acos(w);
    }

    @Override
    public Vector3d getAxis() {
        if (w > 1) {
            // avoid errors in Sqrt
            normalize();
        }
        double div = Math.sqrt(1 - (w * w));

        Vector3d axis = new Vector3d();

        if (div < 0.001) { //TODO: might need a better value for this
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
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    @Override
    public double lengthSquared() {
        return (w * w) + (x * x) + (y * y) + (z * z);
    }

    @Override
    public Quaterniond mul(Quaterniond q2) {
        Quaterniond q1 = new Quaterniond(this);

        w = (q1.w * q2.w) - (q1.x * q2.x) - (q1.y * q2.y) - (q1.z * q2.z);
        x = (q1.w * q2.x) + (q1.x * q2.w) + (q1.y * q2.z) - (q1.z * q2.y);
        y = (q1.w * q2.y) - (q1.x * q2.z) + (q1.y * q2.w) + (q1.z * q2.x);
        z = (q1.w * q2.z) + (q1.x * q2.y) - (q1.y * q2.x) + (q1.z * q2.w);

        return this;
    }

    @Override
    public Quaterniond mulQuaternions(Quaterniond q1, Quaterniond q2) {
        Quaterniond q1Copy = new Quaterniond(q1);
        return q1Copy.mul(q2);
    }

    @Override
    public Quaterniond negate() {
        x = -x;
        y = -y;
        z = -z;
        return this;
    }

    @Override
    public Quaterniond negateCopy() {
        return new Quaterniond(this).negate();
    }

    @Override
    public Quaterniond normalize() {
        double length = length();
        w /= length;
        x /= length;
        y /= length;
        z /= length;
        return this;
    }

    @Override
    public Quaterniond normalizeCopy() {
        return new Quaterniond(this).normalize();
    }

    @Override
    public Quaterniond rotateBy(Quaterniond q) {
        Quaterniond result = new Quaterniond().mulQuaternions(q, this);
        w = result.w;
        x = result.x;
        y = result.y;
        z = result.z;
        return this;
    }

    @Override
    public Quaterniond setFromAxisAngle(Vector3d axis, double angle) {
        Vector3d thisAxis = axis.normalizeCopy();

        double halfAngle = angle * 0.5;
        double sinHalfAngle = Math.sin(halfAngle);

        w = Math.cos(halfAngle);
        x = sinHalfAngle * thisAxis.x;
        y = sinHalfAngle * thisAxis.y;
        z = sinHalfAngle * thisAxis.z;
        return this;
    }

    @Override
    public Quaterniond setFromMatrix(Matrix3d m) {
        return setFromMatrix(new Matrix4d(m));
    }

    @Override
    public Quaterniond setFromMatrix(Matrix4d m) {
        double tr = m.m00 + m.m11 + m.m22;
        double s;

        if (tr > TOLERANCE) {

            s = Math.sqrt(1.0 + tr) * 2.0;
            w = 0.25 * s;
            x = (m.m21 - m.m12) / s;
            y = (m.m02 - m.m20) / s;
            z = (m.m10 - m.m01) / s;

        } else if ((m.m00 > m.m11) && (m.m00 > m.m22)) {

            s = Math.sqrt(1.0 + m.m00 - m.m11 - m.m22) * 2.0;
            w = (m.m21 - m.m12) / s;
            x = 0.25 * s;
            y = (m.m01 + m.m10) / s;
            z = (m.m02 + m.m20) / s;

        } else if ((m.m11 > m.m22)) {

            s = Math.sqrt(1.0 + m.m11 - m.m00 - m.m22) * 2.0;
            w = (m.m02 - m.m20) / s;
            x = (m.m01 + m.m10) / s;
            y = 0.25 * s;
            z = (m.m12 + m.m21) / s;

        } else {

            s = Math.sqrt(1.0 + m.m22 - m.m00 - m.m11) * 2.0;
            w = (m.m10 - m.m01) / s;
            x = (m.m02 + m.m20) / s;
            y = (m.m12 + m.m21) / s;
            z = 0.25 * s;
        }
        return this;
    }

    @Override
    public Quaterniond setIdentity() {
        w = 1;
        x = y = z = 0;
        return this;
    }

    @Override
    public Matrix4d toRotationMatrix() {
        /*
            TODO: possibly normalize the quaternion here (it MUST be normalized, but we don't know if it has already
            TODO: been done or not yet).
        */
        normalize();

        double xSq = x * x;
        double ySq = y * y;
        double zSq = z * z;
        double xy = x * y;
        double xz = x * z;
        double xw = x * w;
        double yz = y * z;
        double yw = y * w;
        double zw = z * w;

        Matrix4d rot = new Matrix4d();

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
