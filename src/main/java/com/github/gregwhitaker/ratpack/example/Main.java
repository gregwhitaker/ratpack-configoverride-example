package com.github.gregwhitaker.ratpack.example;

import com.github.gregwhitaker.ratpack.example.core.config.DatabaseConfiguration;
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
                        .env()
                        .yaml("config.yaml")
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
