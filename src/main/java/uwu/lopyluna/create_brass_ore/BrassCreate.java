package uwu.lopyluna.create_brass_ore;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.AllLangPartials;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.LangMerger;
import com.simibubi.create.foundation.data.TagGen;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.TooltipHelper;
import com.simibubi.create.foundation.item.TooltipModifier;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import uwu.lopyluna.create_brass_ore.registry.BCBlocks;
import uwu.lopyluna.create_brass_ore.registry.BCItems;


@Mod(BrassCreate.MOD_ID)
public class BrassCreate
{
    public static final String NAME = "Create: Dreams n' Desires";
    public static final String MOD_ID = "create_dd";
    public static final String VERSION = "PREBETA.0.1a";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(BrassCreate.MOD_ID);


    public BrassCreate()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        REGISTRATE.registerEventListeners(eventBus);


        BCBlocks.register();
        BCItems.register();



        

        eventBus.addListener(this::clientSetup);

        eventBus.addListener(BrassCreate::init);
        eventBus.addListener(EventPriority.LOWEST, BrassCreate::gatherData);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

    }

    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
        });
    }
    private void clientSetup(final FMLClientSetupEvent event) {
    }

    public static void gatherData(GatherDataEvent event) {
        TagGen.datagen();
        DataGenerator gen = event.getGenerator();
        if (event.includeClient()) {
            gen.addProvider(true, new LangMerger(gen, MOD_ID, NAME, AllLangPartials.values()));
        }
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(BrassCreate.MOD_ID, path);
    }

}
