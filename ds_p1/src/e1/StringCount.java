package e1;

public class StringCount {

    private static final String CMP = "?@#$.,";

    public static int countWords(String text) {
        int count = 0;
        if(text == null){ return count;}
        char[] ch = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            ch[i] = text.charAt(i);
            if (((i > 0) && (ch[i] != ' ') && (ch[i - 1] == ' ')) || ((ch[0] != ' ') && (i == 0)))
                count++;
        }
        return count;
    }

    public static int countChar(String text, char c) {
        int count = 0;
        if(text == null){ return count;}
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == c)
                count++;
        }
        return count;
    }

    public static int countCharIgnoringCase(String text, char c) {
        int count = 0;
        if(text == null){ return count;}
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == Character.toUpperCase(c) || text.charAt(i) == Character.toLowerCase(c))
                count++;
        }
        return count;
    }

    public static boolean isPasswordSafe(String password) {
        boolean upper = false, lower = false, digit = false, symbol = false;

        if (password.length() < 8)
            return false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i)))
                lower = true;
            if (Character.isUpperCase(password.charAt(i)))
                upper = true;
            if (Character.isDigit(password.charAt(i)))
                digit = true;
            for (int j = 0; j < CMP.length(); j++) {
                if (CMP.charAt(j) == password.charAt(i))
                {
                    symbol = true;
                    break;
                }
            }
        }
        return lower && upper && digit && symbol;
    }

    public void main(String[] args) {
        //String str1 ="A password like this is not safe";
        String str2 ="A password containing 1 symbol like # this is safe";
        char character = 'a';
        System.out.println(countWords(str2) + " words.");
        System.out.println(countChar(str2,character) + " characters found.");
        System.out.println(countCharIgnoringCase(str2,character) + " characters found.");
        if (isPasswordSafe(str2))
            System.out.println("The password is safe");
        else
            System.out.println("The password is not safe");
    }

}
