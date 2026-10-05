package ru.mandarinteam.mandarinmapstools.client.manager;

import ru.mandarinteam.mandarinmapstools.client.screen.Hud_watch;

public class HudManager {

    public static boolean watchIsVisibleClient = true;

    public static void registerHud(){
        Hud_watch.register();
    }

}
