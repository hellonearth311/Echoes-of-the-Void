package net.hellonearth311.echoesofthevoid.registries.biome.surface;

import net.hellonearth311.echoesofthevoid.registries.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.minecraft.world.gen.surfacebuilder.MaterialRules.MaterialCondition;
import net.minecraft.world.gen.surfacebuilder.MaterialRules.MaterialRule;

public class EchoesOfTheVoidNetherSurfaceRules {
    // block rules
    private static final MaterialRule NETHERRACK = makeStateRule(Blocks.NETHERRACK);
    private static final MaterialRule NETHER_BRICKS = makeStateRule(Blocks.NETHER_BRICKS);

    // noise params
    private static final RegistryKey<DoublePerlinNoiseSampler.NoiseParameters> CAVE_LAYER_NOISE =
        RegistryKey.of(RegistryKeys.NOISE_PARAMETERS, Identifier.ofVanilla("cave_layer"));
    private static final RegistryKey<DoublePerlinNoiseSampler.NoiseParameters> SURFACE_NOISE =
        RegistryKey.of(RegistryKeys.NOISE_PARAMETERS, Identifier.ofVanilla("surface"));

    public static MaterialRule makeRules() {
        // ooooohhhh fancy terrain :D
        MaterialCondition noiseCondition = MaterialRules.noiseThreshold(CAVE_LAYER_NOISE, -0.2, 0.8);
        MaterialCondition surfaceNoiseCondition = MaterialRules.noiseThreshold(SURFACE_NOISE, 0.3, 1.0);
        MaterialCondition randomBricksCondition = MaterialRules.noiseThreshold(CAVE_LAYER_NOISE, 0.4, 1.0);
        MaterialCondition onFloorCondition = MaterialRules.STONE_DEPTH_FLOOR;
        MaterialCondition nearSurfaceCondition = MaterialRules.stoneDepth(0, false, VerticalSurfaceType.FLOOR);
        MaterialCondition highElevationCondition = MaterialRules.aboveY(YOffset.fixed(60), 0);

        MaterialRule mixedSurface = MaterialRules.sequence(
                MaterialRules.condition(highElevationCondition, NETHER_BRICKS),

                MaterialRules.condition(onFloorCondition,
                    MaterialRules.condition(noiseCondition, NETHER_BRICKS)
                ),

                MaterialRules.condition(nearSurfaceCondition,
                    MaterialRules.condition(surfaceNoiseCondition, NETHER_BRICKS)
                ),

                MaterialRules.condition(randomBricksCondition, NETHER_BRICKS),

                NETHERRACK
        );

        return MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.biome(ModBiomes.NETHER_ECHO), mixedSurface)
        );
    }

    private static MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}