package ru.mandarinteam.mandarinmapstools.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class TestCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher){
        var rootCommand = Commands.literal("tools")
                .requires(source -> source.hasPermission(2));

        var testSubCommand = Commands.literal("test")
                .executes(TestCommand::run);

        rootCommand.then(testSubCommand);

        dispatcher.register(rootCommand);
    }

    private static int run(CommandContext<CommandSourceStack> context){
        context.getSource().sendSuccess(() -> Component.literal("Test"), false);

        return 1;
    }

}
