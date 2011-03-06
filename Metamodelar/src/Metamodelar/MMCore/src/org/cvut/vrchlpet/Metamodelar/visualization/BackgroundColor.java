
package org.cvut.vrchlpet.Metamodelar.visualization;

import java.awt.Color;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class BackgroundColor {

    public static final Color DEFAULT_COLOR = Color.WHITE;

    private Color color;
    
    public BackgroundColor () {
        this.color = DEFAULT_COLOR;
    }

    public BackgroundColor(Color color) {
        this.color = color;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }
}
