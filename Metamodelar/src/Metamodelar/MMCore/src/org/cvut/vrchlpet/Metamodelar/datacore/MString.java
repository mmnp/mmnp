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
public class MString extends MData{

    public MString(String value) {
        super(value);
    }

    @Override
    public boolean isInstanceOf(Object value) {
        if ( String.class.isInstance(value))
            return true;

        return false;
    }

    @Override
    public String getValue() {
        return (String)(this.value);
    }

    @Override
    public Class getMDataClass() {
        return String.class;
    }

    @Override
    public Object clone() {
        return new MString( new String(getValue()));
    }

    

}
