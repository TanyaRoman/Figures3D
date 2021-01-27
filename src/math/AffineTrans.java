package math;

public class AffineTrans {

    private Vector3 f;

    public AffineTrans(Vector3 f){
        this.f = f;
    }

    public Vector3 Shift (Vector3 f, Vector3 df ){  //перенос
        return new Vector3(f.getX()+df.getX(), f.getY()+df.getY(), f.getZ()+df.getZ());
    }

    public Vector3 Scaling (Vector3 f, Vector3 mf){  //масштабирование
        return new Vector3(mf.getX()*f.getX(), mf.getY()*f.getY(), mf.getZ()*f.getZ());
    }

    public Vector3 WaxingX (Vector3 f, double alf){ //вращение вокруг Ox
        return new Vector3(f.getX(), f.getY() * Math.cos(alf) - f.getZ()* Math.sin(alf), f.getY() * Math.sin(alf) + f.getZ() * Math.cos(alf));
    }

    public Vector3 WaxingY (Vector3 f, double alf){ //вращение вокруг Oy
        return new Vector3(f.getX() * Math.cos(alf) + f.getZ() * Math.sin(alf), f.getY(), - f.getX() * Math.sin(alf) + f.getZ() * Math.cos(alf));
    }

    public Vector3 WaxingZ (Vector3 f, double alf){ //вращение вокруг Oz
        return new Vector3(f.getX()*Math.cos(alf)-f.getY()*Math.sin(alf), f.getX()*Math.sin(alf)+f.getY()*Math.cos(alf), f.getZ());
    }

}
