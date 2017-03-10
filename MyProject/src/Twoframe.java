import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Twoframe
{
    private JFrame frame1, frame2;
    private ActionListener action;
    private JButton showButton, hideButton;

    public void createAndDisplayGUI()
    {
        frame1 = new JFrame("FRAME 1");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        frame1.setLocationByPlatform(true);

        JPanel contentPane1 = new JPanel();
        contentPane1.setBackground(Color.BLUE);

        showButton = new JButton("OPEN FRAME 2");
        hideButton = new JButton("HIDE FRAME 2");

        action  = new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                JButton button = (JButton) ae.getSource();

                /*
                 * If this button is clicked, we will create a new JFrame,
                 * and hide the previous one.
                 */
                if (button == showButton)
                {
                    frame2 = new JFrame("FRAME 2");
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
                    frame2.setLocationByPlatform(true);

                    JPanel contentPane2 = new JPanel();
                    contentPane2.setBackground(Color.PINK);

                    contentPane2.add(hideButton);
                    frame2.getContentPane().add(contentPane2);
                    frame2.setSize(300, 300);
                    frame2.setVisible(true);
                    frame1.setVisible(false);
                }
                /*
                 * Here we will dispose the previous frame, 
                 * show the previous JFrame.
                 */
                else if (button == hideButton)
                {
                    frame1.setVisible(true);
                    frame2.setVisible(false);
                    frame2.dispose();
                }
            }
        };

        showButton.addActionListener(action);
        hideButton.addActionListener(action);

        contentPane1.add(showButton);

        frame1.getContentPane().add(contentPane1);
        frame1.setSize(300, 300);
        frame1.setVisible(true);
    }
    public static void main(String... args)
    {
        /*
         * Here we are Scheduling a JOB for Event Dispatcher
         * Thread. The code which is responsible for creating
         * and displaying our GUI or call to the method which 
         * is responsible for creating and displaying your GUI
         * goes into this SwingUtilities.invokeLater(...) thingy.
         */
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Twoframe().createAndDisplayGUI();
            }
        });
    }
}
