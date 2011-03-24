

package org.cvut.vrchlpet.MCore.visualization;

import java.awt.Image;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class BackgroundImage {

    private Image image;

    
    public BackgroundImage() {
        this.image = null;
    }

    public BackgroundImage(Image image) {
        this.image = image;
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }


}
