/* Program Description: A program to let you play Hangman
 * Author: Brandi Morgan, Quintin Gossen
 * Assignment: Group Project
 * Date: July 10, 2018
 * Class: CSCI 1082
 */
package hangman;

	import java.awt.Graphics;
	import java.awt.Image;
	import java.awt.Panel;
	import java.io.IOException;
	import java.io.InputStream;
	import javax.imageio.ImageIO;

	 // panel displays hangman images during game
	public final class DrawMan extends Panel {
	    public final static int NUM_OF_GIFS = 7;
	    public final String[] gifNames;
	    
	    private int currentGif = 0;
	    private Image img = null;
	    
	    
	    //Constructs a new hangman
	     
	    public DrawMan() {
	        this.gifNames = new String[NUM_OF_GIFS];
	        for (int i = 0; i < NUM_OF_GIFS; i++)
	            this.gifNames[i] = "hangman/hangman" + i + ".gif";
	        this.reset();
	    }
	    
	    
	      //Resets the component back to its starting configuration.
	     
	    public void reset() {
	        this.currentGif = 0;
	        this.loadImage();
	    }
	    
	    
	    //  goes to next gif as user progresses/fails
	      //the function does nothing if at final gif
	     
	    public void advancePicture() {
	        if (this.currentGif >= NUM_OF_GIFS - 1)
	            return;
	        this.currentGif++;
	        this.loadImage();
	    }
	    
	    
	     //Loads the current image into memory
	     
	    private void loadImage() {
	        InputStream stream = DrawMan.class.getClassLoader().getResourceAsStream(this.gifNames[this.currentGif]);
	        try {
	            this.img = ImageIO.read(stream);
	        } catch(IOException e) {
	            throw new RuntimeException("Failed to load images: " + e.getMessage());
	        }
	        this.repaint();
	    }
	    
	    
	     // Overrides the paint method to paint the current hangman image to the screen.
	     
	    @Override
	    public void paint(Graphics g) {
	        g.drawImage(this.img.getScaledInstance(this.getWidth(), this.getHeight(), 0), 0, 0, null);
	    }
	}


