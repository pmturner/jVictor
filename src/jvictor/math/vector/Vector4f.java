package jvictor.math.vector;

import jvictor.math.vector.interfaces.Vectorf;

public class Vector4f implements Vectorf<Vector4f> {

    public float x;
    public float y;
    public float z;
    public float w;

    public Vector4f() {
        this(0, 0, 0, 0);
    }

    public Vector4f(Vector2f v) {
        this(v.x, v.y, 0, 0);
    }

    public Vector4f(Vector3f v) {
        this(v.x, v.y, v.z, 0);
    }

    public Vector4f(Vector4f v) {
        this(v.x, v.y, v.z, v.w);
    }

    public Vector4f(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Vector4f add(Vector4f v) {
        x += v.x;
        y += v.y;
        z += v.z;
        w += v.w;
        return this;
    }

    @Override
    public Vector4f addVectors(Vector4f v1, Vector4f v2) {
        Vector4f v1Copy = new Vector4f(v1);
        return v1Copy.add(v2);
    }

    @Override
    public float angleBetween(Vector4f v1, Vector4f v2) {
        return v1.angleTo(v2);
    }

    @Override
    public float angleTo(Vector4f v) {
        float det = cross3d(v).length();
        float dot = dot(v);
        return (float) Math.atan2(det, dot);
    }

    private Vector4f cross3d(Vector4f v) {
        Vector3f v1 = new Vector3f(x, y, z);
        Vector3f v2 = new Vector3f(v.x, v.y, v.z);
        Vector3f cross = v1.cross(v2);
        return new Vector4f(cross.x, cross.y, cross.z, 0);
    }

    private Vector4f crossVectors3d(Vector4f v1, Vector4f v2) {
        return v1.cross3d(v2);
    }

    @Override
    public float dot(Vector4f v) {
        return (x * v.x +
                y * v.y +
                z * v.z +
                w * v.w);
    }

    @Override
    public float dotVectors(Vector4f v1, Vector4f v2) {
        return v1.dot(v2);
    }

    @Override
    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    @Override
    public float lengthSquared() {
        return (x * x +
                y * y +
                z * z +
                w * w);
    }

    @Override
    public Vector4f negate() {
        x = -x;
        y = -y;
        z = -z;
        w = -w;
        return this;
    }

    @Override
    public Vector4f negateCopy() {
        return (new Vector4f(this)).negate();
    }

    @Override
    public Vector4f normalize() {
        float length = length();
        x /= length;
        y /= length;
        z /= length;
        w /= length;
        return this;
    }

    @Override
    public Vector4f normalizeCopy() {
        return (new Vector4f(this)).normalize();
    }

    @Override
    public Vector4f scale(float s) {
        x *= s;
        y *= s;
        z *= s;
        w *= s;
        return this;
    }

    @Override
    public Vector4f scaleCopy(float s) {
        return (new Vector4f(this)).scale(s);
    }

    @Override
    public Vector4f scaleCopyTo(float length) {
        return (new Vector4f(this)).scaleTo(length);
    }

    @Override
    public Vector4f scaleTo(float length) {
        return normalize().scale(length);
    }

    @Override
    public Vector4f sub(Vector4f v) {
        x -= v.x;
        y -= v.y;
        z -= v.z;
        w -= v.w;
        return this;
    }

    @Override
    public Vector4f subVectors(Vector4f v1, Vector4f v2) {
        Vector4f v1Copy = new Vector4f(v1);
        return v1Copy.sub(v2);
    }
}
