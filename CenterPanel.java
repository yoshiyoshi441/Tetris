import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class CenterPanel extends JPanel {
    /**
     * イメージ集
     */
    private Map<String, Image> images = new HashMap<>();

    /**
     * コンストラクタ
     */
    public CenterPanel() {
        addImages();
        setBorder(new EmptyBorder(0, 0, 0, 0));
    }

    /**
     * 読み込むイメージをマップに追加する
     */
    public void addImages() {
        images.put("aquaBlue", getToolkit().getImage("img/Aqua blue.png"));
        images.put("blue", getToolkit().getImage("img/Blue.png"));
        images.put("green", getToolkit().getImage("img/Green.png"));
        images.put("orange", getToolkit().getImage("img/Orenge.png"));
        images.put("purple", getToolkit().getImage("img/Purple.png"));
        images.put("red", getToolkit().getImage("img/Red.png"));
        images.put("yellow", getToolkit().getImage("img/Yellow.png"));
    }

    /**
     * 表示
     * repaintが呼ばれるとココが呼ばれる
     */
    protected void paintComponent(Graphics graphics) {
        //  ランダムにブロックを塗ります
        Random random = new Random();
        String[] keys = images.keySet().toArray(new String[images.size()]);
        String color = keys[random.nextInt(keys.length)];
        graphics.drawImage(images.get(color), 1, 1, this);
    }
}