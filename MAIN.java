import java.util.Objects;

public class MAIN {
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
}
