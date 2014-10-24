import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

class Tetris {
    /**
     * 真ん中のパネル
     */
    private static JPanel centerPanel;

    /**
     * メイン
     *
     * @param args 引数
     * @throws InterruptedException 割り込みが発生した場合
     */
    public static void main(String args[]) throws InterruptedException {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
                try {
                    startGame();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * GUIの作成と表示
     */
    private static void createAndShowGUI() {
        System.out.println("Created GUI" +
                SwingUtilities.isEventDispatchThread());
        JFrame frame = new JFrame();

        centerPanel = new CenterPanel();

        // うえ
        final TopPanel topPanel = new TopPanel();

        // ひだり
        final LeftWallPanel leftWallPanel = new LeftWallPanel();

        // みぎ
        final RightWallPanel rightWallPanel = new RightWallPanel();

        // した
        final BottomPanel bottomPanel = new BottomPanel();

        // タイトル
        frame.setTitle("テトリス");

        // 作ったパネルをフレーム上にのっけていく
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(leftWallPanel, BorderLayout.WEST);
        frame.add(rightWallPanel, BorderLayout.EAST);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.add(centerPanel, BorderLayout.CENTER);

        /**
         * キー操作を監視するためのListener
         */
        frame.addKeyListener(new MyKeyListener());

        /**
         * マウスのクリック操作を監視するためのListener
         */
        frame.addMouseListener(new MyMouseListener());

        /**
         * マウスの動きを監視するためのListener
         */
        frame.addMouseMotionListener(new MyMouseMotionListener());

        /**
         * フレームの操作を監視するためのListener
         */
        frame.addComponentListener(
                new MyComponentListener(topPanel, bottomPanel, leftWallPanel, rightWallPanel));
        frame.pack();
        frame.setBounds(0, 0, 355, 600);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    /**
     * ゲーム開始！
     */
    private static void startGame() throws InterruptedException {
        GameThread thread = new GameThread(centerPanel);
        thread.start();
//        thread.join();
    }
}