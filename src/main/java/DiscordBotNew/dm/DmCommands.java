package DiscordBotNew.dm;

import ideaeclipse.DiscordAPI.bot.IDiscordBot;
import ideaeclipse.DiscordAPI.bot.objects.channel.Field;
import ideaeclipse.DiscordAPI.bot.objects.message.IMessage;
import ideaeclipse.DiscordAPI.bot.objects.role.IRole;
import ideaeclipse.DiscordAPI.bot.objects.user.IDiscordUser;
import ideaeclipse.customTerminal.CommandsClass;
import ideaeclipse.customTerminal.Executable;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DmCommands implements CommandsClass {

    @Executable
    public String modMail(final IDiscordBot bot, final IMessage message, final String string) {
        StringBuilder builder = new StringBuilder();
        builder.append("<N>Message From: ").append(message.getUser().getUsername()).append("</N>");
        builder.append("<V>").append(string).append("</V>");
        List<IDiscordUser> userList = new LinkedList<>();
        final IRole admin = bot.getRoles().getByK2("Admin");
        for (Map.Entry<Long, IDiscordUser> entry : bot.getUsers().getK1VMap().entrySet()) {
            if (entry.getValue().getRoles().containsKey1(admin.getId())) {
                userList.add(entry.getValue());
            }
        }
        for (IDiscordUser user : userList) {
            bot.createDmChannel(user).sendEmbed(Field.parser(String.valueOf(builder)), "https://i.imgur.com/J2l5tvk.png");
        }
        return "message received";
    }
}
