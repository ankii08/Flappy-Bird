import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollisionDetectorTest {

    @Test
    void testCollision() {
        Bird bird = new Bird();
        Pipe pipe = new Pipe(bird.getX());
        bird.jump(); // Simulate a jump
        bird.move(); // Update bird's position after jump

        // Simulate the scenario where the bird should collide with the pipe
        assertTrue(CollisionDetector.checkCollision(bird, pipe), "Bird should collide with the pipe.");
    }

    @Test
    void testCollisionAtPipeEdge() {
        Bird bird = new Bird();
        Pipe pipe = new Pipe(bird.getX() - Pipe.getWidth() + 1); // Bird is just at the left edge of the pipe
        assertTrue(CollisionDetector.checkCollision(bird, pipe), "Bird should collide at the edge of the pipe.");
    }




    @Test
    void testNoCollision() {
        Bird bird = new Bird();
        Pipe pipe = new Pipe(bird.getX() + 1000); // Pipe is far away from the bird

        assertFalse(CollisionDetector.checkCollision(bird, pipe), "Bird should not collide with the distant pipe.");
    }
}
