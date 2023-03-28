import java.util.*;

public class PasswordGenerator {
    // initialising all the characters
    static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String NUMERIC_CHARS = "0123456789";
    static final String SPECIAL_CHARS = "!@#$%^&*()_-+={}[]\\|:;\"'<>,.?/";

    // generate password function
    public static String generateStrongPassword(int length) {
        String validChars = LOWERCASE_CHARS + UPPERCASE_CHARS + NUMERIC_CHARS + SPECIAL_CHARS;
        Random random = new Random();
        StringBuilder password = new StringBuilder();


        for (int i = 0; i < length; i++) {
            password.append(validChars.charAt(random.nextInt(validChars.length())));
        }

        return password.toString();
    }

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your password :- ");
    String pass = sc.nextLine();
    int passwordLength = 12;
    String password = PasswordGenerator.generateStrongPassword(passwordLength);
    System.out.println("Your new strong password is: " + pass+ password);
    sc.close();
}
}