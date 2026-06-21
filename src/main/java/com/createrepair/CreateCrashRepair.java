package com.createrepair;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(CreateCrashRepair.MOD_ID)
public class CreateCrashRepair {
    public static final String MOD_ID = "createcrashrepair";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CreateCrashRepair(FMLJavaModLoadingContext context) {
        LOGGER.info("CreateCrashRepair loaded - CreateCrash crash patch is active");
    }
}
