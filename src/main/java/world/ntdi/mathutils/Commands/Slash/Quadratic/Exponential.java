package world.ntdi.mathutils.Commands.Slash.Quadratic;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.json.simple.parser.ParseException;
import world.ntdi.mathutils.Api.QuadraticMath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exponential extends SlashCommand {

    public Exponential() {
        this.name = "exponential";
        this.help = "Runs the formula selected";
        this.children = new SlashCommand[] { new Growth(), new Decrease(), new Compound() };
    }
    @Override
    protected void execute(SlashCommandEvent event) {
        event.reply("Please select a formula").queue();
    }

    private static class Growth extends SlashCommand {
        public Growth() {
            this.name = "growth";
            this.help = "Growth formula";
            List<OptionData> options = new ArrayList<OptionData>();
            options.add(new OptionData(OptionType.NUMBER, "a", "Starting amount").setRequired(true));
            options.add(new OptionData(OptionType.NUMBER, "p", "Percent of growth").setRequired(true));
            options.add(new OptionData(OptionType.NUMBER, "t", "Time in future (how many times to run)").setRequired(true));

            this.options = options;
        }
        @Override
        protected void execute(SlashCommandEvent event) {
            double a = getOpt(event, "a");
            double p = getOpt(event, "p");
            double t = getOpt(event, "t");

            try {
                event.reply("Final Amount: " + QuadraticMath.expoGrowth(a, p, t)).queue();
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }

        }
    }

    private static class Decrease extends SlashCommand {
        public Decrease() {
            this.name = "decrease";
            this.help = "Decrease formula";
            List<OptionData> options = new ArrayList<OptionData>();
            options.add(new OptionData(OptionType.NUMBER, "a", "Starting amount").setRequired(true));
            options.add(new OptionData(OptionType.NUMBER, "p", "Percent of growth").setRequired(true));
            options.add(new OptionData(OptionType.NUMBER, "t", "Time in future (how many times to run)").setRequired(true));

            this.options = options;
        }
        @Override
        protected void execute(SlashCommandEvent event) {
            double a = getOpt(event, "a");
            double p = getOpt(event, "p");
            double t = getOpt(event, "t");

            try {
                event.reply("Final Amount: " + QuadraticMath.expoDecrease(a, p, t)).queue();
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }

        }
    }

    private static class Compound extends SlashCommand {
        public Compound() {
            this.name = "compound";
            this.help = "Compound formula";
            List<OptionData> options = new ArrayList<OptionData>();
            options.add(new OptionData(OptionType.NUMBER, "a", "Starting amount").setRequired(true));
            options.add(new OptionData(OptionType.NUMBER, "p", "% of growth").setRequired(true));
            options.add(new OptionData(OptionType.NUMBER, "n", "Number of times compounded").setRequired(true));
            options.add(new OptionData(OptionType.NUMBER, "t", "Time in future (how many times to run)").setRequired(true));

            this.options = options;
        }
        @Override
        protected void execute(SlashCommandEvent event) {
            double a = getOpt(event, "a");
            double p = getOpt(event, "p");
            double n = getOpt(event, "n");
            double t = getOpt(event, "t");

            try {
                event.reply("Final Amount: " + QuadraticMath.expoCompound(a, p, n, t)).queue();
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static double getOpt(SlashCommandEvent event, String opt) {
        return event.getOption(opt).getAsDouble();
    }
}
