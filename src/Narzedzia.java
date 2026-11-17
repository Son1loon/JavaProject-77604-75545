import java.util.List;

public class Narzedzia {
    public static <T> void wyswietlListe(List<T> lista) {
        for (T element : lista) {
            System.out.println(element);
        }
    }

    public static void wyswietlTytul(String tytul) {
        System.out.println(tytul);
    }
}