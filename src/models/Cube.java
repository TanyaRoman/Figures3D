package models;

import math.Vector3;
import thirdDimension.IModel;
import thirdDimension.PolyLine3D;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Cube implements IModel {
    private Vector3 LTF, RBN;

    public Cube(Vector3 LTF, Vector3 RBN) {
        this.LTF = LTF; // левая верхняя дальняя точка
        this.RBN = RBN; // правая нижняя ближняя точка
    }

    @Override
    public List<PolyLine3D> getLines() {
        List<PolyLine3D> lines = new LinkedList<>();
        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3[]{
                        new Vector3(LTF.getX(), LTF.getY(), LTF.getZ()),
                        new Vector3(RBN.getX(), LTF.getY(), LTF.getZ()),
                        new Vector3(RBN.getX(), LTF.getY(), RBN.getZ()),
                        new Vector3(LTF.getX(), LTF.getY(), RBN.getZ()),
                }
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3[]{
                        new Vector3(LTF.getX(), RBN.getY(), LTF.getZ()),
                        new Vector3(RBN.getX(), RBN.getY(), LTF.getZ()),
                        new Vector3(RBN.getX(), RBN.getY(), RBN.getZ()),
                        new Vector3(LTF.getX(), RBN.getY(), RBN.getZ()),
                }
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3[]{
                        new Vector3(LTF.getX(), LTF.getY(), LTF.getZ()),
                        new Vector3(LTF.getX(), LTF.getY(), RBN.getZ()),
                        new Vector3(LTF.getX(), RBN.getY(), RBN.getZ()),
                        new Vector3(LTF.getX(), RBN.getY(), LTF.getZ()),
                }
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3[]{
                        new Vector3(RBN.getX(), LTF.getY(), LTF.getZ()),
                        new Vector3(RBN.getX(), LTF.getY(), RBN.getZ()),
                        new Vector3(RBN.getX(), RBN.getY(), RBN.getZ()),
                        new Vector3(RBN.getX(), RBN.getY(), LTF.getZ()),
                }
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3[]{
                        new Vector3(LTF.getX(), RBN.getY(), RBN.getZ()),
                        new Vector3(LTF.getX(), LTF.getY(), RBN.getZ()),
                        new Vector3(RBN.getX(), LTF.getY(), RBN.getZ()),
                        new Vector3(RBN.getX(), RBN.getY(), RBN.getZ()),
                }
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3[]{
                        new Vector3(LTF.getX(), RBN.getY(), LTF.getZ()),
                        new Vector3(LTF.getX(), LTF.getY(), LTF.getZ()),
                        new Vector3(RBN.getX(), LTF.getY(), LTF.getZ()),
                        new Vector3(RBN.getX(), RBN.getY(), LTF.getZ()),
                }
        ), true));
        return lines;
    }
}
