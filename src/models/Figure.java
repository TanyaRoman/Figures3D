package models;

import math.Vector3;
import thirdDimension.IModel;
import thirdDimension.PolyLine3D;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Figure implements IModel {

    private double R, r;
    private double numMajor, numMinor;

    public Figure(double R, double r, double numMajor, double numMinor) {
        this.R = r;
        this.r = r;
        this.numMajor = numMajor;
        this.numMinor = numMinor;
    }

    @Override
    public List<PolyLine3D> getLines() {

        List<PolyLine3D> list = new LinkedList<>();

        double majorStep = 2.0f * Math.PI / numMajor;
        double minorStep = 2.0f * Math.PI / numMinor;

        for (int i = 0; i < numMajor; ++i) { //скелет
            double a0 = i * majorStep;
            double a1 = (i + 1) * majorStep;

            double x00 = Math.sin(a0) + 2 * Math.sin(2 * a0);
            double y00 = Math.cos(a0) - 2 * Math.cos(2 * a0);
            double x11 = Math.sin(a1) + 2 * Math.sin(2 * a1);
            double y11 = Math.cos(a1) - 2 * Math.cos(2 * a1);

            double z00 = -Math.sin(3 * a0);
            double z11 = -Math.sin(3 * a1);

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
                        new Vector3(x00*r1, y00*r1, z0),
                        new Vector3(x11*r1, y11*r1, z0),
                        new Vector3(x11*r2, y11*r2, z1),
                        new Vector3(x00*r2, y00*r2, z1),

                }), true));
            }
        }
        return list;    }
}
