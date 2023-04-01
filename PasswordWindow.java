import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class PasswordWindow extends JFrame implements ActionListener {

    private JTextField usernameField, passwordField;
    private JButton generateButton;
    
    public PasswordWindow() {
        super("Password Window");
        setLocationRelativeTo(null);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        JLabel usernameLabel = new JLabel("Username:");
        panel.add(usernameLabel);
        usernameField = new JTextField(15);
        usernameField.setHorizontalAlignment(JTextField.CENTER);
        panel.add(usernameField);
        
        JLabel passwordLabel = new JLabel("Password:");
        panel.add(passwordLabel);
        passwordField = new JTextField(15);
        passwordField.addActionListener(this);
        panel.add(passwordField);
        
        generateButton = new JButton("Submit");
        generateButton.addActionListener(this);
        panel.add(generateButton);

        panel.setAlignmentX(CENTER_ALIGNMENT);
        panel.setAlignmentY(CENTER_ALIGNMENT);
        
        add(panel);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == passwordField || e.getSource() == generateButton) {
            String password = passwordField.getText();
            if (password.length() > 0) {
                // Check the strength of the password here and suggest a stronger password if needed
                int len=12;
                String suggestedPassword = generateStrongPassword(len);
                JOptionPane.showMessageDialog(this, "Your password is not strong enough. Please use this password\n" + (password+suggestedPassword));
            }
        }
    }
    static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String NUMERIC_CHARS = "0123456789";
    static final String SPECIAL_CHARS = "!@#$%^&*()_-+={}[]\\|:;\"'<>,.?/";

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
