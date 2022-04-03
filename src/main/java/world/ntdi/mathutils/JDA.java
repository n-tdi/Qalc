package world.ntdi.mathutils;

import world.ntdi.mathutils.Commands.PhysicsCommands;
import world.ntdi.mathutils.Commands.QuadraticCommands;
import world.ntdi.mathutils.Commands.UtilCommands;
import world.ntdi.mathutils.Listener.ReadyListener;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;


public class JDA {
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = JDABuilder.createDefault("OTU5NjM5OTY3MDg3MzQ1Njc0.Yke0XQ.icdz9tiglcwfmbATxhnkcKUT8S8");

        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        builder.setBulkDeleteSplittingEnabled(false);
        builder.addEventListeners(new ReadyListener());
        builder.addEventListeners(new QuadraticCommands());
        builder.addEventListeners(new UtilCommands());
        builder.addEventListeners(new PhysicsCommands());
        builder.setActivity(Activity.watching("Math"));

        builder.build();
    }
}
