
package jp.yahooapis.ss.V6.FeedFolderService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeedFolderPlaceholderType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FeedFolderPlaceholderType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AD_CUSTOMIZER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FeedFolderPlaceholderType")
@XmlEnum
public enum FeedFolderPlaceholderType {

    AD_CUSTOMIZER;

    public String value() {
        return name();
    }

    public static FeedFolderPlaceholderType fromValue(String v) {
        return valueOf(v);
    }

}