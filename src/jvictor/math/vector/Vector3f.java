package jvictor.math.vector;

public class Vector3f implements jvictor.math.vector.interfaces.Vector3f<Vector3f> {

    public float x = 0;
    public float y = 0;
    public float z = 0;

    public Vector3f () {}

    public Vector3f (float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Vector3f cross(Vector3f v) {
        return null;
    }

    @Override
    public Vector3f crossVectors(Vector3f v1, Vector3f v2) {
        return null;
    }

    @Override
    public Vector3f add(Vector3f v) {
        return null;
    }

    @Override
    public Vector3f addVectors(Vector3f v1, Vector3f v2) {
        return null;
    }

    @Override
    public float angleTo(Vector3f v) {
        return 0;
    }

    @Override
    public float angleBetween(Vector3f v1, Vector3f v2) {
        return 0;
    }

    @Override
    public float dot(Vector3f v) {
        return 0;
    }

    @Override
    public float dotVectors(Vector3f v1, Vector3f v2) {
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
    public Vector3f setLength(float l) {
        return null;
    }

    @Override
    public Vector3f negate() {
        return null;
    }

    @Override
    public Vector3f negate(Vector3f destination) {
        return null;
    }

    @Override
    public Vector3f normalize() {
        return null;
    }

    @Override
    public Vector3f normalize(Vector3f destination) {
        return null;
    }

    @Override
    public Vector3f scale(float s) {
        return null;
    }

    @Override
    public Vector3f scale(float s, Vector3f destination) {
        return null;
    }

    @Override
    public Vector3f sub(Vector3f v) {
        return null;
    }

    @Override
    public Vector3f subVectors(Vector3f v1, Vector3f v2) {
        return null;
    }
}
