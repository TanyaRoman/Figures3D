package thirdDimension;
import math.Vector3;

import java.util.List;

public class PolyLine3D {

    private List<Vector3> points;
    private boolean closed;

    public PolyLine3D(List<Vector3> points, boolean closed){
        this.points = points;
        this.closed = closed;
    }
    public  List<Vector3> getPoints(){
        return points;
    }

    public  boolean isClosed(){
        return  closed;
    }

    public double avgZ(){
        double sum = 0;
        for (Vector3 v : points){
            sum += v.getZ();
        }
        return sum / points.size();
    }
}
