package jvictor.math.vector.interfaces;

import jvictor.math.matrix.Matrix4f;

public interface Quaterniond<QuaternionType> {

    Matrix4f toRotationMatrix();

    QuaternionType mul(QuaternionType q2);

    QuaternionType mulQuaternions(QuaternionType q1, QuaternionType q2);

    QuaternionType rotateBy(QuaternionType q);

    QuaternionType normalize();

}
