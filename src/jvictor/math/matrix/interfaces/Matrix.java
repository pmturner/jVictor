package jvictor.math.matrix.interfaces;

public interface Matrix<MatType, VecType> {

    /**
     * Add the matrix <code>m</code> to <code>this</code> matrix and return <code>this</code> matrix.
     *
     * @param m the matrix to add to <code>this</code> matrix.
     * @return <code>this</code> matrix after m has been added to it.
     */
    MatType add(MatType m);

    /**
     * Add the matrices <code>m1</code> and <code>m2</code> and return the result.
     *
     * @param m1 the Left Hand Side matrix in the addition.
     * @param m2 the Right Hand Side matrix in the addition.
     * @return the sum of the matrices <code>m1</code> and <code>m2</code>.
     */
    MatType addMatrices(MatType m1, MatType m2);

    /**
     * Set <code>this</code> matrix to it's inverse and return it.
     *
     * @return <code>this</code> matrix after it has been inverted.
     */
    MatType invert();

    /**
     * Calculate and return the inverse of <code>this</code> matrix.
     *
     * @return the inverse of <code>this</code> matrix without modifying <code>this</code> matrix.
     */
    MatType invertCopy();

    /**
     * Multiply <code>this</code> matrix by the matrix <code>m</code>.
     *
     * @param m the Right Hand Side matrix in the multiplication.
     * @return <code>this</code> matrix after it has been multiplied by <code>m</code>.
     */
    MatType mul(MatType m2);

    /**
     * Calculate and return the result of multiplying the matrices <code>m1</code> and <code>m2</code>.
     *
     * @param m1 the Left Hand Side matrix in the multiplication.
     * @param m2 the Right Hand Side matrix in the multiplication.
     * @return the result of the multiplication: <code>m1</code> * <code>m2</code>.
     */
    MatType mulMatrices(MatType m1, MatType m2);

    /**
     * Negate <code>this</code> matrix and return it.
     *
     * @return <code>this</code> matrix after it has been negated.
     */
    MatType negate();

    /**
     * Negate a copy of <code>this</code> matrix and return it.
     *
     * @return a negated copy of <code>this</code> matrix.
     */
    MatType negateCopy();

    /**
     * Set <code>this</code> matrix to the identity matrix and return it.
     *
     * @return <code>this</code> matrix after it has been set to the identity matrix.
     */
    MatType setIdentity();

    /**
     * Set <code>this</code> matrix to the zero matrix and return it.
     *
     * @return <code>this</code> matrix after it has been set to the zero matrix.
     */
    MatType setZero();

    /**
     * Subtract the matrix <code>m</code> from <code>this</code> matrix and return <code>this</code> matrix.
     *
     * @param m the Right Hand Side matrix in the subtraction.
     * @return <code>this</code> matrix after <code>m</code> has been subtracted from it.
     */
    MatType sub(MatType m);

    /**
     * Calculate and return the difference between the matrices <code>m1</code> and <code>m2</code>.
     *
     * @param m1 the Left Hand Side matrix in the subtraction.
     * @param m2 the Right Hand Side matrix in the subtraction.
     * @return the result of the subtraction: <code>m1</code> - <code>m2</code>.
     */
    MatType subMatrices(MatType m1, MatType m2);

    /**
     * Transform the vector <code>v</code> by <code>this</code> matrix and return it.
     *
     * @param v the vector to be transformed
     * @return the vector <code>v</code> after it has been transformed.
     */
    VecType transformVector(VecType v);

    /**
     * Transform a copy of the vector <code>v</code> by <code>this</code> matrix and return the copy.
     *
     * @param v the vector to use in the transformation.
     * @return a transformed copy of the vector <code>v</code>.
     */
    VecType transformVectorCopy(VecType v);

    /**
     * Set <code>this</code> matrix equal to its transpose and return it.
     *
     * @return <code>this</code> matrix after it has been set to its transpose.
     */
    MatType transpose();

    /**
     * Return a copy of <code>this</code> matrix that has been transposed.
     *
     * @return a transposed copy of <code>this</code> matrix.
     */
    MatType transposeCopy();

}
