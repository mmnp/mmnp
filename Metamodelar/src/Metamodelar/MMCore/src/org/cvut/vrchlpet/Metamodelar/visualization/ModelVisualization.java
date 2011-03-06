

package org.cvut.vrchlpet.Metamodelar.visualization;

import java.util.ArrayList;
import org.cvut.vrchlpet.Metamodelar.core.Notation;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ModelVisualization {

    public static final String DEFAULT_NAME = "defautl model visualisation";

    private ArrayList<ReferenceVisualManager> referenceVisualManagers;
    private ArrayList<ConnectionLine> connectionLines;
    private ArrayList<ElementVisualManager>elementVisualManagers;
    private String name;


    public ModelVisualization() {
        this.referenceVisualManagers = new ArrayList<ReferenceVisualManager>();
        this.connectionLines = new ArrayList<ConnectionLine>();
        this.elementVisualManagers = new ArrayList<ElementVisualManager>();
        this.name = DEFAULT_NAME;
    }

    public ModelVisualization(String name, Notation metamodel) {
        this();
        this.name = name;
    }

    /**
     * @return the referenceVisualManagers
     */
    public ArrayList<ReferenceVisualManager> getReferenceVisualManagers() {
        return referenceVisualManagers;
    }

    public void addReferenceVisualManager(ReferenceVisualManager manager) {
        for ( ReferenceVisualManager rvm : referenceVisualManagers) {
            if ( rvm.getName().equals(manager.getName()))
                return;
        }
        this.referenceVisualManagers.add(manager);
    }

    public void removeReferenceVisualManager(ReferenceVisualManager manager) {
        this.referenceVisualManagers.remove(manager);
    }

    /**
     * @return the connectionLines
     */
    public ArrayList<ConnectionLine> getConnectionLines() {
        return connectionLines;
    }

    public void addConnectionLine(ConnectionLine conLine) {
        if ( conLine.getSource() == conLine.getTarget())
            return;

        for ( ConnectionLine cl : connectionLines) {

            if ( conLine.getSource() == cl.getSource() ||
                 conLine.getSource() == cl.getTarget() ||
                 conLine.getTarget() == cl.getSource() ||
                 conLine.getTarget() == cl.getTarget()) {
                     
                return;
            }

        }
        this.connectionLines.add(conLine);
    }

    public void removeConnectionLine(ConnectionLine conLine) {
        this.connectionLines.remove(conLine);
    }

    /**
     * @return the elementVisualManagers
     */
    public ArrayList<ElementVisualManager> getElementVisualManagers() {
        return elementVisualManagers;
    }

    public void addElementVisualManager(ElementVisualManager manager) {
        for ( ElementVisualManager evm : elementVisualManagers) {
            if ( evm.getName().equals(manager.getName()))
                return;
        }
        this.elementVisualManagers.add(manager);
    }

    public void removeElementVisualManager(ElementVisualManager manager) {
        this.elementVisualManagers.remove(manager);
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

}
