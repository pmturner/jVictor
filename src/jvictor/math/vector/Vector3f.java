package jvictor.math.vector;

public class Vector3f implements jvictor.math.vector.interfaces.Vector3f<Vector3f> {

    public float x;
    public float y;
    public float z;

    public Vector3f() {
        this(0, 0, 0);
    }

    public Vector3f(Vector2f v) {
        this(v.x, v.y, 0);
    }

    public Vector3f(Vector3f v) {
        this(v.x, v.y, v.z);
    }

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Vector3f add(Vector3f v) {
        x += v.x;
        y += v.y;
        z += v.z;
        return this;
    }

    @Override
    public Vector3f addVectors(Vector3f v1, Vector3f v2) {
        Vector3f v1Copy = new Vector3f(v1);
        return v1Copy.add(v2);
    }

    @Override
    public float angleBetween(Vector3f v1, Vector3f v2) {
        return v1.angleTo(v2);
    }

    @Override
    public float angleTo(Vector3f v) {
        float det = cross(v).length();
        float dot = dot(v);
        return (float) Math.atan2(det, dot);
    }

    @Override
    public Vector3f cross(Vector3f v) {
        return new Vector3f(
                y * v.z - z * v.y,
                z * v.x - x * v.z,
                x * v.y - y * v.x
        );
    }

    @Override
    public Vector3f crossVectors(Vector3f v1, Vector3f v2) {
        return v1.cross(v2);
    }

    @Override
    public float dot(Vector3f v) {
        return x * v.x + y * v.y + z * v.z;
    }

    @Override
    public float dotVectors(Vector3f v1, Vector3f v2) {
        return v1.dot(v2);
    }

    @Override
    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    @Override
    public float lengthSquared() {
        return x * x + y * y + z * z;
    }

    @Override
    public Vector3f negate() {
        x = -x;
        y = -y;
        z = -z;
        return this;
    }

    @Override
    public Vector3f negateCopy() {
        return (new Vector3f(this)).negate();
    }

    @Override
    public Vector3f normalize() {
        float length = length();
        x /= length;
        y /= length;
        z /= length;
        return this;
    }

    @Override
    public Vector3f normalizeCopy() {
        return (new Vector3f(this)).normalize();
    }

    @Override
    public Vector3f scale(float s) {
        x *= s;
        y *= s;
        z *= s;
        return this;
    }

    @Override
    public Vector3f scaleCopy(float s) {
        return (new Vector3f(this)).scale(s);
    }

    @Override
    public Vector3f scaleCopyTo(float length) {
        return (new Vector3f(this)).normalize().scale(length);
    }

    @Override
    public Vector3f scaleTo(float length) {
        return normalize().scale(length);
    }

    @Override
    public Vector3f sub(Vector3f v) {
        x -= v.x;
        y -= v.y;
        z -= v.z;
        return this;
    }

    @Override
    public Vector3f subVectors(Vector3f v1, Vector3f v2) {
        Vector3f v1Copy = new Vector3f(v1);
        return v1Copy.sub(v2);
    }
}
