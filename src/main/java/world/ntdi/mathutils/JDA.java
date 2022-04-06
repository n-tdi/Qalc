package world.ntdi.mathutils;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import world.ntdi.mathutils.Commands.PhysicsCommands;
import world.ntdi.mathutils.Commands.Slash.Physics.*;
import world.ntdi.mathutils.Commands.Slash.Quadratic.*;
import world.ntdi.mathutils.Commands.UtilCommands;
import world.ntdi.mathutils.Listener.JoinListener;
import world.ntdi.mathutils.Listener.ReadyListener;

import javax.security.auth.login.LoginException;


public class JDA {
    public static void main(String[] args) throws LoginException, InterruptedException {
        CommandClientBuilder builder = new CommandClientBuilder();
        builder.addSlashCommands(new QuadForm(), new Discriminant(), new Qalc(), new FindAll(), new ExpoFunc(), new Force(), new Work(), new Power(), new KE(), new GPE());
        builder.forceGuildOnly(959638142896439307L);
        builder.setServerInvite("https://discord.gg/VU7kWC9Nda");
        builder.setOwnerId("811580599068262421");
        builder.setPrefix("!");
        builder.useHelpBuilder(false);
        builder.setActivity(Activity.watching("math"));
        CommandClient commandClient = builder.build();

        Dotenv dotenv = Dotenv.configure().load();
        net.dv8tion.jda.api.JDA jda = JDABuilder.createDefault(dotenv.get("TOKEN"))
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
