package com.example.dadabhagwan.navigationdrawerdemo.Activity.POJO.Preview;

/**
 * Created by dadabhagwan on 11/28/2016.
 */

import java.util.HashMap;
import java.util.Map;
//import javax.annotation.Generated;

//@Generated("org.jsonschema2pojo")
public class Phone {

    private String mobile;
    private String home;
    private String office;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     *
     * @param mobile
     * The mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     *
     * @return
     * The home
     */
    public String getHome() {
        return home;
    }

    /**
     *
     * @param home
     * The home
     */
    public void setHome(String home) {
        this.home = home;
    }

    /**
     *
     * @return
     * The office
     */
    public String getOffice() {
        return office;
    }

    /**
     *
     * @param office
     * The office
     */
    public void setOffice(String office) {
        this.office = office;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
