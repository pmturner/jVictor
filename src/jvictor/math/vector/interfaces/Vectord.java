package jvictor.math.vector.interfaces;

public interface Vectord<VecType> extends Vector<VecType> {
    double angleTo(VecType v);
    double angleBetween(VecType v1, VecType v2);

    double dot(VecType v);
    double dotVectors(VecType v1, VecType v2);

    double length();
    double lengthSquared();

    VecType scale(double s);
    VecType scaleCopy(double s);

    VecType scaleTo(double l);
    VecType scaleCopyTo(double l);
}
