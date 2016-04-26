
package jp.yahooapis.ss.V6.TrafficEstimatorService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WapMobileEstimateResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WapMobileEstimateResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V6}TrafficEstimateResult">
 *       &lt;sequence>
 *         &lt;element name="carrier" type="{http://ss.yahooapis.jp/V6}CarrierName" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WapMobileEstimateResult", propOrder = {
    "carrier"
})
public class WapMobileEstimateResult
    extends TrafficEstimateResult
{

    @XmlSchemaType(name = "string")
    protected CarrierName carrier;

    /**
     * Gets the value of the carrier property.
     * 
     * @return
     *     possible object is
     *     {@link CarrierName }
     *     
     */
    public CarrierName getCarrier() {
        return carrier;
    }

    /**
     * Sets the value of the carrier property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarrierName }
     *     
     */
    public void setCarrier(CarrierName value) {
        this.carrier = value;
    }

}
