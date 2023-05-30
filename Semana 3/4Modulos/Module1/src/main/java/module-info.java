open module com.wizeline.module1 {
    requires transitive org.apache.logging.log4j;

    exports com.wizeline.module1 to com.wizeline.module2;
}