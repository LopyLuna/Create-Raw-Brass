package uwu.lopyluna.create_brass_ore.worldgen;

import com.google.common.base.Suppliers;
import com.simibubi.create.content.decoration.palettes.AllPaletteStoneTypes;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import uwu.lopyluna.create_brass_ore.BrassCreate;
import uwu.lopyluna.create_brass_ore.BrassTags;
import uwu.lopyluna.create_brass_ore.registry.BCBlocks;

import java.util.List;
import java.util.function.Supplier;

public class WorldgenOreFeatures {

    public static final RuleTest ASURINE = new TagMatchTest(BrassTags.AllBlockTags.asurine_brass_replaceable.tag);
    public static final RuleTest VERIDIUM = new TagMatchTest(BrassTags.AllBlockTags.veridium_brass_replaceable.tag);


    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, BrassCreate.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_TIN_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(ASURINE, BCBlocks.ASURINE_BRASS_ORE.get().defaultBlockState()),
            OreConfiguration.target(VERIDIUM, BCBlocks.VERIDIUM_BRASS_ORE.get().defaultBlockState())));


    public static final RegistryObject<ConfiguredFeature<?, ?>> brass_ore = CONFIGURED_FEATURES.register("brass_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_TIN_ORES.get(),8)));

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
