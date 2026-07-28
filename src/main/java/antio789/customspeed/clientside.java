package antio789.customspeed;



import net.minecraft.client.KeyMapping;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.lwjgl.glfw.GLFW;


@Mod(value = "customspeed", dist = Dist.CLIENT)
public class clientside {
    public clientside(IEventBus modBus) {
        // Perform logic in that should only be executed on the physical client
    }
    private static KeyMapping keyBinding;
    private static final Identifier ID = Identifier.fromNamespaceAndPath(main.modid,"keybinds");//new Identifier(main.modid, "keybinds");
    public static final KeyMapping.Category HELP = new KeyMapping.Category(ID);

    @Override
    public void onInitializeClient() {
        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key."+main.modid+".help", // The translation key of the keybinding's name
                InputConstants.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
                GLFW.GLFW_KEY_K, // The keycode of the key
                HELP// The translation key of the keybinding's category.
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (keyBinding.isDown()) {
                client.player.displayClientMessage(Component.translatable(main.modid + ".config.use"), false);
            }
        });
    }


}
