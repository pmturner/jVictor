package jvictor.math.matrix.interfaces;

public interface Matrixf<MatType, VecType> extends Matrix<MatType, VecType> {

    /**
     * Calculate and return the determinant of <code>this</code> matrix.
     *
     * @return the determinant of <code>this</code> matrix.
     */
    float determinant();

}
