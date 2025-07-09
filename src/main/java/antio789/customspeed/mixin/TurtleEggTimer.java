package antio789.customspeed.mixin;


import antio789.customspeed.config.ModConfig;
import net.minecraft.block.TurtleEggBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;


@Mixin(TurtleEggBlock.class)
public abstract class TurtleEggTimer {
    @ModifyArg(method = "randomTick(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/random/Random;)V",at = @At(value = "INVOKE",target = "Lnet/minecraft/entity/passive/TurtleEntity;setBreedingAge(I)V"),index = 0)
    private int init(int par1){
        return ModConfig.getAnimal_baby();
    }

    @ModifyArg(method = "shouldHatchProgress(Lnet/minecraft/world/World;)Z",at = @At(value = "INVOKE",target = "Lnet/minecraft/util/math/random/Random;nextInt(I)I"),index = 0 )
    private int hatchprogress(int par1){
        return ModConfig.getTurtleCrackChance();
    }
}
