package Bot.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class UtilCommands extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();
        MessageChannel channel = event.getChannel();
        String[] args = msg.getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase("!help")) {
            EmbedBuilder help = new EmbedBuilder();
            help.setTitle("Help", "https://discord.gg/VU7kWC9Nda");
            help.setColor(Color.ORANGE);

            help.setDescription("**!help** - Displays this message\n");

            help.addField("**!findX**", "!findX a b", true);
            help.addField("**!findY**", "!findY x expression", true);
            help.addField("**!findPoints**", "!findPoints x expression", true);
            help.addField("**!findMinOrMax**", "!findMinOrMax a", true);
            help.addField("**!findDomainRange**", "!findDomainRange a x", true);

            help.addField("**!qalc**", "!qalc expression", false);
            help.setAuthor("Qalc Tdi", "https://discord.gg/VU7kWC9Nda", "https://cdn.discordapp.com/avatars/959639967087345674/4fb685544e5f9ce5363336edcf5d5e74.png?size=256");

            help.addField("**!force**", "!force mass acceleration", true);
            help.addField("**!work**", "!work force distance | mass acceleration distance", true);
            help.addField("**!power**", "!power work time | force distance time | mass acceleration distance time", true);

            help.setFooter("Bot made by Ntdi", "https://i.imgur.com/VTc8AiA.jpeg");
            channel.sendMessageEmbeds(help.build()).queue();
        }
    }
}
