import doodlepad.*;
public class GraphicBoard {
    double width;
    double height;
    public GraphicBoard(double width, double height) {
        this.width = width;
        this.height = height;
        Pad allBoard = new Pad(1650, 850);
        Rectangle board1 = new Rectangle(825, 25, 750, 800);
        board1.setFillColor(0, 0, 255);
        Rectangle board2 = new Rectangle(25, 25, 750, 800);
        board2.setFillColor(0, 0, 255);
        Dimension textBox = new Dimension((750/width), (800/height));
        ArrayList<Text> boxes = new ArrayList<Text>();
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                boxes.add(new Text("O", 25+col*textBox.getWidth(), 25+row*textBox.getHeight(), textBox));
            }
        }
    }
    public static void main(String[] args) {
        GraphicBoard g = new GraphicBoard(500.0, 500.0);
    }
}
