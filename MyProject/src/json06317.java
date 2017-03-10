import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import org.json.simple.JSONObject;

public class json06317 extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
	JTextField tf1, tf2, tf5, tf6, tf7, tf8, tf9, tf10, p1, p2, tf3, tf4;

	JButton btn1, btn2;
	JRadioButton rb1, rb2;
	JButton b;

	// JPasswordField p1, p2;

	json06317() {

		/*
		 * JXTextField text = new JXTextField("Your Prompt Here");
		 * text.setPrompt("New Prompt"); frame.add(text, BorderLayout.CENTER);
		 */
		setVisible(true);
		setSize(700, 700);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Registration Form in Java");

		l1 = new JLabel("Registration Form in Windows Form:");
		l1.setForeground(Color.blue);
		l1.setFont(new Font("Serif", Font.BOLD, 20));

		l2 = new JLabel("Name:");
		l3 = new JLabel("Enter your username:");
		l4 = new JLabel("Create Passowrd:");
		l5 = new JLabel("Confirm Password:");
		
      /*  JSONObject obj = new JSONObject();
        obj.put("name", "vikas");
        System.out.print(obj);*/
		/*
		 * l2 = new JLabel("create password:"); l3 = new
		 * JLabel("confirm password:"); l4 = new JLabel("Name:"); l5 = new
		 * JLabel("choose your username:");
		 */

		l6 = new JLabel("Gender:");
		l7 = new JLabel("Birthday:");

		l8 = new JLabel("Mobile phone:");
		l9 = new JLabel("Your current email address:");
		l10 = new JLabel("Location:");
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();

		p1 = new JPasswordField();
		p2 = new JPasswordField();

		// p1 = new JTextField();
		// p2 = new JTextField();
		tf5 = new JTextField();

		rb1 = new JRadioButton("Male");
		rb1.setBounds(300, 230, 100, 30);
		rb2 = new JRadioButton("Female");
		rb2.setBounds(400, 230, 100, 30);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		// b=new JButton("click");
		// b.setBounds(100,150,80,30);
		// b.addActionListener(this);
		// rb1.setBounds(300, 230, 200, 30);
		// rb2.setBounds(300, 250, 200, 30);
		// l1.setBounds(100, 5, 200, 30);
		// l2.setBounds(100, 25, 200, 30);

		// add (l1);
		// add (l2); add(b);

		add(rb1);
		add(rb2);
		tf6 = new JTextField();
		tf7 = new JTextField();
		tf8 = new JTextField();
		tf9 = new JTextField();
		tf10 = new JTextField();

		btn1 = new JButton("Next");
		btn2 = new JButton("Cancel");

		btn1.addActionListener(this);
		btn2.addActionListener(this);

		l1.setBounds(100, 30, 400, 30);
		l2.setBounds(80, 70, 200, 30);
		l3.setBounds(80, 110, 200, 30);
		l4.setBounds(80, 150, 200, 30);
		l5.setBounds(80, 190, 200, 30);
		l6.setBounds(80, 230, 200, 30);
		l7.setBounds(80, 270, 200, 30);
		l8.setBounds(80, 310, 200, 30);
		l9.setBounds(80, 350, 200, 30);
		l10.setBounds(80, 390, 200, 30);

		tf1.setBounds(300, 70, 200, 30);
		tf2.setBounds(300, 110, 200, 30);
		p1.setBounds(300, 150, 200, 30);
		p2.setBounds(300, 190, 200, 30);

		// tf5.setBounds(300, 230, 200, 30);

		/*
		 * Number year = null; SpinnerModel value = new SpinnerNumberModel(year,
		 * //initial value 1990, //minimum value 2050, //maximum value 1);
		 * //step JSpinner spinner = new JSpinner(value);
		 * spinner.setBounds(300,270,50,30); //
		 * spinner.setBounds(100,100,50,30);
		 */

		SpinnerModel value = new SpinnerNumberModel(2010, // initial value
				1990, // minimum value
				2050, // maximum value
				1); // step
		JSpinner spinner = new JSpinner(value);
		spinner.setBounds(440, 270, 50, 30);

		/*
		 * SpinnerModel value1 = new SpinnerNumberModel(5, //initial value 1,
		 * //minimum value 12, //maximum value 1); //step JSpinner spinner1 =
		 * new JSpinner(value1); spinner1.setBounds(390,270,50,30);
		 */

		SpinnerModel value2 = new SpinnerNumberModel(2, // initial value
				1, // minimum value
				31, // maximum value
				1); // step
		JSpinner spinner2 = new JSpinner(value2);
		spinner2.setBounds(300, 270, 50, 30);

		String Month[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		JComboBox cb1 = new JComboBox(Month);
		cb1.setBounds(370, 270, 50, 30);

		// tf6.setBounds(300, 270, 200, 30);
		tf7.setBounds(300, 310, 200, 30);
		// tf8.setBounds(300, 230, 200, 30);
		// tf9.setBounds(300, 270, 200, 30);
		// tf10.setBounds(300, 310, 200, 30);
		tf9.setBounds(300, 350, 200, 30);
		// tf10.setBounds(300, 390, 200, 30);

		String Location[] = { "India", "Aus", "U.S.A", "England", "Newzealand" };
		JComboBox cb = new JComboBox(Location);
		cb.setBounds(300, 390, 200, 30);
		

		// Container f = null;
		// f.add(cb);

		btn1.setBounds(300, 430, 80, 30);
		btn2.setBounds(400, 430, 80, 30);

		add(l1);
		add(l2);
		add(tf1);
		add(l3);
		add(tf2);
		add(l4);
		add(p1);
		add(l5);
		add(p2);

		add(l6);
		add(tf5);
		add(l7);
		add(tf6);
		add(l8);
		add(l9);
		add(l10);
		add(tf8);
		add(tf9);
		add(tf10);
		add(tf7);
		add(btn1);
		add(btn2);
		add(tf3);
		add(tf4);
		add(cb);

		add(spinner);
		add(cb1);
		// add(spinner1);
		add(spinner2);
		// add(spinner);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			int x = 0;
			String s1 = tf1.getText();
			String s2= tf2.getText();
		//String s2 = tf2.getText() + "@gmail.com";
		//	System.out.println(s2);

			// char[] s3 = p1.getPassword();
			// char[] s3 = p1.getText();
			// System.out.println(s3);
			// char[] s4 = p2.getPassword();
			// char[] s4 = p2.getText();
			String s3 = p1.getText();
			String s4 = p2.getText();
		//	System.out.println(s4);
			String s8 = new String(s3);
		//	System.out.println(s8);
			String s9 = new String(s4);
			// System.out.println(s9);

			String s5 = tf5.getText();
			String s6 = tf6.getText();
			String s7 = tf7.getText();
			String s10= tf10.getText();
			String s11= tf9.getText();
			
		//      String data = p2.getText(); //perform your operation
	       //     System.out.println(data);
			
		//	String s1 = tf1.getText();
			
		    JSONObject tf2 = new JSONObject();
             tf2.put("Name", s1);
            System.out.println(tf2);
			
	      //       JSONObject obj = new JSONObject();
	       //     obj.put("name", "vikas");
	       //     System.out.println(obj);
	            
	             JSONObject obj1 = new JSONObject();
	            obj1.put("Enter username",s2);
	            System.out.println(obj1);
	            
	             JSONObject obj2 = new JSONObject();
	            obj2.put("Mobile number",s7);
	            System.out.println(obj2);
	            
	        //      JSONObject obj3 = new JSONObject();
	         //   Object bg;
			//	obj3.put("Gender","" );
	          //  System.out.println(obj3);
	            
	           // JSONObject obj4 = new JSONObject();
	          //  obj4.put("Birthday", "");
	          //  System.out.println(obj4);
	          //  System.out.println();
	            
	            JSONObject obj5 = new JSONObject();
	            obj5.put("Your email",s11);
	            System.out.println(obj5);
	            
	            JSONObject obj6 = new JSONObject();
	            
	         
	           
	          
			//	obj6.put("Loction","" );
	        //    System.out.println(obj6);
			
			
			if (s8.equals(s9)) {
				JOptionPane.showMessageDialog(btn1, "Password is match");
				try {

					Class.forName("com.mysql.jdbc.Driver");
					// Connection con =
					// DriverManager.getConnection("jdbc:mysql://localhost/vikas",
					// "root", "root");
					// PreparedStatement ps = con.prepareStatement("insert into
					// registration (Name, EmailID, Password, Country, State,
					// PhoneNo) values(?,?,?,?,?,?)");
					// ps.setString(1, s1);
					// ps.setString(2, s2);
					// ps.setString(3, s8);
					// ps.setString(4, s5);
					// ps.setString(5, s6);
					// ps.setString(6, s7);
					// int rs = ps.executeUpdate();
					x++;
					if (x > 0) {
						JOptionPane.showMessageDialog(btn1, "Password is match");
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			} else {
				JOptionPane.showMessageDialog(btn1, "Password does not match");
			}
		} else {
			tf1.setText("");
			tf2.setText("");
			p1.setText("");
			p2.setText("");
			// tf5.setText("");
			tf6.setText("");
			tf7.setText("");
			tf3.setText("");
			tf4.setText("");
		}
	}

	public static void main(String args[]) {

		new json06317();
	}
}
