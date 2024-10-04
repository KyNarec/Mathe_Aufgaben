import java.util.Objects;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {
        String os = System.getProperty("os.name");
        if (Objects.equals(os, "Windows 10") | Objects.equals(os, "Windows 11")){
            GUI gui = new GUI(325,350);
        } else if (Objects.equals(os, "Linux")){
            GUI gui = new GUI(300,300);
        } else {
            throw new Exception("Your os could not be identified and/or has no dedicated release. Supported os's are 'Windows' and 'Linux'.");
        }
    }

    public static String getOperatingSystem(){
        return System.getProperty("os.name");
    }

    public static void alt(){
        Scanner in = new Scanner(System.in);
        AUFGABEN AUFGABEN = new AUFGABEN();
        System.out.print("What programm do you want to use? anzahlBegruessungen(1) fak_rek(2) fak_in(3) bak_rek(4) bak_in(5):");
        int x = in.nextInt();
        switch (x) {
            case 1 -> {
                System.out.print("You selected anzahlBegruessungen. Please enter the number the program should use:");
                int n = in.nextInt();
                System.out.println(AUFGABEN.anzahlBegruessungen(n));
            }
            case 2 -> {
                System.out.print("You selected fak_rek. Please enter the number the program should use:");
                int n = in.nextInt();
                System.out.println(AUFGABEN.fak_rek(n));
            }
            case 3 -> {
                System.out.print("You selected fak_in. Please enter the number the program should use:");
                int n = in.nextInt();
                System.out.print(AUFGABEN.fak_in(n));
            }
            case 4 -> {
                System.out.print("You selected bak_rek. Please enter the number the program should use:");
                int n = in.nextInt();
                System.out.print("Thank you, additionally you may specify a starting number:");
                int a = in.nextInt();
                System.out.print(AUFGABEN.bak_rek(n,a));
            }
            case 5 -> {
                System.out.print("You selected bak_in. Please enter the number the program should use:");
                int n = in.nextInt();
                System.out.print("Thank you, additionally you may specify a starting number:");
                int a = in.nextInt();
                System.out.print(AUFGABEN.bak_in(n,a));
            }
        }
    }
}
