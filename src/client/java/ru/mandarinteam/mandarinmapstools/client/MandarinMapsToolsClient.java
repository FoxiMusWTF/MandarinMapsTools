package ru.mandarinteam.mandarinmapstools.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import ru.mandarinteam.mandarinmapstools.client.screen.Hud_watch;

public class MandarinMapsToolsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		System.out.println("MandarinMapsToolsClient initializeClient");

		//Hud_watch.register();
	}
}