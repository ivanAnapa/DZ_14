import java.util.Objects;

public class Ticket implements Comparable<Ticket> {

    private int id;
    private int cost;
    private String from;
    private String to;
    private int flyingTime;

    Ticket[] tickets = new Ticket[0];

    public Ticket(int id, int cost, String from, String to, int flyingTime) {
        this.id = id;
        this.cost = cost;
        this.from = from;
        this.to = to;
        this.flyingTime = flyingTime;
    }


    public int getId() {
        return id;
    }

    public Boolean matches(String from, String to) {
        return this.from.contains(from) && this.to.contains(to);
    }

    @Override
    public String toString() {
        return "Рейс с ID: " + id;
    }

    @Override
    public int compareTo(Ticket ticket) {
        if (cost < ticket.cost) {
            return -1;
        }
        if (cost > ticket.cost) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return
                cost == ticket.cost
                        && flyingTime == ticket.flyingTime
                        && Objects.equals(from, ticket.from)
                        && Objects.equals(to, ticket.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, from, to, flyingTime);
    }
}
