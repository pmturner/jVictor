package jvictor.math.vector.interfaces;

public interface Quaterniond<QuaternionType> extends Quaternion<QuaternionType> {

    double dot(QuaternionType q);

    double dotQuaternions(QuaternionType q1, QuaternionType q2);

    QuaternionType scale(double s);

    QuaternionType scaleCopy(double s);

    QuaternionType setFromAxisAngle(jvictor.math.vector.Vector3f axis, double angle);

    //QuaternionType setFromMatrix(Matrix3d m); //defined here because they are double matrices

    //QuaternionType setFromMatrix(Matrix4d m); //defined here because they are double matrices

    //Matrix4d toRotationMatrix(); //defined here because they are double matrices

}
