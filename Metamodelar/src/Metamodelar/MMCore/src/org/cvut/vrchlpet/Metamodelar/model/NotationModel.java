

package org.cvut.vrchlpet.Metamodelar.model;

import java.util.ArrayList;
import org.cvut.vrchlpet.Metamodelar.core.Notation;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class NotationModel extends Notation{

    private Project project;
    private ArrayList<Author> authors;
    private ModelManager modelManager;
    private Notation metamodel;


    public NotationModel() {
        this.project = null;
        this.modelManager = null;
        this.authors = new ArrayList<Author>();
        this.metamodel = null;
    }

    public NotationModel(Project project, Notation metamodel) {
        this();
        this.project = project;
        this.modelManager = new ModelManager(this);
        this.metamodel = metamodel;
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
     * @return the modelManager
     */
    public ModelManager getModelManager() {
        return modelManager;
    }

    /**
     * @return the metamodel
     */
    public Notation getMetamodel() {
        return metamodel;
    }


}
