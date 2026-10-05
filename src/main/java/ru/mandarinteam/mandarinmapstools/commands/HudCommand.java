package ru.mandarinteam.mandarinmapstools.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import ru.mandarinteam.mandarinmapstools.api.FlagsConfig;

public class HudCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher){
        var rootCommand = Commands.literal("tools")
                .requires(source -> source.hasPermission(2));

        var HudSubCommand = Commands.literal("hud");


        //WATCH
        var HudWatchCommand = Commands.literal("watch");

        var HudWatchAllCommand = Commands.literal("all");

        var HudWatchAllOnCommand = Commands.literal("on")
                .executes(HudCommand::runWatchAllOn);

        var HudOWatchAllOffCommand = Commands.literal("off")
                .executes(HudCommand::runWatchAllOff);

        //WATCH

        HudWatchAllCommand.then(HudOWatchAllOffCommand);
        HudWatchAllCommand.then(HudWatchAllOnCommand);
        HudWatchCommand.then(HudWatchAllCommand);
        HudSubCommand.then(HudWatchCommand);
        rootCommand.then(HudSubCommand);

        dispatcher.register(rootCommand);
    }

    private static int runWatchAllOn(CommandContext<CommandSourceStack> context){
        FlagsConfig.globalHudVisible = true;

        return 1;
    }

    private static int runWatchAllOff(CommandContext<CommandSourceStack> context){
        FlagsConfig.globalHudVisible = false;

        return 1;
    }

}
