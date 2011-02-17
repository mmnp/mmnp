/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.mmattributes;

import java.awt.Font;
import org.cvut.vrchlpet.mmcore.NativeStructure;
import org.cvut.vrchlpet.mmcore.StructureFlag;

/**
 *
 * @author Vrchli
 */
public class Label extends NativeStructure{

    public static final StructureFlag flag = StructureFlag.label;

    private String text;
    private Font font;

    @Override
    public StructureFlag getFlag() {
        return ShapeBorder.flag;
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
        String old = this.text;
        this.text = text;
        firePropertyChanges(this, "text", old, text);
    }

    /**
     * @return the font
     */
    public Font getFont() {
        return font;
    }

    /**
     * @param font the font to set
     */
    public void setFont(Font font) {
        Font old = this.font;
        this.font = font;
        firePropertyChanges(this, "font", old, font);
    }

}
