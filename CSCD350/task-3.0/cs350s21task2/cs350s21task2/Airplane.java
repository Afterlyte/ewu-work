package cs350s21task2;

public class Airplane {
    private String id;
    private Mover mover;

    public Airplane(String id, Mover mover) {
        this.id = id;
        this.mover = mover;
    }

    public String getID() {
        return this.id;
    }

    public Mover getMover() {
        return this.mover;
    }

    public void update() {
        this.mover.update();
    }
}
