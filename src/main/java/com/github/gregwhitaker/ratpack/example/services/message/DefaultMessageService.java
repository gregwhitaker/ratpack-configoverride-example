package com.github.gregwhitaker.ratpack.example.services.message;

import com.github.gregwhitaker.ratpack.example.core.config.MessagesConfiguration;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class DefaultMessageService implements MessageService {

    private MessagesConfiguration config;

    @Inject
    public DefaultMessageService(MessagesConfiguration config) {
        this.config = config;
    }

    @Override
    public String message1() {
        return config.message1;
    }

    @Override
    public String message2() {
        return config.message2;
    }
}
