package io.github.intersteed.blackblock.blockentities;

import io.github.intersteed.blackblock.blocks.TheBlackBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;
import io.github.intersteed.blackblock.blockentities.BlackBlockEntity;

import java.util.function.Supplier;

import static io.github.intersteed.blackblock.BlackBlock.MODID;
import static io.github.intersteed.blackblock.blocks.RegisterBlocks.THE_BLACK_BLOCK;

public class RegisterBlockEntityTypes {

    public static DeferredRegister<BlockEntityType<?>> DR = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MODID);
    public static Supplier<BlockEntityType<BlackBlockEntity>> BLACK_BLOCK_ENTITY_TYPE = DR.register(BlackBlockEntity.REGISTRY_NAME,
            () -> BlockEntityType.Builder.of(
                    BlackBlockEntity::new,
                    THE_BLACK_BLOCK.get()
            ).build(null));
}
