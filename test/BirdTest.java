import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BirdTest {

    private Bird bird;

    @BeforeEach
    void setUp() {
        bird = new Bird();
    }

    @Test
    void testJump() {
        int initialVelocity = bird.getVelocity();
        bird.jump();
        assertTrue(bird.getVelocity() < initialVelocity, "Velocity should decrease on jump.");
    }




    @Test
    void testBoundaries() {
        for (int i = 0; i < 1000; i++) {
            bird.move();
        }
        assertTrue(bird.getY() >= 0, "Bird should not go above the screen.");
    }

    @Test
    void testNegativeVelocity() {
        bird.jump();
        assertTrue(bird.getVelocity() < 0, "Jump should make the velocity negative.");
        bird.move();
        assertTrue(bird.getVelocity() < 0, "Velocity should stay negative after move if not countered by other forces.");
    }




    @Test
    void testMove() {
        int initialY = bird.getY();
        bird.move();
        assertTrue(bird.getY() > initialY, "Bird should move down due to gravity.");
    }

    @Test
    void testReset() {
        bird.jump();
        bird.reset();
        assertEquals(Bird.START_Y, bird.getY(), "Bird's Y position should be reset to the start.");
        assertEquals(0, bird.getVelocity(), "Bird's velocity should be reset to 0.");
    }
}
