package world.ntdi.mathutils.Commands.Slash.Physics;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.json.simple.parser.ParseException;
import world.ntdi.mathutils.Api.MathApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Force extends SlashCommand {
    public Force() {
        this.name = "force";
        this.help = "Calculates the force of an object given mass and acceleration.";

        List<OptionData> options = new ArrayList<OptionData>();
        options.add(new OptionData(OptionType.NUMBER, "mass", "Mass in KG").setRequired(true));
        options.add(new OptionData(OptionType.NUMBER, "acceleration", "Acceleration in m/s^2 (gravity = 9.81 m/s^2)").setRequired(true));

        this.options = options;
    }

    @Override
    protected void execute(SlashCommandEvent event) {
        OptionMapping massOpt = event.getOption("mass");
        OptionMapping accelerationOpt = event.getOption("acceleration");

        double mass = massOpt.getAsDouble();
        double accel = accelerationOpt.getAsDouble();

        try {
            event.reply("Force (J): " + MathApi.mathApiResult(mass + "*" +accel)).queue();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
