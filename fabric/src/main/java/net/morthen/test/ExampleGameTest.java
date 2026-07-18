package net.morthen.test;

import net.fabricmc.fabric.api.gametest.v1.CustomTestMethodInvoker;
import net.fabricmc.fabric.api.gametest.v1.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.level.block.Blocks;
import net.morthen.example.ExampleConstants;

import java.lang.reflect.Method;

public class ExampleGameTest implements CustomTestMethodInvoker {

    @GameTest
    public void dirtAtOrigin(GameTestHelper helper) {
        ExampleConstants.LOGGER.info("Testing Dirt at Origin");
        helper.assertBlockPresent(Blocks.DIRT, 0, 0, 0);
        helper.succeed();
    }

    @Override
    public void invokeTestMethod(GameTestHelper helper, Method method) throws ReflectiveOperationException {
        helper.setBlock(0, 0, 0, Blocks.DIRT);
        method.invoke(this, helper);
    }
}
