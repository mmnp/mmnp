

package org.cvut.vrchlpet.MCore.model;

import java.util.ArrayList;
import java.util.List;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.MetaModel;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class NotationModel {

    private Project project;
    private ArrayList<Author> authors;
    private MetaModel metamodel;
    private ArrayList<ModelElement> elements;


    public NotationModel() {
        this.project = null;
        this.authors = new ArrayList<Author>();
        this.metamodel = null;
        this.elements = new ArrayList<ModelElement>();

    }

    public NotationModel(Project project, MetaModel metamodel) {
        this();
        this.project = project;
        this.metamodel = metamodel;
    }


    public List<Element> getAvailableElements() {
        throw new UnsupportedOperationException("not supported yet");
    }

    public ModelElement createElement(Element element) {
        throw new UnsupportedOperationException("not supported yet");
    }

    public boolean removeElement(ModelElement element) {
        throw new UnsupportedOperationException("not supported yet");
    }

    public List<ModelElement> getElements() {
        return this.elements;
    }



    /**
     * @return the project
     */
    public Project getProject() {
        return project;
    }

    /**
     * @param project the project to set
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * @return the authors
     */
    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public void removeAuthor(Author author) {
        this.authors.remove(author);
    }

    /**
     * @return the metamodel
     */
    public MetaModel getMetamodel() {
        return metamodel;
    }


}
