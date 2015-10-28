package jvictor.math.vector.interfaces;

public interface Vectord<VecType> {
    VecType add(VecType v);
    VecType addVectors(VecType v1, VecType v2);

    double angleTo(VecType v);
    double angleBetween(VecType v1, VecType v2);

    double dot(VecType v);
    double dotVectors(VecType v1, VecType v2);

    double length();
    double lengthSquared();
    VecType setLength(double l);

    VecType negate();
    VecType negate(VecType destination);

    VecType normalize();
    VecType normalize(VecType destination);

    VecType scale(double s);
    VecType scale(double s, VecType destination);

    VecType sub(VecType v);
    VecType subVectors(VecType v1, VecType v2);
}
