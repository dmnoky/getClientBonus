//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.04.12 at 02:35:11 PM MSK 
//


package ru.mkb.bonusws.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClientTypeRs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClientTypeRs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ClientCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MKBBonusInfo" type="{http://mkb.ru/GetClientMkbBonusInfo/}MKBBonusInfoTypeRs" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClientTypeRs", propOrder = {
    "clientCode",
    "mkbBonusInfo"
})
public class ClientTypeRs {

    @XmlElement(name = "ClientCode")
    protected String clientCode;
    @XmlElement(name = "MKBBonusInfo")
    protected MKBBonusInfoTypeRs mkbBonusInfo;

    /**
     * Gets the value of the clientCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientCode() {
        return clientCode;
    }

    /**
     * Sets the value of the clientCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientCode(String value) {
        this.clientCode = value;
    }

    /**
     * Gets the value of the mkbBonusInfo property.
     * 
     * @return
     *     possible object is
     *     {@link MKBBonusInfoTypeRs }
     *     
     */
    public MKBBonusInfoTypeRs getMKBBonusInfo() {
        return mkbBonusInfo;
    }

    /**
     * Sets the value of the mkbBonusInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link MKBBonusInfoTypeRs }
     *     
     */
    public void setMKBBonusInfo(MKBBonusInfoTypeRs value) {
        this.mkbBonusInfo = value;
    }

}