package jvictor.math.vector.interfaces;

public interface Vector3d<VecType> extends Vectord<VecType> {
    VecType cross(VecType v);
    VecType crossVectors(VecType v1, VecType v2);
}
