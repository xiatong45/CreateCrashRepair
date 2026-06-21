package com.createrepair.mixin;

import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * Mixin that prevents CreateCrash from throwing a RuntimeException
 * when the Create mod is installed. Redirects the isLoaded check
 * to always return false, so Create and CreateCrash can coexist.
 */
@Mixin(targets = "com.chapple.createcrash.CreateCrash", remap = false)
public class CreateCrashMixin {

    @Redirect(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraftforge/fml/ModList;isLoaded(Ljava/lang/String;)Z"
            )
    )
    private boolean createcrashRepair$preventCrash(ModList instance, String modId) {
        return false;
    }
}
