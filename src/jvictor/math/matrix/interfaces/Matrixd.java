package jvictor.math.matrix.interfaces;

public interface Matrixd<MatType, VecType> extends Matrix<MatType, VecType> {

    /**
     * Calculate and return the determinant of <code>this</code> matrix.
     *
     * @return the determinant of <code>this</code> matrix.
     */
    double determinant();

    MatType mul(double d);

}
