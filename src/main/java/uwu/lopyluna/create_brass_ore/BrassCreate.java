package uwu.lopyluna.create_brass_ore;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import uwu.lopyluna.create_brass_ore.registry.BCBlocks;
import uwu.lopyluna.create_brass_ore.registry.BCItems;
import uwu.lopyluna.create_brass_ore.worldgen.WorldgenOreFeatures;
import uwu.lopyluna.create_brass_ore.worldgen.WorldgenOrePlacedFeatures;


@Mod(BrassCreate.MOD_ID)
public class BrassCreate
{
    public static final String MOD_ID = "create_brass_ore";

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(BrassCreate.MOD_ID);


    public BrassCreate()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        REGISTRATE.registerEventListeners(eventBus);


        BCBlocks.register();
        BCItems.register();

        BrassTags.init();
        WorldgenOreFeatures.register(eventBus);
        WorldgenOrePlacedFeatures.register(eventBus);
        

        eventBus.addListener(this::clientSetup);
        eventBus.addListener(BrassCreate::init);

        MinecraftForge.EVENT_BUS.register(this);

    }

    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
        });
    }
    private void clientSetup(final FMLClientSetupEvent event) {
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(BrassCreate.MOD_ID, path);
    }

}
