import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PipeTest {

    @Test
    void testMove() {
        Pipe pipe = new Pipe(100);
        int initialX = pipe.getX();
        pipe.move();
        assertTrue(pipe.getX() < initialX, "Pipe should move left after move call.");
    }


    @Test
    void testMarkAsScored() {
        Pipe pipe = new Pipe(100);
        assertFalse(pipe.isScored(), "Pipe should not be scored initially.");
        pipe.markAsScored();
        assertTrue(pipe.isScored(), "Pipe should be marked as scored.");
    }

    @Test
    void testPipeHeight() {
        Pipe pipe = new Pipe(100);
        assertTrue(pipe.getHeight() >= 100 && pipe.getHeight() <= 300, "Pipe height should be within the range 100 to 300.");
    }
}
