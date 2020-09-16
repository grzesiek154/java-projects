package temp;

public class Zgloszenie {

    private Brygada brygada;

    public Zgloszenie(Brygada brygada) {
        this.brygada = brygada;
    }

    public Brygada getBrygada() {
        return brygada;
    }

    public void setBrygada(Brygada brygada) {
        this.brygada = brygada;
    }

    public boolean isCompleted(Boolean isCompleated) {

      if(isCompleated) {
          return true;
      }
      return false;
    }
}
