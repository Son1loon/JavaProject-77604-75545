public abstract class Osoba {
    private String imie;
    private String nazwisko;

    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    // getters
    public String getImie() {
        return imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }

    //  opis
    public abstract String opis();

    // toString
    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }
}
