import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
    private Bird bird;
    private List<Pipe> pipes;
    private Timer timer;
    private boolean gameStarted = false;
    private boolean gameOver = false;
    private boolean allowRestart = false;
    private int score = 0;
    private static final int RESTART_DELAY = 800; // Delay before the game can be restarted
    private static final int PIPE_SPACING = 100; // Spacing between pipes
    private static final int PIPE_WIDTH = 15; // The width of the pipes
    private static final Font SCORE_FONT = new Font("Arial", Font.BOLD, 30);
    private static final Font GAME_OVER_FONT = new Font("Arial", Font.BOLD, 30);
    private static final Color SCORE_COLOR = new Color(255, 215, 0); // Gold color for score
    private static final Color GAME_OVER_COLOR = new Color(255, 0, 0); // Red color for game over message
    private BufferedImage background;
    private static final Font MESSAGE_FONT = new Font("Fredoka One", Font.BOLD, 24);
    private static final Color MESSAGE_COLOR = new Color(255, 223, 0);  // Bright yellow

    public GamePanel() {

        bird = new Bird();
        pipes = new ArrayList<>();
        timer = new Timer(18, this);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (!gameStarted && allowRestart) {
                        resetGame();
                    }
                    if (!gameOver) {
                        bird.jump();
                        if (!gameStarted) {
                            gameStarted = true;
                            timer.start();
                        }
                    }
                }
            }
        });

        // Load the background image
        try {
            background = ImageIO.read(new File("/Users/ankitdas/Documents/CS257/FlappyBirdGame/resources/Flappy.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void resetGame() {
        bird.reset(); // Reset the bird's position and velocity
        pipes.clear(); // Clear existing pipes
        pipes.add(new Pipe(getWidth())); // Add the first pipe again
        score = 0; // Reset the score
        gameOver = false; // Set the game over flag to false
        gameStarted = false; // Game is not started until space is pressed
        allowRestart = false; // Don't allow restart until delay has passed
        timer.start(); // Start the timer again
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

        bird.paint(g);
        for (Pipe pipe : pipes) {
            pipe.paint(g);
        }
        // Display the start message if the game has not started
        if (!gameStarted) {
            g.setFont(MESSAGE_FONT);
            g.setColor(MESSAGE_COLOR);
            g.drawString("Please Press Space to Start", getWidth() / 2 - 150, getHeight() / 2);
        }

        // Draw the score
        g.setFont(SCORE_FONT);
        g.setColor(SCORE_COLOR);
        g.drawString("Score: " + score, getWidth() / 2 - 50, 50); // Adjust x and y to center the text as needed

        if (gameOver) {
             //Draw the game over message
            g.setFont(GAME_OVER_FONT);
            g.setColor(GAME_OVER_COLOR);
            g.drawString("Game Over!", getWidth() / 2 - 100, getHeight() / 3);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameStarted && !gameOver) {
            bird.move();
            managePipes();
            checkForCollisions();
            repaint();
        }
    }

    private void managePipes() {
        Iterator<Pipe> iterator = pipes.iterator();
        while (iterator.hasNext()) {
            Pipe pipe = iterator.next();
            pipe.move();

            if (!pipe.isScored() && pipe.getX() + PIPE_WIDTH < bird.getX()) {
                pipe.markAsScored();
                score++;
            }

            if (pipe.getX() < -PIPE_WIDTH) {
                iterator.remove();
            }
        }

        if ((pipes.isEmpty() || pipes.get(pipes.size() - 1).getX() < getWidth() - PIPE_SPACING) && !gameOver) {
            pipes.add(new Pipe(getWidth() + PIPE_SPACING - PIPE_WIDTH)); // Add new pipe off-screen
        }
    }

    private void checkForCollisions() {
        for (Pipe pipe : pipes) {
            if (CollisionDetector.checkCollision(bird, pipe)) {
                gameOver = true;
                gameStarted = false;
                timer.stop();
                initiateRestartDelay();
                break; // No need to check other pipes
            }
        }

        if (bird.getY() + Bird.getHeight() > getHeight()) {
            gameOver = true;
            gameStarted = false;
            timer.stop();
            initiateRestartDelay();
        }
    }

    private void initiateRestartDelay() {
        Timer restartTimer = new Timer(RESTART_DELAY, (evt) -> allowRestart = true);
        restartTimer.setRepeats(false);
        restartTimer.start();
    }
}
