package com.chapple.createcrashrepair.mixin;

import com.chapple.createcrash.CreateCrash;
import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * Mixin that intercepts CreateCrash's constructor check for the Create mod.
 * When CreateCrash calls ModList.get().isLoaded("create"), we redirect it to
 * return false, preventing the intentional RuntimeException that would crash the game.
 */
@Mixin(CreateCrash.class)
public class CreateCrashMixin {

    @Redirect(
        method = "<init>(Lnet/minecraftforge/fml/javafmlmod/FMLJavaModLoadingContext;)V",
        at = @At(value = "INVOKE", target = "Lnet/minecraftforge/fml/ModList;isLoaded(Ljava/lang/String;)Z"),
        require = 0
    )
    private boolean preventCreateCrashCrash(ModList modList, String modId) {
        if ("create".equals(modId)) {
            return false;
        }
        return modList.isLoaded(modId);
    }
}
