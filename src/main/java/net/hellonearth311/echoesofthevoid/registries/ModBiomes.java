package net.hellonearth311.echoesofthevoid.registries;

import net.hellonearth311.echoesofthevoid.EchoesOfTheVoid;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomes {
    public static final RegistryKey<Biome> END_ECHO = RegistryKey.of(RegistryKeys.BIOME, 
            Identifier.of(EchoesOfTheVoid.MOD_ID, "end_echo"));

    public static void registerBiomes() {
        EchoesOfTheVoid.LOGGER.info("Registering mod biomes for " + EchoesOfTheVoid.MOD_ID);
    }
}
