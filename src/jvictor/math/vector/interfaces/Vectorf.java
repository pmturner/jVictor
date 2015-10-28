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
     * Adds the vector <code>v2</code> to a copy of the vector <code>v1</code> and returns the result of the
     * addition.  Note: this modifies neither <code>v1</code> nor <code>v2</code>.
     *
     * @param v1 the LeftHandSide vector in the addition.
     * @param v2 the RightHandSide vector in the addition.
     * @return the sum of the vectors <code>v1</code> and <code>v2</code>.
     */
    VecType addVectors(VecType v1, VecType v2);

    /**
     * Calculate and return the angle (in Radians) between <code>this</code> vector and <code>v</code>.
     * Note: this calculation is performed relative to <code>this</code> vector.  In other words, this function
     * returns the angle FROM: <code>this</code> vector TO: <code>v</code>.
     *
     * @param v the vector to which <code>this</code> vector will be compared when calculating the angle.
     * @return the angle between <code>this</code> vector and <code>v</code>.
     */
    float angleTo(VecType v);

    /**
     * Calculate and return the angle (in Radians) between the vectors <code>v1</code> and <code>v2</code>.
     * Note: this calculation is performed relative to the vector <code>v1</code>.  In other words, this function
     * returns the angle FROM: <code>v1</code> TO: <code>v2</code>.
     *
     * @param v1 the first vector in the angle calculation.
     * @param v2 the second vector in the angle calculation.
     * @return the angle between the vectors <code>v1</code> and <code>v2</code>.
     */
    float angleBetween(VecType v1, VecType v2);

    /**
     * Calculate and return the dot product of <code>this</code> vector and <code>v</code>.
     *
     * @param v the vector to 'dot' with <code>this</code> vector.
     * @return the dot product of <code>this</code> vector and <code>v</code>.
     */
    float dot(VecType v);

    /**
     * Calculate and return the dot product of the vectors <code>v1</code> and <code>v2</code>.
     *
     * @param v1 the first vector in the dot product.
     * @param v2 the second vector in the dot product.
     * @return the dot product of the vectors <code>v1</code> and <code>v2</code>.
     */
    float dotVectors(VecType v1, VecType v2);

    /**
     * Calculate and return the length of <code>this</code> vector.
     *
     * @return the length of <code>this</code> vector.
     */
    float length();

    /**
     * Calculate and return the length squared of <code>this</code> vector.
     *
     * @return the length squared of <code>this</code> vector.
     */
    float lengthSquared();

    /**
     * Negate <code>this</code> vector and return it.
     *
     * @return <code>this</code> vector.
     */
    VecType negate();

    /**
     * Negate a copy of <code>this</code> vector and return it.
     *
     * @return a negated copy of <code>this</code> vector.
     */
    VecType negateCopy();

    /**
     * Normalize <code>this</code> this vector and return it.
     *
     * @return <code>this</code> vector.
     */
    VecType normalize();

    /**
     * Normalize a copy of <code>this</code> this vector and return it.
     *
     * @return a normalized copy of <code>this</code> vector.
     */
    VecType normalizeCopy();

    /**
     * Scale <code>this</code> vector and return it.
     *
     * @param s the factor by which to scale.
     * @return <code>this</code> vector.
     */
    VecType scale(float s);

    /**
     * Scale a copy of <code>this</code> vector and return it.
     *
     * @param s the factor by which to scale.
     * @return a scaled copy of <code>this</code> vector.
     */
    VecType scaleCopy(float s);

    /**
     * Set <code>this</code> vector's length to <code>l</code>.
     *
     * @param l the final length of <code>this</code> vector.
     * @return <code>this</code> vector.
     */
    VecType scaleTo(float l);

    /**
     * Set the length of a copy of <code>this</code> vector to <code>l</code>.
     *
     * @param l the final length of the copied vector.
     * @return a scaled copy of <code>this</code> vector.
     */
    VecType scaleCopyTo(float l);

    /**
     * Subtract the vector <code>v</code> from <code>this</code> vector and return <code>this</code> vector.
     *
     * @param v the vector to be subtracted from <code>this</code> vector.
     * @return <code>this</code> vector.
     */
    VecType sub(VecType v);

    /**
     * Subtract vector <code>v2</code> from a copy of the vector <code>v1</code> and return the result.  Note: this
     * modifies neither <code>v1</code> nor <code>v2</code>.
     *
     * @param v1 the LeftHandSide vector in the subtraction.
     * @param v2 the RightHandSide vector in the subtraction.
     * @return the result of the subtraction: <code>v1 - v2</code>.
     */
    VecType subVectors(VecType v1, VecType v2);
}
