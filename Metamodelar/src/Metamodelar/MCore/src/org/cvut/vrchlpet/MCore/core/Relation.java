

package org.cvut.vrchlpet.MCore.core;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Relation extends MetaObject{

    public static final boolean DEFAULT_SYMETRIC = false;

    private boolean symetric;



    public Relation() {
        this.symetric = DEFAULT_SYMETRIC;
    }


    /**
     * @return the invertible
     */
    public boolean isSymetric() {
        return symetric;
    }

    /**
     * @param invertible the invertible to set
     */
    public void setSymetric(boolean symetric) {
        this.symetric = symetric;
    }

    @Override
    public String toString() {
        String s = "";

        s += getNameSpace() + ", symetric: " + symetric;

        return s;
    }

}
