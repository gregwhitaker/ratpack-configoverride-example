package com.github.gregwhitaker.ratpack.example.services;

import com.github.gregwhitaker.ratpack.example.services.message.DefaultMessageService;
import com.github.gregwhitaker.ratpack.example.services.message.MessageService;
import com.google.inject.AbstractModule;

/**
 * Module responsible for wiring up all of the services within the application.
 */
public class ServicesModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MessageService.class).to(DefaultMessageService.class);
    }
}
