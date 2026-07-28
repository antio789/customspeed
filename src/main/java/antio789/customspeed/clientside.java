package antio789.customspeed;



import net.minecraft.client.KeyMapping;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.common.util.Lazy;
import org.lwjgl.glfw.GLFW;


@Mod(value = "customspeed", dist = Dist.CLIENT)
public class clientside {
    public clientside(IEventBus modBus) {
        // Perform logic in that should only be executed on the physical client
    }
    public static final Lazy<KeyMapping> MOD_KEY = Lazy.of(() -> new KeyMapping("key.customspeed.help",
            InputConstants.Type.KEYSYM,  GLFW.GLFW_KEY_H, KeyMapping.Category.MISC
    ));
    @SubscribeEvent // on the game event bus only on the physical client
    public static void onClientTick(ClientTickEvent.Post event) {
        while (MOD_KEY.get().consumeClick()) {
            // Execute logic to perform on click here
        }
    }

    public static final KeyMapping.Category MOD_CATEGORY = new KeyMapping.Category(Identifier.fromNamespaceAndPath(customspeed.MODID , "config.use"));

    @SubscribeEvent // on the mod event bus only on the physical client
    public static void registerBindings(RegisterKeyMappingsEvent event) {
        // Register category
        event.registerCategory(MOD_CATEGORY);
        // Register binding with category used
        event.register(MOD_KEY.get());
    }


}
