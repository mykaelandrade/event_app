package com.eventoapp.eventoapp.Controller;

import com.eventoapp.eventoapp.Models.Event;
import com.eventoapp.eventoapp.Models.Guest;
import com.eventoapp.eventoapp.Repository.EventRepository;
import com.eventoapp.eventoapp.Repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private GuestRepository guestRepository;

    @RequestMapping(value = "/registerEvent", method = RequestMethod.GET)
    private String form() {
        return "Event/formEvent";
    }

    @RequestMapping(value = "/registerEvent", method = RequestMethod.POST)
    private String form(Event event) {

        eventRepository.save(event);

        return "redirect:/registerEvent";
    }

    @RequestMapping("/events")
    public ModelAndView listEvent() {
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<Event> events = eventRepository.findAll();
        modelAndView.addObject("events", events);
        return modelAndView;
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public ModelAndView detailEvent(@PathVariable("code") long code) {
        Event event = eventRepository.findByCode(code);
        ModelAndView modelAndView = new ModelAndView("Event/detailEvent");
        modelAndView.addObject("event", event);
        System.out.println("event" + event);
        return modelAndView;
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.POST)
    public String detailEvent(@PathVariable("code") long code, Guest guest) {
        Event event = eventRepository.findByCode(code);
        guest.setEvent(event);
        guestRepository.save(guest);
        return "redirect:/{code}";
    }
}
