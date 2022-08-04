package antio789.customspeed.mixin;


import antio789.customspeed.config.ModConfig;
import net.minecraft.entity.passive.FoxEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(FoxEntity.MateGoal.class)
public abstract class foxtimer {

    @ModifyArg(method="breed",at= @At(value = "INVOKE",target = "Lnet/minecraft/entity/passive/AnimalEntity;setBreedingAge(I)V"),index = 0)
    private int init(int par1){
        if(par1==6000) return ModConfig.getAnimal_adult();
        else {
            return ModConfig.getAnimal_baby();
        }
    }
    @ModifyArg(method="breed",at= @At(value = "INVOKE",target = "Lnet/minecraft/entity/passive/FoxEntity;setBreedingAge(I)V"),index = 0)
    private int init2(int par1){
        if(par1==-24000){
            return ModConfig.getAnimal_baby();
        }
         return par1;
    }
}
