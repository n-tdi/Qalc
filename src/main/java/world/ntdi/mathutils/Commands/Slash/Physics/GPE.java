package world.ntdi.mathutils.Commands.Slash.Physics;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.json.simple.parser.ParseException;
import world.ntdi.mathutils.Api.MathApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GPE extends SlashCommand {
    public GPE() {
        this.name = "gpe";
        this.help = "GPE";

        List<OptionData> options = new ArrayList<>();
        options.add(new OptionData(OptionType.NUMBER, "height", "Height above surface in meters").setRequired(true));
        options.add(new OptionData(OptionType.NUMBER, "mass", "Mass in grams").setRequired(true));

        this.options = options;
    }
    @Override
    protected void execute(SlashCommandEvent event) {
        double height = getOpt(event, "height");
        double mass = getOpt(event, "mass");

        try {
            event.reply("GPE: " + MathApi.mathApiResult(mass + "*" + height + "*9.81")).queue();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public double getOpt(SlashCommandEvent event, String opt) {
        return event.getOption(opt).getAsDouble();
    }
}
