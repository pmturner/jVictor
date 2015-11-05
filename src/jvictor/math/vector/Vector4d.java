package jvictor.math.vector;

import jvictor.math.vector.interfaces.Vectord;

public class Vector4d implements Vectord<Vector4d> {

    public double x;
    public double y;
    public double z;
    public double w;

    public Vector4d() {
        this(0, 0, 0, 0);
    }

    public Vector4d(Vector4d v) {
        this(v.x, v.y, v.z, v.w);
    }

    public Vector4d(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Vector4d add(Vector4d v) {
        return null;
    }

    @Override
    public Vector4d addVectors(Vector4d v1, Vector4d v2) {
        return null;
    }

    @Override
    public double angleBetween(Vector4d v1, Vector4d v2) {
        return 0;
    }

    @Override
    public double angleTo(Vector4d v) {
        return 0;
    }

    @Override
    public double dot(Vector4d v) {
        return 0;
    }

    @Override
    public double dotVectors(Vector4d v1, Vector4d v2) {
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
    public Vector4d negate() {
        return null;
    }

    @Override
    public Vector4d negateCopy() {
        return null;
    }

    @Override
    public Vector4d normalize() {
        return null;
    }

    @Override
    public Vector4d normalizeCopy() {
        return null;
    }

    @Override
    public Vector4d scale(double s) {
        return null;
    }

    @Override
    public Vector4d scaleCopy(double s) {
        return null;
    }

    @Override
    public Vector4d scaleCopyTo(double l) {
        return null;
    }

    @Override
    public Vector4d scaleTo(double l) {
        return null;
    }

    @Override
    public Vector4d sub(Vector4d v) {
        return null;
    }

    @Override
    public Vector4d subVectors(Vector4d v1, Vector4d v2) {
        return null;
    }
}
