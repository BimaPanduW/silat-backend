package com.bima.silat.controllers;


import com.bima.silat.StandardResponse;
import com.bima.silat.StatusResponse;
import com.bima.silat.services.UserService;
import com.bima.silat.services.entities.User;
import com.bima.silat.services.impl.UserServiceImpl;
import com.google.gson.Gson;

import static spark.Spark.get;
import static spark.Spark.post;

public class UserController {

    public UserController() {
        UserService userService = new UserServiceImpl();

        post("/users", (req, res) -> {
            res.type("application/json");
            User user = new Gson().fromJson(req.body(), User.class);

            userService.addUser(user);
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
        });

        get("/users", (req, res) -> {
           res.type("application/json");

           return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,
                   new Gson().toJsonTree(userService.getUsers())));
        });
    }
}
