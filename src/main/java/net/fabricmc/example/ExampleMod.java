package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.network.packet.s2c.play.ParticleS2CPacket;
import net.minecraft.particle.ParticleTypes;

public class ExampleMod implements ModInitializer {
    @Override
    public void onInitialize() {
        ServerTickEvents.START_SERVER_TICK.register(server -> {
            server.getPlayerManager().getPlayerList().forEach(p -> {
                var packet = new ParticleS2CPacket(ParticleTypes.FIREWORK, false, 0, 0, 0, 0, 0, 0, 0, 1);
                for (int i = 0; i < 1000; i++) {
                    p.networkHandler.sendPacket(packet);
                }
            });
        });
    }
}
