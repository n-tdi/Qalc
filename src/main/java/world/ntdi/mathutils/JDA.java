package world.ntdi.mathutils;

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
import world.ntdi.mathutils.Commands.UtilCommands;
import world.ntdi.mathutils.Listener.JoinListener;
import world.ntdi.mathutils.Listener.ReadyListener;

import javax.security.auth.login.LoginException;
import java.util.Objects;


public class JDA {
    public static void main(String[] args) throws LoginException, InterruptedException {
        net.dv8tion.jda.api.JDA jda = JDABuilder.createDefault("OTU5NjM5OTY3MDg3MzQ1Njc0.Yke0XQ.icdz9tiglcwfmbATxhnkcKUT8S8")
            .disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE)
            .setBulkDeleteSplittingEnabled(false)
            .addEventListeners(new ReadyListener())
            .addEventListeners(new JoinListener())
            .addEventListeners(new QuadraticCommands())
            .addEventListeners(new UtilCommands())
            .addEventListeners(new PhysicsCommands())
            .setActivity(Activity.watching("Math"))
            .build();

        jda.awaitReady();
        jda.awaitStatus(net.dv8tion.jda.api.JDA.Status.CONNECTING_TO_WEBSOCKET);

        CommandListUpdateAction commands = jda.updateCommands();
        Guild guild = jda.getGuildById("717087885859058688");
        CommandListUpdateAction gCommands = guild.updateCommands();
        commands.addCommands(
                Commands.slash("findx", "Finds the x cord with a given a and b")
                        .addOptions(new OptionData(OptionType.NUMBER, "a", "The a cord").setRequired(true))
                        .addOptions(new OptionData(OptionType.NUMBER, "b", "The b cord").setRequired(true))
        );

        commands.addCommands(
                Commands.slash("findy", "Finds the y cord with a given x and expression")
                        .addOptions(new OptionData(OptionType.NUMBER, "x", "The x cord").setRequired(true))
                        .addOptions(new OptionData(OptionType.STRING, "expression", "The expression").setRequired(true))
        );

        commands.addCommands(
                Commands.slash("fintpoints", "Find 5 points to graph with a given x and expression")
                        .addOptions(new OptionData(OptionType.NUMBER, "x", "The x cord").setRequired(true))
                        .addOptions(new OptionData(OptionType.STRING, "expression", "The expression").setRequired(true))
        );

        commands.addCommands(
                Commands.slash("pointtype", "Find if the point as a minimum or maximum with a given a")
                        .addOptions(new OptionData(OptionType.NUMBER, "a", "The a number").setRequired(true))
        );

        commands.addCommands(
                Commands.slash("domainrange", "Finds the domain and range with a given a")
                        .addOptions(new OptionData(OptionType.NUMBER, "a", "The a number").setRequired(true))
                        .addOptions(new OptionData(OptionType.NUMBER, "x", "The x number").setRequired(true))
        );

        commands.addCommands(
                Commands.slash("findanswer", "Finds the answer of a quadratic equation with a given expression")
                        .addOptions(new OptionData(OptionType.STRING, "expression", "The expression").setRequired(true))
        );

        commands.addCommands(
                Commands.slash("findall", "Find all the answers of a quadratic equation with a given expression, a, b")
                        .addOptions(new OptionData(OptionType.NUMBER, "a", "The a number").setRequired(true))
                        .addOptions(new OptionData(OptionType.NUMBER, "b", "The b number").setRequired(true))
                        .addOptions(new OptionData(OptionType.STRING, "expression", "The expression").setRequired(true))
        );

        commands.addCommands(
                Commands.slash("qalc", "Qalculate a given expression")
                        .addOptions(new OptionData(OptionType.STRING, "expression", "The expression").setRequired(true))
        );
        gCommands.addCommands(
                Commands.slash("findx", "Finds the x cord with a given a and b")
                        .addOptions(new OptionData(OptionType.NUMBER, "a", "The a cord").setRequired(true))
                        .addOptions(new OptionData(OptionType.NUMBER, "b", "The b cord").setRequired(true))
        );

        gCommands.addCommands(
                Commands.slash("findy", "Finds the y cord with a given x and expression")
                        .addOptions(new OptionData(OptionType.NUMBER, "x", "The x cord").setRequired(true))
                        .addOptions(new OptionData(OptionType.STRING, "expression", "The expression").setRequired(true))
        );

        gCommands.addCommands(
                Commands.slash("fintpoints", "Find 5 points to graph with a given x and expression")
                        .addOptions(new OptionData(OptionType.NUMBER, "x", "The x cord").setRequired(true))
                        .addOptions(new OptionData(OptionType.STRING, "expression", "The expression").setRequired(true))
        );

        gCommands.addCommands(
                Commands.slash("pointtype", "Find if the point as a minimum or maximum with a given a")
                        .addOptions(new OptionData(OptionType.NUMBER, "a", "The a number").setRequired(true))
        );

        gCommands.addCommands(
                Commands.slash("domainrange", "Finds the domain and range with a given a")
                        .addOptions(new OptionData(OptionType.NUMBER, "a", "The a number").setRequired(true))
                        .addOptions(new OptionData(OptionType.NUMBER, "x", "The x number").setRequired(true))
        );

        gCommands.addCommands(
                Commands.slash("findanswer", "Finds the answer of a quadratic equation with a given expression")
                        .addOptions(new OptionData(OptionType.STRING, "expression", "The expression").setRequired(true))
        );

        gCommands.addCommands(
                Commands.slash("findall", "Find all the answers of a quadratic equation with a given expression, a, b")
                        .addOptions(new OptionData(OptionType.NUMBER, "a", "The a number").setRequired(true))
                        .addOptions(new OptionData(OptionType.NUMBER, "b", "The b number").setRequired(true))
                        .addOptions(new OptionData(OptionType.STRING, "expression", "The expression").setRequired(true))
        );

        gCommands.addCommands(
                Commands.slash("qalc", "Qalculate a given expression")
                        .addOptions(new OptionData(OptionType.STRING, "expression", "The expression").setRequired(true))
        );
        commands.queue();
        gCommands.queue();
    }
}
