package com.greatlearning.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.entity.Ticket;
import com.greatlearning.service.TicketService;

@Controller
@RequestMapping("/admin")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/tickets")
	public String listTickets(Model model) {
		List<Ticket> ticket = ticketService.findAll();
		model.addAttribute("tickets", ticket);
		return "tickets";
	}

	@GetMapping("/tickets/search")
	public String searchTicket(@RequestParam("query") String query, Model model) {

		// get the book from the database
		List<Ticket> ticket = ticketService.findbytitle(query);

		ticket.addAll(ticketService.findbyDescription(query));

		model.addAttribute("tickets", ticket);
		return "tickets";

	}

	@GetMapping("/tickets/newTicket")
	public String newTicket(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("tickets", ticket);
		model.addAttribute("condition", true);
		return "newTicket";
	}

	@PostMapping("/tickets/newTicket")
	public String addNewTicket(@ModelAttribute("ticket") Ticket ticket, Model model) {
		ticket.setCreatedOn(LocalDate.now().toString());
		ticketService.save(ticket);

		return "redirect:/admin/tickets";
	}

	@GetMapping("/tickets/edit")
	public String editTicket(@RequestParam("id") int id, Model model) {
		Ticket ticket = ticketService.findById(id);
		model.addAttribute("tickets", ticket);
		model.addAttribute("condition", false);
		return "newTicket";
	}

	@PostMapping("/tickets/delete")
	public String deleteTicket(@RequestParam("id") int id, Model model) {
		ticketService.deleteById(id);
		return "redirect:/admin/tickets";
	}

}
