package net.hellonearth311.echoesofthevoid;

import net.fabricmc.api.ModInitializer;

import net.hellonearth311.echoesofthevoid.registries.ModBiomes;
import net.hellonearth311.echoesofthevoid.registries.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoesOfTheVoid implements ModInitializer {
	public static final String MOD_ID = "echoesofthevoid";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Echoes of the Void world!");
		ModBiomes.registerBiomes();
		ModItems.initializeModItems();
	}
}