

package org.cvut.vrchlpet.MCore.model;

import java.util.ArrayList;
import java.util.Date;
import org.cvut.vrchlpet.MCore.core.MetaModel;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Project {

    public static final String DEFAULT_VERSION = "1.0";

    private Date dateOfCreation;
    private String version;
    private ArrayList<NotationModel> models;

    public Project() {
        this.dateOfCreation = new Date();
        this.version = DEFAULT_VERSION;
        this.models = new ArrayList<NotationModel>();
    }

    public Project(String version) {
        this();
        this.version = version;
    }


    public NotationModel createNewModel(MetaModel notation) {
        NotationModel model = new NotationModel(this, notation);
        addModel(model);
        return model;
    }

    /**
     * @return the dateOfCreation
     */
    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    /**
     * @param dateOfCreation the dateOfCreation to set
     */
    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return the models
     */
    public ArrayList<NotationModel> getModels() {
        return models;
    }

    public void addModel(NotationModel model) {
        this.models.add(model);
    }

    public void removeModel(NotationModel model) {
        this.removeModel(model);
    }



    
}
