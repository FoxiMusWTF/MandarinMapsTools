package ru.mandarinteam.mandarinmapstools.client.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import ru.mandarinteam.mandarinmapstools.utils.time.Time;

public class TimeCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher){
        var rootCommand = Commands.literal("tools")
                .requires(source -> source.hasPermission(2));

        var timeSubCommand = Commands.literal("time")
                .executes(TimeCommand::runGetTime);

        rootCommand.then(timeSubCommand);

        dispatcher.register(rootCommand);
    }

    private static int runGetTime(CommandContext<CommandSourceStack> context){
        context.getSource().sendSuccess(() -> Component.literal("Сейчас " + Time.getTime()), false);

        return 1;
    }

}
