/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.util;

import org.cvut.vrchlpet.MCore.core.Model;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MetamodelSerializer implements IModelSerializer{

    private static MetamodelSerializer instance = null;

    private MetamodelSerializer() {

    }

    public static MetamodelSerializer getSerializer() {
        if ( instance == null)
            instance = new MetamodelSerializer();

        return instance;
    }


    @Override
    public void serialize(String path, Model model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Model deserialize(String path) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
