package antio789.customspeed.mixin;


import antio789.customspeed.config.ModConfig;
import net.minecraft.block.TurtleEggBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;


@Mixin(TurtleEggBlock.class)
public abstract class TurtleEggTimer {
    @ModifyArg(method = "randomTick(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/random/Random;)V",at = @At(value = "INVOKE",target = "Lnet/minecraft/entity/passive/TurtleEntity;setBreedingAge(I)V"),index = 0)
    private int init(int par1){
        return ModConfig.getAnimal_baby();
    }

    //"shouldHatchProgress(Lnet/minecraft/world/World;)Z",at = @At(value = "INVOKE",target = "Lnet/minecraft/util/math/random/Random;nextInt(I)I"),index = 0 )
    @ModifyVariable(method = "shouldHatchProgress(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)Z",at = @At(value = "STORE"))
    private float chance(float f){
        if(f < 1.0f){
            return ModConfig.getTurtleCrackChance();
        }
        return f;
    }
}
