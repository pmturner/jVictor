package jvictor.math.vector.interfaces;

public interface Vectord<VecType> extends Vector<VecType> {
    /**
     * Calculate and return the angle (in Radians) between the vectors <code>v1</code> and <code>v2</code>.
     *
     * @param v1 the first vector in the angle calculation.
     * @param v2 the second vector in the angle calculation.
     * @return the angle between the vectors <code>v1</code> and <code>v2</code>.
     */
    double angleBetween(VecType v1, VecType v2);

    /**
     * Calculate and return the angle (in Radians) between <code>this</code> vector and <code>v</code>.
     *
     * @param v the vector to compare to <code>this</code> vector when calculating the angle.
     * @return the angle between <code>this</code> vector and <code>v</code>.
     */
    double angleTo(VecType v);

    /**
     * Calculate and return the dot product of <code>this</code> vector and <code>v</code>.
     *
     * @param v the vector to 'dot' with <code>this</code> vector.
     * @return the dot product of <code>this</code> vector and <code>v</code>.
     */
    double dot(VecType v);

    /**
     * Calculate and return the dot product of the vectors <code>v1</code> and <code>v2</code>.
     *
     * @param v1 the first vector in the dot product.
     * @param v2 the second vector in the dot product.
     * @return the dot product of the vectors <code>v1</code> and <code>v2</code>.
     */
    double dotVectors(VecType v1, VecType v2);

    /**
     * Calculate and return the length of <code>this</code> vector.
     *
     * @return the length of <code>this</code> vector.
     */
    double length();

    /**
     * Calculate and return the length squared of <code>this</code> vector.
     *
     * @return the length squared of <code>this</code> vector.
     */
    double lengthSquared();

    /**
     * Scale <code>this</code> vector and return it.
     *
     * @param s the factor by which to scale.
     * @return <code>this</code> vector.
     */
    VecType scale(double s);

    /**
     * Scale a copy of <code>this</code> vector and return it.
     *
     * @param s the factor by which to scale.
     * @return a scaled copy of <code>this</code> vector.
     */
    VecType scaleCopy(double s);

    /**
     * Set the length of a copy of <code>this</code> vector to <code>l</code>.
     *
     * @param length the final length of the copied vector.
     * @return a scaled copy of <code>this</code> vector.
     */
    VecType scaleCopyTo(double length);

    /**
     * Set <code>this</code> vector's length to <code>l</code>.
     *
     * @param length the final length of <code>this</code> vector.
     * @return <code>this</code> vector.
     */
    VecType scaleTo(double length);
}
