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
public class ModelAbstractFactory implements IModelAbstractFactory{

    private static ModelAbstractFactory instance = null;

    private ModelAbstractFactory(){}


    public static ModelAbstractFactory getModelAbstractFactory() {
        if ( instance == null)
            instance = new ModelAbstractFactory();

        return instance;
    }


    @Override
    public IModelFactory createMetamodelFactory() {
        return new MetamodelFactory();
    }

    @Override
    public IModelFactory createModelFactory() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
