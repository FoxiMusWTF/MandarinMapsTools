package ru.mandarinteam.mandarinmapstools.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import ru.mandarinteam.mandarinmapstools.utils.time.Time;

public class FrezeeCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher){
        var rootCommand = Commands.literal("tools")
                .requires(source -> source.hasPermission(2));

        var freezeSubCommand = Commands.literal("frezee");

        var onArg = Commands.literal("on")
                        .executes(FrezeeCommand::runOn);

        var offArg = Commands.literal("off")
                .executes(FrezeeCommand::runOff);

        freezeSubCommand.then(onArg);
        freezeSubCommand.then(offArg);
        rootCommand.then(freezeSubCommand);


        dispatcher.register(rootCommand);
    }

    private static int runOn(CommandContext<CommandSourceStack> context){
        context.getSource().sendSuccess(() -> Component.literal("Время заморожено"), false);
        Time.setTimeFrozen(true);

        return 1;
    }

    private static int runOff(CommandContext<CommandSourceStack> context) {
        context.getSource().sendSuccess(() -> Component.literal("Время разморожено"), false);
        Time.setTimeFrozen(false);

        return 1;
    }
}
