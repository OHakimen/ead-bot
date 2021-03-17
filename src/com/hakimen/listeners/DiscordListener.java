package com.hakimen.listeners;

import com.hakimen.EAD;
import com.hakimen.embed.EventEmbed;
import com.hakimen.entity.CalendarEvent;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.UpdateEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class DiscordListener extends ListenerAdapter {
    long updateInterval = 60000 ;

    @Override
    public void onGenericUpdate(@NotNull UpdateEvent<?, ?> event) {
        ArrayList<String> ids = new ArrayList<>();
        List<Guild> guilds = event.getJDA().getGuilds();
        for (Guild g:guilds) {
            for(TextChannel t:g.getTextChannels()){
                if(t.getName().equals("ead-thread")){
                    ids.add(t.getId());
                    break;
                }
            }
        }
        if(!ids.isEmpty()) {
            Thread t = new Thread("AutoMessage") {
                @Override
                public void run() {
                    boolean isRunning = true;
                    while(isRunning){
                    try {
                        Thread.sleep(updateInterval);
                        EAD e = new EAD("05517614159","Lilica3461",true);
                        e.Login();
                        List<CalendarEvent> events = e.getCurrentEventList();
                        e.driver.close();

                        for (int i = 0; i < ids.size(); i++) {
                            for (CalendarEvent ev:events) {
                                MessageEmbed embedToSend = new EventEmbed(ev).build();
                                event.getJDA().getTextChannelsByName("ead-thread",true).get(i).sendMessage(embedToSend).queue();
                            }
                        }
                        } catch (Exception e) {
                            e.printStackTrace();
                            isRunning = false;
                        try {
                            this.join();
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                    }
                    }
                }
            };
            t.start();
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
       if(event.getAuthor().isBot()) return;
       Message msg = event.getMessage();
       MessageChannel channel = msg.getChannel();
       if(msg.getContentDisplay().startsWith("!update")){
           updateInterval = Long.parseLong(msg.getContentDisplay().replace("!update ",""));
           channel.sendMessage("Timer set to : "+updateInterval+" ms per update").queue();
       }
    }
}
