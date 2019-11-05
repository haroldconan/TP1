package com.tp.tp1;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChiffreCesarTest {

    @Test
    public void chiffreCesar_decalage0() throws Exception {
        assertEquals("ABCDEF", ChiffreCesar.chiffrement("ABCDEF",0));
    }

    @Test
    public void chiffreCesar_decalage1() throws Exception {
        assertEquals("BCDEFG", ChiffreCesar.chiffrement("ABCDEF",1));
    }

    @Test
    public void chiffreCesar_minuscules_decalage1() throws Exception {
        assertEquals("BCDEFG", ChiffreCesar.chiffrement("abcdef",1));
    }

    @Test
    public void chiffreCesar_minuscules_decalage4() throws Exception {
        assertEquals("EFGHIJ", ChiffreCesar.chiffrement("abcdef",4));
    }

    @Test
    public void chiffreCesar_caracteresNonChiffres() throws Exception {
        assertEquals("EFG &;HIJ", ChiffreCesar.chiffrement("abc &;def",4));
    }

    @Test
    public void chiffreCesar_Z_decalage1() throws Exception {
        assertEquals("A", ChiffreCesar.chiffrement("Z",1));
    }

    @Test
    public void chiffreCesar_Z_decalage3() throws Exception {
        assertEquals("C", ChiffreCesar.chiffrement("Z",3));
    }

    @Test
    public void chiffreCesar_decalage26() throws Exception {
        assertEquals("ABCDEF", ChiffreCesar.chiffrement("ABCDEF",26));
    }

    @Test
    public void chiffreCesar_double_decalage13() throws Exception {
        assertEquals("ABCDEF", ChiffreCesar.chiffrement(ChiffreCesar.chiffrement("ABCDEF",13),13));
    }

    @Test
    public void chiffreCesar_Y_decalage1() throws Exception {
        assertEquals("Z", ChiffreCesar.chiffrement("Y",1));
    }

    @Test
    public void chiffreCesar_X_decalage2() throws Exception {
        assertEquals("Z", ChiffreCesar.chiffrement("X",2));
    }

}
