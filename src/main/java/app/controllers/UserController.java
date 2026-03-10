package app.controllers;

import app.exceptions.DatabaseException;
import app.persistence.ConnectionPool;
import app.persistence.UserMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class UserController {

    public static void addRoutes(Javalin app, ConnectionPool connectionPool){
        app.get("/createuser", ctx -> ctx.render("createuser.html"));
        app.post("/createuser", ctx -> createUser(ctx, connectionPool));
    }

    public static void createUser(Context ctx, ConnectionPool connectionPool){
        // hent data fra HTML form
        String username = ctx.formParam("username");
        String password = ctx.formParam("password");

        // oprette bruger i DB
        try {
            UserMapper.createuser(username, password, connectionPool);
            // tilbage til forside
            ctx.render("index.html");
        } catch (DatabaseException e) {
            ctx.render("createuser.html");
        }

    }
}
