/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.util;


import java.util.ArrayList;
import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Model;
import org.cvut.vrchlpet.MCore.core.Property;
import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MCore.core.ReferenceableObject;
import org.cvut.vrchlpet.MCore.core.Relation;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MetamodelBuilder implements IModelBuilder{

    private Model model;

    public MetamodelBuilder() {
        this.model = getModel();
    }

    public MetamodelBuilder(Model model) {
        this.model = model;
    }


    @Override
    public Model getModel() {
        if ( model == null)
            model = new Model();
        return this.model;
    }

    private boolean isNamespaceInUse(String namespace) {

        // kontrola nad elementy
        for ( Element el : model.getElements()) {
            if ( el.getNameSpace().equals(namespace))
                return true;

            for ( Attribute at : el.getAttributes()) {
                if ( at.getNameSpace().equals(namespace))
                    return true;

                for ( Property p : at.getProperties()) {
                    if ( p.getNameSpace().equals(namespace))
                        return true;
                }
            }
        }

        // kontrola nad relacemi
        for ( Relation rel : model.getRelations()) {
            if ( rel.getNameSpace().equals(namespace))
                return true;
        }


        return false;
    }


    @Override
    public Element createElement(String namespace) {
        if ( isNamespaceInUse(namespace))
            return null;

        Element el = null;

        el = new Element();
        el.setNameSpace(namespace);
        model.getElements().add(el);
        el.setModel(model);

        return el;
    }

    /**
     * Metoda odstrani element z modelu.
     *
     * @param element element, ktery se smaze
     * @param hardErasement pokud je nastaven na true, pak se spolecne s
     *         elementem smazou i elementy dedici a elementy, ktere jsou soucasti
     *         mazaneho elementu a to rekurzivne
     * @return true pokud smazani probehne vporadku, false, pokud element neexistuje
     */
    @Override
    public boolean removeElement(Element element, boolean hardErasement) {
        if ( !model.getElements().contains(element))
            return false;

        // nechceme, aby se po kazde provedene akci nad elementem notifykovalo
        // staci, kdyz se bude notifykovat az smazani daneho elementu na urovni modelu
        element.setEnableNotification(false);

        // nejprve odebereme vsechny reference objektum, ktere se na odebirany
        // element odkazuji, pokud je hardErasement = ture, pak se odstrani
        // i vsechny elementy, pro ktere je mazany element kontainerem
        ArrayList<Element> elementsToBeDeleted = new ArrayList<Element>();
        for (Reference ref : element.getReferences()) {
            if ( hardErasement)
                if ( ref.isContainer()) {
                    if ( ref.getOpposite().getOwner() instanceof Element &&
                            ref.getOpposite().getOwner() != element)
                        elementsToBeDeleted.add((Element)ref.getOpposite().getOwner());
                }

            // osetreni concurrent exception
            if ( ref.getOpposite().getOwner() != element) {
                ReferenceableObject ro = ref.getOpposite().getOwner();
                ro.getReferences().remove(ref.getOpposite());
            }
        }

        // odebereme vsechny reference odebiraneho elementu
        element.getReferences().clear();

        // zrusime vsechny attributy
        element.getAttributes().clear();

        // odstranime vsechny elementy dedici od daneho elementu (zavisi na hodnote hardErasement)
        for ( Element el : model.getElements()) {
            if ( el.getSuperElement() == element)
                if ( hardErasement) {
                    elementsToBeDeleted.add(el);
                } else {
                    el.setSuperElement(null);
                }
        }

        // odebereme puvodni element
        model.getElements().remove(element);


        // rekurzivne odebereme vsechny oznacene elementy (urcene k smazani, protoze
        // vystupovali jako potomci nebo jako soucasti mazaneho elementu)
        // zavisi na hodnote hardErasement (true - rekurzivni mazani)
        if ( hardErasement)
            for (Element el : elementsToBeDeleted) {
                if ( el != element)
                    removeElement(el, true);
            }
        return true;
    }

    /**
     * Metoda zajisti relaci(nema nic spolecneho s 'Relation' tridou) dedeni.
     * Nelze vytvorit cyklicke dedeni
     *
     * @param concrete element, ktery dedi
     * @param superType element, od ktereho se dedi
     * @return true, pokud je relace navazana, false, pokud neni mozne relaci vytvorit
     */
    @Override
    public boolean setSuperType(Element concrete, Element superType) {

        if ( !model.getElements().contains(concrete) ||
                !model.getElements().contains(superType))
                return false;


        // kontrola zacykleni potencionalni nove dedicnosti
        for ( Element el : superType.getAllSuperElements()) {
            if ( el == concrete)
                return false;
        }

        concrete.setSuperElement(superType);

        return true;
    }

    /**
     * Vytvori novou relaci a prida ji do seznamu existujicich relaci.
     *
     * @param namespace - relace bude vytvorena s danym namespace
     * @return objekt nove relace. Null jestlize je zadany namespace jiz pouzivan
     */
    @Override
    public Relation createRelation(String namespace) {
        if ( isNamespaceInUse(namespace))
            return null;

        Relation rel = null;

        rel = new Relation();
        rel.setNameSpace(namespace);
        model.getRelations().add(rel);


        return rel;
    }

    /**
     * Odstrani relaci ze seznamu a smaze vsechny reference, ktere se
     * na danou relaci odkazuji
     *
     * @param relation
     * @return
     */
    @Override
    public boolean removeRelation(Relation relation) {

        if ( ! model.getRelations().contains(relation))
            return false;

        ArrayList<Reference> refToBeRemoved;
        for ( Element el : model.getElements()) {
            refToBeRemoved = new ArrayList<Reference>();
            for ( Reference ref : el.getReferences()) {
                if ( ref.getRelation() == relation) {
                    refToBeRemoved.add(ref);
                }
            }
            el.getReferences().removeAll(refToBeRemoved);
        }

        model.getRelations().remove(relation);

        return true;
    }

    @Override
    public Attribute createAttribute(Element el, String namespace) {

        if ( isNamespaceInUse(namespace))
            return null;

        Attribute at = null;

        at = new Attribute();
        at.setNameSpace(namespace);
        el.getAttributes().add(at);

        return at;
    }

    @Override
    public boolean removeAttribute(Attribute at, Element el) {
        return el.getAttributes().remove(at);
    }

    @Override
    public Property createProperty(Attribute at, String namespace) {
        if ( isNamespaceInUse(namespace))
            return null;

        Property p = null;

        p = new Property();
        p.setNameSpace(namespace);
        at.getProperties().add(p);

        return p;
    }

    @Override
    public boolean removeProperty(Property property, Attribute at) {
        return at.getProperties().remove(property);
    }

    /**
     * Vytvori relaci mezi dvema objekty.
     *
     * @param source zdrojovy objekt
     * @param target cilovy objekt
     * @param rel relace mezi objekty
     * @return referenci, odkazujici na zdrojovy element
     */
    @Override
    public Reference makeGeneralRelation(ReferenceableObject source, ReferenceableObject target, Relation rel) {
        if ( ! model.getRelations().contains(rel))
            return null;

        Reference refSource = null;
        Reference refTarget = null;

        refSource = source.createReference(rel); // reference na zdroj
        refTarget = target.createReference(rel); // reference na cil

        refSource.setOpposite(refTarget);
        refTarget.setOpposite(refSource);

        refSource.setSource(true);

        return refSource;
    }

    @Override
    public Reference makeContainerRelation(ReferenceableObject container, ReferenceableObject containment, Relation rel) {
        Reference ref = makeGeneralRelation(container, containment, rel);
        ref.setContainer(true);

        return ref;
    }

    @Override
    public boolean removeRelation(ReferenceableObject owner, Reference ref) {
        owner.getReferences().remove(ref.getOpposite());
        owner.getReferences().remove(ref);
        return true;
    }



}
