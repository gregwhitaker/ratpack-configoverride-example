package com.github.gregwhitaker.ratpack.example.api;

import com.github.gregwhitaker.ratpack.example.api.message.GetMessageHandler;
import com.google.inject.AbstractModule;

/**
 * Module responsible for wiring up all of the API endpoints within the application.
 */
public class ApiModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Endpoints.class);

        bind(GetMessageHandler.class);
    }
}
