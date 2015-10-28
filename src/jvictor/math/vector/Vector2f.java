package jvictor.math.vector;

import jvictor.math.vector.interfaces.Vectorf;

public class Vector2f implements Vectorf<Vector2f> {

    public float x = 0;
    public float y = 0;

    public Vector2f () {}

    public Vector2f (float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Vector2f add(Vector2f v) {
        this.x += v.x;
        this.y += v.y;
        return this;
    }

    @Override
    public Vector2f addVectors(Vector2f v1, Vector2f v2) {
        Vector2f result = new Vector2f();
        result.x = v1.x + v2.x;
        result.y = v1.y + v2.y;
        return result;
    }

    @Override
    public float angleTo(Vector2f v) {
        return 0;
    }

    @Override
    public float angleBetween(Vector2f v1, Vector2f v2) {
        return 0;
    }

    @Override
    public float dot(Vector2f v) {
        return 0;
    }

    @Override
    public float dotVectors(Vector2f v1, Vector2f v2) {
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
    public Vector2f setLength(float l) {
        return null;
    }

    @Override
    public Vector2f negate() {
        return null;
    }

    @Override
    public Vector2f negate(Vector2f destination) {
        return null;
    }

    @Override
    public Vector2f normalize() {
        return null;
    }

    @Override
    public Vector2f normalize(Vector2f destination) {
        return null;
    }

    @Override
    public Vector2f scale(float s) {
        return null;
    }

    @Override
    public Vector2f scale(float s, Vector2f destination) {
        return null;
    }

    @Override
    public Vector2f sub(Vector2f v) {
        return null;
    }

    @Override
    public Vector2f subVectors(Vector2f v1, Vector2f v2) {
        return null;
    }
}
