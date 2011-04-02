

package org.cvut.vrchlpet.MCore.model;

import java.util.Date;
import org.cvut.vrchlpet.MCore.core.Model;
import org.cvut.vrchlpet.MCore.util.IModelAbstractFactory;
import org.cvut.vrchlpet.MCore.util.IModelFactory;
import org.cvut.vrchlpet.MCore.util.MList;
import org.cvut.vrchlpet.MCore.util.Notifyer;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MModel extends Notifyer{


    private IModelFactory factory;
    private MList<Author> authors;
    private Date theCreationDate; // datum vytvoreni;

    public MModel(IModelFactory factory) {
        this.factory = factory;
        this.authors = new MList<Author>();
        this.authors.addPropertyChangeListener(this);
        this.theCreationDate = new Date();
    }

    public Model getModel() {
        return this.factory.getBuilder().getModel();
    }


    /**
     * @return the authors
     */
    public MList<Author> getAuthors() {
        return this.authors;
    }

    /**
     * @return the theCreationDate
     */
    public Date getTheCreationDate() {
        return this.theCreationDate;
    }

    /**
     * @return the factory
     */
    public IModelFactory getFactory() {
        return this.factory;
    }
}
