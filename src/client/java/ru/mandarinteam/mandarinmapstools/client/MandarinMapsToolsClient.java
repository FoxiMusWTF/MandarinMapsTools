package ru.mandarinteam.mandarinmapstools.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import ru.mandarinteam.mandarinmapstools.client.manager.ClientCommandManager;
import ru.mandarinteam.mandarinmapstools.client.manager.HudManager;
import ru.mandarinteam.mandarinmapstools.manager.CommandManager;

public class MandarinMapsToolsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		System.out.println("MandarinMapsToolsClient initializeClient");

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			ClientCommandManager.registerCommands(dispatcher, registryAccess, environment);
		});

		HudManager.registerHud();
	}
}