/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.Metamodelar.datacore;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MBoolean extends MData{


    public MBoolean(boolean value) {
        super(value);
    }


    @Override
    public boolean isInstanceOf(Object value) {
        if ( Boolean.class.isInstance(value))
            return true;

        return false;
    }

    @Override
    public Boolean getValue() {
        return (Boolean)(this.value);
    }

    @Override
    public Class getMDataClass() {
        return Boolean.class;
    }

    @Override
    public Object clone() {
        return new MBoolean(getValue());
    }

}
