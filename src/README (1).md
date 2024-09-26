# FlappyBird

Team members (edit these):
1. Ankit


## libraries Used
For this project I used the following Libraries:
javax.swing: This package provides a set of "lightweight" (all-Java language) components that, to the maximum degree possible, work the same on all platforms.
JFrame, JPanel, Timer, and SwingUtilities are some of the Swing classes used.
java.awt: This package is the original platform-independent windowing, graphics, and user-interface widget toolkit in Java.
Graphics, Color, KeyEvent, and KeyAdapter are some of the AWT components used.
java.util: Contains the collections framework, legacy collection classes, event model, date and time facilities, and miscellaneous utility classes.
List, ArrayList, Random, and Iterator are some of the utility classes used.

## How to run the game?
Please download all the provided Java class files and unit test files from the links or attachments that have been shared with you. Additionally, 
make sure to download the Flappy.jpg image, which is necessary for the game's background. Once downloaded, create a folder named resources within 
your project directory and place the Flappy.jpg image inside this folder. This setup ensures that all game resources are correctly organized and 
accessible by the game when it runs.


## Problems Faced

1.Struggled with collision detection:
Initially, getting the collision detection to work correctly was a hurdle. I found it challenging because I was using incorrect coordinates or dimensions for the bird and pipes,
which meant that the bird would pass through the pipes without registering a collision or it would collide when it shouldn't have.
2.Had an issue with the pipes not starting from the bottom:
I encountered a problem where the pipes did not start from the bottom of the screen as expected. The cause turned out to be miscalculations in the position and height of the lower pipe.
I had to adjust the logic to make the pipes extend from the bottom to the correct height.
3.Implementing a restart delay after the game ended:
I realized the game would instantly restart if the spacebar was held down at the end, due to continuous input. To address this, I implemented a delay mechanism that prevented immediate restarts,
allowing players to see their final score and decide when to start a new game.
4.Changing the bird's graphics from a square:
The bird was initially just a simple square, which didn't look very good. I wanted to enhance the bird's appearance to make the game more visually engaging. 
So I worked on changing the representation from a square to a more bird-like figure, which involved either drawing a more complex shape or using an image.
5.Found the pipe generation logic challenging:
Managing the incoming pipes was trickier than I anticipated. Ensuring that they appeared with uniform gaps and consistent intervals was crucial for the game’s playability. 
I had to carefully work on the timing and positioning to get the flow of the game just right.
 ## Other Problems
Choosing the right font size, color, and placement requires multiple adjustments to ensure readability across all devices and resolutions.
Adding a scrolling background with trees involved understanding and implementing parallax effects correctly.
Adjusting the game speed to balance difficulty and playability required changes to several parameters.
Properly handling keyboard events to start the game and make the bird jump was initially confusing.


 ## Limitations
Could have added audio in the game but could not get enough time to finish the audio code.