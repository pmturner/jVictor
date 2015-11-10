package jvictor.math.vector.interfaces;

import jvictor.math.matrix.Matrix3d;
import jvictor.math.matrix.Matrix4d;

public interface Quaterniond<QuaternionType> extends Quaternion<QuaternionType> {

    double angleBetween(QuaternionType q1, QuaternionType q2);

    double angleTo(QuaternionType q);

    double dot(QuaternionType q);

    double dotQuaternions(QuaternionType q1, QuaternionType q2);

    double getAngle();

    jvictor.math.vector.Vector3d getAxis();

    double length();

    double lengthSquared();

    QuaternionType setFromAxisAngle(jvictor.math.vector.Vector3d axis, double angle);

    QuaternionType setFromMatrix(Matrix3d m); //defined here because they are double matrices

    QuaternionType setFromMatrix(Matrix4d m); //defined here because they are double matrices

    Matrix4d toRotationMatrix(); //defined here because they are double matrices

}
