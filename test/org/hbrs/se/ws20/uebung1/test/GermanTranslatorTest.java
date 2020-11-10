package org.hbrs.se.ws20.uebung1.test;

import org.hbrs.se.ws20.uebung1.control.GermanTranslator;
import org.hbrs.se.ws20.uebung1.control.Translator;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    GermanTranslator gt;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        gt = new GermanTranslator();
    }

    @org.junit.jupiter.api.Test
    void translateNumber() {
        assertEquals("sieben", gt.translateNumber(7));
        assertEquals("Übersetzung der Zahl 11 nicht möglich (1.0)", gt.translateNumber(11));
        assertEquals("Übersetzung der Zahl -1 nicht möglich (1.0)", gt.translateNumber(-1));
        assertEquals("Übersetzung der Zahl 0 nicht möglich (1.0)", gt.translateNumber(0));
    }
}