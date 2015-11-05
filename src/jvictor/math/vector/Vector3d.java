package jvictor.math.vector;

public class Vector3d implements jvictor.math.vector.interfaces.Vector3d<Vector3d> {

    public double x;
    public double y;
    public double z;

    public Vector3d() {
        this(0, 0, 0);
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
        return null;
    }

    @Override
    public Vector3d addVectors(Vector3d v1, Vector3d v2) {
        return null;
    }

    @Override
    public double angleBetween(Vector3d v1, Vector3d v2) {
        return 0;
    }

    @Override
    public double angleTo(Vector3d v) {
        return 0;
    }

    @Override
    public Vector3d cross(Vector3d v) {
        return null;
    }

    @Override
    public Vector3d crossVectors(Vector3d v1, Vector3d v2) {
        return null;
    }

    @Override
    public double dot(Vector3d v) {
        return 0;
    }

    @Override
    public double dotVectors(Vector3d v1, Vector3d v2) {
        return 0;
    }

    @Override
    public double length() {
        return 0;
    }

    @Override
    public double lengthSquared() {
        return 0;
    }

    @Override
    public Vector3d negate() {
        return null;
    }

    @Override
    public Vector3d negateCopy() {
        return null;
    }

    @Override
    public Vector3d normalize() {
        return null;
    }

    @Override
    public Vector3d normalizeCopy() {
        return null;
    }

    @Override
    public Vector3d scale(double s) {
        return null;
    }

    @Override
    public Vector3d scaleCopy(double s) {
        return null;
    }

    @Override
    public Vector3d scaleCopyTo(double l) {
        return null;
    }

    @Override
    public Vector3d scaleTo(double l) {
        return null;
    }

    @Override
    public Vector3d sub(Vector3d v) {
        return null;
    }

    @Override
    public Vector3d subVectors(Vector3d v1, Vector3d v2) {
        return null;
    }
}
