public class randm {
    randm(){

    }
    public int anzahlBegruessungen(int personen){
        if (personen < 2){
            return 0;
        } else {
            return anzahlBegruessungen(personen - 1) + personen - 1;
        }
    }
    public int fak_rek(int n){
        if (n < 2){
            return 1;
        }
        else {
            return fak_rek(n-1)*n;
        }
    }
    public int fak_in(int n){
        int erg = 1;
        for (int i = 1; i <= n; i++ ){
            erg *= i;
        }
        return erg;
    }
    public int bak_rek(int n){
        return 1;
    }
    public int bak_in(int n){
        int erg = 1;
        for (int i = 1; i == n; i++){

        }
        return erg;
    }
}
