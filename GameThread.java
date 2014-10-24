import javax.swing.*;

/**
 * ゲーム用のスレッド
 */
public class GameThread extends Thread {
    /**
     * パネル
     */
    private final JPanel panel;

    /**
     * コンストラクタ
     *
     * @param panel パネル
     */
    public GameThread(final JPanel panel) {
        this.panel = panel;
    }

    /**
     * スレッドスタートで呼び出される
     */
    @Override
    public void run() {
        while (true) {
            panel.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ignored) {
            }
        }
    }
}
