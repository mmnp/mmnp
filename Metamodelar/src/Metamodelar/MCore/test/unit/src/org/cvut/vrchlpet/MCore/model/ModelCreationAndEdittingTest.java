/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.model;


import org.cvut.vrchlpet.MCore.util.IModelBuilder;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Model;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MCore.util.IModelAbstractFactory;
import org.cvut.vrchlpet.MCore.util.Info;
import org.cvut.vrchlpet.MCore.util.ModelAbstractFactory;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ModelCreationAndEdittingTest {



    public ModelCreationAndEdittingTest() {
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


    private MModel createKomplexModel() {
        IModelAbstractFactory maf = ModelAbstractFactory.getModelAbstractFactory();
        MModel model = new MModel(maf.createMetamodelFactory());
        IModelBuilder builder = model.getFactory().getBuilder();

        Element e1 = builder.createElement("E1");
        Element e2 = builder.createElement("E2");
        Element e3 = builder.createElement("E3");
        Element e4 = builder.createElement("E4");
        Element e5 = builder.createElement("E5");
        Element e6 = builder.createElement("E6");
        Element e7 = builder.createElement("E7");
        Relation generalization = builder.createRelation("Generalization");
        Relation association = builder.createRelation("Association");
        Relation defaultRel = builder.createRelation("DefaultRel");
        builder.setSuperType(e2, e1);
        builder.makeContainerRelation(e2, e3, defaultRel);
        builder.makeGeneralRelation(e4, e4, association);
        builder.makeContainerRelation(e2, e2, defaultRel);
        builder.makeGeneralRelation(e3, e1, association);
        builder.makeGeneralRelation(e1, e3, association);
        builder.makeContainerRelation(e3, e2, defaultRel);
        builder.setSuperType(e5, e2);
        builder.makeContainerRelation(e5, e3, defaultRel);
        builder.makeContainerRelation(e3, e5, defaultRel);
        builder.makeContainerRelation(e5, e2, defaultRel);
        builder.makeContainerRelation(e2, e5, defaultRel);
        builder.makeGeneralRelation(e1, e6, association);
        builder.makeGeneralRelation(e1, e7, association);
        builder.makeContainerRelation(e1, e7, defaultRel);
        builder.makeContainerRelation(e6, e1, defaultRel);
        builder.makeContainerRelation(e6, e4, defaultRel);
        return model;
    }

    private Element findElement(Model model, String namespace) {

        for ( Element el : model.getElements())
            if ( el.getNameSpace().equals(namespace))
                return el;

        return null;
    }

    
    @Test
    public void testRemovingElements() {
        MModel model = createKomplexModel();
        
        Info.printInfo(model.getModel());

        Element el = findElement(model.getModel(), "E1");
        model.getFactory().getBuilder().removeElement(el, true);
        
        Info.printInfo(model.getModel());
        
    }


    /*
    @Test
    public void testAddingElements() {
        IModelBuilder builder = new MetamodelBuilder();
        MModel model = new MModel(builder);

        assertTrue(model.getModel().getElements().isEmpty());

        String namespace = "MyElement";

        builder.createElement(namespace);

        assertTrue(model.getModel().getElements().size() == 1);
        
        assertTrue(builder.createElement(namespace) == null);
        assertTrue(model.getModel().getElements().size() == 1);

    }
*/

}
