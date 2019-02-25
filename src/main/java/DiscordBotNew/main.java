package DiscordBotNew;

import DiscordBotNew.dm.DmCommands;
import DiscordBotNew.generic.ChannelCommands;
import ideaeclipse.DiscordAPI.bot.DiscordBotBuilder;

public class main {
    public static void main(String[] ars) {
        new DiscordBotBuilder(ars[0]).channelCommands(new ChannelCommands()).dmCommands(new DmCommands()).setCommandChannel("rolesbot").setCommandPrefix("!").setEmbedFooter("https://i.imgur.com/J2l5tvk.png").start();
    }
}
