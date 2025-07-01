package com.valxor.dispenserseed.mixin;

import net.minecraft.block.DispenserBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.valxor.dispenserseed.behavior.SeedDispenserBehavior;

@Mixin(DispenserBlock.class)
public class DispenserBlockMixin {
    
    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void onStaticInit(CallbackInfo ci) {


        SeedDispenserBehavior.registerBehaviors();
    }
}
