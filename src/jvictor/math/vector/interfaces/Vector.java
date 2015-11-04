package jvictor.math.vector.interfaces;


public interface Vector<VecType> {
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
