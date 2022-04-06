package world.ntdi.mathutils.Commands.Slash.Physics;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.json.simple.parser.ParseException;
import world.ntdi.mathutils.Api.MathApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Work extends SlashCommand {
    public Work() {
        this.name = "work";
        this.help = "Calculates the work based on a sub command.";
        this.children = new SlashCommand[] {new WorkForce(), new WorkMassAccel()};
    }
    @Override
    public void execute(SlashCommandEvent event) { event.reply("You can use the sub commands to calculate the work.").queue(); }

    private static class WorkForce extends SlashCommand {
        public WorkForce() {
            this.name = "force";
            this.help = "Calculates the work given a force and distance.";
            List<OptionData> options = new ArrayList<OptionData>();
            options.add(new OptionData(OptionType.NUMBER, "force", "Force in Joules").setRequired(true));
            options.add(new OptionData(OptionType.NUMBER, "distance", "Distance in Meters").setRequired(true));

            this.options = options;
        }
        @Override
        public void execute(SlashCommandEvent event) {
            double force = getOpt(event, "force");
            double distance = getOpt(event, "distance");

            try {
                event.reply("Work (N): " + MathApi.mathApiResult(force  + "*" + distance)).queue();
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private static class WorkMassAccel extends SlashCommand {
        public WorkMassAccel() {
            this.name = "mass-acceleration";
            this.help = "Calculates the work given mass, acceleration and distance.";
            List<OptionData> options = new ArrayList<OptionData>();
            options.add(new OptionData(OptionType.NUMBER, "mass", "Mass in grams").setRequired(true));
            options.add(new OptionData(OptionType.NUMBER, "acceleration", "Acceleration in m/s^2").setRequired(true));
            options.add(new OptionData(OptionType.NUMBER, "distance", "Distance in Meters").setRequired(true));

            this.options = options;
        }
        @Override
        public void execute(SlashCommandEvent event) {
            double mass = getOpt(event, "mass");
            double accel = getOpt(event, "acceleration");
            double distance = getOpt(event, "distance");

            try {
                event.reply("Work (N): " + MathApi.mathApiResult(mass + "*" + accel  + "*" + distance)).queue();
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static double getOpt(SlashCommandEvent event, String opt) {
        return event.getOption(opt).getAsDouble();
    }
}
