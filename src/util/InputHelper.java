package util;

import java.util.Scanner;


public class InputHelper {

    private static final Scanner scanner = new Scanner(System.in);


    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("  Please enter a number: ");
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine(); // flush
        return val;
    }

    public static void close() {
        scanner.close();
    }
}