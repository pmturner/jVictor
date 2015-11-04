package jvictor.math.vector;

import jvictor.math.matrix.Matrix4f;

public class Quaternionf {

    private float w;
    private float x;
    private float y;
    private float z;

//    private Quaternionf(float w, float x, float y, float z) {
//        this.w = w;
//        this.x = x;
//        this.y = y;
//        this.z = z;
//    }
//
//    public Quaternionf(Quaternionf q) {
//        this(q.w, q.x, q.y, q.z);
//    }
//
//    public Quaternionf() {
//        this(1, 0, 0, 0);
//    }
//
//    public Quaternionf(Vector3f axis, float angle) {
//        axis.normalize();
//
//        float halfAngle = angle * 0.5f;
//        float sinHalfAngle = (float) Math.sin(halfAngle);
//
//        this.w = (float) Math.cos(halfAngle);
//        this.x = sinHalfAngle * axis.x;
//        this.y = sinHalfAngle * axis.y;
//        this.z = sinHalfAngle * axis.z;
//    }
//
//    public Matrix4f toRotationMatrix() {
//        /*
//            TODO: possibly normalize the quaternion here (it MUST be normalized, but we don't know if it has already
//            TODO: been done or not yet).
//        */
//        this.normalize();
//
//        float xSq = x*x;
//        float ySq = y*y;
//        float zSq = z*z;
//
//        float xy = x*y;
//        float xz = x*z;
//        float xw = x*w;
//        float yz = y*z;
//        float yw = y*w;
//        float zw = z*w;
//
//        Matrix4f rot = new Matrix4f();
//
//        rot.m00 = 1 - 2*ySq - 2*zSq;
//        rot.m01 = 2*xy  - 2*zw;
//        rot.m02 = 2*xz  + 2*yw;
//        rot.m03 = 0;
//
//        rot.m10 = 2*xy + 2*zw;
//        rot.m11 = 1 - 2*xSq - 2*zSq;
//        rot.m12 = 2*yz + 2*xw;
//        rot.m13 = 0;
//
//        rot.m20 = 2*xz - 2*yw;
//        rot.m21 = 2*yz - 2*xw;
//        rot.m22 = 1 - 2*xSq - 2*ySq;
//        rot.m23 = 0;
//
//        /*
//            TODO: this part shouldn't be necessary because this is the same as the identity matrix, but we need to make
//            TODO: sure it isn't before removing it.
//        */
//        rot.m30 = 0;
//        rot.m31 = 0;
//        rot.m32 = 0;
//        rot.m33 = 1;
//
//        return rot;
//    }
//
//    public Quaternionf mul(Quaternionf q2) {
//        Quaternionf q1 = new Quaternionf(this);
//
//        w = q1.w*q2.w - q1.x*q2.x - q1.y*q2.y - q1.z*q2.z;
//        x = q1.w*q2.x + q1.x*q2.w + q1.y*q2.z - q1.z*q2.y;
//        y = q1.w*q2.y - q1.x*q2.z + q1.y*q2.w + q1.z*q2.x;
//        z = q1.w*q2.z + q1.x*q2.y - q1.y*q2.x + q1.z*q2.w;
//
//        return this;
//    }
//
//    public Quaternionf mulQuaternions(Quaternionf q1, Quaternionf q2) {
//        Quaternionf q1Copy = new Quaternionf(q1);
//        return q1Copy.mul(q2);
//    }
//
//    public Quaternionf rotateBy(Quaternionf q) {
//        Quaternionf result = new Quaternionf().mulQuaternions(q, this);
//        this.w = result.w;
//        this.x = result.x;
//        this.y = result.y;
//        this.z = result.z;
//        return this;
//    }
//
//    public Quaternionf normalize() {
//        float length = (float) Math.sqrt(w*w + x*x + y*y + z*z);
//        w /= length;
//        x /= length;
//        y /= length;
//        z /= length;
//        return this;
//    }

}
