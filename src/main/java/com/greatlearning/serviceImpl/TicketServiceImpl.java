package com.greatlearning.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.dao.TicketRepository;
import com.greatlearning.entity.Ticket;
import com.greatlearning.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticket;

	@Override
	public List<Ticket> findAll() {
		return ticket.findAll();

	}

	@Override
	public List<Ticket> findbytitle(String title) {
		return ticket.findByTitleContainingIgnoreCase(title);
	}

	@Override
	public List<Ticket> findbyDescription(String desc) {
		return ticket.findByDescriptionContainingIgnoreCase(desc);
	}

	@Override
	public void save(Ticket _ticket) {
		ticket.save(_ticket);
	}

	@Override
	public Ticket findById(int id) {

		return ticket.findById(id).get();
	}

	@Override
	public void deleteById(int id) {

		ticket.deleteById(id);
	}

}