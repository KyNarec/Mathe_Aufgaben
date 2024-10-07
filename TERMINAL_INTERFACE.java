import java.util.Scanner;

public class TERMINAL_INTERFACE {

    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        AUFGABEN AUFGABEN = new AUFGABEN();
        String options = "What programm do you want to use? anzahlBegruessungen(1) fak_rek(2) fak_it(3) bak_rek(4) bak_it(5) hasen_rek(6) hasen_it(7):";
        System.out.print(CYAN + options + YELLOW);
        int x = in.nextInt();

        switch (x) {
            case 1 -> {
                System.out.print("You selected anzahlBegruessungen. Please enter the number the program should use:");
                int n = in.nextInt();
                result(AUFGABEN.anzahlBegruessungen(n));
            }
            case 2 -> {
                System.out.print("You selected fak_rek. Please enter the number the program should use:");
                int n = in.nextInt();
                result(AUFGABEN.fak_rek(n));
            }
            case 3 -> {
                System.out.print("You selected fak_it. Please enter the number the program should use:");
                int n = in.nextInt();
                result(AUFGABEN.fak_it(n));
            }
            case 4 -> {
                System.out.print("You selected bak_rek. Please enter the number the program should use:");
                int n = in.nextInt();
                System.out.print("Thank you, additionally you may specify a starting number:");
                int a = in.nextInt();
                result(AUFGABEN.bak_rek(n, a));
            }
            case 5 -> {
                System.out.print("You selected bak_it. Please enter the number the program should use:");
                int n = in.nextInt();
                System.out.print("Thank you, additionally you may specify a starting number:");
                int a = in.nextInt();
                result(AUFGABEN.bak_it(n, a));
            }
            case 6 -> {
                System.out.print("You selected hasen_rek. Please enter the number the program should use:");
                int n = in.nextInt();
                result(AUFGABEN.hasen_rek(n));
            }
            case 7 -> {
                System.out.print("You selected hasen_it. Please enter the number the program should use:");
                int n = in.nextInt();
                result(AUFGABEN.hasen_it(n));
            }
            default -> System.out.println(RED + "You did not provide a valid number, exiting..." + RESET);
        }
    }

    public static void result(int res){
        System.out.println(GREEN + "Your result: " + res);
    }
}
