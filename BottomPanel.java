import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BottomPanel extends JPanel {
    /**
     * コンストラクタ
     */
    public BottomPanel() {
        // パネルの設定
        setPreferredSize(new Dimension(25, 25));
        setBorder(new EmptyBorder(0, 0, 0, 0));
    }
    /**
     * 表示
     * repaintが呼ばれるとココが呼ばれる
     */
    protected void paintComponent(Graphics graphics) {
        // サイズを求めておく
        Dimension size = getSize();

        // ブロックの色
        Color block = new Color(95, 95, 80);
        graphics.setColor(block);

        //↓壁
        for (int i = 0; i < size.width; i = i + 25) {
            graphics.fillRect(i, 0, 24, 24);
        }
    }
}
