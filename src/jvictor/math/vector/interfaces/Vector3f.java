package jvictor.math.vector.interfaces;

public interface Vector3f<VecType> extends Vectorf<VecType> {
    VecType cross(VecType v);

    VecType crossVectors(VecType v1, VecType v2);
}
