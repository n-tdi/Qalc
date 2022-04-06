package world.ntdi.mathutils.Commands.Slash.Physics;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.utils.data.DataType;
import org.json.simple.parser.ParseException;
import world.ntdi.mathutils.Api.MathApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KE extends SlashCommand {
    public KE() {
        this.name = "ke";
        this.help = "Calculates the kinetic given mass and velocity";
        List<OptionData> options = new ArrayList<>();
        options.add(new OptionData(OptionType.NUMBER, "mass", "Mass in grams").setRequired(true));
        options.add(new OptionData(OptionType.NUMBER, "velocity", "The text of the new tag").setRequired(true));

        this.options = options;
        this.arguments = "<mass> <velocity>";
        this.guildOnly = false;
    }
    @Override
    protected void execute(SlashCommandEvent event) {
        double mass = getOpt(event, "mass");
        double velocity = getOpt(event, "velocity");

        try {
            event.reply("KE: " + MathApi.mathApiResult("(" + mass + "*" + velocity + "*" + velocity + ") / 2")).queue();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public double getOpt(SlashCommandEvent event, String opt) {
        return event.getOption(opt).getAsDouble();
    }
}
