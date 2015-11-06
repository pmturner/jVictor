package jvictor.math.vector.interfaces;

import jvictor.math.matrix.Matrix3f;
import jvictor.math.matrix.Matrix4f;

public interface Quaternionf<QuaternionType> extends Quaternion<QuaternionType> {

    float angleBetween(QuaternionType q1, QuaternionType q2);

    float angleTo(QuaternionType q);

    float dot(QuaternionType q);

    float dotQuaternions(QuaternionType q1, QuaternionType q2);

    float getAngle();

    jvictor.math.vector.Vector3f getAxis();

    QuaternionType setFromAxisAngle(jvictor.math.vector.Vector3f axis, float angle);

    QuaternionType setFromMatrix(Matrix3f m); //defined here because they are float matrices

    QuaternionType setFromMatrix(Matrix4f m); //defined here because they are float matrices

    Matrix4f toRotationMatrix(); //defined here because they are float matrices
}
