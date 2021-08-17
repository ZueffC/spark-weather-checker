import spark.template.jade.JadeTemplateEngine;
import static spark.Spark.*;
import spark.ModelAndView;

import java.util.*;
import java.lang.*;

public class Main {

    static String[] kuznechnoye  = new String[] {"https://yandex.ru/pogoda/kuznechnoe/month?via=ms", "https://www.gismeteo.ru/weather-kuznechnoye-163627/","https://world-weather.ru/pogoda/russia/kuznechnoye/"};
    static String[] priozersk    = new String[] {"https://yandex.ru/pogoda/priozersk/month?via=ms", "https://www.gismeteo.ru/weather-priozersk-3932/","https://world-weather.ru/pogoda/russia/priozersk/"};
    static String[] spb          = new String[] {"http://yandex.ru/pogoda/saint-petersburg/month","https://www.gismeteo.ru/weather-sankt-peterburg-4079/","https://world-weather.ru/pogoda/russia/saint_petersburg/"};
    static String[] sortavala    = new String[] {"https://yandex.ru/pogoda/10937/month", "https://www.gismeteo.ru/weather-sortavala-3931/", "https://world-weather.ru/pogoda/russia/sortavala/"};

    static Dictionary<String, String[]> cities = new Hashtable<>();
    static Map<String, Object> model = new HashMap<>();
    
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        
        cities.put("кузнечное",  kuznechnoye);
        cities.put("приозерск",  priozersk);
        cities.put("сортавала", sortavala);
        cities.put("спб", spb);
        staticFiles.location("/public");
        
        get("/", (req, res) ->
            new ModelAndView(model, "index"), new JadeTemplateEngine()
        );
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }

}
