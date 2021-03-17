package com.hakimen;

import com.hakimen.entity.CalendarEvent;
import com.hakimen.listeners.DiscordListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) throws LoginException {
          JDA jda = JDABuilder.createDefault("NAO ROUBA MINHA KEY TA OKEY ??").build();
          jda.addEventListener(new DiscordListener());
    }
}
