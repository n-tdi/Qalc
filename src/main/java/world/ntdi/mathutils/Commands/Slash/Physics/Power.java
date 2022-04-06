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

public class Power extends SlashCommand {
    public Power() {
        this.name = "power";
        this.help = "Calculates the power based on a sub command.";
        this.children = new SlashCommand[] {new PowerWorkTime(), new PowerForceDistTime(), new PowerMassAccelDistTime()};
    }
    @Override
    public void execute(SlashCommandEvent event) { event.reply("You can use the sub commands to calculate the power.").queue(); }

    private static class PowerWorkTime extends SlashCommand {
        public PowerWorkTime() {
            this.name = "work-time";
            this.help = "Calculates the power given a work and time.";
            List<OptionData> options = new ArrayList<OptionData>();
            options.add(new OptionData(OptionType.NUMBER, "work", "Work in Newtons").setRequired(true));
            options.add(new OptionData(OptionType.NUMBER, "time", "Time in Seconds").setRequired(true));

            this.options = options;
        }
        @Override
        public void execute(SlashCommandEvent event) {
            double work = getOpt(event, "work");
            double dist = getOpt(event, "time");
            try {
                event.reply("Power (W): " + MathApi.mathApiResult(work  + "/" + dist)).queue();
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private static class PowerForceDistTime extends SlashCommand {
        public PowerForceDistTime() {
            this.name = "force-dist-time";
            this.help = "Calculates the power given force, distance and time.";
            List<OptionData> options = new ArrayList<OptionData>();
            options.add(new OptionData(OptionType.NUMBER, "force", "Force in Joules").setRequired(true));
            options.add(new OptionData(OptionType.NUMBER, "distance", "Distance in Meters").setRequired(true));
            options.add(new OptionData(OptionType.NUMBER, "time", "Time in seconds").setRequired(true));

            this.options = options;
        }
        @Override
        public void execute(SlashCommandEvent event) {
            double force = getOpt(event, "force");
            double time = getOpt(event, "time");
            double dist = getOpt(event, "distance");

            try {
                event.reply("Power (W): " + MathApi.mathApiResult("(" + force + "*" + dist  + ")/" + time)).queue();
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private static class PowerMassAccelDistTime extends SlashCommand {
        public PowerMassAccelDistTime() {
            this.name = "mass-accel-dist-time";
            this.help = "Calculates the power given mass, acceleration, distance, and time.";
            List<OptionData> options = new ArrayList<OptionData>();
            options.add(new OptionData(OptionType.NUMBER, "mass", "Mass in KG").setRequired(true));
            options.add(new OptionData(OptionType.NUMBER, "acceleration", "Acceleration in m/s^2 (gravity = 9.81 m/s^2)").setRequired(true));
            options.add(new OptionData(OptionType.NUMBER, "distance", "Distance in Meters").setRequired(true));
            options.add(new OptionData(OptionType.NUMBER, "time", "Time in seconds").setRequired(true));

            this.options = options;
        }
        @Override
        public void execute(SlashCommandEvent event) {
            double mass = getOpt(event, "mass");
            double accel = getOpt(event, "acceleration");
            double time = getOpt(event, "time");
            double dist = getOpt(event, "distance");

            try {
                event.reply("Power (W): " + MathApi.mathApiResult("(" + mass + "*" + accel + "*" + dist  + ")/" + time)).queue();
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static double getOpt(SlashCommandEvent event, String opt) {
        return event.getOption(opt).getAsDouble();
    }
}
