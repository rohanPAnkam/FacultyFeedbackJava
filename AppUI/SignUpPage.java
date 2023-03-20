package AppUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.lang.*;

public class SignUpPage implements ActionListener {

    JFrame f;
    JTextField mail,usr, fText;
    JTextField cPText, pText;
    JComboBox d , mon, y, rNo;
    JButton fSign, logB, icon1; 

    SignUpPage() {

        f = new JFrame();
        f.setLayout(null);

        /*
         * JLabel subTitl = new JLabel("Personal Info : ");
        subTitl.setBounds(200, 8, 330, 80);
        subTitl.setFont(new Font("Arial", Font.BOLD, 45));
        f.add(subTitl);
         */
        

        ImageIcon feedback = new ImageIcon(ClassLoader.getSystemResource("Icons/resume.png"));
        Image feedB = feedback.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon feedIcon = new ImageIcon(feedB);
        JLabel feedI = new JLabel(feedIcon);
        feedI.setBounds(240, 55, 60, 60);
        f.add(feedI);

        JLabel subTitl = new JLabel("Details :");
        subTitl.setBounds(350, 45, 330, 80);
        subTitl.setFont(new Font("Arial", Font.BOLD, 60));
        f.add(subTitl);

        JLabel back = new JLabel("Back");
        back.setBounds(70,32,100,30);
        back.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 22));
        f.add(back);

        ImageIcon bIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/back.png"));
        Image b1 = bIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon backIcon = new ImageIcon(b1);
        icon1 = new JButton(backIcon);
        icon1.setBounds(12, 25, 50, 40);
        f.add(icon1);

        JLabel roll = new JLabel("Roll No : ");
        roll.setBounds(240, 180, 120, 30);
        roll.setFont(new Font("Arial", Font.BOLD, 25));
        f.add(roll);

        String[] nos = {"1","2","3","4","5","6","7","8","9","10","11","12","1","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70"};
        rNo = new JComboBox<>(nos);
        rNo.setBounds(490, 178, 80, 28);
        rNo.setFont(new Font("Arial",Font.LAYOUT_LEFT_TO_RIGHT,15));
        f.add(rNo);

        JLabel fName = new JLabel("Full Name : ");
        fName.setBounds(240, 230, 150, 30);
        fName.setFont(new Font("Arial", Font.BOLD, 25));
        f.add(fName);

        fText = new JTextField();
        fText.setBounds(490, 228, 420, 28);
        //fText.setBackground(Color.GRAY);
        fText.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 25));
        f.add(fText);

        JLabel email = new JLabel("E-mail : ");
        email.setBounds(240, 280, 120, 30);
        email.setFont(new Font("Arial", Font.BOLD, 25));
        f.add(email);

        mail = new JTextField();
        mail.setBounds(490, 278, 420, 28);
        //mail.setBackground(Color.GRAY);
        mail.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 25));
        f.add(mail);

        JLabel username = new JLabel("Username");
        username.setBounds(240, 330, 130, 30);
        username.setFont(new Font("Arial", Font.BOLD, 25));
        f.add(username);

        usr = new JTextField();
        usr.setBounds(490, 328, 420, 28);
        usr.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 25));
        f.add(usr);

        JLabel dob = new JLabel("Date Of Birth : ");
        dob.setBounds(240, 380, 200, 30);
        dob.setFont(new Font("Arial", Font.BOLD, 25));
        f.add(dob);

        String[] dates = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        d = new JComboBox<>(dates);
        d.setBounds(490, 380, 80, 28);
        d.setFont(new Font("Arial",Font.LAYOUT_LEFT_TO_RIGHT,15));
        f.add(d);

        String months[] = {"January", "February","March","April","May","June","July","August","September","October", "November", "December"};
        mon = new JComboBox<>(months);
        mon.setBounds(600, 380, 130, 28);
        mon.setFont(new Font("Arial",Font.LAYOUT_LEFT_TO_RIGHT,15));
        f.add(mon);

        String[] years = {"1998", "1999", "2000","2001","2002","2003","2004","2005","2006"};
        y = new JComboBox<>(years);
        y.setBounds(760, 380, 120, 28);
        y.setFont(new Font("Arial",Font.LAYOUT_LEFT_TO_RIGHT,15));
        f.add(y);


        JLabel pass = new JLabel("Password : ");
        pass.setBounds(240, 430, 200, 30);
        pass.setFont(new Font("Arial", Font.BOLD, 25));
        f.add(pass);

        pText = new JTextField();
        pText.setBounds(490, 430, 420, 28);
        pText.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 25));
        f.add(pText);

        JLabel cPass = new JLabel("Confirm Password : ");
        cPass.setBounds(240, 480, 250, 30);
        cPass.setFont(new Font("Arial", Font.BOLD, 25));
        f.add(cPass);

        cPText = new JTextField();
        cPText.setBounds(490, 480, 420, 28);
        cPText.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 25));
        f.add(cPText);

        fSign = new JButton("Sign Up");
        fSign.setBounds(390,535,320,43);
        fSign.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 30));
        fSign.addActionListener(this);
        f.add(fSign);

        JLabel l1 = new JLabel("Have an account?");
        l1.setBounds(440,570,200,40);
        l1.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
        f.add(l1);

        logB = new JButton("Log In");
        logB.setBounds(560, 575, 80, 32);
        logB.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
        logB.addActionListener(this);
        f.add(logB);

        f.setSize(1150,750);
        f.setLocation(165, 80);
        f.getContentPane().setBackground(Color.LIGHT_GRAY);
        //f.setUndecorated(true);
        f.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        String rollNo = (String) rNo.getSelectedItem();
        String fullN = fText.getText();
        String eMail = mail.getText();
        String userName = usr.getText();
        String dt = (String) d.getSelectedItem();
        String m = (String) mon.getSelectedItem();
        String ye = (String) y.getSelectedItem();
        String pasWo = pText.getText();
        //String pWord = pText.getText();
        //String cPasWo = cPText.getPassword().toString();
        
        

        if(ae.getSource() == fSign) {

             
            try {
                 if(userName.equals("")) {
                    JOptionPane.showMessageDialog(null,"Username is Required!");
                }
                else {
                	Conn c = new Conn();
                    String query = "insert into signup values('"+rollNo+"', '"+fullN+"', '"+eMail+"', '"+userName+"','"+pasWo+"','"+dt+"', '"+m+"', '"+ye+"')";
                    String query2 = "insert into login values('"+rollNo+"', '"+userName+"', '"+pasWo+"')";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query2);
                    f.setVisible(false);
                    new LoginPage();
                }
            }
            catch(Exception e) {
                System.out.println(e);
            }
            
           
        }
        else if(ae.getSource() == logB || ae.getSource() == icon1) {
           f.setVisible(false);
           new LoginPage();
        }

    }

    public static void main(String []args) {
        new SignUpPage();
    }

}
