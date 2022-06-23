package com.example.back.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.back.models.Event;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class EventController {

    private List<Event> events = new ArrayList<>();
    private AtomicLong nextId = new AtomicLong();

    @PostMapping("/event")
    public Event creatForm(@RequestBody Event event) {
        Event e = event;
        e.setId((int) nextId.incrementAndGet());
        events.add(e);
        return e;
    }

    @GetMapping("/getevents")
    public List<Event> getEvents(){
        return events;
    }

}
