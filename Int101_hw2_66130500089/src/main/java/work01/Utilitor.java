
package work01;

public class Utilitor {
    
     public static String testString(String value) { 
        if (value == null) {
            throw new NullPointerException();
        }
        if (value.isBlank()) {
            throw new IllegalArgumentException();
        }
        return value;
    }

    public static double testPositive(double value) { 
        if (value >= 0) {
            return value;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static int computeIsbn10(long isbn10) { 
        int sum = 0; // 
        int digit;
        for (int i = 1; i < 10; i++) {
            digit = ((int) isbn10) % 10; 
            isbn10 = ((int) isbn10) / 10; 
            sum += digit * (i + 1); 

        }
        sum %= 11; 
        return 11 - sum; 
    }
}

