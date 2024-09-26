public class CollisionDetector {

    /**
     * Checks for collisions between the bird and a given pipe.
     *
     * @param bird The bird object whose position and dimensions are to be checked.
     * @param pipe The pipe object to check against the bird for any overlap.
     * @return true if there is a collision either with the upper or lower part of the pipe, false otherwise.
     */
    public static boolean checkCollision(Bird bird, Pipe pipe) {
        // Retrieve the position and dimensions of the bird.
        int birdX = bird.getX();
        int birdY = bird.getY();
        int birdWidth = Bird.getWidth();  // Width of the bird.
        int birdHeight = Bird.getHeight();  // Height of the bird.

        // Retrieve the position and dimensions of the pipe.
        int pipeX = pipe.getX();
        int pipeWidth = Pipe.getWidth();  // Width of the pipe.
        int pipeHeight = pipe.getHeight();  // Height of the upper part of the pipe.
        int gap = Pipe.getGap();  // Vertical gap between the upper and lower parts of the pipe.

        // Determine if the bird collides with the upper part of the pipe.
        boolean hitsUpperPipe = birdX < pipeX + pipeWidth && birdX + birdWidth > pipeX && birdY < pipeHeight;

        // Determine if the bird collides with the lower part of the pipe.
        boolean hitsLowerPipe = birdX < pipeX + pipeWidth && birdX + birdWidth > pipeX && birdY + birdHeight > pipeHeight + gap;

        // Return true if either collision condition is met.
        return hitsUpperPipe || hitsLowerPipe;
    }
}
