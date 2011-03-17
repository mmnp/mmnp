

package org.cvut.vrchlpet.Metamodelar.core;

import java.util.List;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface INotation {
    public boolean removeElement(Element element);
    public Element createElement(String namespace);
    public List<Element> getAllDerivedElements(Element element);
 // public Element cloneElement(Element element);
    public Reference createSimpleReference(Element owner, Element target);
    public Reference createContainerReference(Element owner, Element target);
}
