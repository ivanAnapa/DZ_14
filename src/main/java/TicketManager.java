import java.util.Arrays;

public class TicketManager {


    private Ticket[] tickets = new Ticket[0];

    public void add(Ticket newTicket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        tmp[tmp.length - 1] = newTicket;
        tickets = tmp;
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];

        for (Ticket ticket : tickets) {

            if (ticket.matches(from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;

            }
        }
        Arrays.sort(result);
        return result;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public Ticket[] deleteByID(int id) {

        if (findById(id) == null) {
            throw new NotFoundException("Ticket with id: " + id + " not found");
        }
        Ticket[] result = new Ticket[tickets.length - 1];
        int count = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                result[count] = ticket;
                count++;
            }
            tickets = result;
        }
        return tickets;
    }

}
