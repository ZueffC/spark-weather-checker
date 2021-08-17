import  org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.*;

public class Parser {
    public static String get_worldweather(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        Elements elems = document.select(".current");
        return (elems).toString();
    }

    public static String get_gismetio(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        Elements elems = document.select("div.tab.tooltip");
        return (elems).toString();
    }

    public static String get_yandex(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        Elements elems = document.select("div.climate-calendar-day_current_day");
        return (elems).toString();
    }
    public static void main(String[] args){

    }
}
