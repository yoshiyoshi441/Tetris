import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RightWallPanel extends JPanel {
    /**
     * 壁
     */
    private final Image wall = getToolkit().getImage("img/wall.png");

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
        // 背景とか
        graphics.setColor(Color.cyan);

        // サイズを求めておく
        Dimension size = getSize();

        //→壁
        for (int i = 0; i < size.height; i = i + 25) {
            graphics.drawImage(wall, size.width - 24, i, this);
        }
    }
}
