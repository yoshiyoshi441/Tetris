import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * マウスのクリック操作を監視するためのListener
 */
public class MyMouseListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("MouseClicked: " + e.getButton());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("MousePressed: " + e.getButton());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("MouseReleased: " + e.getButton());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("MouseEntered: " + e.getButton());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("MouseExited: " + e.getButton());
    }
}
