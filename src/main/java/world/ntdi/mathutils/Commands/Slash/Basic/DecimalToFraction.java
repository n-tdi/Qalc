package world.ntdi.mathutils.Commands.Slash.Basic;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import world.ntdi.mathutils.Api.BasicMath;

import java.util.ArrayList;
import java.util.List;

public class DecimalToFraction extends SlashCommand {
    public DecimalToFraction() {
        this.name = "dtf";
        this.help = "Converts a decimal number to a fraction";

        List<OptionData> options = new ArrayList<OptionData>();
        options.add(new OptionData(OptionType.NUMBER, "decimal", "the decimal").setRequired(true));

        this.options = options;
    }
    @Override
    protected void execute(SlashCommandEvent event) {
        double decimal = getOpt(event, "decimal");

        event.reply("Your new fraction: " + BasicMath.convertToFraction(decimal)).queue();
    }

    public double getOpt(SlashCommandEvent event, String opt) {
        return event.getOption(opt).getAsDouble();
    }
}
