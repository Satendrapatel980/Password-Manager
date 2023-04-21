import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.util.Random;

public class PasswordWindow extends JFrame implements ActionListener {

    JTextField usernameField, passwordField;
    JButton generateButton;
    
    public PasswordWindow() {
        super("Password Window");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        JPanel panel = new JPanel();
        JLabel usernameLabel = new JLabel("Username:");
        panel.add(usernameLabel);
        usernameField = new JTextField(15);
        panel.add(usernameField);
        
        JLabel passwordLabel = new JLabel("Password:");
        panel.add(passwordLabel);
        passwordField = new JTextField(15);
        passwordField.addActionListener(this);
        panel.add(passwordField);
        
        generateButton = new JButton("Submit");
        generateButton.addActionListener(this);
        panel.add(generateButton);
        
        add(panel);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if ( e.getSource() == generateButton || e.getSource()== passwordField) {
            String password = passwordField.getText();
            if (password.length() > 0) {
                // Check the strength of the password here and suggest a stronger password if needed
                int len=8;
                String suggestedPassword = generateStrongPassword(len);
                String a = password;
                int n = a.length();
                boolean hasLower = false;
                boolean hasUpper = false;
                boolean hasDigit = false;
                boolean specialChar = false;
                
                for(int i=0;i<n;i++){
                    char ch = a.charAt(i);
                        if(Character.isUpperCase(ch)){
                            hasUpper = true;
                        }
                        else if(Character.isLowerCase(ch)){
                            hasLower=true;
                        }
                        else if(Character.isDigit(ch)){
                            hasDigit = true;
                        }
                        else {
                            if(ch == '<' || ch == '>'){
                                JOptionPane.showMessageDialog(this, "Your password is malicious");
                                return;
                            }
                            else {
                                specialChar = true;
                            }
                        }
                }
                if(a.length()>=12){
                    if(hasUpper && hasLower  && hasDigit && specialChar ){

                        JOptionPane.showMessageDialog(this, "Your password is strong enough. You can use this password");
                    }
                    else {
                        JOptionPane.showMessageDialog(this, "Your password is not strong enough. Please use this password\n" + (password+suggestedPassword));
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "Please Enter valid password...!!. You password is not of enough length(12)");
                }   
            }
            else {
                JOptionPane.showMessageDialog(this, "Please Enter password...!!");

            }
        }
    }
    String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String NUMERIC_CHARS = "0123456789";
    String SPECIAL_CHARS = "!@#$%^&*()_-+={}[]\\|:;\"'<>,.?/";

    private String generateStrongPassword(int length) {
        // Code to generate a strong password here
        String validChars = LOWERCASE_CHARS + UPPERCASE_CHARS + NUMERIC_CHARS + SPECIAL_CHARS;
        Random random = new Random();
        StringBuilder password = new StringBuilder();


        for (int i = 0; i < length; i++) {
            password.append(validChars.charAt(random.nextInt(validChars.length())));
        }

        return password.toString();
    }
    
    public static void main(String[] args) {
        new PasswordWindow();
    }
}
