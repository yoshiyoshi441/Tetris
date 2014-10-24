import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * キー操作を監視するためのListener
 */
public class MyKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("KeyTyped: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("KeyPressed: " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("KeyReleased: " + e.getKeyChar());
    }
}
