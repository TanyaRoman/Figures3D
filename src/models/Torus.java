package models;

import math.Vector3;
import thirdDimension.IModel;
import thirdDimension.PolyLine3D;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Torus implements IModel {

    private double R, r;
    private double numMajor, numMinor;

    public Torus(double R, double r, double numMajor, double numMinor) {
        this.R = R;
        this.r = r;
        this.numMajor = numMajor;
        this.numMinor = numMinor;
    }

    @Override
    public List<PolyLine3D> getLines() {
        List<PolyLine3D> list = new LinkedList<>();

        double majorStep = 2.0f * Math.PI / numMajor;
        double minorStep = 2.0f * Math.PI / numMinor;

        for (int i = 0; i < numMajor; ++i) {
            double a0 = i * majorStep;
            double a1 = (i+1)* majorStep;
            double x0 =  Math.cos(a0);
            double y0 =  Math.sin(a0);
            double x1 =  Math.cos(a1);
            double y1 =  Math.sin(a1);

            for (int j=0; j<numMinor; ++j) {
                double b0 = j * minorStep;
                double b1 = (j + 1) * minorStep;
                double c0 = Math.cos(b0);
                double c1 = Math.cos(b1);
                double r1 = r * c0 + R;
                double r2 = r * c1 + R;
                double z0 = r * Math.sin(b0);
                double z1 = r * Math.sin(b1);

                list.add(new PolyLine3D(Arrays.asList(new Vector3[]{
                        new Vector3(x0*r1, y0*r1, z0),
                        new Vector3(x1*r1, y1*r1, z0),
                        new Vector3(x1*r2, y1*r2, z1),
                        new Vector3(x0*r2, y0*r2, z1),

                }), true));
            }
        }

        return list;
    }
}
