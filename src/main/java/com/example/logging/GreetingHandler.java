package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import reactor.core.publisher.Mono;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
@Component
public class GreetingHandler {
    
    Journal journal;
    private static final Logger Logger = LoggerFactory.getLogger(GreetingHandler.class);

    @Autowired
    public GreetingHandler(Journal journal) {
        this.journal = journal;
    }
    


    @GetMapping("/greeting")
    Mono<ServerResponse> greeting(ServerRequest request) {
        journal.log("Message sent to journal DB");
        Logger.error("Something else is wrong here");
        return ServerResponse.ok().contentType(TEXT_PLAIN).body(fromObject("Hello World!"));
    }
}
