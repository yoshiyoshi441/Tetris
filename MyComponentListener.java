import javax.swing.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * フレームの操作を監視するためのListener
 */
public class MyComponentListener implements ComponentListener {
    /**
     * うえ
     */
    private final JPanel top;

    /**
     * ひだり
     */
    private final JPanel left;

    /**
     * みぎ
     */
    private final JPanel right;

    /**
     * した
     */
    private final JPanel bottom;


    /**
     * コンストラクタ
     */
    public MyComponentListener(final JPanel top, final JPanel bottom, final JPanel left, JPanel right) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }

    /**
     * パネルのリサイズが行われたときに呼び出される
     * @param e イベント
     */
    @Override
    public void componentResized(ComponentEvent e) {
        top.repaint();
        left.repaint();
        right.repaint();
        bottom.repaint();
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
