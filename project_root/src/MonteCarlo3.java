import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MonteCarlo3 extends JFrame{
  private JPanel buttonPanel = new JPanel();
  private JButton start, stop;
  private JLabel piLabel;
  private Container c;
  private drawPolygon panel;
	
  public MonteCarlo3() {

    // label in which to show the approximate value of PI
    // as it is computed
    piLabel = new JLabel();

    panel = new drawPolygon(piLabel);

    stop = new JButton("Stop");
    stop.addActionListener(new ActionListener() {	//stop simulation
      public void actionPerformed(ActionEvent e) {
        panel.stopDarts();
      }
    });

    start = new JButton("Start");
    start.addActionListener(new ActionListener() {	//reset and start simulation
      public void actionPerformed(ActionEvent e) {
        panel.startDarts();
      }
    });

    buttonPanel.setLayout(new GridLayout(1,3,0,0));		
    buttonPanel.add(stop);
    buttonPanel.add(piLabel);
    buttonPanel.add(start);
    panel.setSize(400,400);

    // Add the panels to the content pane to make the JFrame visible
    c = getContentPane();
    c.add(panel, BorderLayout.CENTER);
    c.add(buttonPanel, BorderLayout.SOUTH);

    setSize(450, 450);
    setVisible(true);
  }
	
  public static void main(String[] args) {
    MonteCarlo3 target = new MonteCarlo3();
    target.addWindowListener(
      new WindowAdapter(){
        public void windowClosing(WindowEvent e) {
          System.exit(0);
        }
      });
  }
}
