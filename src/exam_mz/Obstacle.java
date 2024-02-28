package exam_mz;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.Iterator;

public class Obstacle extends Figure {
    public Obstacle(Graphics2D buffer, int delay, int width, int height, int x, int y, Color color, AnimPanel panel) {
        super(buffer, delay, width, height, x, y, color, panel);
        shape = new Ellipse2D.Float(x, y, 20, 20);
        aft = new AffineTransform();
        area = new Area(shape);
    }

    protected Shape nextFrame() {
        area = new Area(area);
        aft = new AffineTransform();
        findCollision();
        area.transform(aft);
        return area;
    }

    protected void findCollision() {
        Iterator<Circle> iterator = circleList.iterator();
        while (iterator.hasNext()) {
            Circle object = iterator.next();
            if (object != null) {
                int[] c = object.figurePosition();
                if (shape.intersects(c[0], c[1], c[2], c[3])) {
                    object.collisionWithObstacle();
                    iterator.remove();
                    break;
                }
            }
        }
    }

}

