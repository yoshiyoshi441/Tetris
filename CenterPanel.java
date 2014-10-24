import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.CubicCurve2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class CenterPanel extends JPanel {
    /**
     * ブロックの X 座標
     */
    private int x = 1;

    /**
     * ブロックの Y 座標
     */
    private int y = 1;

    /**
     * コンストラクタ
     */
    public CenterPanel() {
        setBorder(new EmptyBorder(0, 0, 0, 0));
    }

    /**
     * 表示
     * repaintが呼ばれるとココが呼ばれる
     */
    protected void paintComponent(Graphics graphics) {
        //  ランダムにブロックを塗りますとおもったけど
        // 同じ大きさの■をいろいろな色で塗ることにします
        Random random = new Random();

        int red = random.nextInt(255);
        int green = random.nextInt(255);
        int blue = random.nextInt(255);

        // X と Y の座標を少しづつズラしてみると？？
        graphics.setColor(new Color(0, 0, 0));
        graphics.fillRect(1, 0, 300, 600);
        if (x < 300) {
            x = x + 1;
        } else {
            x = 1;
        }

        if (y < 500) {
            y = y + 1;
        } else {
            y = 1;
        }


        Color color = new Color(red, green, blue);
        graphics.setColor(color);
        graphics.fillRect(x, y, 24, 24);
    }
}