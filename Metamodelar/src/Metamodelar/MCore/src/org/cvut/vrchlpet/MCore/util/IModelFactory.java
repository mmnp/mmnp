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
public interface IModelFactory {
    public IModelBuilder getBuilder();
    public IModelBuilder getBuilder(Model model);
    public IModelSerializer getModelSerializer();
    public IModelInfoManager getModelInfoManager();
}
