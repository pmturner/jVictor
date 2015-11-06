package jvictor.math.vector;

import jvictor.math.matrix.Matrix3d;
import jvictor.math.matrix.Matrix4d;

public class Quaterniond implements jvictor.math.vector.interfaces.Quaterniond<Quaterniond> {

    private double w;
    private double x;
    private double y;
    private double z;

    private Quaterniond(double w, double x, double y, double z) {
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
        return 0;
    }

    @Override
    public double angleTo(Quaterniond q) {
        return 0;
    }

    @Override
    public double dot(Quaterniond q) {
        return 0;
    }

    @Override
    public double dotQuaternions(Quaterniond q1, Quaterniond q2) {
        return 0;
    }

    @Override
    public double getAngle() {
        return 0;
    }

    @Override
    public Vector3d getAxis() {
        return null;
    }

    @Override
    public Quaterniond mul(Quaterniond q2) {
        return null;
    }

    @Override
    public Quaterniond mulQuaternions(Quaterniond q1, Quaterniond q2) {
        return null;
    }

    @Override
    public Quaterniond negate() {
        return null;
    }

    @Override
    public Quaterniond negateCopy() {
        return null;
    }

    @Override
    public Quaterniond normalize() {
        return null;
    }

    @Override
    public Quaterniond normalizeCopy() {
        return null;
    }

    @Override
    public Quaterniond rotateBy(Quaterniond q) {
        return null;
    }

    @Override
    public Quaterniond setFromAxisAngle(Vector3d axis, double angle) {
        return null;
    }

    @Override
    public Quaterniond setFromMatrix(Matrix3d m) {
        return null;
    }

    @Override
    public Quaterniond setFromMatrix(Matrix4d m) {
        return null;
    }

    @Override
    public Quaterniond setIdentity() {
        return null;
    }

    @Override
    public Matrix4d toRotationMatrix() {
        return null;
    }
}
