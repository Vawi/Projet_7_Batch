
package org.val.win.model.bean;

import org.val.win.model.exception.NotFoundException;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.val.win package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _NotFoundException_QNAME = new QName("http://contract.service.win.val.org/", "NotFoundException");
    private final static QName _Emprunt_QNAME = new QName("http://contract.service.win.val.org/", "emprunt");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.val.win
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NotFoundException }
     * 
     */
    public NotFoundException createNotFoundException() {
        return new NotFoundException();
    }

    /**
     * Create an instance of {@link Emprunt }
     * 
     */
    public Emprunt createEmprunt() {
        return new Emprunt();
    }

    /**
     * Create an instance of {@link Utilisateur }
     * 
     */
    public Utilisateur createUtilisateur() {
        return new Utilisateur();
    }

    /**
     * Create an instance of {@link Ouvrage }
     * 
     */
    public Ouvrage createOuvrage() {
        return new Ouvrage();
    }

    /**
     * Create an instance of {@link EmpruntArray }
     * 
     */
    public EmpruntArray createEmpruntArray() {
        return new EmpruntArray();
    }

    /**
     * Create an instance of {@link OuvrageArray }
     * 
     */
    public OuvrageArray createOuvrageArray() {
        return new OuvrageArray();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.service.win.val.org/", name = "NotFoundException")
    public JAXBElement<NotFoundException> createNotFoundException(NotFoundException value) {
        return new JAXBElement<NotFoundException>(_NotFoundException_QNAME, NotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Emprunt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.service.win.val.org/", name = "emprunt")
    public JAXBElement<Emprunt> createEmprunt(Emprunt value) {
        return new JAXBElement<Emprunt>(_Emprunt_QNAME, Emprunt.class, null, value);
    }

}
