
public class Rower extends Pojazd {

    private boolean elektryczny;

    public Rower(String marka, String model, int rokProdukcji,
                 double cenaZaDzien, boolean elektryczny) {
        super(marka, model, rokProdukcji, cenaZaDzien);
        this.elektryczny = elektryczny;
    }

    public boolean isElektryczny() {
        return elektryczny;
    }

    @Override
    public TypPojazdu getTypPojazdu() {
        return TypPojazdu.ROWER;
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
        return super.toString()
                + " | Elektryczny: " + (elektryczny ? "Tak" : "Nie");
    }
}
