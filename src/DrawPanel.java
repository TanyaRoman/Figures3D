import math.Matrix4;
import math.Vector3;
import models.*;
import thirdDimension.Camera;
import thirdDimension.Scene;
import thirdDimension.ScreenConverter;
import thirdDimension.ScreenPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawPanel extends JPanel implements MouseListener,  MouseMotionListener{

    private ScreenConverter sc;
    private Camera cam;
    private Scene scene;

    public DrawPanel(){
        super();
        sc = new ScreenConverter(-2, 2, 4, 4, 500, 500);
        cam = new Camera();
        scene = new Scene();

        // Сдесь можно выбрать фигуру, которую необходимо вывести

//        scene.models.add(new Cube(new Vector3(-1, -1, -1), new Vector3(1, 1, 1))) ;
        scene.models.add(new Torus(0.7, 0.3, 20, 10));
//        scene.models.add(new Figure(0.5, 0.25, 40, 20));

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(scene.drawScene(cam, sc), 0, 0, null);
    }

    private ScreenPoint last = null;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        last = new ScreenPoint(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        last = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        ScreenPoint np = new ScreenPoint(e.getX(), e.getY());
        if (last != null) {
            int dx = np.getI() - last.getI();
            int dy = np.getJ() - last.getJ();
            double a = dx * Math.PI / 180;
            double b = dy * Math.PI / 180;
            cam.rotate = Matrix4.rotate(a, 0).mul(Matrix4.rotate(b, 1).mul(cam.rotate));
        }
        last = np;
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
