package uwu.lopyluna.create_brass_ore.registry;

import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.Create;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

import static uwu.lopyluna.create_brass_ore.BrassCreate.REGISTRATE;

import net.minecraft.MethodsReturnNonnullByDefault;
import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings({"unused", "inline"})
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BCItems {

    static {
        Create.REGISTRATE.creativeModeTab(() -> AllCreativeModeTabs.BASE_CREATIVE_TAB);
    }

    public static final ItemEntry<Item>
            CRUSHED_RAW_BRASS = ingredient("crushed_raw_brass"),
            raw_brass = ingredient("raw_brass");


    private static ItemEntry<Item> ingredient(String name) {
        return REGISTRATE.item(name, Item::new)
                .register();
    }

    public static void register() {}
}
