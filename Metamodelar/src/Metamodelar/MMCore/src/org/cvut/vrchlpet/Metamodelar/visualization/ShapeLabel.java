

package org.cvut.vrchlpet.Metamodelar.visualization;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ShapeLabel extends Label{

    public static final ShapeLabelPosition DEFAULT_POSITION = ShapeLabelPosition.top;

    private ShapeLabelPosition labelPosition;
    
    public ShapeLabel() {
        this.labelPosition = DEFAULT_POSITION;
    }

    public ShapeLabel(ShapeLabelPosition position) {
        this.labelPosition = position;
    }

    /**
     * @return the labelPosition
     */
    public ShapeLabelPosition getLabelPosition() {
        return labelPosition;
    }

    /**
     * @param labelPosition the labelPosition to set
     */
    public void setLabelPosition(ShapeLabelPosition labelPosition) {
        this.labelPosition = labelPosition;
    }

}
