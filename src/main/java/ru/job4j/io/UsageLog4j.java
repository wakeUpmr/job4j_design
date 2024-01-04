package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        short shortPrim = 5;
        int intPrim = 33000;
        long longPrim = 3000000000L;
        double doublePrim = 10.25;
        float floatPrim = 20.25F;
        char charPrim = 'a';
        boolean boolPrim = true;
        byte bytePrim = 127;

        LOG.debug("short primitive : {}", shortPrim);
        LOG.debug("integer primitive : {}", intPrim);
        LOG.debug("long primitive : {}", longPrim);
        LOG.debug("double primitive : {}", doublePrim);
        LOG.debug("float primitive : {}", floatPrim);
        LOG.debug("char primitive : {}", charPrim);
        LOG.debug("boolean primitive : {}", boolPrim);
        LOG.debug("byte primitive : {}", bytePrim);


    }
}