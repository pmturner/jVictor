package jvictor.math.matrix.interfaces;

import jvictor.math.vector.Vector2f;
import jvictor.math.vector.Vector3f;

public interface Matrix4f<MatType, VecType> extends Matrixf<MatType, VecType> {

    /**
     * Rotate <code>this</code> matrix by the given angle around the give axis and return it.
     *
     * @param angle the angle by which to rotate.
     * @param axis  and axis around which to rotate.
     * @return <code>this</code> matrix after it has been rotated.
     */
    MatType rotate(float angle, Vector3f axis);

    /**
     * Rotate a copy of <code>this</code> matrix by the given angle around the given axis and return it.
     *
     * @param angle the angle by which to rotate.
     * @param axis  the axis around which to rotate.
     * @return a rotated copy of <code>this</code> matrix.
     */
    MatType rotateCopy(float angle, Vector3f axis);

    /**
     * Translate <code>this</code> matrix by the vector <code>v</code>.
     *
     * @param v the vector by which to translate.
     * @return <code>this</code> matrix after it has been translated.
     */
    MatType translateBy(Vector2f v);

    /**
     * Translate <code>this</code> matrix by the vector <code>v</code>.
     *
     * @param v the vector by which to translate.
     * @return <code>this</code> matrix after it has been translated.
     */
    MatType translateBy(Vector3f v);

    /**
     * Translate a copy of <code>this</code> matrix by the vector <code>v</code>.
     *
     * @param v the vector by which to translate.
     * @return a translated copy of <code>this</code> matrix.
     */
    MatType translateCopyBy(Vector2f v);

    /**
     * Translate a copy of <code>this</code> matrix by the vector <code>v</code>.
     *
     * @param v the vector by which to translate.
     * @return a translated copy of <code>this</code> matrix.
     */
    MatType translateCopyBy(Vector3f v);

}
