package jvictor.math.vector.interfaces;

public interface Quaternion<QuaternionType> {
    /**
     * Calculate and return the result of multiplying <code>this</code> quaternion with <code>q2</code>.
     *
     * @param q2 the Right Hand Side quaternion in the multiplication.
     * @return the quaternion result of the multiplication: <code>this</code> * <code>q2</code>.
     */
    QuaternionType mul(QuaternionType q2);

    /**
     * Calculate and return the result of multiplying the quaternions <code>q1</code> and <code>q2</code>.
     *
     * @param q1 the Left Hand Side quaternion in the multiplication.
     * @param q2 the Right Hand Side quaternion in the multiplication.
     * @return the quaternion result of the multiplication: <code>q1</code> * <code>q2</code>.
     */
    QuaternionType mulQuaternions(QuaternionType q1, QuaternionType q2);

    /**
     * Negate <code>this</code> quaternion and return it.
     *
     * @return <code>this</code> quaternion after it has been negated.
     */
    QuaternionType negate();

    /**
     * Negate a copy of <code>this</code> quaternion and return it.
     *
     * @return a negated copy of <code>this</code> quaternion.
     */
    QuaternionType negateCopy();

    /**
     * Normalize <code>this</code> quaternion and return it.
     *
     * @return <code>this</code> quaternion after it has been normalized.
     */
    QuaternionType normalize();

    /**
     * Normalize a copy of <code>this</code> quaternion and return it.
     *
     * @return a normalized copy of <code>this</code> quaternion.
     */
    QuaternionType normalizeCopy();

    /**
     * Rotate <code>this</code> quaternion by the quaternion <code>q</code>.
     *
     * @param q the quaternion representing the rotation to apply to <code>this</code> quaternion.
     * @return <code>this</code> quaternion after it has had the rotation applied.
     */
    QuaternionType rotateBy(QuaternionType q);

    /**
     * Set <code>this</code> quaternion to the identity quaternion.
     *
     * @return <code>this</code> quaternion after it has been set to the identity.
     */
    QuaternionType setIdentity();
}
