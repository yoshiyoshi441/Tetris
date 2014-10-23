import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

class Tetris {
    /**
     * フレーム
     */
    private static JFrame frame;

    /**
     * メイン
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
                startGame();
            }
        });
    }

    /**
     * GUIの作成と表示
     */
    private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? " +
                SwingUtilities.isEventDispatchThread());
        frame = new JFrame("Swing Paint Demo");
        frame.setTitle("テトリス");
        frame.add(new TetrisPanel());
        frame.pack();
        frame.setBounds(0, 0, 480, 640);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * ゲーム開始！
     */
    private static void startGame() {
        // スレッドを使ってイメージを切り替えるよ
        Thread thread = new Thread() {
            /**
             * フレームを再描画する
             */
            @Override
            public void run() {
                while (true) {
                    frame.repaint();
                    try {
                        Thread.sleep(400);
                    } catch (Exception ignored) {
                    }
                }
            }
        };
        thread.start();
    }
}