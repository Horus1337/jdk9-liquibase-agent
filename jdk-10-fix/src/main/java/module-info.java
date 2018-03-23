module eu.mhavlik.agent.jdk10liquibase {
    requires net.bytebuddy;
    requires java.instrument;

    opens eu.mhavlik.agent;
}