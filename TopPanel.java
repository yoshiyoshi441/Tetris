import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TopPanel extends JPanel {
    /**
     * コンストラクタ
     */
    public TopPanel() {
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

        //↑壁
        graphics.fillRect(0, 0, 24, 24);
        graphics.fillRect(25, 0, 24, 24);
        graphics.fillRect(size.width - 49, 0, 24, 24);
        graphics.fillRect(size.width - 24, 0, 24, 24);
    }
}
