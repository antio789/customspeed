package antio789.customspeed.mixin;

import antio789.customspeed.config.ModConfig;
import net.minecraft.world.entity.animal.allay.Allay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Allay.class)
public abstract class Allayduplicationtimer {
    @Shadow private long duplicationCooldown;
    @Inject(at = @At("TAIL"), method = "startDuplicationCooldown")
    private void setspawnerread(CallbackInfo cir){
        duplicationCooldown= ModConfig.getAllayduplication();
    }
}
