import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class app {

    public static void main(String[] args) {

        // root is 'src/main/resources', so put files in 'src/main/resources/public'
        staticFiles.location("/public"); // Static files

        get("/", (req, res) -> {
            res.redirect("/hello");
            return null;
        });


        get("/hello", (req, res) -> {

            Map<String, Object> map = new HashMap<>();

            // create the greeting message
            String greeting = "Hello, " + req.queryParams("username");

            // put it in the map which is passed to the template - the value will be merged into the template
            map.put("greeting", greeting);

            return new ModelAndView(map, "index.handlebars");

        }, new HandlebarsTemplateEngine());
    }
}
