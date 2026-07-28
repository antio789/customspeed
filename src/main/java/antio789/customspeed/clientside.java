package antio789.customspeed;



import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;

public class clientside implements ClientModInitializer {
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
