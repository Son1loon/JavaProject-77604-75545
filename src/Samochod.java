
public class Samochod extends Pojazd {

    private boolean klimatyzacja;

    public Samochod(String marka, String model, int rokProdukcji, double cenaZaDzien, boolean klimatyzacja) {
        super(marka, model, rokProdukcji, cenaZaDzien);
        this.klimatyzacja = klimatyzacja;
    }

    public boolean isKlimatyzacja() {
        return klimatyzacja;
    }

    @Override
    public TypPojazdu getTypPojazdu() {
        return TypPojazdu.SAMOCHOD;
    }

    @Override
    public double obliczKoszt(int dni) {
        if (dni <= 0) {
            throw new IllegalArgumentException("Liczba dni musi byc dodatnia");
        }
        return getCenaZaDzien() * dni;
    }

    @Override
    public String toString() {
        return super.toString() + " | Klimatyzacja: " + (klimatyzacja ? "Tak" : "Nie");
    }
}
