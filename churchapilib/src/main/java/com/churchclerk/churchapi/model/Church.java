/*

 */
package com.churchclerk.churchapi.model;

import com.churchclerk.baseapi.model.BaseModel;

import java.util.Objects;

/**
 *
 */
public class Church extends BaseModel {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Church)) return false;
        if (!super.equals(o)) return false;
        Church model = (Church) o;
        return Objects.equals(name, model.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
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
