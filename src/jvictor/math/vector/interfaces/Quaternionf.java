package jvictor.math.vector.interfaces;

import com.sun.javafx.geom.Matrix3f;
import jvictor.math.matrix.Matrix4f;

public interface Quaternionf<QuaternionType> {

    float dot(QuaternionType q);

    float dotQuaternions(QuaternionType q1, QuaternionType q2);

    QuaternionType mul(QuaternionType q2);

    QuaternionType mulQuaternions(QuaternionType q1, QuaternionType q2);

    QuaternionType negate();

    QuaternionType negateCopy();

    QuaternionType normalize();

    QuaternionType normalizeCopy();

    QuaternionType rotateBy(QuaternionType q);

    QuaternionType scale (float s);

    QuaternionType scaleCopy (float s);

    QuaternionType setFromAxisAngle(jvictor.math.vector.Vector3f axis, float angle);

    QuaternionType setFromMatrix(Matrix3f m);

    QuaternionType setFromMatrix(Matrix4f m);

    QuaternionType setIdentity();

    Matrix4f toRotationMatrix();
}
