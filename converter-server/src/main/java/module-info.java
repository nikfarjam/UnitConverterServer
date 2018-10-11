module com.mehdi.main {
    requires spring.boot.autoconfigure;
    requires org.apache.logging.log4j;
    requires spring.boot;
    requires java.sql;

    opens com.mehdi.main to spring.core;

    exports com.mehdi.main;
}