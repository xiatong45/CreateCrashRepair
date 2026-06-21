package com.chapple.createcrashrepair;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(CreateCrashRepair.MOD_ID)
public class CreateCrashRepair {
    public static final String MOD_ID = "createcrashrepair";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CreateCrashRepair() {
        LOGGER.info("CreateCrashRepair loaded. Patching CreateCrash to prevent crash when Create is present.");
    }
}
