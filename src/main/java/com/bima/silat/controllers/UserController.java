package com.bima.silat.controllers;


import com.bima.silat.StandardResponse;
import com.bima.silat.StatusResponse;
import com.bima.silat.services.UserService;
import com.bima.silat.services.entities.User;
import com.bima.silat.services.impl.UserServiceImpl;
import com.google.gson.Gson;

import static spark.Spark.*;

public class UserController {

    public UserController() {
        UserService userService = new UserServiceImpl();

        post("/users", (request, response) -> {
            response.type("application/json");
            User user = new Gson().fromJson(response.body(), User.class);

            userService.addUser(user);
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
        });

        get("/users", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,
                    new Gson().toJsonTree(userService.getUsers())));
        });

        get("/users/:id", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,
                    new Gson().toJsonTree(userService.getUser(request.params(":id")))));
        });

        put("/users/:id", (request, response) -> {
            response.type("application/json");
            User toEdit = new Gson().fromJson(request.body(), User.class);
            User editedUser = userService.editUser(toEdit);

            if (editedUser != null) {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.SUCCESS,new Gson()
                                .toJsonTree(editedUser)));
            } else {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.ERROR,new Gson()
                                .toJson("User not found or error in edit")));
            }
        });

        delete("/users/:id", (request, response) -> {
            response.type("application/json");
            userService.deleteUser(request.params(":id"));
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, "user deleted"));
        });

        options("/users/:id", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS,
                            (userService.userExist(
                                    request.params(":id"))) ? "User exists" : "User does not exists" ));
        });
    }
}
