/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.mmdatatypes;



/**
 *
 * @author Vrchli
 */
public class MDate  implements IMJavaClass{

    public static final Class clazz = java.util.Date.class;


    @Override
    public Class getClassClassifier() {
        return clazz;
    }

    @Override
    public boolean isInstanceOf(Object o) {
        if ( o == null)
            return false;

        if ( o.getClass() == getClassClassifier())
            return true;


        return false;

    }

}
