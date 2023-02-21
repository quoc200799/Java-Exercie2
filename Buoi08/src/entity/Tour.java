package entity;

public class Tour {
    private Buses buses;
    private int turn;

    public Tour(Buses buses, int turn) {
        this.buses = buses;
        this.turn = turn;
    }

    public Buses getBuses() {
        return buses;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "buses=" + buses +
                ", turn=" + turn +
                '}';
    }

    public void setBuses(Buses buses) {
        this.buses = buses;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }



}
