package net.hellonearth311.echoesofthevoid.registries.biome;

import net.hellonearth311.echoesofthevoid.EchoesOfTheVoid;
import net.hellonearth311.echoesofthevoid.registries.biome.region.EndEchoRegion;
import net.hellonearth311.echoesofthevoid.registries.biome.region.NetherEchoRegion;
import net.hellonearth311.echoesofthevoid.registries.biome.surface.EchoesOfTheVoidEndSurfaceRules;
import net.hellonearth311.echoesofthevoid.registries.biome.surface.EchoesOfTheVoidNetherSurfaceRules;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.*;
import terrablender.api.ParameterUtils.Continentalness;
import terrablender.api.ParameterUtils.Depth;
import terrablender.api.ParameterUtils.Erosion;
import terrablender.api.ParameterUtils.Humidity;
import terrablender.api.ParameterUtils.ParameterPointListBuilder;
import terrablender.api.ParameterUtils.Temperature;
import terrablender.api.ParameterUtils.Weirdness;

import java.util.function.Consumer;

import com.mojang.datafixers.util.Pair;

import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class EchoesOfTheVoidTerraBlenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized()
    {
        // register end echo region + surface rules
        Regions.register(new EndEchoRegion(Identifier.of(EchoesOfTheVoid.MOD_ID, "end_echo_region"), 2));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, EchoesOfTheVoid.MOD_ID, EchoesOfTheVoidEndSurfaceRules.makeRules());

        // register nether echo region + surface rules
        Regions.register(new NetherEchoRegion(Identifier.of(EchoesOfTheVoid.MOD_ID, "nether_echo_region"), 2));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, EchoesOfTheVoid.MOD_ID, EchoesOfTheVoidNetherSurfaceRules.makeRules());
    }
}
