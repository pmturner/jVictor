package jvictor.math.vector;

import jvictor.math.vector.interfaces.Vectord;

public class Vector2d implements Vectord<Vector2d> {

    public double x;
    public double y;

    public Vector2d() {
        this(0, 0);
    }

    public Vector2d(Vector2d v) {
        this(v.x, v.y);
    }

    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Vector2d add(Vector2d v) {
        return null;
    }

    @Override
    public Vector2d addVectors(Vector2d v1, Vector2d v2) {
        return null;
    }

    @Override
    public double angleBetween(Vector2d v1, Vector2d v2) {
        return 0;
    }

    @Override
    public double angleTo(Vector2d v) {
        return 0;
    }

    @Override
    public double dot(Vector2d v) {
        return 0;
    }

    @Override
    public double dotVectors(Vector2d v1, Vector2d v2) {
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
    public Vector2d negate() {
        return null;
    }

    @Override
    public Vector2d negateCopy() {
        return null;
    }

    @Override
    public Vector2d normalize() {
        return null;
    }

    @Override
    public Vector2d normalizeCopy() {
        return null;
    }

    @Override
    public Vector2d scale(double s) {
        return null;
    }

    @Override
    public Vector2d scaleCopy(double s) {
        return null;
    }

    @Override
    public Vector2d scaleCopyTo(double l) {
        return null;
    }

    @Override
    public Vector2d scaleTo(double l) {
        return null;
    }

    @Override
    public Vector2d sub(Vector2d v) {
        return null;
    }

    @Override
    public Vector2d subVectors(Vector2d v1, Vector2d v2) {
        return null;
    }
}
