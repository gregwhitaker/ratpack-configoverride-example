package com.github.gregwhitaker.ratpack.example;

import ratpack.jackson.Jackson;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;

/**
 * Starts the ratpack-configoverride-example application.
 */
public class Main {

    public static void main(String... args) throws Exception {
        RatpackServer.start(s -> s
                .serverConfig(c -> c
                        .yaml("config.yaml")  // Pulls configuration from config.yaml file
                        .env()  // Pulls configuration from environment variables
                        .require("/database", DatabaseConfiguration.class)
                        .baseDir(BaseDir.find()).build())
                .handlers(chain -> chain
                        .get("config", ctx -> {
                            ctx.render(Jackson.json(ctx.get(DatabaseConfiguration.class)));
                        })
                )
        );
    }
}
