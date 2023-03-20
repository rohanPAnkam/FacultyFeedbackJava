package AppUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.sql.*;

public class LoginPage implements ActionListener {

    JFrame f = new JFrame();
    JTextField userText;
    JPasswordField password;
    JButton logIn;
    JButton signUp;
    JComboBox roll;

    LoginPage() {

        f.setLayout(null);

        JPanel leftSide = new JPanel();
        leftSide.setBounds(0, 0, 500, 750);
        leftSide.setBackground(Color.CYAN);
        f.add(leftSide);



        ImageIcon profile = new ImageIcon(ClassLoader.getSystemResource("Icons/profile.png"));
        Image user = profile.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon p1 = new ImageIcon(user);
        JLabel pUser = new JLabel(p1);
        pUser.setBounds(100, 550, 100, 100);
        //pUser.setLocation(500, 500);
        leftSide.add(pUser);

        JLabel rl = new JLabel("Roll No.");
        rl.setBounds(580,180,200,30);
        rl.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        f.add(rl);

        String[] nos = {"1","2","3","4","5","6","7","8","9","10","11","12","1","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70"};
        roll = new JComboBox<>(nos);
        roll.setBounds(730,180,80,30);
        f.add(roll);

        
        JLabel userName = new JLabel("Username : ");
        userName.setBounds(580, 250, 160, 30);
        userName.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        f.add(userName);

        userText = new JTextField(); 
        userText.setBounds(730, 250, 200, 35);
        userText.setFont(new Font("Arial", Font.ROMAN_BASELINE, 18));
        //userText.setBackground(Color.LIGHT_GRAY);
        f.add(userText);

        JLabel passName = new JLabel("Password : ");
        passName.setBounds(580, 320, 160, 30);
        passName.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        f.add(passName);

        password = new JPasswordField();
        password.setBounds(730, 318, 200, 35);
        f.add(password);

        Border blueLine = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        logIn = new JButton("Login");
        logIn.setBounds(580, 380, 128, 60);
        logIn.setFont(new Font("SAN_SERIF", Font.BOLD, 40));
        logIn.setBackground(Color.WHITE);
        logIn.setBorder(blueLine);
        logIn.addActionListener(this);
        //logIn.setForeground(Color.CYAN);
        f.add(logIn);

        signUp = new JButton("Signup");
        signUp.setBounds(760, 380, 168, 60);
        signUp.setFont(new Font("Raleway", Font.BOLD, 40));
        signUp.setBorder(blueLine);
        signUp.addActionListener(this);
        f.add(signUp);

        f.setSize(1150,750);
        f.setLocation(165, 80);
        f.getContentPane().setBackground(Color.LIGHT_GRAY);
        //f.setUndecorated(true);
        f.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {


        String usName = userText.getText();
        String passT = password.getText();
        String rollNo = (String) roll.getSelectedItem();

        if(ae.getSource() == logIn) {
            
            try {

                Conn c = new Conn();
                String query = "select * from login where Roll_No = '"+rollNo+"'and Username = '"+usName+"' and Pass_word = '"+passT+"' ";
                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()) {
                    f.setVisible(false);
                    new FeedJava(rollNo); 
                }
                else {
                    JOptionPane.showMessageDialog(null,"Incorrect Username or Pin");
                }

                
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == signUp) {
            f.setVisible(false);
            new SignUpPage();
        }

    }

    public static void main(String []args) {
        new LoginPage();
    }
}
