package ru.mandarinteam.mandarinmapstools.client.manager;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import ru.mandarinteam.mandarinmapstools.client.commands.HudClientCommand;
import ru.mandarinteam.mandarinmapstools.commands.FrezeeCommand;
import ru.mandarinteam.mandarinmapstools.commands.TestCommand;
import ru.mandarinteam.mandarinmapstools.commands.TimeCommand;

public class ClientCommandManager {

    public static void registerCommands(CommandDispatcher<CommandSourceStack> dispatcher,
                                        CommandBuildContext registryAccess,
                                        Commands.CommandSelection environment) {

        HudClientCommand.register(dispatcher);
    }

}
