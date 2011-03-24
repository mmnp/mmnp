

package org.cvut.vrchlpet.MCore.core;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Relation extends MetaObject{

    public static final boolean DEFAULT_INVERTILE = false;

    private boolean invertible;



    public Relation() {
        this.invertible = DEFAULT_INVERTILE;
    }


    /**
     * @return the invertible
     */
    public boolean isInvertible() {
        return invertible;
    }

    /**
     * @param invertible the invertible to set
     */
    public void setInvertible(boolean invertible) {
        this.invertible = invertible;
    }

}
