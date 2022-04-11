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

public class Geometric extends SlashCommand {
    public Geometric() {
        this.name = "geometric";
        this.children = new SlashCommand[]{new Single(), new Multiple()};
        this.guildOnly = false;
    }

    @Override
    protected void execute(SlashCommandEvent e) {
        e.reply("Please use sub commands!").queue();
    }

    private static class Single extends SlashCommand{
        public Single() {
            this.name = "single";
            this.help = "Calculate a single number in the sequence";
            List<OptionData> options = new ArrayList<OptionData>();
            options.add(new OptionData(OptionType.NUMBER, "a", "Starting number in sequence").setRequired(true));
            options.add(new OptionData(OptionType.NUMBER, "r", "Common Ratio").setRequired(true));
            options.add(new OptionData(OptionType.NUMBER, "n", "Number of how far in the sequence to go").setRequired(true));

            this.options = options;
        }

        @Override
        protected void execute(SlashCommandEvent e) {
            double a = getOpt(e, "a");
            double r = getOpt(e, "r");
            double n = getOpt(e, "n");

            try {
                e.reply("The number in the pattern is: " + QuadraticMath.predictFuture(a, r, n)).queue();
            } catch (IOException | ParseException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static class Multiple extends SlashCommand{
        public Multiple() {
            this.name = "multiple";
            this.help = "Calculate multiple numbers in the sequence";
            List<OptionData> options = new ArrayList<OptionData>();
            options.add(new OptionData(OptionType.NUMBER, "a", "Starting number in sequence").setRequired(true));
            options.add(new OptionData(OptionType.NUMBER, "r", "Common Ratio").setRequired(true));
            options.add(new OptionData(OptionType.NUMBER, "start-num", "the first number in the pattern you want to predict").setRequired(true));
            options.add(new OptionData(OptionType.NUMBER, "end-num", "the last number in the pattern you want to predict").setRequired(true));

            this.options = options;
        }

        @Override
        protected void execute(SlashCommandEvent e) {
            double a = getOpt(e, "a");
            double r = getOpt(e, "r");
            double startNum = getOpt(e, "start-num");
            double endNum = getOpt(e, "end-num");

            try {
                StringBuilder sb = new StringBuilder();
                for(int i = (int)startNum; i <= endNum; i++) {
                    sb.append(QuadraticMath.predictFuture(a, r, i)).append(", ");
                }
                e.reply("The numbers in the pattern are: " + sb.toString()).queue();
            } catch (IOException | ParseException ex) {
                ex.printStackTrace();
            }
        }
    }


    public static double getOpt(SlashCommandEvent event, String opt) {
        return event.getOption(opt).getAsDouble();
    }
}
