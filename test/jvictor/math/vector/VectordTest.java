package jvictor.math.vector;

public class VectordTest {

    final double TOLERANCE = 0.000000000000001;

    double angle;
    double targetAngle;
    double dot;
    double targetDot;
    double length;
    double targetLength;
    double lengthSq;
    double targetLengthSq;
    double inputAngle;
    double outputAngle;

    public boolean similar(double a, double b) {
        return Math.abs(a - b) < TOLERANCE;
    }

    public boolean similar(double a, double b, double tolerance) {
        return Math.abs(a - b) < tolerance;
    }

    public boolean similar(Vector2d a, Vector2d b) {
        return similar(a.x, b.x) && similar(a.y, b.y);
    }

    public boolean similar(Vector3d a, Vector3d b) {
        return similar(a.x, b.x) && similar(a.y, b.y) && similar(a.z, b.z);
    }

    public boolean similar(Vector4d a, Vector4d b) {
        return similar(a.x, b.x) && similar(a.y, b.y) && similar(a.z, b.z) && similar(a.w, b.w);
    }
}
