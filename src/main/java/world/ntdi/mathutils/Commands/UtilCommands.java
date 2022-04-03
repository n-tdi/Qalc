package world.ntdi.mathutils.Commands;

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
            if (args.length == 1) {
                channel.sendMessageEmbeds(basicHelp().build()).queue();
            } else if (args.length == 2) {
                if (args[1].equalsIgnoreCase("quadratic")) {
                    channel.sendMessageEmbeds(quadraticHelp().build()).queue();
                } else if (args[1].equalsIgnoreCase("basic")) {
                    channel.sendMessageEmbeds(basicMathHelp().build()).queue();
                } else if (args[1].equalsIgnoreCase("physics")) {
                    channel.sendMessageEmbeds(physicsHelp().build()).queue();
                }
            } else {
                channel.sendMessageEmbeds(basicHelp().build()).queue();
            }
        }
    }

    public EmbedBuilder basicHelp() {
        EmbedBuilder help = new EmbedBuilder();
        help.setTitle("Help", "https://discord.gg/VU7kWC9Nda");
        help.setColor(Color.ORANGE);
        help.setAuthor("Qalc Tdi", "https://discord.gg/VU7kWC9Nda", "https://cdn.discordapp.com/avatars/959639967087345674/4fb685544e5f9ce5363336edcf5d5e74.png?size=256");
        help.setDescription("Get all the **juicy** info of the commands here!");
        help.addField("**!help quadratic**", "show the help embed for quadratic commands", true);
        help.addField("**!help basic**", "show the help embed for basic math commands", true);
        help.addField("**!help physics**", "show the help embed for physics commands", true);

        help.setFooter("Bot made by Ntdi", "https://i.imgur.com/VTc8AiA.jpeg");
        return help;
    }

    public EmbedBuilder basicMathHelp() {
        String expr = "[expression](https://d138zd1ktt9iqe.cloudfront.net/media/seo_landing_files/expression-vs-equation-1618895944.png)";
        EmbedBuilder help = new EmbedBuilder();
        help.setTitle("Help", "https://discord.gg/VU7kWC9Nda");
        help.setColor(Color.ORANGE);
        help.setAuthor("Qalc Tdi", "https://discord.gg/VU7kWC9Nda", "https://cdn.discordapp.com/avatars/959639967087345674/4fb685544e5f9ce5363336edcf5d5e74.png?size=256");
        help.setDescription("Get all the **juicy** info of the quadratic commands here!");

        help.addField("**!qalc**", "!qalc " + expr, false);

        help.setFooter("Bot made by Ntdi", "https://i.imgur.com/VTc8AiA.jpeg");
        return help;
    }

    public EmbedBuilder quadraticHelp() {
        String a = "[a](https://d138zd1ktt9iqe.cloudfront.net/media/seo_landing_files/quadratic-equations-01-1620383155.png)";
        String b = "[b](https://d138zd1ktt9iqe.cloudfront.net/media/seo_landing_files/quadratic-equations-01-1620383155.png)";
        String expr = "[expression](https://d138zd1ktt9iqe.cloudfront.net/media/seo_landing_files/expression-vs-equation-1618895944.png)";
        String x = "[x](https://d138zd1ktt9iqe.cloudfront.net/media/seo_landing_files/quadratic-equations-01-1620383155.png)";
        EmbedBuilder help = new EmbedBuilder();
        help.setTitle("Help", "https://discord.gg/VU7kWC9Nda");
        help.setColor(Color.ORANGE);
        help.setAuthor("Qalc Tdi", "https://discord.gg/VU7kWC9Nda", "https://cdn.discordapp.com/avatars/959639967087345674/4fb685544e5f9ce5363336edcf5d5e74.png?size=256");
        help.setDescription("Get all the **juicy** info of the quadratic commands here!");

        help.addField("**!findAll**", "!findAll " + a + " " + b + " " + expr, true);
        help.addField("**!findAnswer**", "!find " + expr, true);
        help.addField("**!findX**", "!findX " + a + " " + b, true);
        help.addField("**!findY**", "!findY " + x + " " + expr, true);
        help.addField("**!findPoints**", "!findPoints " + x + " " + expr, true);
        help.addField("**!findMinOrMax**", "!findMinOrMax " + a, true);
        help.addField("**!findDomainRange**", "!findDomainRange " + a + " " + x, true);

        help.setFooter("Bot made by Ntdi", "https://i.imgur.com/VTc8AiA.jpeg");
        return help;
    }

    public EmbedBuilder physicsHelp() {
        EmbedBuilder help = new EmbedBuilder();
        help.setTitle("Help", "https://discord.gg/VU7kWC9Nda");
        help.setColor(Color.ORANGE);
        help.setAuthor("Qalc Tdi", "https://discord.gg/VU7kWC9Nda", "https://cdn.discordapp.com/avatars/959639967087345674/4fb685544e5f9ce5363336edcf5d5e74.png?size=256");
        help.setDescription("Get all the **juicy** info of the physics commands here!");

        String mass = " [mass](https://i1.wp.com/eschool.iaspaper.net/wp-content/uploads/2018/02/Difference.jpg?fit=728%2C546&ssl=1)";
        String acel = " [aceleration](https://cdn.kastatic.org/ka-perseus-images/ee08cfdce4bdba3844612f517e4daf28803f3c46.png)";
        String force = " [force](https://www.physicsclassroom.com/Class/newtlaws/u2l2a3.gif)";
        String dist = " [distance](https://cdn1.byjus.com/wp-content/uploads/2020/02/Distance-And-Displacement-2.png)";
        String work = " [work](https://i.ytimg.com/vi/i7tmmv84N7c/maxresdefault.jpg)";
        String time = " [time](https://cdn.mos.cms.futurecdn.net/9meMCxtJU3NWkh5YcPs7qG-1200-80.jpg)";

        help.addField("**!force**", "!force" + mass + acel, true);
        help.addField("**!work**", "!work" + force + dist + " |" + mass + acel + dist, true);
        help.addField("**!power**", "!power " + work + time + " |" + force + dist + time + " |" + mass + acel + dist + time, true);

        help.setFooter("Bot made by Ntdi", "https://i.imgur.com/VTc8AiA.jpeg");
        return help;
    }

    public EmbedBuilder oldEmbed() {
        String a = "[a](https://d138zd1ktt9iqe.cloudfront.net/media/seo_landing_files/quadratic-equations-01-1620383155.png)";
        String b = "[b](https://d138zd1ktt9iqe.cloudfront.net/media/seo_landing_files/quadratic-equations-01-1620383155.png)";
        String expr = "[expression](https://d138zd1ktt9iqe.cloudfront.net/media/seo_landing_files/expression-vs-equation-1618895944.png)";
        String x = "[x](https://d138zd1ktt9iqe.cloudfront.net/media/seo_landing_files/quadratic-equations-01-1620383155.png)";
        EmbedBuilder help = new EmbedBuilder();
        help.setTitle("Help", "https://discord.gg/VU7kWC9Nda");
        help.setColor(Color.ORANGE);

        help.setDescription("Get all the **juicy** info of the commands here!");

        help.addField("\n", "*Quadratic Equations*", false);


        help.addField("\n", "*Basic Math*", false);

        help.addField("**!qalc**", "!qalc " + expr, false);
        help.setAuthor("Qalc Tdi", "https://discord.gg/VU7kWC9Nda", "https://cdn.discordapp.com/avatars/959639967087345674/4fb685544e5f9ce5363336edcf5d5e74.png?size=256");

        help.addField("\n", "*Physic Equations*", false);

        String mass = " [mass](https://i1.wp.com/eschool.iaspaper.net/wp-content/uploads/2018/02/Difference.jpg?fit=728%2C546&ssl=1)";
        String acel = " [aceleration](https://cdn.kastatic.org/ka-perseus-images/ee08cfdce4bdba3844612f517e4daf28803f3c46.png)";
        String force = " [force](https://www.physicsclassroom.com/Class/newtlaws/u2l2a3.gif)";
        String dist = " [distance](https://cdn1.byjus.com/wp-content/uploads/2020/02/Distance-And-Displacement-2.png)";
        String work = " [work](https://i.ytimg.com/vi/i7tmmv84N7c/maxresdefault.jpg)";
        String time = " [time](https://cdn.mos.cms.futurecdn.net/9meMCxtJU3NWkh5YcPs7qG-1200-80.jpg)";

        help.addField("**!force**", "!force" + mass + acel, true);
        help.addField("**!work**", "!work" + force + dist + " |" + mass + acel + dist, true);
        help.addField("**!power**", "!power " + work + time + " |" + force + dist + time + " |" + mass + acel + dist + time, true);

        help.setFooter("Bot made by Ntdi", "https://i.imgur.com/VTc8AiA.jpeg");
        return help;
    }
}
