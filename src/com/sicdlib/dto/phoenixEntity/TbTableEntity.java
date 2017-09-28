package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"tb_table\"")
public class TbTableEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="table_name")
    private String tableName;

    @Property(value="entity_name")
    private String entityName;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    @Override
    public String toString() {
        return "TbTableEntity{" +
                "pk='" + pk + '\'' +
                ", tableName='" + tableName + '\'' +
                ", entityName='" + entityName + '\'' +
                '}';
    }
}
