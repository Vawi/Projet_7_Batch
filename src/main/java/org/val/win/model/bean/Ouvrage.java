
package org.val.win.model.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ouvrage complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ouvrage"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="auteur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idOuvrage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="nomOuvrage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombreDispo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ouvrage", propOrder = {
    "auteur",
    "idOuvrage",
    "nomOuvrage",
    "nombreDispo"
})
public class Ouvrage {

    protected String auteur;
    protected Integer idOuvrage;
    protected String nomOuvrage;
    protected Integer nombreDispo;

    /**
     * Obtient la valeur de la propriété auteur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * Définit la valeur de la propriété auteur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuteur(String value) {
        this.auteur = value;
    }

    /**
     * Obtient la valeur de la propriété idOuvrage.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdOuvrage() {
        return idOuvrage;
    }

    /**
     * Définit la valeur de la propriété idOuvrage.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdOuvrage(Integer value) {
        this.idOuvrage = value;
    }

    /**
     * Obtient la valeur de la propriété nomOuvrage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomOuvrage() {
        return nomOuvrage;
    }

    /**
     * Définit la valeur de la propriété nomOuvrage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomOuvrage(String value) {
        this.nomOuvrage = value;
    }

    /**
     * Obtient la valeur de la propriété nombreDispo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNombreDispo() {
        return nombreDispo;
    }

    /**
     * Définit la valeur de la propriété nombreDispo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNombreDispo(Integer value) {
        this.nombreDispo = value;
    }

}
