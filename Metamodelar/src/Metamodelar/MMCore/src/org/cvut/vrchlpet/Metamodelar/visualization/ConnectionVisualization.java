

package org.cvut.vrchlpet.Metamodelar.visualization;

import java.util.ArrayList;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ConnectionVisualization implements IVisualization {

    public static final LineStyle DEFAULT_LINE_STYLE = LineStyle.simple;
    public static final String DEFAULT_GROUP_NAME = "connection visual manager groupname";

    private String groupName;
    private ArrayList<ConnectionLabel> labels;
    private LineStyle lineStyle;



    public ConnectionVisualization() {
        this.groupName = DEFAULT_GROUP_NAME;
        this.lineStyle = DEFAULT_LINE_STYLE;
        this.labels = new ArrayList<ConnectionLabel>();
    }

    public ConnectionVisualization(String name) {
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

    public void addLabel(ConnectionLabel label) {
        this.labels.add(label);
    }

    public void removeLabel(ConnectionLabel label) {
        this.labels.remove(label);
    }

    public ArrayList<ConnectionLabel> getLabels() {
        return this.labels;
    }

    /**
     * @return the lineStyle
     */
    public LineStyle getLineStyle() {
        return lineStyle;
    }

    /**
     * @param lineStyle the lineStyle to set
     */
    public void setLineStyle(LineStyle lineStyle) {
        this.lineStyle = lineStyle;
    }
}
