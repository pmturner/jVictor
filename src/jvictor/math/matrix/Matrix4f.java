package jvictor.math.matrix;

import jvictor.math.matrix.interfaces.Matrixf;

public class Matrix4f implements Matrixf<Matrix4f> {

    public float m00, m01, m02, m03;
    public float m10, m11, m12, m13;
    public float m20, m21, m22, m23;
    public float m30, m31, m32, m33;

    @Override
    public Matrix4f add(Matrix4f m) {
        return null;
    }
}
