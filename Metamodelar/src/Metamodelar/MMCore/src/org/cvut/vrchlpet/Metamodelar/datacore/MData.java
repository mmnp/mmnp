

package org.cvut.vrchlpet.Metamodelar.datacore;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public abstract class MData {


    protected Object value;

    public abstract boolean isInstanceOf(Object value);
    public abstract Object getValue();
    public abstract Class getMDataClass();
    @Override
    public abstract Object clone();
    

    public MData() {}

    public MData(Object value) {
        this.value = value;
    }


    public void setValue(Object value) {
        if (isInstanceOf(value)) {
            this.value = value;
            return;
        }

        throw new IllegalArgumentException("MString:setValue - inserted data is not instance of "
                                          + getMDataClass().getName() + " \n"
                                          + "thrown for: " + value.toString());

    }
    
}
