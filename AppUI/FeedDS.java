package AppUI;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class FeedDS implements ActionListener, MouseListener {

    JFrame f;
    JComboBox c1,c2,c3,c4,c5;
    JButton next, PreIcon, logIcon;
    JTextArea tArea;
    String rollNo;

    FeedDS(String rollNo) {

        this.rollNo = rollNo;
        f = new JFrame();
        f.setLayout(null);

        

        ImageIcon pre = new ImageIcon(ClassLoader.getSystemResource("Icons/arrow-left.png"));
        Image p1 = pre.getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT);
        ImageIcon preS = new ImageIcon(p1);
        JButton PreIcon = new JButton(preS);
        PreIcon.setBounds(80, 20, 55, 57);
        PreIcon.setBackground(Color.LIGHT_GRAY);
        PreIcon.addMouseListener(this);
        f.add(PreIcon);

        JLabel titl = new JLabel("Data Structure");
        titl.setBounds(250, 35, 250, 120);
        titl.setFont(new Font("Arial", Font.BOLD, 36));
        f.add(titl);

        ImageIcon dLine = new ImageIcon(ClassLoader.getSystemResource("Icons/line.png"));
        Image l1 = dLine.getImage().getScaledInstance(630, 80, Image.SCALE_DEFAULT);
        ImageIcon dLine2 = new ImageIcon(l1);
        JLabel linIcon = new JLabel(dLine2);
        linIcon.setBounds(250, 100, 630, 80);
        f.add(linIcon);

        ImageIcon lg = new ImageIcon(ClassLoader.getSystemResource("Icons/logout.png"));
        Image logO = lg.getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT);
        ImageIcon lg2 = new ImageIcon(logO);
        logIcon = new JButton(lg2);
        logIcon.setBounds(1050, 20, 55, 57);
        logIcon.addActionListener(this);
        f.add(logIcon);

        JLabel q1 = new JLabel("Is the teaching attention-seeking?");
        q1.setBounds(250, 150, 300, 60);
        q1.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        f.add(q1);

        String[] feeling = {"Very Bad", "Bad", "Good", "Very Good", "Excellent"};
        c1 = new JComboBox<>(feeling);
        c1.setBounds(540,155,120,50);
        c1.setBackground(Color.WHITE);
        f.add(c1);

        JLabel q2 = new JLabel("Is the voice of the lecturer audible?");
        q2.setBounds(250, 200, 400, 60);
        q2.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        f.add(q2);

        c2 = new JComboBox<>(feeling);
        c2.setBounds(540,205,120,50);
        c2.setBackground(Color.WHITE);
        f.add(c2);

        JLabel q3 = new JLabel("Does the lecturer interact with the students on a daily basis?");
        q3.setBounds(250, 250, 500, 60);
        q3.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        f.add(q3);

        c3 = new JComboBox<>(feeling);
        c3.setBounds(750,255,120,50);
        c3.setBackground(Color.WHITE);
        f.add(c3);

        JLabel q4 = new JLabel("Does the lecturer clear the doubts efficiently?");
        q4.setBounds(250, 300, 500, 60);
        q4.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        f.add(q4);

        c4 = new JComboBox<>(feeling);
        c4.setBounds(650,305,120,50);
        c4.setBackground(Color.WHITE);
        f.add(c4);

        JLabel q5 = new JLabel("Does the lecturer clear the syllabus within the given time?");
        q5.setBounds(250, 350, 500, 60);
        q5.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        f.add(q5);

        c5 = new JComboBox<>(feeling);
        c5.setBounds(750,355,120,50);
        c5.setBackground(Color.WHITE);
        f.add(c5);

        JLabel q6 = new JLabel("Suggestions From Your Side:");
        q6.setBounds(250, 400, 500, 50);
        q6.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        f.add(q6);

        tArea = new JTextArea();
        tArea.setBounds(250,450,630,100);
        tArea.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        f.add(tArea);

        
        next = new JButton("Next");
        next.setBounds(800, 580, 80, 50);
        next.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 25));
        next.addActionListener(this);
        f.add(next);


        
        f.setLayout(null);
        f.setSize(1150,750);
        f.setLocation(165, 80);
        f.getContentPane().setBackground(Color.LIGHT_GRAY);
        //f.setUndecorated(true);
        f.setVisible(true);
    }
    
    public void mouseClicked(MouseEvent  e) {
        f.setVisible(false);
        new FeedJava("");
    }

    public void actionPerformed(ActionEvent ae) {
    
        if(ae.getSource() == next) {

            String q1Feel = (String) c1.getSelectedItem();
            String q2Feel = (String) c2.getSelectedItem();
            String q3Feel = (String) c3.getSelectedItem();
            String q4Feel = (String) c4.getSelectedItem();
            String q5Feel = (String) c5.getSelectedItem();
            String sugFeel = tArea.getText(); 

            try{

                Conn c = new Conn();
                String query = "insert into dataS values('"+rollNo+"', '"+q1Feel+"', '"+q2Feel+"', '"+q3Feel+"', '"+q4Feel+"', '"+q5Feel+"', '"+sugFeel+"')";
                c.s.executeUpdate(query);

                f.setVisible(false);
                new FeedCG(rollNo);

            }
            catch(Exception ex) {
                System.out.println(ex);
            }

        }
        else if(ae.getSource() == logIcon) {
            f.setVisible(false);
            System.exit(0);
        }
    }

    public static void main(String []args) {
        new FeedDS("");
    }

    @Override
    public void mousePressed(MouseEvent e) {

        if(e.getSource() == logIcon) {
            System.exit(0);
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}
