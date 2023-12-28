package com.greatlearning.service;

import java.util.List;

import com.greatlearning.entity.Ticket;

public interface TicketService {

	public List<Ticket> findAll();

	public List<Ticket> findbytitle(String title);

	public List<Ticket> findbyDescription(String desc);

	public void save(Ticket ticket);

	public Ticket findById(int id);

	public void deleteById(int id);

}
