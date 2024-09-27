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
        //TODO: finish that
        if(n == 0){
            return 0;
        }
        return bak_in(n-1)*2;
    }
    public int bak_in(int n){
        int erg = 0;
        for (int i = 1; i <= n; i++){
            erg += i*2;
        }
        return erg;
    }
}
