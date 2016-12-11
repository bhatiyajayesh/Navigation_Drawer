package com.example.dadabhagwan.navigationdrawerdemo.Activity.POJO.Preview;

/**
 * Created by dadabhagwan on 11/28/2016.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import javax.annotation.Generated;

//@Generated("org.jsonschema2pojo")
public class Examples {

    private List<Contact> contacts = new ArrayList<Contact>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The contacts
     */
    public List<Contact> getContacts() {
        return contacts;
    }

    /**
     *
     * @param contacts
     * The contacts
     */
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
