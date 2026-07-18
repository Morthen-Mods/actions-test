package net.morthen.example;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.gametest.framework.FunctionGameTestInstance;
import net.minecraft.gametest.framework.TestData;
import net.minecraft.gametest.framework.TestEnvironmentDefinition;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Rotation;
import net.morthen.test.ExampleGameTest;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.RegisterGameTestsEvent;

@Mod(ExampleConstants.MOD_ID)
public class Example {

    public Example(IEventBus bus) {
        ExampleGameTest.TEST_FUNCTION.register(bus);
        bus.register(Example.class);
    }

    @SubscribeEvent // on the mod event bus
    public static void registerTests(RegisterGameTestsEvent event) {
        Holder<TestEnvironmentDefinition<?>> env = event.registerEnvironment(
                Identifier.fromNamespaceAndPath(ExampleConstants.MOD_ID, "example_environment"),
                new TestEnvironmentDefinition.Weather(TestEnvironmentDefinition.Weather.Type.THUNDER)
        );

        event.registerTest(
                Identifier.fromNamespaceAndPath(ExampleConstants.MOD_ID, "example_test"),
                new FunctionGameTestInstance(
                        ExampleGameTest.EXAMPLE_FUNCTION.getKey(),
                        new TestData<>(env, Identifier.withDefaultNamespace("empty"),
                                400, 50, true, Rotation.NONE)
                )
        );
    }

}
