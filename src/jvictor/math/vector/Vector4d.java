package jvictor.math.vector;

import jvictor.math.vector.interfaces.Vectord;

public class Vector4d implements Vectord<Vector4d> {

    public double x;
    public double y;
    public double z;
    public double w;

    public Vector4d() {
        this(0, 0, 0, 0);
    }

    public Vector4d(Vector4d v) {
        this(v.x, v.y, v.z, v.w);
    }

    public Vector4d(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Vector4d add(Vector4d v) {
        x += v.x;
        y += v.y;
        z += v.z;
        w += v.w;
        return this;
    }

    @Override
    public Vector4d addVectors(Vector4d v1, Vector4d v2) {
        Vector4d v1Copy = new Vector4d(v1);
        return v1Copy.add(v2);
    }

    @Override
    public double angleBetween(Vector4d v1, Vector4d v2) {
        return v1.angleTo(v2);
    }

    @Override
    public double angleTo(Vector4d v) {
        double det = cross3d(v).length();
        double dot = dot(v);
        return Math.atan2(det, dot);
    }

    private Vector4d cross3d(Vector4d v) {
        Vector3d v1 = new Vector3d(x, y, z);
        Vector3d v2 = new Vector3d(v.x, v.y, v.z);
        Vector3d cross = v1.cross(v2);
        return new Vector4d(cross.x, cross.y, cross.z, 0);
    }

    private Vector4d crossVectors3d(Vector4d v1, Vector4d v2) {
        return v1.cross3d(v2);
    }

    @Override
    public double dot(Vector4d v) {
        return x * v.x + y * v.y + z * v.z + w * v.w;
    }

    @Override
    public double dotVectors(Vector4d v1, Vector4d v2) {
        return v1.dot(v2);
    }

    @Override
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    @Override
    public double lengthSquared() {
        return x * x + y * y + z * z + w * w;
    }

    @Override
    public Vector4d negate() {
        x = -x;
        y = -y;
        z = -z;
        w = -w;
        return this;
    }

    @Override
    public Vector4d negateCopy() {
        return new Vector4d(this).negate();
    }

    @Override
    public Vector4d normalize() {
        double length = length();
        x /= length;
        y /= length;
        z /= length;
        w /= length;
        return this;
    }

    @Override
    public Vector4d normalizeCopy() {
        return new Vector4d(this).normalize();
    }

    @Override
    public Vector4d scale(double s) {
        x *= s;
        y *= s;
        z *= s;
        w *= s;
        return this;
    }

    @Override
    public Vector4d scaleCopy(double s) {
        return new Vector4d(this).scale(s);
    }

    @Override
    public Vector4d scaleCopyTo(double l) {
        return new Vector4d(this).scaleTo(l);
    }

    @Override
    public Vector4d scaleTo(double l) {
        return normalize().scale(l);
    }

    @Override
    public Vector4d sub(Vector4d v) {
        x -= v.x;
        y -= v.y;
        z -= v.z;
        w -= v.w;
        return this;
    }

    @Override
    public Vector4d subVectors(Vector4d v1, Vector4d v2) {
        Vector4d v1Copy = new Vector4d(v1);
        return v1Copy.sub(v2);
    }
}
