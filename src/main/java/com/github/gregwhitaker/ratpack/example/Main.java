package com.github.gregwhitaker.ratpack.example;

import com.github.gregwhitaker.ratpack.example.api.ApiModule;
import com.github.gregwhitaker.ratpack.example.api.Endpoints;
import com.github.gregwhitaker.ratpack.example.core.config.MessagesConfiguration;
import com.github.gregwhitaker.ratpack.example.services.ServicesModule;
import ratpack.guice.Guice;
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
                        .require("/messages", MessagesConfiguration.class)
                        .baseDir(BaseDir.find()).build())
                .registry(Guice.registry(b -> b
                        .module(ApiModule.class)
                        .module(ServicesModule.class))
                )
                .handlers(chain -> chain
                        .insert(Endpoints.class)
                )
        );
    }
}
