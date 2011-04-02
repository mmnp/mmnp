/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.model;

import org.cvut.vrchlpet.MCore.util.IModelBuilder;
import java.util.Date;
import org.cvut.vrchlpet.MCore.util.MList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vrchli
 */
public class MCoreModelTest {

    public MCoreModelTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetBuilder() {
    }

    @Test
    public void testGetAuthors() {
        System.out.println("getAuthors");
        MModel instance = null;
        MList expResult = null;
        MList result = instance.getAuthors();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTheCreationDate() {
        System.out.println("getTheCreationDate");
        MModel instance = null;
        Date expResult = null;
        Date result = instance.getTheCreationDate();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

}