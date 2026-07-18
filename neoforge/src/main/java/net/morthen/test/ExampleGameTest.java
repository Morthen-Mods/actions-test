package net.morthen.test;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.level.block.Blocks;
import net.morthen.example.ExampleConstants;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Consumer;


public class ExampleGameTest {
    public static void exampleTest(GameTestHelper helper) {
        helper.setBlock(0, 0, 0, Blocks.DIRT);
        helper.assertBlockPresent(Blocks.DIRT, new BlockPos(0, 0, 0));
        helper.succeed();
    }

    public static final DeferredRegister<Consumer<GameTestHelper>> TEST_FUNCTION =
            DeferredRegister.create(BuiltInRegistries.TEST_FUNCTION, ExampleConstants.MOD_ID);

    public static final DeferredHolder<Consumer<GameTestHelper>, Consumer<GameTestHelper>> EXAMPLE_FUNCTION =
            TEST_FUNCTION.register("example_function", () -> ExampleGameTest::exampleTest);
}
