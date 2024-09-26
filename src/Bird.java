import java.awt.Color;
import java.awt.Graphics;

/**
 * Represents the player's character in the game, controlled by jumping to navigate through obstacles.
 */
public class Bird {
    public static final int WIDTH = 20;  // Width of the bird.
    public static final int HEIGHT = 20; // Height of the bird.
    public static final int START_X = 100;  // Initial horizontal position.
    public static final int START_Y = 250;  // Initial vertical position.
    private static final int GRAVITY = 1;   // Gravity effect increases the downward velocity.
    private static final int JUMP_VELOCITY = -10; // Upward velocity when the bird jumps.

    private int y;   // Current vertical position of the bird.
    private int x;   // Current horizontal position of the bird.
    private int velocity; // Current velocity of the bird.

    /**
     * Initializes the bird with default position and zero initial velocity.
     */
    public Bird() {
        this.x = START_X;
        this.y = START_Y;
        this.velocity = 0;
    }

    /**
     * Causes the bird to jump by setting its velocity to a negative value, countering gravity.
     */
    public void jump() {
        velocity = JUMP_VELOCITY;
    }

    /**
     * Updates the bird's position based on its velocity and applies gravity.
     */
    public void move() {
        velocity += GRAVITY;  // Apply gravity effect
        y += velocity;        // Update vertical position
        y = Math.max(y, 0);   // Ensure the bird does not go above the screen boundary
    }

    /**
     * Renders the bird on the screen.
     *
     * @param g Graphics context used to draw the bird.
     */
    public void paint(Graphics g) {
        g.setColor(Color.RED); // Set the color for the bird.
        g.fillOval(x, y, WIDTH, HEIGHT); // Draw the head.
        g.fillArc(x - WIDTH / 2, y, WIDTH * 2, HEIGHT, 0, 180); // Draw the body.
    }

    /**
     * Resets the bird to its initial position and velocity.
     */
    public void reset() {
        x = START_X;
        y = START_Y;
        velocity = 0;
    }

    // Getter methods for the bird's properties
    public int getX() { return x; }
    public int getY() { return y; }
    public int getVelocity() { return velocity; }
    public static int getWidth() { return WIDTH; }
    public static int getHeight() { return HEIGHT; }


}
