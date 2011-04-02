

package org.cvut.vrchlpet.MCore.util;


/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IModelAbstractFactory {
    public IModelFactory createMetamodelFactory();
    public IModelFactory createModelFactory();
}
