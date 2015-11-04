package jvictor.math.vector.interfaces;

import com.sun.javafx.geom.Matrix3f;
import jvictor.math.matrix.Matrix4f;

public interface Quaternionf<QuaternionType> extends Quaternion<QuaternionType> {

    float dot(QuaternionType q);

    float dotQuaternions(QuaternionType q1, QuaternionType q2);

    QuaternionType scale(float s);

    QuaternionType scaleCopy(float s);

    QuaternionType setFromAxisAngle(jvictor.math.vector.Vector3f axis, float angle);

    QuaternionType setFromMatrix(Matrix3f m); //defined here because they are float matrices

    QuaternionType setFromMatrix(Matrix4f m); //defined here because they are float matrices

    Matrix4f toRotationMatrix(); //defined here because they are float matrices
}
