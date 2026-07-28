package antio789.customspeed.mixin;


import antio789.customspeed.config.ModConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(targets = "net.minecraft.world.entity.animal.fox.Fox$FoxBreedGoal")
public abstract class foxtimer {

    @ModifyArg(method = "breed", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/Animal;setAge(I)V"), index = 0)
    private int init(int par1) {
        return par1 == 6000 ? ModConfig.getAnimal_adult() : ModConfig.getAnimal_baby();
    }

    @ModifyArg(method = "breed", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/fox/Fox;setAge(I)V"), index = 0)
    private int init2(int par1) {
        return par1 == -24000 ? ModConfig.getAnimal_baby() : par1;
    }
}