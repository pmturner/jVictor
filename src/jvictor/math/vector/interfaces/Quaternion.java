package jvictor.math.vector.interfaces;

public interface Quaternion<QuaternionType> {
    QuaternionType mul(QuaternionType q2);

    QuaternionType mulQuaternions(QuaternionType q1, QuaternionType q2);

    QuaternionType negate();

    QuaternionType negateCopy();

    QuaternionType normalize();

    QuaternionType normalizeCopy();

    QuaternionType rotateBy(QuaternionType q);

    QuaternionType setIdentity();
}
