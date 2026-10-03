package ru.mandarinteam.mandarinmapstools.client.manager;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import ru.mandarinteam.mandarinmapstools.client.commands.FrezeeCommand;
import ru.mandarinteam.mandarinmapstools.client.commands.TestCommand;
import ru.mandarinteam.mandarinmapstools.client.commands.TimeCommand;

public class CommandManager {

    public static void registerCommands(CommandDispatcher<CommandSourceStack> dispatcher,
                                        CommandBuildContext registryAccess,
                                        Commands.CommandSelection environment) {

        TestCommand.register(dispatcher);
        TimeCommand.register(dispatcher);
        FrezeeCommand.register(dispatcher);
    }

}
