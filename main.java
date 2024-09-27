import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        randm randm = new randm();
        System.out.print("What programm do you want to use? anzahlBegruessungen(1) fak_rek(2) fak_in(3) bak_rek(4) bak_in(5):");
        int x = in.nextInt();
        switch (x) {
            case 1 ->  {
                System.out.print("You selected anzahlBegruessungen. Please enter the number the program should use:");
                int n = in.nextInt();
                System.out.println(randm.anzahlBegruessungen(n));
            }
            case 2 -> {
                System.out.print("You selected fak_rek. Please enter the number the program should use:");
                int n = in.nextInt();
                System.out.println(randm.fak_rek(n));
            }
            case 3 -> {
                System.out.print("You selected fak_in. Please enter the number the program should use:");
                int n = in.nextInt();
                System.out.print(randm.fak_in(n));
            }
            case 4 -> {
                System.out.print("You selected bak_rek. Please enter the number the program should use:");
                int n = in.nextInt();
                System.out.print(randm.bak_rek(n));
            }
            case 5 -> {
                System.out.print("You selected bak_in. Please enter the number the program should use:");
                int n = in.nextInt();
                System.out.print(randm.bak_in(n));
            }
        }
    }
}
