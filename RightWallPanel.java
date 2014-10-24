import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RightWallPanel extends JPanel {
    /**
     * コンストラクタ
     */
    public RightWallPanel(){
        // パネルの設定
        setPreferredSize(new Dimension(24, 24));
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

        //→壁
        for (int i = 0; i < size.height; i = i + 25) {
            graphics.fillRect(size.width - 24, i, 24, 24);
        }
    }
}
