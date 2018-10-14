module com.mehdi.main {
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.boot;
    requires org.apache.logging.log4j;
    requires java.sql;

    requires com.mehdi.api.length.controller;

    opens com.mehdi.main to spring.core;

    exports com.mehdi.main;
}