package jvictor.math.vector;

import jvictor.math.vector.interfaces.Vectorf;

public class Vector2f implements Vectorf<Vector2f> {

    public float x;
    public float y;

    public Vector2f() {
        this(0, 0);
    }

    public Vector2f(Vector2f v) {
        this(v.x, v.y);
    }

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Vector2f add(Vector2f v) {
        x += v.x;
        y += v.y;
        return this;
    }

    @Override
    public Vector2f addVectors(Vector2f v1, Vector2f v2) {
        Vector2f v1Copy = new Vector2f(v1);
        return v1Copy.add(v2);
    }

    @Override
    public float angleBetween(Vector2f v1, Vector2f v2) {
        return v1.angleTo(v2);
    }

    @Override
    public float angleTo(Vector2f v) {
        float dot = dot(v);
        float det = (x * v.y) - (y * v.x);
        return (float) Math.atan2(det, dot);
    }

    @Override
    public float dot(Vector2f v) {
        return (x * v.x) + (y * v.y);
    }

    @Override
    public float dotVectors(Vector2f v1, Vector2f v2) {
        return v1.dot(v2);
    }

    public boolean equals(Vector2f v) {
        return (x == v.x) && (y == v.y);
    }

    @Override
    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    @Override
    public float lengthSquared() {
        return (x * x) + (y * y);
    }

    @Override
    public Vector2f negate() {
        x = -x;
        y = -y;
        return this;
    }

    @Override
    public Vector2f negateCopy() {
        return (new Vector2f(this)).negate();
    }

    @Override
    public Vector2f normalize() {
        float length = length();
        x /= length;
        y /= length;
        return this;
    }

    @Override
    public Vector2f normalizeCopy() {
        return (new Vector2f(this)).normalize();
    }

    @Override
    public Vector2f scale(float s) {
        x *= s;
        y *= s;
        return this;
    }

    @Override
    public Vector2f scaleCopy(float s) {
        return (new Vector2f(this)).scale(s);
    }

    @Override
    public Vector2f scaleCopyTo(float length) {
        return (new Vector2f(this)).scaleTo(length);
    }

    @Override
    public Vector2f scaleTo(float length) {
        return normalize().scale(length);
    }

    @Override
    public Vector2f sub(Vector2f v) {
        x -= v.x;
        y -= v.y;
        return this;
    }

    @Override
    public Vector2f subVectors(Vector2f v1, Vector2f v2) {
        return new Vector2f(v1).sub(v2);
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
