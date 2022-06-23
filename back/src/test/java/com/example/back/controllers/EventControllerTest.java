package com.example.back.controllers;

import com.example.back.models.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import net.minidev.json.JSONStreamAwareEx;
import org.json.JSONString;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EventController.class)
class EventControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void creatForm() throws Exception{
        Event event = new Event(1, "test", "description_event", "10", "20", 3);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(event);
        MvcResult result = mvc.perform(post("/api/event").contentType(MediaType.APPLICATION_JSON)
        .content(requestJson)).andExpect(status().isOk()).andReturn();
        assertEquals(mapper.readTree(requestJson), mapper.readTree(result.getResponse().getContentAsString()));
    }


    @Test
    void getEvents() throws Exception {
        MvcResult result = mvc.perform(get("/api/getevents").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
    }
}