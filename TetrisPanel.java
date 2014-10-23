import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class TetrisPanel extends JPanel {
    /**
     * イメージ集
     */
    private Map<String, Image> images = new HashMap<>();

    /**
     * 壁ブロックの高さ
     */
    int bwheight = 31;
    /**
     * 壁ブロックの幅
     */
    int bwwidth = 8;

    /**
     * 可動ブロックの高さ
     */
    int bheight = 55;

    /**
     * 可動ブロックの幅
     */
    int bwidth = 56;

    boolean wallPainted = false;

    /**
     * コンストラクタ
     */
    public TetrisPanel() {
        addImages();
    }

    /**
     * 壁が一度でも表示されたか
     * @return 表示されたかの結果
     */
    public boolean isWallPainted() {
        return wallPainted;
    }

    /**
     * 読み込むイメージをマップに追加する
     */
    public void addImages() {
        images.put("wall", getToolkit().getImage("img/Wall.png"));
        images.put("wallHeight", getToolkit().getImage("img/Wallheight.png"));
        images.put("wallWidth", getToolkit().getImage("img/Wallwidth.png"));
        images.put("aquaBlue", getToolkit().getImage("img/Aqua blue.png"));
        images.put("blue", getToolkit().getImage("img/Blue.png"));
        images.put("green", getToolkit().getImage("img/Green.png"));
        images.put("orange", getToolkit().getImage("img/Orenge.png"));
        images.put("purple", getToolkit().getImage("img/Purple.png"));
        images.put("red", getToolkit().getImage("img/Red.png"));
        images.put("yellow", getToolkit().getImage("img/Ye);llow.png"));
    }

    /**
     * 表示
     * repaintが呼ばれるとココが呼ばれる
     */
    protected void paintComponent(Graphics graphics) {
        // 壁を表示するのは一度だけでよい
        if (!isWallPainted()) {
            Dimension size = getSize();
            graphics.setColor(Color.black);
            graphics.fillRect(0, 0, size.width - 1, size.height - 1);
            //↑壁
            graphics.drawImage(images.get("wall"), 32, bwheight, this);
            graphics.drawImage(images.get("wall"), 56, bwheight, this);
            graphics.drawImage(images.get("wall"), 248, bwheight, this);
            graphics.drawImage(images.get("wall"), 224, bwheight, this);
            //←縦壁
            graphics.drawImage(images.get("wallHeight"), bwwidth, bwheight, this);
            //↓壁
            graphics.drawImage(images.get("wallWidth"), 32, 535, this);
            //→壁
            graphics.drawImage(images.get("wallHeight"), 272, bwheight, this);
        }
        //ブロック
        paintBlock(graphics);
    }

    /**
     * ランダムにブロックを塗ります
     *
     * @param graphics
     */
    public void paintBlock(Graphics graphics) {
        Random random = new Random();
        String[] keys = images.keySet().toArray(new String[images.size()]);
        String color;
        do {
            color = keys[random.nextInt(keys.length)];
            if (!color.startsWith("wall")) {
                break;
            }
        } while (true);
        graphics.drawImage(images.get(color), bwidth, bheight, this);
    }
}