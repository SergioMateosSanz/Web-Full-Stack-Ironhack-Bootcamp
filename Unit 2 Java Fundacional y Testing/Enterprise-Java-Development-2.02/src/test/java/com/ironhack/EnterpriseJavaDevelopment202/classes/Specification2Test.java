package com.ironhack.EnterpriseJavaDevelopment202.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Specification2Test {

    Specification2 specification2;

    @BeforeEach
    void setUp() {
        specification2 = new Specification2();
    }

    @Test
    void validateJavaKeywords_True_InputJavaKeyword() {
        assertTrue(specification2.validateJavaKeywords("Don't abstract my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't assert my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't boolean my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't byte my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't case my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't catch my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't char my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't class my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't const my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't continue my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't default my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't do my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't double my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't else my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't enum my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't extends my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't final my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't finally my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't float my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't for my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't goto my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't if my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't implements my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't import my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't instanceof my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't int my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't interface my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't long my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't native my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't new my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't package my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't private my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't protected my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't public my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't return my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't short my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't static my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't strictfp my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't super my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't switch my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't synchronized my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't this my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't throw my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't throws my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't transient my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't try my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't void my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't volatile my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't while my heart"));
    }

    @Test
    void validateJavaKeywords_False_ValidInput() {
        assertFalse(specification2.validateJavaKeywords("En un lugar de la mancha ..."));
        assertFalse(specification2.validateJavaKeywords("I love to abstractdance"));
        assertFalse(specification2.validateJavaKeywords("I love to assertdance"));
        assertFalse(specification2.validateJavaKeywords("I love to booleandance"));
        assertFalse(specification2.validateJavaKeywords("I love to bytedance"));
        assertFalse(specification2.validateJavaKeywords("I love to casedance"));
        assertFalse(specification2.validateJavaKeywords("I love to catchdance"));
        assertFalse(specification2.validateJavaKeywords("I love to chardance"));
        assertFalse(specification2.validateJavaKeywords("I love to classdance"));
        assertFalse(specification2.validateJavaKeywords("I love to constdance"));
        assertFalse(specification2.validateJavaKeywords("I love to continuedance"));
        assertFalse(specification2.validateJavaKeywords("I love to defaultdance"));
        assertFalse(specification2.validateJavaKeywords("I love to dodance"));
        assertFalse(specification2.validateJavaKeywords("I love to doubledance"));
        assertFalse(specification2.validateJavaKeywords("I love to elsedance"));
        assertFalse(specification2.validateJavaKeywords("I love to enumdance"));
        assertFalse(specification2.validateJavaKeywords("I love to extendsdance"));
        assertFalse(specification2.validateJavaKeywords("I love to finaldance"));
        assertFalse(specification2.validateJavaKeywords("I love to finallydance"));
        assertFalse(specification2.validateJavaKeywords("I love to floatdance"));
        assertFalse(specification2.validateJavaKeywords("I love to fordance"));
        assertFalse(specification2.validateJavaKeywords("I love to gotodance"));
        assertFalse(specification2.validateJavaKeywords("I love to ifdance"));
        assertFalse(specification2.validateJavaKeywords("I love to implementsdance"));
        assertFalse(specification2.validateJavaKeywords("I love to importdance"));
        assertFalse(specification2.validateJavaKeywords("I love to instanceofdance"));
        assertFalse(specification2.validateJavaKeywords("I love to intdance"));
        assertFalse(specification2.validateJavaKeywords("I love to interfacedance"));
        assertFalse(specification2.validateJavaKeywords("I love to longdance"));
        assertFalse(specification2.validateJavaKeywords("I love to nativedance"));
        assertFalse(specification2.validateJavaKeywords("I love to newdance"));
        assertFalse(specification2.validateJavaKeywords("I love to packagedance"));
        assertFalse(specification2.validateJavaKeywords("I love to privatedance"));
        assertFalse(specification2.validateJavaKeywords("I love to protecteddance"));
        assertFalse(specification2.validateJavaKeywords("I love to publicdance"));
        assertFalse(specification2.validateJavaKeywords("I love to returndance"));
        assertFalse(specification2.validateJavaKeywords("I love to shortdance"));
        assertFalse(specification2.validateJavaKeywords("I love to staticdance"));
        assertFalse(specification2.validateJavaKeywords("I love to strictfpdance"));
        assertFalse(specification2.validateJavaKeywords("I love to superdance"));
        assertFalse(specification2.validateJavaKeywords("I love to switchdance"));
        assertFalse(specification2.validateJavaKeywords("I love to synchronizeddance"));
        assertFalse(specification2.validateJavaKeywords("I love to thisdance"));
        assertFalse(specification2.validateJavaKeywords("I love to throwdance"));
        assertFalse(specification2.validateJavaKeywords("I love to throwsdance"));
        assertFalse(specification2.validateJavaKeywords("I love to transientdance"));
        assertFalse(specification2.validateJavaKeywords("I love to trydance"));
        assertFalse(specification2.validateJavaKeywords("I love to voiddance"));
        assertFalse(specification2.validateJavaKeywords("I love to volatiledance"));
        assertFalse(specification2.validateJavaKeywords("I love to whiledance"));
    }

    @Test
    void validateJavaKeywords_True_InputJavaKeywordInUpperCase() {
        assertTrue(specification2.validateJavaKeywords("Don't ABSTRACT my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't ASSERT my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't BOOLEAN my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't BYTE my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't CASE my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't CATCH my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't CHAR my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't CLASS my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't CONST my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't CONTINUE my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't DEFAULT my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't DO my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't DOUBLE my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't ELSE my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't ENUM my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't EXTENDS my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't FINAL my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't FINALLY my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't FLOAT my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't FOR my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't GOTO my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't IF my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't IMPLEMENTS my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't IMPORT my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't INSTANCEOF my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't INT my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't INTERFACE my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't LONG my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't NATIVE my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't NEW my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't PACKAGE my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't PRIVATE my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't PROTECTED my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't PUBLIC my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't RETURN my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't SHORT my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't STATIC my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't STRICTFP my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't SUPER my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't SWITCH my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't SYNCHRONIZED my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't THIS my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't THROW my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't THROWS my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't TRANSIENT my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't TRY my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't VOID my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't VOLATILE my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't WHILE my heart"));
    }

    @Test
    void validateJavaKeywords_True_InputJavaKeywordInUpperAndLowerCase() {
        assertTrue(specification2.validateJavaKeywords("Don't AbStRaCt my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't aSSErT my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't bOOLEAn my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't ByTE my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't CAsE my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't CAtCH my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't ChaR my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't CLASs my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't cONST my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't CONtinUE my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't DEFaULT my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't Do my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't DOUbLE my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't ELsE my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't Enum my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't EXtENDS my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't FInAL my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't FINaLLY my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't FLOaT my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't fOR my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't GoTO my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't iF my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't IMPLeMENTS my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't IMPoRT my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't INSTaNCEOF my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't InT my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't INtERFaCE my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't LOnG my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't NAtIVE my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't NeW my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't PACkAGE my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't PRIvATE my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't PROtECTED my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't PUBlIC my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't RETuRN my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't SHoRT my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't STaTIC my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't StRICTFP my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't SuPER my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't SWItCH my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't SYNChRONIZED my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't THIs my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't ThROW my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't THrOWS my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't TRaNSIENT my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't TrY my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't VOiD my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't VOlATILE my heart"));
        assertTrue(specification2.validateJavaKeywords("Don't WHiLE my heart"));
    }
}