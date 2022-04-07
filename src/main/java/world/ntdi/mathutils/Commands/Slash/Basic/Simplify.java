package world.ntdi.mathutils.Commands.Slash.Basic;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.json.simple.parser.ParseException;
import world.ntdi.mathutils.Api.BasicMath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Simplify extends SlashCommand {
    public Simplify() {
        this.name = "simp";
        this.help = "Simplifies a given expression";

        List<OptionData> options = new ArrayList<OptionData>();
        options.add(new OptionData(OptionType.STRING, "expression", "the expression").setRequired(true));

        this.options = options;
    }
    @Override
    protected void execute(SlashCommandEvent event) {
        String expr = event.getOption("expression").getAsString();

        try {
            event.reply("Simplified expression: " + BasicMath.simplfy(expr)).queue();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public double getOpt(SlashCommandEvent event, String opt) {
        return event.getOption(opt).getAsDouble();
    }
}
