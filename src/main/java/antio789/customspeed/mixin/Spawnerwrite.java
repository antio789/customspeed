package antio789.customspeed.mixin;

import antio789.customspeed.config.csGameRules;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.storage.ValueOutput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BaseSpawner.class)
public abstract class Spawnerwrite {
    @Shadow private int minSpawnDelay;

    @Shadow private int maxSpawnDelay;
/*
    @Inject(at = @At("RETURN"), method = "writeNbt",cancellable = true)
    private void setspawnerspeed(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> cis){
        System.out.println("changed");
        nbt.putShort("MinSpawnDelay", (short) ModConfig.getMinspawndelay());
        nbt.putShort("MaxSpawnDelay", (short) ModConfig.getMaxspawndelay());
        System.out.println(nbt.getShort("MinSpawnDelay"));
        cis.setReturnValue(nbt);
    }
*/
    @Inject(at = @At("RETURN"), method = "save")
    private void setspawnerread(ValueOutput view, CallbackInfo ci){
            this.minSpawnDelay = csGameRules.getMinspawndelay();
            this.maxSpawnDelay = csGameRules.getMaxspawndelay();
    }

}
