package eu.scoopgmbh.agent;

import java.lang.instrument.Instrumentation;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

public class LiquibasePatcher {

    public static void premain(String args, Instrumentation instrumentation) {
        new AgentBuilder.Default()
            .with(AgentBuilder.RedefinitionStrategy.RETRANSFORMATION)
            .with(AgentBuilder.TypeStrategy.Default.REDEFINE)
            .type(ElementMatchers.named("liquibase.util.SystemUtils"))
            .transform((builder, typeDescription, classLoader, module) -> builder.method(ElementMatchers.named("getJavaVersionTrimmed")).intercept(FixedValue.value("9.0.0")))
            .installOn(instrumentation);
    }

}
