package math;

public class Vector4 {
    private double[] coords;

    public Vector4(double x, double y, double z, double w){
        coords = new double[] {x, y, z, w};
    }

    public Vector4(double x, double y, double z){
        this(x, y, z, 0);
    }

    public Vector4(Vector3 v, double w){
        this(v.getX(), v.getY(), v.getZ(), w);
    }

    public Vector4(Vector3 v){
        this(v, 0);
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

    public double getW(){
        return coords[3];
    }

    public double at(int idx){
        return coords[idx];
    }

    public Vector4 normalized(){ //нормализыция вектора
        if (Math.abs(getW()) < 1e-12){
            return  new Vector4(getX(), getY(), getZ());
        }
        return  new Vector4(
                getX()/getW(),
                getY()/getW(),
                getZ()/getW(),
                1
        );
    }

    public static Vector4 zero(){ // нулевой вектор
        return  new Vector4(0, 0, 0, 0);
    }

    public Vector4 mul(double num){ // умножение вектора на число
        return new Vector4(
                getX()*num,
                getY()*num,
                getZ()*num,
                getW()*num
        );
    }
}
