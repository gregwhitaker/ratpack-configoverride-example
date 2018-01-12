package com.github.gregwhitaker.ratpack.example.api;

import com.github.gregwhitaker.ratpack.example.api.message.GetMessageHandler;
import ratpack.func.Action;
import ratpack.handling.Chain;

/**
 * All API endpoints hosted by the application.
 */
public class Endpoints implements Action<Chain> {

    @Override
    public void execute(Chain chain) throws Exception {
        chain.path("messages/:id", GetMessageHandler.class);
    }
}
