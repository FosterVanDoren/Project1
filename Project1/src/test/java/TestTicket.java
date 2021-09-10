import java.sql.SQLException;
import java.util.List;


import org.junit.jupiter.api.Test;
import com.troy.Ticket;
import com.troy.TicketDAO;
import com.troy.TicketDAOFactory;

public class TestTicket {
	
	@Test
	public void Test() throws SQLException {
	TicketDAO dao = TicketDAOFactory.getTicketDao();
	List<Ticket> tickets = dao.getTickets();
	for(Ticket ticket: tickets) {
		System.out.println(ticket.getTransId());
	}
	}
}
