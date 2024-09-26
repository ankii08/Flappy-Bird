import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

/**
 * Represents an obstacle pipe in a Flappy Bird-like game.
 * Pipes have fixed widths, variable heights, and move leftward across the game screen.
 */
public class Pipe {
    private static final int WIDTH = 30;  // Standard width of the pipes.
    private static final int GAP = 150;   // Vertical gap between the top and bottom parts of the pipe.

    private int x;       // X-coordinate for the starting position of the pipe.
    private int height;  // Randomly generated height for the top part of the pipe.
    private boolean scored = false;  // Indicates whether the bird has successfully passed this pipe.

    /**
     * Initializes a new pipe with a starting x-coordinate.
     * The height of the pipe is randomly set between 100 and 300 pixels.
     *
     * @param startX The initial x-coordinate of the pipe.
     */
    public Pipe(int startX) {
        this.x = startX;
        this.height = new Random().nextInt(200) + 100;
    }

    /**
     * Updates the pipe's position to simulate movement towards the left.
     */
    public void move() {
        x -= 5;
    }

    /**
     * Draws the pipe on the game panel.
     *
     * @param g Graphics object used for drawing.
     */
    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, 0, WIDTH, height);  // Draw the top section of the pipe.
        g.fillRect(x, height + GAP, WIDTH, 600 - (height + GAP));  // Draw the bottom section of the pipe.
    }

    // Getter and setter methods
    public boolean isScored() { return scored; }
    public void markAsScored() { scored = true; }
    public int getX() { return x; }
    public int getHeight() { return height; }
    public static int getWidth() { return WIDTH; }
    public static int getGap() { return GAP; }
}
