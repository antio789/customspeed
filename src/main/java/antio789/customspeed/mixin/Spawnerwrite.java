package antio789.customspeed.mixin;

import antio789.customspeed.config.ModConfig;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.MobSpawnerLogic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobSpawnerLogic.class)
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
    @Inject(at = @At("RETURN"), method = "writeNbt")
    private void setspawnerread(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> cir){
        this.minSpawnDelay=ModConfig.getMinspawndelay();
        this.maxSpawnDelay=ModConfig.getMaxspawndelay();
    }

}
