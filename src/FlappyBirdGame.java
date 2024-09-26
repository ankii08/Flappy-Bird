import javax.swing.JFrame;

/**
 * The FlappyBirdGame class extends JFrame and creates main window for the game.
 */
public class FlappyBirdGame extends JFrame {

    // Declare a GamePanel which will handle the game rendering and logic.
    private GamePanel gamePanel;

    /**
     * Constructor for FlappyBirdGame sets up the main game window.
     */
    public FlappyBirdGame() {
        // Set the title of the JFrame.
        super("Flappy Bird");

        // Set the size of the window to 800x600 pixels.
        setSize(800, 600);

        // Set the default close operation to exit the application when the window is closed.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the window not resizable, fixing its size.
        setResizable(false);

        // Create a new instance of GamePanel which contains all the game logic and visuals.
        gamePanel = new GamePanel();

        // Add the GamePanel to the JFrame to make it visible and active.
        add(gamePanel);

        // Set the JFrame to be visible. This last step is necessary to display the window.
        setVisible(true);
    }



}
