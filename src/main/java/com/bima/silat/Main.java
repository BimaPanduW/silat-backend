package com.bima.silat;

import com.bima.silat.controllers.UserController;
import com.bima.silat.managers.DataBaseManager;
import spark.Spark;

import static spark.Spark.get;


public class Main {

    public static void main(String[] args) {
        DataBaseManager baseManager = new DataBaseManager();

        get("/ping", (req, res) -> "Hello geng!");

        Spark.before((request, response) -> {
            response.header("Content-Type", "application/json");
        });

        Spark.after((request, response) -> {
            response.header("Content-Type", "application/json");
        });

        new UserController();

    }
}
