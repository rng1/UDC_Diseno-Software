package e1;

public class StringCount {

    //String of the elements we consider symbols
    private static final String CMP = "?@#$.,";

    public static int countWords(String text) {
        int count = 0; //counter
        if(text == null){ return count;} //if there is no text return 0
        char[] ch = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            ch[i] = text.charAt(i);
            if (((i > 0) && (ch[i] != ' ') && (ch[i - 1] == ' ')) || ((ch[0] != ' ') && (i == 0))) //check for any kind of space
                count++;
        }
        return count;
    }

    public static int countChar(String text, char c) {
        int count = 0; //counter
        if(text == null){ return count;} //if there is no text return 0
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == c) //check for the same character
                count++;
        }
        return count;
    }

    public static int countCharIgnoringCase(String text, char c) {
        int count = 0; //counter
        if(text == null){ return count;}
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == Character.toUpperCase(c) || text.charAt(i) == Character.toLowerCase(c)) //check for the same character in upper and lower case
                count++;
        }
        return count;
    }

    public static boolean isPasswordSafe(String password) {
        boolean upper = false, lower = false, digit = false, symbol = false; //variables to check if... there is an upper, lower, digit and symbol

        if (password.length() < 8) //is too short
            return false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) //there is a lower case
                lower = true;
            if (Character.isUpperCase(password.charAt(i))) //there is a upper case
                upper = true;
            if (Character.isDigit(password.charAt(i))) //there is a digit
                digit = true;
            for (int j = 0; j < CMP.length(); j++) {
                if (CMP.charAt(j) == password.charAt(i)) //there is a symbol
                {
                    symbol = true;
                    break;
                }
            }
        }
        return lower && upper && digit && symbol;
    }
}
