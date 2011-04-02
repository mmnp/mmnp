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
public class MetamodelFactory implements IModelFactory {

    private IModelBuilder builder = null;
    private IModelInfoManager infoManager = null;

    public MetamodelFactory(){}


    @Override
    public IModelBuilder getBuilder() {
        if ( this.builder == null)
            this.builder = new MetamodelBuilder();
        
        return this.builder;
    }

    @Override
    public IModelSerializer getModelSerializer() {
        return MetamodelSerializer.getSerializer();
    }

    @Override
    public IModelInfoManager getModelInfoManager() {
        if ( this.infoManager == null)
            this.infoManager = new MetamodelInfoManager(getBuilder().getModel());
        
        return this.infoManager;
    }

    /**
     * Metoda vytvori novy builder nad zadanym modelem. Metoda muze predstavovat
     * potencionalni nebezpeci prepsani jiz vytvoreneho builderu.
     *
     * @param model nad kterym se vytvori novy builder
     * @return MetamodelBuilder modelu
     */
    @Override
    public IModelBuilder getBuilder(Model model) {
        this.builder = new MetamodelBuilder(model);
        infoManager = null;
        getModelInfoManager();

        return this.builder;
    }

}
