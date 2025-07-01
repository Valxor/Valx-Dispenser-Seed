package com.valxor.dispenserseed;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.valxor.dispenserseed.behavior.SeedDispenserBehavior;

public class Valxdispenserseed implements ModInitializer {
	public static final String MOD_ID = "valxdispenserseed";




	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {




		LOGGER.info("Initializing ValxDispenerSeed mod...");
		

		SeedDispenserBehavior.registerBehaviors();
		
		LOGGER.info("ValxDispenerSeed mod initialized successfully!");
	}
}
