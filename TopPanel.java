import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TopPanel extends JPanel {
    /**
     * 壁
     */
    private final Image wall = getToolkit().getImage("img/Wall.png");

    /**
     * コンストラクタ
     */
    public TopPanel() {
        // パネルの設定
        setPreferredSize(new Dimension(24, 24));
        setBorder(new EmptyBorder(0, 0, 0, 0));
    }

    /**
     * 表示
     * repaintが呼ばれるとココが呼ばれる
     */
    protected void paintComponent(Graphics graphics) {
        // 背景とか
        graphics.setColor(Color.blue);

        // サイズを求めておく
        Dimension size = getSize();

        //↑壁
        graphics.drawImage(wall, 0, 0, this);
        graphics.drawImage(wall, 25, 0, this);
        graphics.drawImage(wall, size.width - 49, 0, this);
        graphics.drawImage(wall, size.width - 24, 0, this);
    }
}
