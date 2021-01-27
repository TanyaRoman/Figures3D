package math;

public class Vector3 {

    private double[] coords;

    public Vector3(double x, double y, double z){
        coords = new double[] {x, y, z};
    }

    public Vector3(Vector4 v){
        if (Math.abs(v.getW()) < 1e-12){
            coords = new double[] {v.getX(), v.getY(), v.getZ()};
        }else {
            coords = new  double[]{
                    v.getX()/v.getW(),
                    v.getY()/v.getW(),
                    v.getZ()/v.getW()
            };
        }
    }

    public double getX(){
        return coords[0];
    }
    public double getY(){
        return coords[1];
    }
    public double getZ(){
        return coords[2];
    }
    public double at(int idx){
        return coords[idx];
    }
}
