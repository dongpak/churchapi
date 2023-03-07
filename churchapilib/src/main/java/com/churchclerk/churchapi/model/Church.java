/*

 */
package com.churchclerk.churchapi.model;

import com.churchclerk.baseapi.model.BaseModel;
import com.churchclerk.contactapi.model.Contact;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

/**
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@SuperBuilder
@NoArgsConstructor
public class Church extends BaseModel {
    private String  name;
    private Contact contact;

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
