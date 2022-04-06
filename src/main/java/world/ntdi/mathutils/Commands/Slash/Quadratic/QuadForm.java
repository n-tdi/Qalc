package world.ntdi.mathutils.Commands.Slash.Quadratic;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.json.simple.parser.ParseException;
import pw.chew.jdachewtils.command.OptionHelper;
import world.ntdi.mathutils.Api.QuadraticMath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuadForm extends SlashCommand {
    public QuadForm() {
        this.name = "quadform";
        this.help = "Calculates the answer with te quadratic formula given a, b, c.";

        List<OptionData> options = new ArrayList<OptionData>();
        options.add(new OptionData(OptionType.NUMBER, "a", "the a number").setRequired(true));
        options.add(new OptionData(OptionType.NUMBER, "b", "the b number").setRequired(true));
        options.add(new OptionData(OptionType.NUMBER, "c", "the c number").setRequired(true));

        this.options = options;
        this.arguments = "<a> <b> <c>";
    }

    @Override
    protected void execute(SlashCommandEvent event) {
        OptionMapping aOpt = event.getOption("a");
        OptionMapping bOpt = event.getOption("b");
        OptionMapping cOpt = event.getOption("c");
        double a = aOpt.getAsDouble();
        double b = bOpt.getAsDouble();
        double c = cOpt.getAsDouble();
        try {
            List<String> quadFormAnswers = QuadraticMath.quadForm(a, b, c);
            event.reply("Quadratic Formula Answer: \nx1 = " + quadFormAnswers.get(0) + "\nx2 = " + quadFormAnswers.get(1)).queue();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
