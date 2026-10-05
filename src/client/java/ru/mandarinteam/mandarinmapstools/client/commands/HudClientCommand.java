package ru.mandarinteam.mandarinmapstools.client.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import ru.mandarinteam.mandarinmapstools.client.manager.HudManager;

public class HudClientCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher){
        var rootCommand = Commands.literal("tools")
                .requires(source -> source.hasPermission(2));

        var HudSubCommand = Commands.literal("hud");


        //WATCH
        var HudWatchCommand = Commands.literal("watch");

        var HudWatchOnCommand = Commands.literal("on")
                .executes(HudClientCommand::runWatchOn);

        var HudWatchOffCommand = Commands.literal("off")
                .executes(HudClientCommand::runWatchOff);

        //WATCH

        HudWatchCommand.then(HudWatchOffCommand);
        HudWatchCommand.then(HudWatchOnCommand);
        HudSubCommand.then(HudWatchCommand);
        rootCommand.then(HudSubCommand);

        dispatcher.register(rootCommand);
    }

    private static int runWatchOn(CommandContext<CommandSourceStack> context){
        HudManager.watchIsVisibleClient = true;

        return 1;
    }

    private static int runWatchOff(CommandContext<CommandSourceStack> context){
        HudManager.watchIsVisibleClient = false;

        return 1;
    }


}
