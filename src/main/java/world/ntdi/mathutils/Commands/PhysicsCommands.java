package world.ntdi.mathutils.Commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import world.ntdi.mathutils.Api.ScienceMath;

public class PhysicsCommands extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();
        MessageChannel channel = event.getChannel();
        String[] args = msg.getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase("!force")) {
            if (args.length == 3) {
                double mass = Double.parseDouble(args[1]);
                double acceleration = Double.parseDouble(args[2]);
                reply(channel, "Force (N): " + ScienceMath.getForce(mass, acceleration));
            } else {
                reply(channel, "Invalid arguments. Usage: !force <mass> <acceleration>");
            }
        } else if (args[0].equalsIgnoreCase("!work")) {
            if (args.length == 3) {
                double force = Double.parseDouble(args[1]);
                double distance = Double.parseDouble(args[2]);
                reply(channel, "Work (J): " + ScienceMath.getWork(force, distance));
            } else if (args.length == 4) {
                double mass = Double.parseDouble(args[1]);
                double acceleration = Double.parseDouble(args[2]);
                double distance = Double.parseDouble(args[3]);
                reply(channel, "Work (J): " + ScienceMath.getWork(mass, acceleration, distance));
            } else {
                reply(channel, "Invalid arguments. Usage: !work <force distance | mass acceleration distance>");
            }
        } else if (args[0].equalsIgnoreCase("!power")) {
            if (args.length == 3) {
                double work = Double.parseDouble(args[1]);
                double time = Double.parseDouble(args[2]);
                reply(channel, "Power (W): " + ScienceMath.getPower(work, time));
            } else if (args.length == 4) {
                double force = Double.parseDouble(args[1]);
                double distance = Double.parseDouble(args[2]);
                double time = Double.parseDouble(args[3]);
                reply(channel, "Power (W): " + ScienceMath.getPower(force, distance, time));
            } else if (args.length == 5) {
                double mass = Double.parseDouble(args[1]);
                double acceleration = Double.parseDouble(args[2]);
                double distance = Double.parseDouble(args[3]);
                double time = Double.parseDouble(args[4]);
                reply(channel, "Power (W): " + ScienceMath.getPower(mass, acceleration, distance, time));
            }
        } else if (args[0].equalsIgnoreCase("!ke")) {
            if (args.length == 3) {
                double mass = Double.parseDouble(args[1]);
                double velocity = Double.parseDouble(args[2]);
                reply(channel, "Kinetic Energy (J): " + ScienceMath.getKE(mass, velocity));
            }
        } else if (args[0].equalsIgnoreCase("!gpe")) {
            if (args.length == 4) {
                double height = Double.parseDouble(args[1]);
                double mass = Double.parseDouble(args[2]);
                double velocity = Double.parseDouble(args[3]);
                reply(channel, "Gravitational Potential Energy (J): " + ScienceMath.getGPE(height, mass, velocity));
            }
        }
    }
    public void reply(MessageChannel channel, String message) {
        channel.sendMessage(message).queue();
    }
}
