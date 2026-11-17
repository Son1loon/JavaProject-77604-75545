public class Wypozyczenie {
    private Klient klient;
    private Pojazd pojazd;
    private int liczbaDni;
    private static int liczbaWypozyczen = 0;

    public Wypozyczenie (Klient klient, Pojazd pojazd, int liczbaDni) {
        if (klient == null || pojazd == null) {
            throw new IllegalArgumentException("Klient i pojazd nie moga byc null");
        }

        if (liczbaDni <= 0) {
            throw new IllegalArgumentException("Liczba dni musi byc dodatnia");
        }

        this.klient = klient;
        this.pojazd = pojazd;
        this.liczbaDni = liczbaDni;
        liczbaWypozyczen++;
    }

    public Klient getKlient() {
        return klient;
    }
    public Pojazd getPojazd() {
        return pojazd;
    }
    public int getLiczbaDni() {
        return liczbaDni;
    }

    public static int getLiczbaWypozyczen() {
        return liczbaWypozyczen;
    }

    public double obliczKoszt() {
        return pojazd.obliczKoszt(liczbaDni);
    }

    @Override
    public String toString() {
        return "Klient: " + klient.getImie() + " " + klient.getNazwisko() + " | Pojazd: " + pojazd + " | Dni: " + liczbaDni + " | Koszt: " + obliczKoszt() + " PLN";
    }
}
