

package org.cvut.vrchlpet.Metamodelar.visualization;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ElementLabel extends Label{

    private Position position;

    
    public ElementLabel() {
        this.position = new Position();
        this.position.setAbsolute(false);
        this.position.setLayout(Layout.flow);
    }


    /**
     * @return the labelPosition
     */
    public Position getLabelPosition() {
        return position;
    }

    /**
     * @param labelPosition the labelPosition to set
     */
    public void setLabelPosition(Position labelPosition) {
        this.position = labelPosition;
    }

}
