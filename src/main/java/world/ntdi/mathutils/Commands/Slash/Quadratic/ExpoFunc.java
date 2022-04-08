package world.ntdi.mathutils.Commands.Slash.Quadratic;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.json.simple.parser.ParseException;
import world.ntdi.mathutils.Api.QuadraticMath;
import world.ntdi.mathutils.Api.ValidApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExpoFunc extends SlashCommand {
    public ExpoFunc() {
        this.name = "expofunc";
        this.help = "Calculates the exponential function given x and expression.";

        List<OptionData> options = new ArrayList<OptionData>();
        options.add(new OptionData(OptionType.STRING, "expression", "the expression").setRequired(true));

        this.options = options;
    }

    @Override
    protected void execute(SlashCommandEvent event) {
        OptionMapping exprOpt = event.getOption("expression");
        String expr = exprOpt.getAsString();

        try {
            ArrayList<String> result = ValidApi.checkIfValid(expr);
            if (result.get(0).equalsIgnoreCase("valid")) {
                List<String> output = QuadraticMath.exponentialFunction5Points(expr);
                event.reply("Here are 5 points:\n" + output.get(0) + "\n" + output.get(1) + "\n" + output.get(2) + "\n" + output.get(3) + "\n" + output.get(4)).queue();
            } else {
                event.reply(result.get(1)).queue();
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
