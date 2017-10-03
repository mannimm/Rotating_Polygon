
import java.awt.*;
import java.text.*;
import javax.swing.*;

import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

public class drawPolygon extends JPanel {
  private BufferedImage bim;
  private JLabel piLabel;
  private int tries = 0;
  private int hits = 0;
  private int centerx = 200;
  private int centery = 200;
  private int radius = 100;
  private double x=0;
  private double y=0;
  private boolean isHit=false;
  private Timer time;
	
  public drawPolygon(JLabel piLabel){ //constructor to set up simulation
    this.piLabel = piLabel;
    setBackground (Color.BLACK);		
    bim = new BufferedImage (400, 400, BufferedImage.TYPE_INT_RGB);

    time = new Timer(1,new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        tries++;
        double r = Math.random();
        x = (-1 + 2 * r);
        r = Math.random();
        y = (-1 + 2 * r);         

        repaint();
      }
    });	
  }
	
  //stop the timer that controls the simulation
  public void stopDarts(){time.stop();}	

  //start the timer that controls the simulation
  public void startDarts() {
    time.start();
    Graphics2D big = bim.createGraphics();
    big.setColor (Color.BLACK);
    big.fillRect(0, 0, 400, 400);
    tries = 0;
    hits = 0;
    repaint();
  }

/*
  public void paintComponent(Graphics g){ 	//create the polygons
    super.paintComponent(g); 

    // get a graphics context for the offscreen image
    Graphics2D big = bim.createGraphics();

    // Set the color for the dart location
    // Yellow is a hit;  red is a miss
    big.setColor (Color.RED);
    if (x * x + y * y <= 1) { 
      hits++; 
      big.setColor (Color.YELLOW);
    }
    else {
      big.setColor (Color.RED);
    }

    // Draw the position of the dart
    int xhit = (int) (((x+1)*100)+centerx-radius);
    int yhit = (int) (((y+1)*100)+centery-radius);
    big.fillOval (xhit, yhit, 6, 6);

    // Now draw the offscreen image into the on-screen panel
    Graphics2D picture = (Graphics2D)g;
    picture.drawImage(bim, 0, 0, this);

    // calculate current estimate of PI
    // Display number of tries and the PI estimate in the label
    double piEstimate = 0.0;
    if (tries != 0) {
      piEstimate = 4.0 * hits / tries;
    }

    this.piLabel.setText (Integer.toString(tries) + "  " + 
    new DecimalFormat("  #.########").format(piEstimate));
  }
}
*/

  public void paintComponent(Graphics g){ 	//create the polygons
    super.paintComponent(g); 

    // Set the color for the dart location
    // Yellow is a hit;  red is a miss
    g.setColor (Color.RED);
    if (x * x + y * y <= 1) { 
      hits++; 
      g.setColor (Color.YELLOW);
    }
    else {
      g.setColor (Color.RED);
    }

    // Draw the position of the dart
    int xhit = (int) (((x+1)*100)+centerx-radius);
    int yhit = (int) (((y+1)*100)+centery-radius);

    //int xVertex = (int) (((x+ 100)+centerx-radius);


    g.fillOval (xhit, yhit, 6, 6);

    g.fillOval (200, 200, 20,20);
    g.drawRect(100,100,150 ,120);
    int [] x = {50,150,50,150};
    int [] y = {50,50,150,50};
    g.drawPolygon(x,y,4);

    // calculate current estimate of PI
    // Display number of tries and the PI estimate in the label
    double piEstimate = 0.0;
    if (tries != 0) {
      piEstimate = 4.0 * hits / tries;
    }

    this.piLabel.setText (Integer.toString(tries) + "  " + 
    new DecimalFormat("  #.########").format(piEstimate));
  }
}
