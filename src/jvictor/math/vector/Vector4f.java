package jvictor.math.vector;

import jvictor.math.vector.interfaces.Vectorf;

public class Vector4f implements Vectorf<Vector4f> {

    public float x;
    public float y;
    public float z;
    public float w;

    public Vector4f () {
        this(0, 0, 0, 0);
    }

    public Vector4f (Vector4f v) {
        this(v.x, v.y, v.z, v.w);
    }

    public Vector4f (float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Vector4f add(Vector4f v) {
        this.x += v.x;
        this.y += v.y;
        this.z += v.z;
        this.w += v.w;
        return this;
    }

    @Override
    public Vector4f addVectors(Vector4f v1, Vector4f v2) {
        Vector4f v1Copy = new Vector4f(v1);
        return v1Copy.add(v2);
    }

    @Override
    public float angleTo(Vector4f v) {
        Vector4f v1 = this.normalizeCopy();
        Vector4f v2 = v.normalizeCopy();
        return (float) Math.acos(v1.dot(v2));
    }

    @Override
    public float angleBetween(Vector4f v1, Vector4f v2) {
        return v1.angleTo(v2);
    }

    @Override
    public float dot(Vector4f v) {
        return (this.x * v.x +
                this.y * v.y +
                this.z * v.z +
                this.w * v.w);
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
        return (this.x * this.x +
                this.y * this.y +
                this.z * this.z +
                this.w * this.w);
    }

    @Override
    public Vector4f negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        this.w = -this.w;
        return this;
    }

    @Override
    public Vector4f negateCopy() {
        return (new Vector4f(this)).negate();
    }

    @Override
    public Vector4f normalize() {
        float length = length();
        this.x /= length;
        this.y /= length;
        this.z /= length;
        this.w /= length;
        return this;
    }

    @Override
    public Vector4f normalizeCopy() {
        return (new Vector4f(this)).normalize();
    }

    @Override
    public Vector4f scale(float s) {
        this.x *= s;
        this.y *= s;
        this.z *= s;
        this.w *= s;
        return this;
    }

    @Override
    public Vector4f scaleCopy(float s) {
        return (new Vector4f(this)).scale(s);
    }

    @Override
    public Vector4f scaleTo(float length) {
        return normalize().scale(length);
    }

    @Override
    public Vector4f scaleCopyTo(float length) {
        return (new Vector4f(this)).scaleTo(length);
    }

    @Override
    public Vector4f sub(Vector4f v) {
        this.x -= v.x;
        this.y -= v.y;
        this.z -= v.z;
        this.w -= v.w;
        return this;
    }

    @Override
    public Vector4f subVectors(Vector4f v1, Vector4f v2) {
        Vector4f v1Copy = new Vector4f(v1);
        return v1Copy.sub(v2);
    }
}