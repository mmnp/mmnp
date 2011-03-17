
package org.cvut.vrchlpet.Metamodelar.visualization;


/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ReferenceVisualization implements IVisualization {


    public static final String DEFAULT_GROUP_NAME = "reference visual manager gourpname";

    private ReferenceArrow referenceArrow;
    private String groupName;

    public ReferenceVisualization () {
        this.referenceArrow = new ReferenceArrow(ReferenceArrow.DEFAULT_ARROW_SHAPE);
        this.groupName = DEFAULT_GROUP_NAME;
    }

    public ReferenceVisualization(String name) {
        this();
        this.groupName = name;
    }

    /**
     * @return the referenceArrow
     */
    public ReferenceArrow getReferenceArrow() {
        return referenceArrow;
    }

    /**
     * @param referenceArrow the referenceArrow to set
     */
    public void setReferenceArrow(ReferenceArrow referenceArrow) {
        this.referenceArrow = referenceArrow;
    }

    /**
     * @return the groupName
     */
    @Override
    public String getName() {
        return groupName;
    }

    /**
     * @param groupName the groupName to set
     */
    public void setName(String name) {
        this.groupName = name;
    }
}
