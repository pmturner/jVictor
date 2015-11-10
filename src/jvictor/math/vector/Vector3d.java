package jvictor.math.vector;

public class Vector3d implements jvictor.math.vector.interfaces.Vector3d<Vector3d> {

    public double x;
    public double y;
    public double z;

    public Vector3d() {
        this(0, 0, 0);
    }

    public Vector3d(Vector2d v) {
        this(v.x, v.y, 0);
    }

    public Vector3d(Vector3d v) {
        this(v.x, v.y, v.z);
    }

    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Vector3d add(Vector3d v) {
        x += v.x;
        y += v.y;
        z += v.z;
        return this;
    }

    @Override
    public Vector3d addVectors(Vector3d v1, Vector3d v2) {
        Vector3d v1Copy = new Vector3d(v1);
        return v1Copy.add(v2);
    }

    @Override
    public double angleBetween(Vector3d v1, Vector3d v2) {
        return v1.angleTo(v2);
    }

    @Override
    public double angleTo(Vector3d v) {
        double det = cross(v).length();
        double dot = dot(v);
        return Math.atan2(det, dot);
    }

    @Override
    public Vector3d cross(Vector3d v) {
        return new Vector3d(
                y * v.z - z * v.y,
                z * v.x - x * v.z,
                x * v.y - y * v.x
        );
    }

    @Override
    public Vector3d crossVectors(Vector3d v1, Vector3d v2) {
        return v1.cross(v2);
    }

    @Override
    public double dot(Vector3d v) {
        return x * v.x + y * v.y + z * v.z;
    }

    @Override
    public double dotVectors(Vector3d v1, Vector3d v2) {
        return v1.dot(v2);
    }

    @Override
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    @Override
    public double lengthSquared() {
        return x * x + y * y + z * z;
    }

    @Override
    public Vector3d negate() {
        x = -x;
        y = -y;
        z = -z;
        return this;
    }

    @Override
    public Vector3d negateCopy() {
        return new Vector3d(this).negate();
    }

    @Override
    public Vector3d normalize() {
        double length = length();
        x /= length;
        y /= length;
        z /= length;
        return this;
    }

    @Override
    public Vector3d normalizeCopy() {
        return new Vector3d(this).normalize();
    }

    @Override
    public Vector3d scale(double s) {
        x *= s;
        y *= s;
        z *= s;
        return this;
    }

    @Override
    public Vector3d scaleCopy(double s) {
        return new Vector3d(this).scale(s);
    }

    @Override
    public Vector3d scaleCopyTo(double l) {
        return new Vector3d(this).scaleTo(l);
    }

    @Override
    public Vector3d scaleTo(double l) {
        return normalize().scale(l);
    }

    @Override
    public Vector3d sub(Vector3d v) {
        x -= v.x;
        y -= v.y;
        z -= v.z;
        return this;
    }

    @Override
    public Vector3d subVectors(Vector3d v1, Vector3d v2) {
        Vector3d v1Copy = new Vector3d(v1);
        return v1Copy.sub(v2);
    }
}
