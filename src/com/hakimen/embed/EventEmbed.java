package com.hakimen.embed;

import com.hakimen.entity.CalendarEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;

public class EventEmbed {
    CalendarEvent ev;
    public EventEmbed(CalendarEvent ev){
        this.ev = ev;
    }
    public MessageEmbed build(){
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle(ev.getTitle(),ev.getLink());
        builder.setColor(Color.GREEN);
        builder.addField("Data : "+ev.getDate(),ev.getDateLink(),false);
        builder.addField("Curso : "+ev.getCourse(),ev.getCourseLink(),false);
        builder.addField("Tipo : ",ev.getType(),false);
        builder.addField("Status : ",ev.getStatus(),false);
        builder.setDescription(ev.getDescription());
        return builder.build();
    }
}
