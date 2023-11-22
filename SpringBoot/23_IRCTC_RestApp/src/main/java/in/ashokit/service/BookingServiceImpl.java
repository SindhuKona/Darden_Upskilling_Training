package in.ashokit.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import in.ashokit.request.Passenger;
import in.ashokit.response.Ticket;

@Service
public class BookingServiceImpl implements BookingService {
	private Integer ticketNumber = 1;
	private Map<Integer, Ticket> ticketsMap = new HashMap<>();

	@Override
	public Ticket bookTicket(Passenger passenger) {
		Ticket t = new Ticket();
		BeanUtils.copyProperties(passenger, t);
		t.setTicketCost(2000.00);
		t.setStatus("Confirmed");
		t.setTicketNumber(ticketNumber);
		ticketsMap.put(ticketNumber, t);
		ticketNumber++;

		return t;

	}

	@Override
	public Ticket getTicket(Integer ticketNumber) {
		if (ticketsMap.containsKey(ticketNumber)) {
			return ticketsMap.get(ticketNumber);
		}
		return null;
	}
}
