package antio789.customspeed.mixin;


import antio789.customspeed.config.ModConfig;
import net.minecraft.world.entity.animal.Animal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;


@Mixin(Animal.class)
public abstract class AdultAnimalTimer {
    @ModifyArg(method = "finalizeSpawnChildFromBreeding(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/animal/Animal;Lnet/minecraft/world/entity/AgeableMob;)V",at = @At(value = "INVOKE",target = "Lnet/minecraft/world/entity/animal/Animal;setAge(I)V"),index = 0)
    private int init(int par1){
        return ModConfig.getAnimal_adult();
    }

}
