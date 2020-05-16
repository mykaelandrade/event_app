package com.eventoapp.eventoapp.Controller;

import com.eventoapp.eventoapp.Models.Event;
import com.eventoapp.eventoapp.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

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
}
