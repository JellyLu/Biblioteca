package tools;

import java.util.Scanner;

/**
 * Created by yjlu@thoughtworks.com on 7/24/16.
 */
public class ConsoleTool {
    public static void logln(String outPutString) {
        System.out.println(outPutString);
    }

    public static void log(String outPutString) {
        System.out.print(outPutString);
    }

    public static String inputFromConsole() {
        Scanner scan = new Scanner(System.in);

        return scan.nextLine();
    }
}
