open module com.mehdi.api.length.controller {
    requires spring.boot.autoconfigure;
    requires org.apache.logging.log4j;
    requires spring.boot;
    requires java.sql;
    requires spring.web;

    exports com.mehdi.api.length.controller;
}