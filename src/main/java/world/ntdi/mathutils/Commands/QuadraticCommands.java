package world.ntdi.mathutils.Commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.simple.parser.ParseException;
import world.ntdi.mathutils.Api.QuadraticMath;

import java.io.IOException;

public class QuadraticCommands extends ListenerAdapter {
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getGuild() == null) { return; }
        if (event.getName().equals("findx")) {
            double a = event.getOption("a").getAsDouble();
            double b = event.getOption("b").getAsDouble();
            try {
                event.reply("Here you go: x = " + QuadraticMath.getX(a, b)).queue();
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        } else if (event.getName().equals("findy")) {
            double x = event.getOption("x").getAsDouble();
            String expr = event.getOption("expression").getAsString();
            try {
                event.reply("The solution is: y = " + QuadraticMath.getY(x, expr)).queue();
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        } else if (event.getName().equals("findpoints")) {
            double x = event.getOption("x").getAsDouble();
            String expr = event.getOption("expression").getAsString();
            try {
                event.reply("Here are 5 points:\n" + QuadraticMath.getPoints5(x, expr)).queue();
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        } else if (event.getName().equals("pointtype")) {
            double a = event.getOption("a").getAsDouble();
            event.reply("The point type is: " + QuadraticMath.minOrMax(a)).queue();
        } else if (event.getName().equals("domainrange")) {
            double a = event.getOption("a").getAsDouble();
            double x = event.getOption("x").getAsDouble();
            event.reply("The domain and range is: \n" + QuadraticMath.getDomainAndRange(a, x)).queue();
        } else if (event.getName().equals("findanswer")) {
            String expr = event.getOption("expression").getAsString();
            try {
                event.reply("The answer is: " + QuadraticMath.getAnswer(expr)).queue();
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        } else if (event.getName().equals("findall")) {
            double a = event.getOption("a").getAsDouble();
            double b = event.getOption("b").getAsDouble();
            String expr = event.getOption("expression").getAsString();
            try {
                double x = QuadraticMath.getX(a, b);
                double y = QuadraticMath.getY(x, expr);
                StringBuilder sb = new StringBuilder();
                sb.append("Here is all the information you'll need:\n")
                        .append("x = ").append(x).append("\n")
                        .append("y = ").append(y).append("\n")
                        .append("Answer = ").append(QuadraticMath.getAnswer(expr)).append("\n")
                        .append("Points: ").append(QuadraticMath.getPoints5(x, expr)).append("\n")
                        .append("Domain and range: ").append(QuadraticMath.getDomainAndRange(a, x)).append("\n")
                        .append("Point type: ").append(QuadraticMath.minOrMax(a));
                event.reply(sb.toString()).queue();
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        } else if (event.getName().equals("qalc")) {
            String expr = event.getOption("expression").getAsString();
            try {
                event.reply("The answer is: " + QuadraticMath.getAnswer(expr)).queue();
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        } else if (event.getName().equals("discriminant")) {
            double a = event.getOption("a").getAsDouble();
            double b = event.getOption("b").getAsDouble();
            double c = event.getOption("c").getAsDouble();
            try {
                event.reply("The discriminant is: " + QuadraticMath.getDiscriminant(a, b, c));
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
        else {
            event.reply("Unknown interaction").setEphemeral(true).queue();
        }
    }

    public void reply(MessageChannel channel, String message) {
        channel.sendMessage(message).queue();
    }
}
