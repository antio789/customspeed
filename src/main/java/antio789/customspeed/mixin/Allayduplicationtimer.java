package antio789.customspeed.mixin;

import antio789.customspeed.config.csGameRules;
import net.minecraft.world.entity.animal.allay.Allay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Allay.class)
public abstract class Allayduplicationtimer {
    @Shadow private long duplicationCooldown;
    @Inject(at = @At("TAIL"), method = "resetDuplicationCooldown")
    private void setspawnerread(CallbackInfo cir){
        duplicationCooldown= csGameRules.getAllay_duplication();
    }
}
