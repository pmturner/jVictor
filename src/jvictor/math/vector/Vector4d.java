package jvictor.math.vector;

import jvictor.math.vector.interfaces.Vectord;

public class Vector4d implements Vectord<Vector4d> {

    public double x = 0;
    public double y = 0;
    public double z = 0;
    public double w = 0;

    public Vector4d () {}

    public Vector4d (double x, double y, double z, double w) {
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
    public double angleTo(Vector4d v) {
        return 0;
    }

    @Override
    public double angleBetween(Vector4d v1, Vector4d v2) {
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
    public Vector4d setLength(double l) {
        return null;
    }

    @Override
    public Vector4d negate() {
        return null;
    }

    @Override
    public Vector4d negate(Vector4d destination) {
        return null;
    }

    @Override
    public Vector4d normalize() {
        return null;
    }

    @Override
    public Vector4d normalize(Vector4d destination) {
        return null;
    }

    @Override
    public Vector4d scale(double s) {
        return null;
    }

    @Override
    public Vector4d scale(double s, Vector4d destination) {
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
