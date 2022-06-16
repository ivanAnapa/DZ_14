import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicketsTest {

    Ticket ticket1 = new Ticket(1, 111, "SPB", "VRN", 11);
    Ticket ticket2 = new Ticket(2, 222, "MSK", "VRN", 7);
    Ticket ticket3 = new Ticket(3, 333, "SPB", "MSK", 1);
    Ticket ticket4 = new Ticket(4, 444, "VLAD", "EKT", 15);
    Ticket ticket5 = new Ticket(5, 555, "KRD", "VLAD", 13);
    Ticket ticket6 = new Ticket(6, 666, "SPB", "VLAD", 2);
    Ticket ticket7 = new Ticket(7, 321, "VLAD", "EKT", 14);
    Ticket ticket8 = new Ticket(8, 321, "VLAD", "EKT", 13);
    Ticket ticket9 = new Ticket(9, 100, "VLAD", "EKT", 2);
    Ticket ticket10 = new Ticket(10, 1234, "VLAD", "EKT", 14);


    @Test
    public void shouldFindByPortsFromTo() {
        TicketManager manager = new TicketManager();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] actual = manager.findAll("VLAD", "EKT");
        Ticket[] expected = {ticket9, ticket7, ticket8, ticket4, ticket10};
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));

        manager.deleteByID(7);
        actual = manager.findAll("VLAD", "EKT");
        Ticket[] expected2 = { ticket9, ticket8, ticket4, ticket10 };
        assertArrayEquals(expected2, actual);
        System.out.println(Arrays.toString(actual));
    }

    @Test
    public void shouldFindById() {
        TicketManager manager = new TicketManager();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket actual = manager.findById(3);
        Ticket expected = ticket3;
        assertEquals(expected, actual);
        System.out.println(actual);
    }

    @Test
    public void shouldGetExceptionWhenDeleteByWrongId() {

        TicketManager manager = new TicketManager();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Assertions.assertThrows(NotFoundException.class, () -> {
            manager.deleteByID(22);
        });
    }

}
