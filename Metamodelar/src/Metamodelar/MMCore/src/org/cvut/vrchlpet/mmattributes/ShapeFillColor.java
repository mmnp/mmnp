/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.mmattributes;

import java.awt.Color;
import org.cvut.vrchlpet.mmcore.NativeStructure;
import org.cvut.vrchlpet.mmcore.StructureFlag;

/**
 *
 * @author Vrchli
 */
public class ShapeFillColor extends NativeStructure{

    public static final StructureFlag flag = StructureFlag.fillcolor;

    private Color color;

    
    @Override
    public StructureFlag getFlag() {
        return ShapeFillColor.flag;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        Color old = this.color;
        this.color = color;
        firePropertyChanges(this, "color", old, color);
    }



}
