package com.hakimen;

import com.hakimen.entity.CalendarEvent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class EAD {
    public WebDriver driver;
    String user,pass;


    public EAD(String user,String pass,boolean headless){
        this.user = user;
        this.pass = pass;
        System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(headless);
        driver = new ChromeDriver(options);
        driver.get("https://ead.ifms.edu.br/calendar/view.php?view=upcoming");
    }
    public void Login(){
        driver.findElement(By.id("username")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("password")).submit();

    }

    public List<CalendarEvent> getCurrentEventList(){
        ArrayList<CalendarEvent> events = new ArrayList<>();
        Document calendar = Jsoup.parse(driver.getPageSource());
        Elements upcoming = calendar.getElementsByClass("calendarwrapper")
                .first()
                .getElementsByClass("eventlist")
                .first()
                .getElementsByClass("event");
        for(Element event:upcoming){
            CalendarEvent calendarEvent = new CalendarEvent();
            calendarEvent.setIcon(event.getElementsByClass("card-header").first().getElementsByClass("icon").attr("src"));
            calendarEvent.setCourseId(Integer.parseInt(event.attr("data-course-id")));
            calendarEvent.setEventId(Integer.parseInt(event.attr("data-event-id")));
            calendarEvent.setStatus(event.attr("data-event-eventtype"));
            calendarEvent.setType(event.attr("data-event-component"));
            calendarEvent.setTitle(event.attr("data-event-title"));
            Element cardBody = event.getElementsByClass("description").first();
            calendarEvent.setDate(cardBody.getElementsByTag("div").first().getElementsByTag("div").get(1).text());
            calendarEvent.setDateLink(cardBody.getElementsByTag("div").first().getElementsByTag("div").get(1).getElementsByTag("a").attr("href"));
            calendarEvent.setDescription(cardBody.getElementsByTag("div").get(2).getElementsByClass("description-content").text());
            calendarEvent.setCourse(cardBody.getElementsByTag("div").last().getElementsByClass("col-11").text());
            calendarEvent.setCourseLink(cardBody.getElementsByTag("div").last().getElementsByClass("col-11").first().getElementsByTag("a").attr("href"));
            Element eventLink = event.getElementsByClass("card-footer").first();
            if(eventLink != null){
                eventLink = event.getElementsByClass("card-link").first();
                calendarEvent.setLink(eventLink.attr("href"));
            }else{
                calendarEvent.setLink("");
            }
            events.add(calendarEvent);
        }

        return events;
    }

}
