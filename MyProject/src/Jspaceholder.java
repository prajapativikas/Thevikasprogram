import javax.swing.*;
 
public class Jspaceholder {
 
    public static <CustomTextField> void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JLabel label = new JLabel("Email:");
 
                CustomTextField customTextField = new CustomTextField(20);
                ((Object) customTextField).setPlaceholder("example@address.com");
                /*customTextField.setFont(new Font("Arial", Font.PLAIN, 24));
                customTextField.setForeground(Color.RED);
                customTextField.setPlaceholderForeground(Color.RED);*/
 
                JButton button = new JButton("Test focus");
 
                JPanel panel = new JPanel();
                panel.add(label);
                panel.add(customTextField);
                panel.add(button);
 
                JFrame frame = new JFrame("CustomTextField");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(panel);
                frame.pack();
                frame.setVisible(true);
            }
        });
 
    }
}