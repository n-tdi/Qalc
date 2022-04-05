package world.ntdi.mathutils.Commands.Slash;

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

public class FindAll extends SlashCommand {
    public FindAll() {
        this.name = "findall";
        this.help = "find all the data needed for a given equation";

        List<OptionData> options = new ArrayList<OptionData>();
        options.add(new OptionData(OptionType.NUMBER, "a", "the a number").setRequired(true));
        options.add(new OptionData(OptionType.NUMBER, "b", "the b number").setRequired(true));
        options.add(new OptionData(OptionType.NUMBER, "c", "the c number").setRequired(true));
        options.add(new OptionData(OptionType.STRING, "expression", "the expression").setRequired(true));

        this.options = options;

        this.arguments = "<a> <b> <c> <expression>";
    }
    @Override
    protected void execute(SlashCommandEvent event) {
        OptionMapping aOpt = event.getOption("a");
        OptionMapping bOpt = event.getOption("b");
        OptionMapping cOpt = event.getOption("c");
        OptionMapping exprOpt = event.getOption("expression");
        double a = aOpt.getAsDouble();
        double b = bOpt.getAsDouble();
        double c = cOpt.getAsDouble();
        String expr = exprOpt.getAsString();
        try {
            List<String> xs = QuadraticMath.quadForm(a, b, c);
            double x1 = Double.parseDouble(xs.get(0));
            double x2 = Double.parseDouble(xs.get(1));
            StringBuilder sb = new StringBuilder();
            sb.append("Here is all the info you'll Need:\n")
                    .append("**x1:**").append("\n")
                    .append("  - ").append("y = ").append(QuadraticMath.getY(x1, expr)).append("\n")
                    .append("  - ").append("Points: \n").append(QuadraticMath.getPoints5(x1, expr))
                    .append("  - ").append("Domain and range: ").append("\n").append(QuadraticMath.getDomainAndRange(a, x1)).append("\n")
                    .append("  - ").append("Point type: ").append(QuadraticMath.minOrMax(a)).append("\n")
                    .append("**x2:**").append("\n")
                    .append("  - ").append("y = ").append(QuadraticMath.getY(x2, expr)).append("\n")
                    .append("  - ").append("Points: \n").append(QuadraticMath.getPoints5(x2, expr))
                    .append("  - ").append("Domain and range: ").append(QuadraticMath.getDomainAndRange(a, x2)).append("\n")
                    .append("  - ").append("Point type: ").append(QuadraticMath.minOrMax(a));

            event.reply(sb.toString()).queue();

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }


    }
}
