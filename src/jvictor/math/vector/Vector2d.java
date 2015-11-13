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
        x += v.x;
        y += v.y;
        return this;
    }

    @Override
    public Vector2d addVectors(Vector2d v1, Vector2d v2) {
        Vector2d v1Copy = new Vector2d(v1);
        return v1Copy.add(v2);
    }

    @Override
    public double angleBetween(Vector2d v1, Vector2d v2) {
        return v1.angleTo(v2);
    }

    @Override
    public double angleTo(Vector2d v) {
        double dot = dot(v);
        double det = (x * v.y) - (y * v.x);
        return Math.atan2(det, dot);
    }

    @Override
    public double dot(Vector2d v) {
        return (x * v.x) + (y * v.y);
    }

    @Override
    public double dotVectors(Vector2d v1, Vector2d v2) {
        return v1.dot(v2);
    }

    @Override
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    @Override
    public double lengthSquared() {
        return (x * x) + (y * y);
    }

    @Override
    public Vector2d negate() {
        x = -x;
        y = -y;
        return this;
    }

    @Override
    public Vector2d negateCopy() {
        return new Vector2d(this).negate();
    }

    @Override
    public Vector2d normalize() {
        double length = length();
        x /= length;
        y /= length;
        return this;
    }

    @Override
    public Vector2d normalizeCopy() {
        return new Vector2d(this).normalize();
    }

    @Override
    public Vector2d scale(double s) {
        x *= s;
        y *= s;
        return this;
    }

    @Override
    public Vector2d scaleCopy(double s) {
        return new Vector2d(this).scale(s);
    }

    @Override
    public Vector2d scaleCopyTo(double l) {
        return new Vector2d(this).scaleTo(l);
    }

    @Override
    public Vector2d scaleTo(double l) {
        return normalize().scale(l);
    }

    @Override
    public Vector2d sub(Vector2d v) {
        x -= v.x;
        y -= v.y;
        return this;
    }

    @Override
    public Vector2d subVectors(Vector2d v1, Vector2d v2) {
        Vector2d v1Copy = new Vector2d(v1);
        return v1Copy.sub(v2);
    }

    public boolean equals(Vector2d v) {
        return  (x == v.x) && (y == v.y);
    }

    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
