
package org.cvut.vrchlpet.Metamodelar.core;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Notation extends Classifier {

    protected Date created;
    protected String version;
    protected ArrayList<Element> elements;

    public static final String DEFAULT_VERSION = "1.0";

    public Notation() {
        this.created = new Date();
        version = DEFAULT_VERSION;
        this.elements = new ArrayList<Element>();
    }

    public Notation(String version) {
        this();
        this.version = version;
    }

    public void addAttribute(Element el) {
        this.elements.add(el);
        firePropertyChange("elements", el, this.elements);
    }

    public void removeAttribute(Element el) {
        this.elements.remove(el);
        firePropertyChange("elements", el, this.elements);
    }

    public ArrayList<Element> getElements() {
        return this.elements;
    }

}
