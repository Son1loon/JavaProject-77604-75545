public class Pracownik extends Osoba{
    private String stanowisko;
    private double pensja;

    public Pracownik(String imie, String nazwisko, String stanowisko, double pensja) {
        super(imie, nazwisko);

        this.stanowisko = stanowisko;
        this.pensja = pensja;

    }

    public String obsluz(Wypozyczenie wypozyczenie) {
        return "Sprzedawca " + getImie() + " (" + stanowisko + ") obsluzyl: " + wypozyczenie;
    }

    @Override
    public String opis() {
        return "Pracownik: " + getImie() + " " + getNazwisko() + ", stanowisko: " + stanowisko + ", pensja: " + pensja;
    };
}
