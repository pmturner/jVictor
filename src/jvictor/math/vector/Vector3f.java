package jvictor.math.vector;

public class Vector3f implements jvictor.math.vector.interfaces.Vector3f<Vector3f> {

    public float x;
    public float y;
    public float z;

    public Vector3f () {
        this(0, 0, 0);
    }

    public Vector3f (Vector3f v) {
        this(v.x, v.y, v.z);
    }

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
    public Vector3f negate() {
        return null;
    }

    @Override
    public Vector3f negateCopy() {
        return null;
    }

    @Override
    public Vector3f normalize() {
        return null;
    }

    @Override
    public Vector3f normalizeCopy() {
        return null;
    }

    @Override
    public Vector3f scale(float s) {
        return null;
    }

    @Override
    public Vector3f scaleCopy(float s) {
        return null;
    }

    @Override
    public Vector3f scaleTo(float l) {
        return null;
    }

    @Override
    public Vector3f scaleCopyTo(float l) {
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
