package ru.mandarinteam.mandarinmapstools.client.screen;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import ru.mandarinteam.mandarinmapstools.utils.time.Time;

public class Hud_watch implements HudRenderCallback {

    public static final ResourceLocation WATCH_TEXTURE = ResourceLocation.fromNamespaceAndPath("mandarinmapstools", "images/hud_watch.png");

    private static float testBattery = 75.0F;
    private static int testDay = 1;

    public static void register() {
        HudRenderCallback.EVENT.register(new Hud_watch());
    }

    @Override
    public void onHudRender(GuiGraphics drawContext, DeltaTracker tickCounter) {

        Minecraft minecraft = Minecraft.getInstance();

        int screenWidth = drawContext.guiWidth();
        int screenHeight = drawContext.guiHeight();
        Font font = minecraft.font;

        int x = 10;
        int y = screenHeight - 80;

        drawContext.blit(WATCH_TEXTURE, x, y, 0, 0, 65, 65, 65, 65);

        String timeString = Time.getTime();


        drawContext.pose().pushPose();
        drawContext.pose().scale(2.0F, 4.0F, 2.0F);

        int timeY = (int) ((y + 30) / 4.0F);

        drawContext.drawString(font, timeString, x - 1, timeY, 0xFFFFFF, false);
        drawContext.pose().popPose();
    }
}