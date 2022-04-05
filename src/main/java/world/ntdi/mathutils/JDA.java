package world.ntdi.mathutils;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import world.ntdi.mathutils.Commands.PhysicsCommands;
import world.ntdi.mathutils.Commands.QuadraticCommands;
import world.ntdi.mathutils.Commands.Slash.Discriminant;
import world.ntdi.mathutils.Commands.Slash.FindAll;
import world.ntdi.mathutils.Commands.Slash.Qalc;
import world.ntdi.mathutils.Commands.Slash.QuadForm;
import world.ntdi.mathutils.Commands.UtilCommands;
import world.ntdi.mathutils.Listener.JoinListener;
import world.ntdi.mathutils.Listener.ReadyListener;

import javax.security.auth.login.LoginException;
import java.util.Objects;


public class JDA {
    public static void main(String[] args) throws LoginException, InterruptedException {
        CommandClientBuilder builder = new CommandClientBuilder();
        builder.addSlashCommands(new QuadForm(), new Discriminant(), new Qalc(), new FindAll());
        builder.forceGuildOnly(959638142896439307L);
        builder.setServerInvite("https://discord.gg/VU7kWC9Nda");
        builder.setOwnerId("811580599068262421");
        builder.setPrefix("!");
        builder.useHelpBuilder(false);
        builder.setActivity(Activity.watching("math"));
        CommandClient commandClient = builder.build();

        net.dv8tion.jda.api.JDA jda = JDABuilder.createDefault("OTU5NjM5OTY3MDg3MzQ1Njc0.Yke0XQ.icdz9tiglcwfmbATxhnkcKUT8S8")
                .disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE)
                .setBulkDeleteSplittingEnabled(false)
                .addEventListeners(
                        new ReadyListener(),
                        new PhysicsCommands(),
                        new JoinListener(),
                        //new QuadraticCommands(),
                        new UtilCommands(),
                        commandClient)
                .setActivity(Activity.watching("Math"))
                .build();

        jda.awaitReady();

        CommandListUpdateAction commandListUpdateAction = jda.updateCommands();
        commandListUpdateAction.queue();
    }
}
