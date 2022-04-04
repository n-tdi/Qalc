package world.ntdi.mathutils.Listener;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;

public class JoinListener implements EventListener {
    @Override
    public void onEvent(@NotNull GenericEvent event) {
        if (event instanceof GuildMemberJoinEvent) {
            GuildMemberJoinEvent e = (GuildMemberJoinEvent) event;
            e.getGuild().getDefaultChannel().sendMessage("Welcome " + e.getMember().getAsMention() + " to the server!\nHead over to #homework-help to use botcommands\nMy base command is !help").queue();
        }
    }
}
