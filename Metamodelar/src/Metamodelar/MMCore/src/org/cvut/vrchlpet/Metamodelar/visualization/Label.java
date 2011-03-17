
package org.cvut.vrchlpet.Metamodelar.visualization;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Label {


    public static final boolean DEFAULT_MOVABLE = false;
    public static final boolean DEFAULT_EDITABLE = true;
    public static final String DEFAULT_TEXT = "default label text";

    private boolean movable;
    private boolean editable;
    private String text;

    public Label () {
        this.movable = DEFAULT_MOVABLE;
        this.editable = DEFAULT_EDITABLE;
        this.text = DEFAULT_TEXT;
    }

    public Label(String text) {
        this();
        this.text = text;
    }

    /**
     * @return the movable
     */
    public boolean isMovable() {
        return movable;
    }

    /**
     * @param movable the movable to set
     */
    public void setMovable(boolean movable) {
        this.movable = movable;
    }

    /**
     * @return the editable
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * @param editable the editable to set
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }
}
