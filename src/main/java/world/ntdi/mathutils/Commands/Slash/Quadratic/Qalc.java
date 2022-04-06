package world.ntdi.mathutils.Commands.Slash.Quadratic;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.json.simple.parser.ParseException;
import world.ntdi.mathutils.Api.QuadraticMath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Qalc extends SlashCommand {
    public Qalc() {
        this.name = "qalc";
        this.help = "Calculates the given expression";

        List<OptionData> options = new ArrayList<OptionData>();
        options.add(new OptionData(OptionType.STRING, "expression", "the expression").setRequired(true));

        this.options = options;
        this.arguments = "<expression>";
    }

    @Override
    protected void execute(SlashCommandEvent event) {
        OptionMapping exprOpt = event.getOption("expression");
        String expr = exprOpt.getAsString();
        try {
            event.reply("The answer is: " + QuadraticMath.qalc(expr)).queue();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
