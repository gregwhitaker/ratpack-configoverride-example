package com.github.gregwhitaker.ratpack.example.services.message;

import com.google.inject.Singleton;

@Singleton
public class DefaultMessageService implements MessageService {

    @Override
    public String message1() {
        return null;
    }

    @Override
    public String message2() {
        return null;
    }
}
