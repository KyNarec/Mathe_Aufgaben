public class AUFGABEN {
    AUFGABEN(){}

    public int anzahlBegruessungen(int personen){
        if (personen < 2)
            return 0;
        else return anzahlBegruessungen(personen - 1) + personen - 1;
    }

    public int fak_rek(int n){
        if (n < 2) return 1;
        return fak_rek(n-1) * n;
    }

    public int fak_it(int n){
        int erg = 1;
        for (int i = 1; i <= n; i++ ) erg *= i;
        return erg;
    }

    public int bak_rek(int n, int a){
        if(n < 1) return a;
        return bak_rek(n-1, a) * 2;
    }

    public int bak_it(int n, int a){
        int erg = a;
        for (int i = 1; i <= n; i++) erg *= 2;
        return erg;
    }

    public int hasen_rek(int n) {
        if (n < 3) return 1;
        return hasen_rek(n-1) + hasen_it(n-2);
    }

    public int hasen_it(int n) {
        int ergebnis = 1;
        if (n < 3) return 1;
        for (int i = 3; i <= n; i++) ergebnis = ergebnis * 2;
        return ergebnis;
    }
}
