package temp;

import java.util.List;

public class Operator {

    private List<Zgloszenie> zgloszenia;



    public Zlecenie dodajZgloszenie(Zgloszenie zgloszenie) {

        zgloszenia.add(zgloszenie);

        return new Zlecenie(zgloszenie);

    }

    public void dodajNowaBrygadeDoZglosznie(Zgloszenie zgloszenie) {

        zgloszenie.setBrygada(new Brygada());
    }
}
