package com.bima.silat;

import spark.Spark;

import static spark.route.HttpMethod.get;

public class Main {

    public static void main(String[] args) {
        Spark.get("/ping", (req, res)->"Hello geng!");

        Spark.before((request, response) -> {
            response.header("Content-Type", "application/json");
        });
        Spark.after((request, response) -> {
            response.header("Content-Type", "application/json");
        });
    }
}
