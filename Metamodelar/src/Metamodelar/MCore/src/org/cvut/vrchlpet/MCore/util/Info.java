

package org.cvut.vrchlpet.MCore.util;

import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Model;
import org.cvut.vrchlpet.MCore.core.Property;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MCore.datacore.MBoolean;
import org.cvut.vrchlpet.MCore.datacore.MString;
import org.cvut.vrchlpet.MCore.model.MModel;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Info {



    public static void printInfo(Model model) {

        String separator = "======================================================================";

        System.out.println(separator);

        System.out.println("Model: " + model.getNameSpace());
        System.out.println("Elements:");
        for ( Element el : model.getElements()) {
            System.out.println(el.toString());
        }

        System.out.println("");
        System.out.println("Relations:");
        for ( Relation rel : model.getRelations()) {
            System.out.println(rel.toString());
        }

        System.out.println(separator);
    }

    public static MModel createRandomModel() {
        IModelAbstractFactory maf = ModelAbstractFactory.getModelAbstractFactory();
        MModel model = new MModel(maf.createMetamodelFactory());
        IModelBuilder builder = model.getFactory().getBuilder();

        model.getModel().setNameSpace("My testing model");

        Element e1 = builder.createElement("E1");
        Element e2 = builder.createElement("E2");
        Element e3 = builder.createElement("E3");
        Element e4 = builder.createElement("E4");
        Element e5 = builder.createElement("E5");
        Element e6 = builder.createElement("E6");
        Element e7 = builder.createElement("E7");


        Attribute at1e1 = builder.createAttribute(e1, "a1");
        Property p1at1e1 = builder.createProperty(at1e1, "p1");
        p1at1e1.setMData(new MString());
        Attribute at2e1 = builder.createAttribute(e1, "a2");
        Property p1at2e1 = builder.createProperty(at2e1, "p2");
        p1at2e1.setMData(new MBoolean());






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


}
