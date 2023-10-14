package uwu.lopyluna.create_brass_ore.registry;


import static uwu.lopyluna.create_brass_ore.BrassCreate.REGISTRATE;

import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.Create;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MaterialColor;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings({"unused", "inline"})
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BCBlocks {

    static {
        REGISTRATE.creativeModeTab(() -> AllCreativeModeTabs.BASE_CREATIVE_TAB);
    }

    public static final BlockEntry<Block> RAW_BRASS_BLOCK = REGISTRATE.block("raw_brass_block", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .properties(p -> p.color(MaterialColor.TERRACOTTA_YELLOW))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.STONE))
            .properties(p -> p.strength(1f,1.6f))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> VERIDIUM_BRASS_ORE = REGISTRATE.block("veridium_brass_ore", Block::new)
            .initialProperties(() -> Blocks.DEEPSLATE_GOLD_ORE)
            .properties(p -> p.color(MaterialColor.TERRACOTTA_YELLOW))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.TUFF))
            .properties(p -> p.strength(4.5f,3f))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> ASURINE_BRASS_ORE = REGISTRATE.block("asurine_brass_ore", Block::new)
            .initialProperties(() -> Blocks.DEEPSLATE_GOLD_ORE)
            .properties(p -> p.color(MaterialColor.TERRACOTTA_YELLOW))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE))
            .properties(p -> p.strength(4.5f,3f))
            .simpleItem()
            .register();


    public static void register() {}
}
