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
public interface IModelSerializer {
    public void serialize(String path, Model model);
    public Model deserialize(String path);
}
