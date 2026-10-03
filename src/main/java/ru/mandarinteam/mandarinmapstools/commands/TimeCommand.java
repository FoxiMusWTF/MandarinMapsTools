package ru.mandarinteam.mandarinmapstools.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import ru.mandarinteam.mandarinmapstools.utils.time.Time;

public class TimeCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher){
        var rootCommand = Commands.literal("tools")
                .requires(source -> source.hasPermission(2));

        var timeSubCommand = Commands.literal("time");

        var timeGetCommand = Commands.literal("get")
                        .executes(TimeCommand::runGetTime);

        var timeSetCommand = Commands.literal("set");

        var timeSetHoursCommand = Commands.literal("hours")
                .then(Commands.argument("value", IntegerArgumentType.integer(0, 23))
                        .executes(TimeCommand::runSetHoursTime));

        var timeSetMinutesCommand = Commands.literal("minutes")
                .then(Commands.argument("value", IntegerArgumentType.integer(0, 59))
                        .executes(TimeCommand::runSetMinutesTime));

        timeSetCommand.then(timeSetMinutesCommand);
        timeSetCommand.then(timeSetHoursCommand);
        timeSubCommand.then(timeSetCommand);
        timeSubCommand.then(timeGetCommand);
        rootCommand.then(timeSubCommand);

        dispatcher.register(rootCommand);
    }

    private static int runGetTime(CommandContext<CommandSourceStack> context){
        context.getSource().sendSuccess(() -> Component.literal("Сейчас " + Time.getTime()), false);

        return 1;
    }

    private static int runSetHoursTime(CommandContext<CommandSourceStack> context){

        int hours = IntegerArgumentType.getInteger(context, "value");

        Time.setCustomHours(hours);

        return 1;
    }

    private static int runSetMinutesTime(CommandContext<CommandSourceStack> context){

        int minutes = IntegerArgumentType.getInteger(context, "value");

        Time.setCustomMinutes(minutes);

        return 1;
    }

}
