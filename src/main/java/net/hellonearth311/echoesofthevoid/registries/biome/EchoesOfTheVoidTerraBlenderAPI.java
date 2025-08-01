package net.hellonearth311.echoesofthevoid.registries.biome;

import net.hellonearth311.echoesofthevoid.EchoesOfTheVoid;
import net.hellonearth311.echoesofthevoid.registries.biome.surface.EchoesOfTheVoidSurfaceRules;
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
        Regions.register(new EndEchoRegion(Identifier.of(EchoesOfTheVoid.MOD_ID, "end_echo_region"), 6));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD , EchoesOfTheVoid.MOD_ID, EchoesOfTheVoidSurfaceRules.makeRules());
    }

    public class EndEchoRegion extends Region {
        public EndEchoRegion(Identifier id, int weight)
        {
            super(id, RegionType.OVERWORLD, weight);
        }

        @Override
        public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
            VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

            new ParameterPointListBuilder()
                    .temperature(Temperature.span(Temperature.COOL, Temperature.NEUTRAL))
                    .humidity(Humidity.span(Humidity.NEUTRAL, Humidity.HUMID))
                    .continentalness(Continentalness.INLAND)
                    .erosion(Erosion.FULL_RANGE)
                    .depth(Depth.SURFACE, Depth.FLOOR)
                    .weirdness(Weirdness.PEAK_NORMAL)
                    .build().forEach(point -> builder.add(point, ModBiomes.END_ECHO));

            builder.build().forEach(mapper);
        }
    }

}
