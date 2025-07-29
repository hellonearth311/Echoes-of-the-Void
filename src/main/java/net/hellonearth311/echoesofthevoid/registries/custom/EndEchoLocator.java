package net.hellonearth311.echoesofthevoid.registries.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class EndEchoLocator extends Item {
    public EndEchoLocator(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient) {
            user.sendMessage(Text.literal("The nearest End Echo is at " + get_nearest_end_echo()), false);
            stack.damage(1, user);
        }

        return ActionResult.SUCCESS;
    }

    public String get_nearest_end_echo() {
        // logic for finding nearest end echo here
        // placeholder for now
        return "X: 100 Y: 72 Z: 100";
    }
}
