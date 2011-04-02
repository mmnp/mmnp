

package org.cvut.vrchlpet.MCore.visualization.ui;

import javax.swing.JButton;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonUI;
import org.cvut.vrchlpet.MCore.core.MetaObject;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IMetaObjectUI{

    
    public void installUI(MetaObject obj);
    public void uninstallUI(MetaObject obj);

}
