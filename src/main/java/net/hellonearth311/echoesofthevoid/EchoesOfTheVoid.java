package net.hellonearth311.echoesofthevoid;

import net.fabricmc.api.ModInitializer;

import net.hellonearth311.echoesofthevoid.registries.ModItems;
import net.hellonearth311.echoesofthevoid.registries.entity.ModEntities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoesOfTheVoid implements ModInitializer {
	public static final String MOD_ID = "echoesofthevoid";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// register stuff
		ModItems.initializeModItems();
		ModEntities.initializeModEntities();
		LOGGER.info("Echoes of the Void loaded successfully!");
	}
}