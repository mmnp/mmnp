

package org.cvut.vrchlpet.Metamodelar.visualization;

import java.util.ArrayList;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ElementVisualization implements IVisualization {

    public static final String DEFAULT_GROUP_NAME = "element visual manager groupname";

    private String groupName;
    private Border border;
    private BackgroundColor backgroundColor;
    private BackgroundImage backgroundImage;
    private ArrayList<ElementLabel> labels;


    public ElementVisualization() {
        this.groupName = DEFAULT_GROUP_NAME;
        this.border = null;
        this.backgroundColor = null;
        this.backgroundImage = null;
        this.labels = new ArrayList<ElementLabel>();
    }

    public ElementVisualization(String name) {
        this();
        this.groupName = name;
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

    /**
     * @return the border
     */
    public Border getBorder() {
        return border;
    }

    /**
     * @param border the border to set
     */
    public void setBorder(Border border) {
        this.border = border;
    }

    /**
     * @return the backgroundColor
     */
    public BackgroundColor getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @param backgroundColor the backgroundColor to set
     */
    public void setBackgroundColor(BackgroundColor backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * @return the backgroundImage
     */
    public BackgroundImage getBackgroundImage() {
        return backgroundImage;
    }

    /**
     * @param backgroundImage the backgroundImage to set
     */
    public void setBackgroundImage(BackgroundImage backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    /**
     * @return the labels
     */
    public ArrayList<ElementLabel> getLabels() {
        return labels;
    }

    public void addLabel(ElementLabel label) {
        this.labels.add(label);
    }

    public void removeLabel(ElementLabel label) {
        this.labels.remove(label);
    }

}
