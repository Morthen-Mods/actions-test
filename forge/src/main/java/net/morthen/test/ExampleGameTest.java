package net.morthen.test;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.morthen.example.ExampleConstants;

import java.util.function.Consumer;


public class ExampleGameTest {
    public static void exampleTest(GameTestHelper helper) {
        helper.setBlock(0, 0, 0, Blocks.DIRT);
        helper.assertBlockPresent(Blocks.DIRT, new BlockPos(0, 0, 0));
        helper.succeed();
    }

    public static final DeferredRegister<Consumer<GameTestHelper>> TEST_FUNCTION =
            DeferredRegister.create(Registries.TEST_FUNCTION, ExampleConstants.MOD_ID);

    public static final RegistryObject<Consumer<GameTestHelper>> EXAMPLE_FUNCTION =
            TEST_FUNCTION.register("example_function", () -> ExampleGameTest::exampleTest);
}
