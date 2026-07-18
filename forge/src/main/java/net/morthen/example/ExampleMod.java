package net.morthen.example;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.morthen.test.ExampleGameTest;

@Mod(ExampleConstants.MOD_ID)
public class ExampleMod {
    public ExampleMod(FMLJavaModLoadingContext context) {
        ExampleGameTest.TEST_FUNCTION.register(context.getModBusGroup());
        System.out.println("ExampleMod Loaded");
    }
}
