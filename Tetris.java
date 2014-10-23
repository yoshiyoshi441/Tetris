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
     * フレーム
     */
    private static JFrame frame;

    /**
     * ブロック
     */
    private static JPanel centerPanel;

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
        System.out.println("Created GUI" +
                SwingUtilities.isEventDispatchThread());
        frame = new JFrame();

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
        frame.addKeyListener(new KeyListener() {
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
        });

        /**
         * マウスのクリック操作を監視するためのListener
         */
        frame.addMouseListener(new MouseListener() {
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
        });

        /**
         * マウスの動きを監視するためのListener
         */
        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("MouseDragged: " + e.getButton());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("MouseMoved: " + e.getButton());
            }
        });

        /**
         * フレームの操作を監視するためのListener
         */
        frame.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                topPanel.repaint();
                leftWallPanel.repaint();
                rightWallPanel.repaint();
                bottomPanel.repaint();
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
        });

        frame.pack();
        frame.setBounds(0, 0, 480, 640);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    /**
     * ゲーム開始！
     */
    private static void startGame() {
        Thread thread = new Thread() {
            /**
             * 真ん中のパネルだけ再描画する
             */
            @Override
            public void run() {
                while (true) {
                    centerPanel.repaint();
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