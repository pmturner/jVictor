package jvictor.math.vector;

public class VectorfTest {

    final float TOLERANCE = 0.000001f;

    float angle;
    float targetAngle;
    float dot;
    float targetDot;
    float length;
    float targetLength;
    float lengthSq;
    float targetLengthSq;
    float inputAngle;
    float outputAngle;

    public boolean similar(float a, float b) {
        return Math.abs(a - b) < TOLERANCE;
    }

    public boolean similar(float a, float b, float tolerance) {
        return Math.abs(a - b) < tolerance;
    }

    public boolean similar(Vector2f a, Vector2f b) {
        return similar(a.x, b.x) && similar(a.y, b.y);
    }

    public boolean similar(Vector3f a, Vector3f b) {
        return similar(a.x, b.x) && similar(a.y, b.y) && similar(a.z, b.z);
    }

    public boolean similar(Vector4f a, Vector4f b) {
        return similar(a.x, b.x) && similar(a.y, b.y) && similar(a.z, b.z) && similar(a.w, b.w);
    }

}
