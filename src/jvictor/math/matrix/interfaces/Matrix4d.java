package jvictor.math.matrix.interfaces;

import jvictor.math.vector.Vector2d;
import jvictor.math.vector.Vector3d;

public interface Matrix4d<MatType, VecType> extends Matrixd<MatType, VecType> {
    /**
     * Rotate <code>this</code> matrix by the given angle around the give axis and return it.
     *
     * @param angle the angle by which to rotate.
     * @param axis  and axis around which to rotate.
     * @return <code>this</code> matrix after it has been rotated.
     */
    MatType rotate(double angle, Vector3d axis);

    /**
     * Rotate a copy of <code>this</code> matrix by the given angle around the given axis and return it.
     *
     * @param angle the angle by which to rotate.
     * @param axis  the axis around which to rotate.
     * @return a rotated copy of <code>this</code> matrix.
     */
    MatType rotateCopy(double angle, Vector3d axis);

    /**
     * Translate <code>this</code> matrix by the vector <code>v</code>.
     *
     * @param v the vector by which to translate.
     * @return <code>this</code> matrix after it has been translated.
     */
    MatType translateBy(Vector2d v);

    /**
     * Translate <code>this</code> matrix by the vector <code>v</code>.
     *
     * @param v the vector by which to translate.
     * @return <code>this</code> matrix after it has been translated.
     */
    MatType translateBy(Vector3d v);

    /**
     * Translate a copy of <code>this</code> matrix by the vector <code>v</code>.
     *
     * @param v the vector by which to translate.
     * @return a translated copy of <code>this</code> matrix.
     */
    MatType translateCopyBy(Vector2d v);

    /**
     * Translate a copy of <code>this</code> matrix by the vector <code>v</code>.
     *
     * @param v the vector by which to translate.
     * @return a translated copy of <code>this</code> matrix.
     */
    MatType translateCopyBy(Vector3d v);
}
