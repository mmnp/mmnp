

package org.cvut.vrchlpet.Metamodelar.visualization;

import java.util.ArrayList;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ElementVisualManager {

    public static final String DEFAULT_NAME = "";

    private String name;
    private Border border;
    private BackgroundColor backgroundColor;
    private BackgroundImage backgroundImage;
    private ArrayList<ShapeLabel> labels;


    public ElementVisualManager() {
        this.name = DEFAULT_NAME;
        this.border = null;
        this.backgroundColor = null;
        this.backgroundImage = null;
        this.labels = new ArrayList<ShapeLabel>();
    }

    public ElementVisualManager(String name) {
        this();
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
    public ArrayList<ShapeLabel> getLabels() {
        return labels;
    }

    public void addLabel(ShapeLabel label) {
        this.labels.add(label);
    }

    public void removeLabel(ShapeLabel label) {
        this.labels.remove(label);
    }

}
