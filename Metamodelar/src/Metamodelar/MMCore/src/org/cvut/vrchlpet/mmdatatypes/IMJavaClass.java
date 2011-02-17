/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.mmdatatypes;

/**
 *
 * @author Vrchli
 */
public interface IMJavaClass {
    public Class getClassClassifier();
    public boolean isInstanceOf(Object o);
}
