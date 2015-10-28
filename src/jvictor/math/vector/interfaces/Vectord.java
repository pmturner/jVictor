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

    VecType negate();
    VecType negateCopy();

    VecType normalize();
    VecType normalizeCopy();

    VecType scale(double s);
    VecType scaleCopy(double s);

    VecType scaleTo(double l);
    VecType scaleCopyTo(double l);

    VecType sub(VecType v);
    VecType subVectors(VecType v1, VecType v2);
}
