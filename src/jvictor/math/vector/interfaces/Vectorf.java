package jvictor.math.vector.interfaces;

public interface Vectorf<VecType> {
    /**
     * Adds the vector <code>v</code> to <code>this</code> vector and returns <code>this</code> vector.
     *
     * @param v the vector to add to <code>this</code> vector.
     * @return <code>this</code> vector.
     */
    VecType add(VecType v);

    /**
     * Adds the vector <code>v1</code> to the vector <code>v2</code> and returns the result of the addition.
     *
     * @param v1 the LeftHandSide vector in the addition.
     * @param v2 the RightHandSide vector in the addition.
     * @return the sum of the vectors <code>v1</code> and <code>v2</code>.
     */
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
