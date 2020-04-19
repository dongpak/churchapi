/*

 */
package com.churchclerk.churchapi.model;

import com.churchclerk.baseapi.model.BaseModel;
import com.churchclerk.contactapi.model.Contact;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

/**
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Church extends BaseModel {
    private String  name;
    private Contact contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Church)) return false;
        if (!super.equals(o)) return false;
        Church church = (Church) o;
        return Objects.equals(name, church.name) &&
                Objects.equals(contact, church.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, contact);
    }

    /**
     *
     * @param source
     */
    public void copy(Church source) {
        super.copy(source);
        setName(source.getName());
    }

    /**
     *
     * @param source
     */
    public void copyNonNulls(Church source) {
        super.copyNonNulls(source);
        copy(source.getName(), this::setName);
    }
}
