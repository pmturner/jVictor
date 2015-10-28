package jvictor.math.vector.interfaces;

public interface Vectorf<VecType> {
    VecType add(VecType v);
    VecType addVectors(VecType v1, VecType v2);

    float angleTo(VecType v);
    float angleBetween(VecType v1, VecType v2);

    float dot(VecType v);
    float dotVectors(VecType v1, VecType v2);

    float length();
    float lengthSquared();
    VecType setLength(float l);

    VecType negate();
    VecType negate(VecType destination);

    VecType normalize();
    VecType normalize(VecType destination);

    VecType scale(float s);
    VecType scale(float s, VecType destination);

    VecType sub(VecType v);
    VecType subVectors(VecType v1, VecType v2);
}
