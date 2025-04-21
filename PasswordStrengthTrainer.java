import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordStrengthTrainer {

    // Check if the password length is sufficient
    public static boolean checkLength(String password) {
        return password.length() >= 8;
    }

    // Check if the password contains at least one uppercase letter
    public static boolean checkUppercase(String password) {
        return password.chars().anyMatch(Character::isUpperCase);
    }

    // Check if the password contains at least one lowercase letter
    public static boolean checkLowercase(String password) {
        return password.chars().anyMatch(Character::isLowerCase);
    }

    // Check if the password contains at least one digit
    public static boolean checkDigit(String password) {
        return password.chars().anyMatch(Character::isDigit);
    }

    // Check if the password contains at least one special character
    public static boolean checkSpecialChar(String password) {
        String specialChars = "!@#$%^&*()_+={}[]:;<>,.?/~`|";
        return password.chars().anyMatch(ch -> specialChars.indexOf(ch) >= 0);
    }

    // Evaluate the strength of the password
    public static void evaluatePassword(String password) {
        System.out.println("Password Strength Evaluation:");

        int strength = 0;

        if (checkLength(password)) {
            System.out.println("✓ Length: Good");
            strength++;
        } else {
            System.out.println("✘ Length: Weak (must be at least 8 characters)");
        }

        if (checkUppercase(password)) {
            System.out.println("✓ Uppercase: Good");
            strength++;
        } else {
            System.out.println("✘ Uppercase: Add at least one uppercase letter");
        }

        if (checkLowercase(password)) {
            System.out.println("✓ Lowercase: Good");
            strength++;
        } else {
            System.out.println("✘ Lowercase: Add at least one lowercase letter");
        }

        if (checkDigit(password)) {
            System.out.println("✓ Digit: Good");
            strength++;
        } else {
            System.out.println("✘ Digit: Add at least one digit");
        }

        if (checkSpecialChar(password)) {
            System.out.println("✓ Special Character: Good");
            strength++;
        } else {
            System.out.println("✘ Special Character: Add at least one special character");
        }

        // Provide overall strength feedback
        if (strength == 5) {
            System.out.println("\n✅ Your password is strong!");
        } else if (strength == 4) {
            System.out.println("\n⚠️ Your password is medium strength.");
        } else {
            System.out.println("\n❌ Your password is weak. Consider improving it.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Password Strength Trainer!");
        System.out.print("Enter your password to check its strength: ");
        String password = scanner.nextLine();

        evaluatePassword(password);
        scanner.close();
    }
}

