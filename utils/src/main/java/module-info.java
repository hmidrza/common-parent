module ir.hamapp.commons.utils {
    requires org.junit.jupiter.api;
    requires ir.hamapp.commons.time;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    exports ir.hamapp.commons.utils.json;
    exports ir.hamapp.commons.utils.characters;
    exports ir.hamapp.commons.utils.test;
}