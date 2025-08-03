package net.hellonearth311.echoesofthevoid.registries.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;

public class EndEchoLocator extends Item {
    public EndEchoLocator(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient && user instanceof ServerPlayerEntity serverPlayer) {
            ServerWorld serverWorld = serverPlayer.getWorld();
            MinecraftServer server = serverWorld.getServer();

            ServerCommandSource source = serverPlayer.getCommandSource().withLevel(2);

            server.getCommandManager().executeWithPrefix(source, "locate biome minecraft:plains");

            stack.damage(1, user);
        }

        return ActionResult.SUCCESS;
    }
}
