

package org.cvut.vrchlpet.Metamodelar.visualization;

import java.util.ArrayList;
import org.cvut.vrchlpet.Metamodelar.core.Reference;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ConnectionLine {

    public static final LineStyle DEFAULT_LINE_STYLE = LineStyle.simple;

    private Reference source;
    private Reference target;
    private LineStyle lineStyle;
    private ArrayList<ConnectionLabel> labels;

    public ConnectionLine () {
        this.source = null;
        this.target = null;
        this.lineStyle = DEFAULT_LINE_STYLE;
        this.labels = new ArrayList<ConnectionLabel>();
    }

    public ConnectionLine(Reference source, Reference target, LineStyle lineStyle) {
        this.source = source;
        this.target = target;
        this.lineStyle = lineStyle;
        this.labels = new ArrayList<ConnectionLabel>();
    }

    public static boolean isBiRelation(Reference a, Reference b) {
        if ( a == null || b == null)
            return false;
        
        return (a.getOpposite() == b && b.getOpposite() == a) ? true : false;
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
     * @return the source
     */
    public Reference getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(Reference source) {
        this.source = source;
    }

    /**
     * @return the target
     */
    public Reference getTarget() {
        return target;
    }

    /**
     * @param target the target to set
     */
    public void setTarget(Reference target) {
        this.target = target;
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
