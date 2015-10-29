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
        return new Vector3f(
            this.y * v.z - this.z * v.y,
            this.z * v.x - this.x * v.z,
            this.x * v.y - this.y * v.x
        );
    }

    @Override
    public Vector3f crossVectors(Vector3f v1, Vector3f v2) {
        return v1.cross(v2);
    }

    @Override
    public Vector3f add(Vector3f v) {
        this.x += v.x;
        this.y += v.y;
        this.z += v.z;
        return this;
    }

    @Override
    public Vector3f addVectors(Vector3f v1, Vector3f v2) {
        Vector3f v1Copy = new Vector3f(v1);
        return v1Copy.add(v2);
    }

    /**
     * Calculate and return the signed angle (in Radians) between <code>this</code> vector and <code>v</code>.
     * Note: this calculation is performed relative to <code>this</code> vector.  In other words, this function
     * returns the signed angle FROM: <code>this</code> vector TO: <code>v</code>.
     *
     * @param v the vector to which <code>this</code> vector will be compared when calculating the angle.
     * @return the signed angle between <code>this</code> vector and <code>v</code>.
     */
    @Override
    public float angleTo(Vector3f v) {
        float det = this.cross(v).length();
        float dot = this.dot(v);
        return (float) Math.atan2(det, dot);
    }

    /**
     * Calculate and return the signed angle (in Radians) between the vectors <code>v1</code> and <code>v2</code>.
     * Note: this calculation is performed relative to the vector <code>v1</code>.  In other words, this function
     * returns the signed angle FROM: <code>v1</code> TO: <code>v2</code>.
     *
     * @param v1 the first vector in the angle calculation.
     * @param v2 the second vector in the angle calculation.
     * @return the signed angle between the vectors <code>v1</code> and <code>v2</code>.
     */
    @Override
    public float angleBetween(Vector3f v1, Vector3f v2) {
        return v1.angleTo(v2);
    }

    @Override
    public float dot(Vector3f v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
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
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }

    @Override
    public Vector3f negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        return this;
    }

    @Override
    public Vector3f negateCopy() {
        return (new Vector3f(this)).negate();
    }

    @Override
    public Vector3f normalize() {
        float length = length();
        this.x /= length;
        this.y /= length;
        this.z /= length;
        return this;
    }

    @Override
    public Vector3f normalizeCopy() {
        return (new Vector3f(this)).normalize();
    }

    @Override
    public Vector3f scale(float s) {
        this.x *= s;
        this.y *= s;
        this.z *= s;
        return this;
    }

    @Override
    public Vector3f scaleCopy(float s) {
        return (new Vector3f(this)).scale(s);
    }

    @Override
    public Vector3f scaleTo(float length) {
        return this.normalize().scale(length);
    }

    @Override
    public Vector3f scaleCopyTo(float length) {
        return (new Vector3f(this)).normalize().scale(length);
    }

    @Override
    public Vector3f sub(Vector3f v) {
        this.x -= v.x;
        this.y -= v.y;
        this.z -= v.z;
        return this;
    }

    @Override
    public Vector3f subVectors(Vector3f v1, Vector3f v2) {
        return v1.sub(v2);
    }
}