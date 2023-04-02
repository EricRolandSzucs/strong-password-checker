import java.util.Scanner;

public class PasswordChecker {

    public static int makePasswordStrong(String password) {

        int stringLength = password.length();
        
        char[] characters = password.toCharArray();
        
        boolean[] changesNeeded = {false, false, false};
        
        for(int i = 0; i<stringLength;i++) {
            if(Character.isLowerCase(characters[i])) {
                changesNeeded[0] = true;
            } else if (Character.isUpperCase(characters[i])) {
                changesNeeded[1] = true;
            } else if (Character.isDigit(characters[i])) {
                changesNeeded[2] = true;
            }
        }
        
        int neededChanges = (changesNeeded[0] ? 0 : 1) + (changesNeeded[1] ? 0 : 1) + (changesNeeded[2] ? 0 : 1);

        int repeating = 1;
        int changes = 0;
        int oneRemoval = 0;
        int twoRemovals = 0;

        for(int i = 1; i<=stringLength;i++) {
            if(i == stringLength || characters[i] != characters[i-1]) {
                if(repeating > 2) {
                    changes += repeating / 3;
                    if(repeating % 3 == 0)
                        oneRemoval++;
                    else if(repeating % 3 == 1)
                        twoRemovals++;
                }
                repeating = 1;
            } else if(characters[i] == characters[i-1]) {
                repeating++;
            }

        }
        if(stringLength < 20)
            return Math.max(Math.max(changes,neededChanges), 6 - stringLength);
        else {
            int toDelete = stringLength - 20;
            changes -= Math.min(toDelete, oneRemoval);
            changes -= Math.min(Math.max(toDelete - oneRemoval, 0), twoRemovals * 2) / 2;
            changes -= Math.max(toDelete - oneRemoval - 2 * twoRemovals, 0) / 3;
            return toDelete + Math.max(neededChanges, changes);
        }
    }
    public static void main(String[] argv) {
        System.out.println("""
                Rules of a strong password:
                1. Must contain at least 6 characters and at most 20 characters.
                2. Must contain at least one lowercase letter, at least one uppercase letter, and at least one
                digit.
                3. Must NOT contain three repeating characters in a row enter a password.
                
                Please enter a password: \s""");

        Scanner sc = new Scanner(System.in);

        System.out.println("Changes needed: " + makePasswordStrong(sc.nextLine()));

    }
}
