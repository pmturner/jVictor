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
        return null;
    }

    @Override
    public Vector4f addVectors(Vector4f v1, Vector4f v2) {
        return null;
    }

    @Override
    public float angleTo(Vector4f v) {
        return 0;
    }

    @Override
    public float angleBetween(Vector4f v1, Vector4f v2) {
        return 0;
    }

    @Override
    public float dot(Vector4f v) {
        return 0;
    }

    @Override
    public float dotVectors(Vector4f v1, Vector4f v2) {
        return 0;
    }

    @Override
    public float length() {
        return 0;
    }

    @Override
    public float lengthSquared() {
        return 0;
    }

    @Override
    public Vector4f negate() {
        return null;
    }

    @Override
    public Vector4f negateCopy() {
        return null;
    }

    @Override
    public Vector4f normalize() {
        return null;
    }

    @Override
    public Vector4f normalizeCopy() {
        return null;
    }

    @Override
    public Vector4f scale(float s) {
        return null;
    }

    @Override
    public Vector4f scaleCopy(float s) {
        return null;
    }

    @Override
    public Vector4f scaleTo(float l) {
        return null;
    }

    @Override
    public Vector4f scaleCopyTo(float l) {
        return null;
    }

    @Override
    public Vector4f sub(Vector4f v) {
        return null;
    }

    @Override
    public Vector4f subVectors(Vector4f v1, Vector4f v2) {
        return null;
    }
}
