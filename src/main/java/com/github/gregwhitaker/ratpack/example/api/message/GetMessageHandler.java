package com.github.gregwhitaker.ratpack.example.api.message;

import com.github.gregwhitaker.ratpack.example.services.message.MessageService;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.handling.Context;
import ratpack.handling.Handler;

/**
 * API endpoint that returns a message to the user.
 */
public class GetMessageHandler implements Handler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetMessageHandler.class);

    @Inject
    private MessageService messageService;

    @Override
    public void handle(Context ctx) throws Exception {
        String id = ctx.getAllPathTokens().get("id");

        if (id.equalsIgnoreCase("1")) {
            LOGGER.info("Request for Message1");

            ctx.render(messageService.message1());
        } else if (id.equalsIgnoreCase("2")) {
            LOGGER.info("Request for Message2");

            ctx.render(messageService.message2());
        } else {
            LOGGER.warn("Request for Invalid Message: {}", id);

            ctx.getResponse().status(404);
            ctx.getResponse().send();
        }
    }
}
