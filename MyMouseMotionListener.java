import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * マウスの動きを監視するためのListener
 */
public class MyMouseMotionListener implements MouseMotionListener {
    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("MouseDragged: " + e.getButton());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("MouseMoved: " + e.getButton());
    }
}
