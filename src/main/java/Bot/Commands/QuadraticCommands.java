package Bot.Commands;

import Bot.Api.QuadraticMath;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class QuadraticCommands extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();
        MessageChannel channel = event.getChannel();
        String[] args = msg.getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase("!findX")) {
            if (args.length == 3) {
                double a = Double.parseDouble(args[1]);
                double b = Double.parseDouble(args[2]);
                try {
                    reply(channel, "The solution is: x = " + QuadraticMath.getX(a, b));
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
            } else {
                reply(channel, "Please enter the values of a and b - !findX 2 4");
            }
        } else if (args[0].equalsIgnoreCase("!findY")) {
            if (args.length >= 3) {
                double x = Double.parseDouble(args[1]);
                StringBuilder sb = new StringBuilder();
                for (int i = 2; i < args.length; i++) {
                    sb.append(args[i]).append(" ");
                }
                String expr = sb.toString();
                try {
                    reply(channel, "The solution is: y = " + QuadraticMath.getY(x, expr));
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
            } else {
                reply(channel, "Please enter the values of x and expression - !findY 2 x^2 + 2(x) + 1");
            }
        } else if (args[0].equalsIgnoreCase("!findPoints")) {
            if (args.length >= 3) {
                double x = Double.parseDouble(args[1]);
                StringBuilder sb = new StringBuilder();
                for (int i = 2; i < args.length; i++) {
                    sb.append(args[i]).append(" ");
                }
                String expr = sb.toString();
                reply(channel, "Here are 5 points (p.s. they mirror):");
                try {
                    reply(channel, QuadraticMath.getPoints5(x, expr));
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
            } else {
                reply(channel, "Please enter the values of x and expression - !findPoints 2 x^2 + 2(x) + 1");
            }
        } else if (args[0].equalsIgnoreCase("!qalc")) {
            if (args.length >= 2) {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    sb.append(args[i]).append(" ");
                }
                String expr = sb.toString();
                try {
                    reply(channel, "The result is: " + QuadraticMath.qalc(expr));
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
            } else {
                reply(channel, "Please enter the values of x and expression - !qalc 1 + 1");
            }
        } else if (args[0].equalsIgnoreCase("!findMinOrMax")) {
            if (args.length == 2) {
                double a = Double.parseDouble(args[1]);
                reply(channel, "Your expression has a: " + QuadraticMath.minOrMax(a));
            } else {
                reply(channel, "Please enter the values of a - !minOrMax 1");
            }
        } else if (args[0].equalsIgnoreCase("!findDomainRange")) {
            if (args.length == 3) {
                double a = Double.parseDouble(args[1]);
                double x = Double.parseDouble(args[2]);
                reply(channel, "The domain and range are: " + QuadraticMath.getDomainAndRange(a, x));
            } else {
                reply(channel, "Please enter the values of a and x - !domainRange 1 2");
            }
        } else if (args[0].equalsIgnoreCase("!findAll")) {
            if (args.length >= 4) {
                double a = Double.parseDouble(args[1]);
                double b = Double.parseDouble(args[2]);
                StringBuilder sb = new StringBuilder();
                for (int i = 3; i < args.length; i++) {
                    sb.append(args[i]).append(" ");
                }
                String expr = sb.toString();
                double x;
                double y;
                try {
                    x = QuadraticMath.getX(a, b);
                    y = QuadraticMath.getY(x, expr);
                    reply(channel, "Here is all the information you'll need:");
                    reply(channel, "X: " + x);
                    reply(channel, "Y: " + y);
                    reply(channel, "The answer is: " + QuadraticMath.getAnswer(expr));
                    reply(channel, "5 Points: \n" + QuadraticMath.getPoints5(x, expr));
                    reply(channel, "Domain and range: " + QuadraticMath.getDomainAndRange(a, x));
                    reply(channel, "Minimum or maximum: " + QuadraticMath.minOrMax(a));
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
            } else {
                reply(channel, "Please enter the values of a, b and expression - !findAll 1 2 x^2 + 2(x) + 1");
            }
        } else if (args[0].equalsIgnoreCase("!findAnswer")) {
            if (args.length >= 2) {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    sb.append(args[i]).append(" ");
                }
                String expr = sb.toString();
                try {
                    reply(channel, "The answer is: " + QuadraticMath.getAnswer(expr));
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
            } else {
                reply(channel, "Please enter the expression - !findAnswer x^2 + 2(x) + 1");
            }
        }
    }

    public void reply(MessageChannel channel, String message) {
        channel.sendMessage(message).queue();
    }
}
