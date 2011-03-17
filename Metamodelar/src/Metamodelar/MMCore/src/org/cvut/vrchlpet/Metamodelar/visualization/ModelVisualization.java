

package org.cvut.vrchlpet.Metamodelar.visualization;



import org.cvut.vrchlpet.Metamodelar.core.Element;
import org.cvut.vrchlpet.Metamodelar.core.Notation;
import org.cvut.vrchlpet.Metamodelar.core.Reference;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ModelVisualization {

    public static final String DEFAULT_NAME = "defautl model visualisation";


    private IVisualManager<ElementVisualization, Element> elementManager;
    private IVisualManager<ReferenceVisualization, Reference> referenceManager;
    private IVisualManager<ConnectionVisualization, Reference> connectionManager;

    private String name;


    public ModelVisualization() {
        this.elementManager = new ElementVisualManager();
        this.referenceManager = new ReferenceVisualManager();
        this.connectionManager = new ConnectionVisualManager();
        this.name = DEFAULT_NAME;
    }

    public ModelVisualization(String name, Notation metamodel) {
        this();
        this.name = name;
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

    /**
     * @return the elementManager
     */
    public IVisualManager<ElementVisualization, Element> getElementManager() {
        return elementManager;
    }

    /**
     * @return the referenceManager
     */
    public IVisualManager<ReferenceVisualization, Reference> getReferenceManager() {
        return referenceManager;
    }

    /**
     * @return the connectionManager
     */
    public IVisualManager<ConnectionVisualization, Reference> getConnectionManager() {
        return connectionManager;
    }

}
