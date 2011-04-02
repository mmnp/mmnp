

package org.cvut.vrchlpet.MCore.core;


import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.EventListenerList;
import org.cvut.vrchlpet.MCore.util.Notifyer;
import org.cvut.vrchlpet.MCore.visualization.ui.CommonMetaObjectUI;
import org.cvut.vrchlpet.MCore.visualization.ui.IMetaObjectUI;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MetaObject extends Notifyer{

    protected String nameSpace;
    protected String description;

    public static final String DEFAULT_NAMESPACE = "empty namespace";
    public static final String DEFAULT_DESCRIPTION = "empty description";

    protected CommonMetaObjectUI ui;

    public MetaObject() {
        this.nameSpace = DEFAULT_NAMESPACE;
        this.description = DEFAULT_DESCRIPTION;
    }

    public MetaObject(String namseSpace, String description) {
        this();
        this.nameSpace = namseSpace;
        this.description = description;
    }

    

    /**
     * @return the nameSpace
     */
    public String getNameSpace() {
        return nameSpace;
    }

    /**
     * @param nameSpace the nameSpace to set
     */
    public void setNameSpace(String nameSpace) {
        String old = this.nameSpace;
        this.nameSpace = nameSpace;
        firePropertyChange("nameSpace", old, this.nameSpace);
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        String old = this.description;
        this.description = description;
        firePropertyChange("description", old, this.description);
    }

    /**
     * @return the ui
     */
    public CommonMetaObjectUI getUi() {
        return ui;
    }

    /**
     * @param ui the ui to set
     */
    public void setUi(CommonMetaObjectUI ui) {
        this.ui = ui;
    }

}
