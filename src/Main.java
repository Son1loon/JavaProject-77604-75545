public class Main {

    public static void main(String[] args) {
        Pojazd[] pojazdy = {
                new Samochod("BMW", "M3", 2022, 300, true),
                new Samochod("Audi", "A4", 2020, 200, false),
                new Motocykl("Yamaha", "R1", 2021, 150, 1000),
                new Motocykl("Honda", "CBR", 2019, 120, 600),
                new Rower("Trek", "Marlin", 2023, 50, false),
                new Rower("Giant", "Explore", 2024, 80, true)
        };

        Osoba[] osoby = {
                new Klient("Arsen", "Medvid"),
                new Klient("Jan", "Kowalski"),
                new Pracownik("Adam", "Nowak", "Sprzedawca", 4500),
                new Pracownik("Piotr", "Wisniewski", "Manager", 6000)
        };
        Wypozyczalnia wypozyczalnia = new Wypozyczalnia();

        for (Pojazd pojazd : pojazdy) {
            wypozyczalnia.dodajPojazd(pojazd);
        }
        for (Osoba osoba : osoby) {
            if (osoba instanceof Klient) {
                wypozyczalnia.dodajKlienta((Klient) osoba);
            } else {
                wypozyczalnia.dodajOsobe(osoba);
            }
        }
        KonsolaUI ui = new KonsolaUI(wypozyczalnia);
        ui.uruchom();
    }
}