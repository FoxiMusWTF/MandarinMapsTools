package ru.mandarinteam.mandarinmapstools.api.network;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record HudSyncPayload(String message, boolean value) implements CustomPacketPayload {

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return null;
    }
}
