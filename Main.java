import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;


public class Main {
    public static void main(String[] agrs ) {

        ImageIcon image  = new ImageIcon("user.webp");
        // image.add("video.png");

        Border border = BorderFactory.createLineBorder(Color.green,10);

        JLabel label  = new JLabel("New User");
        JLabel label1 = new JLabel("Existing User");
        // label.setText("This is label");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER); // left, right, center of an image 
        label.setVerticalTextPosition(JLabel.TOP); // top, center , bottom
        label.setForeground(new Color(0,0,0));
        label.setFont(new Font("MV Boli", Font.PLAIN, 36));
        label.setIconTextGap(100); // set gap of text and image can be +ve
        label.setBackground(new Color(0x123456));
        label.setOpaque(true);
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon+text within label
        label.setHorizontalAlignment(JLabel.CENTER); // set horizontal position
        label.setBounds(0,20,700,800); // co-ordinates of label/ layout where label needs to pus




        label1.setIcon(image);
        label1.setHorizontalTextPosition(JLabel.CENTER);  
        label1.setVerticalTextPosition(JLabel.TOP); 
        label1.setForeground(new Color(0,0,0));
        label1.setFont(new Font("MV Boli", Font.PLAIN, 36));
        label1.setIconTextGap(100); 
        label1.setBackground(new Color(0x123456));
        label1.setOpaque(true);
        label1.setBorder(border);
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setBounds(800,20,700,800);







        JFrame frame = new JFrame();
        frame.setTitle("Password Manager");
        // frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setResizable(false);
        frame.setSize(900,900);
        frame.setVisible(true);
        frame.setBackground(new Color(100,100,100));
        // frame.getContentPane().setBackground(Color.CYAN);
        // frame.getContentPane().setBackground(new Color(190,100,250));
        // frame.getContentPane().setBackground(new Color(0x123456));
        frame.setLayout(null);
        frame.add(label);// use pack method after label only other wise it didn't work
        // frame.pack(); // use to show label in its default size intially then we can increase or decrese 
        frame.add(label1);
    }
}
