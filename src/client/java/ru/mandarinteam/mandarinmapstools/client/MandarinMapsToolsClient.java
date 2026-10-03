package ru.mandarinteam.mandarinmapstools.client;

import net.fabricmc.api.ClientModInitializer;
import ru.mandarinteam.mandarinmapstools.client.manager.CommandManager;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import ru.mandarinteam.mandarinmapstools.client.screen.Hud_watch;

public class MandarinMapsToolsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		System.out.println("MandarinMapsToolsClient initializeClient");

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			CommandManager.registerCommands(dispatcher, registryAccess, environment);
		});
		Hud_watch.register();
	}
}