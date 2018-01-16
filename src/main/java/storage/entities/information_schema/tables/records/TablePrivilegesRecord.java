/*
 * This file is generated by jOOQ.
*/
package storage.entities.information_schema.tables.records;


import org.jooq.Field;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.TableRecordImpl;
import storage.entities.information_schema.tables.TablePrivileges;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.10.0"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class TablePrivilegesRecord extends TableRecordImpl<TablePrivilegesRecord> implements Record6<String, String, String, String, String, String> {

    private static final long serialVersionUID = 257074483;

    /**
     * Setter for <code>information_schema.TABLE_PRIVILEGES.GRANTEE</code>.
     */
    public void setGrantee(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>information_schema.TABLE_PRIVILEGES.GRANTEE</code>.
     */
    public String getGrantee() {
        return (String) get(0);
    }

    /**
     * Setter for <code>information_schema.TABLE_PRIVILEGES.TABLE_CATALOG</code>.
     */
    public void setTableCatalog(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>information_schema.TABLE_PRIVILEGES.TABLE_CATALOG</code>.
     */
    public String getTableCatalog() {
        return (String) get(1);
    }

    /**
     * Setter for <code>information_schema.TABLE_PRIVILEGES.TABLE_SCHEMA</code>.
     */
    public void setTableSchema(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>information_schema.TABLE_PRIVILEGES.TABLE_SCHEMA</code>.
     */
    public String getTableSchema() {
        return (String) get(2);
    }

    /**
     * Setter for <code>information_schema.TABLE_PRIVILEGES.TABLE_NAME</code>.
     */
    public void setTableName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>information_schema.TABLE_PRIVILEGES.TABLE_NAME</code>.
     */
    public String getTableName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>information_schema.TABLE_PRIVILEGES.PRIVILEGE_TYPE</code>.
     */
    public void setPrivilegeType(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>information_schema.TABLE_PRIVILEGES.PRIVILEGE_TYPE</code>.
     */
    public String getPrivilegeType() {
        return (String) get(4);
    }

    /**
     * Setter for <code>information_schema.TABLE_PRIVILEGES.IS_GRANTABLE</code>.
     */
    public void setIsGrantable(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>information_schema.TABLE_PRIVILEGES.IS_GRANTABLE</code>.
     */
    public String getIsGrantable() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<String, String, String, String, String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<String, String, String, String, String, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return TablePrivileges.TABLE_PRIVILEGES.GRANTEE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TablePrivileges.TABLE_PRIVILEGES.TABLE_CATALOG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TablePrivileges.TABLE_PRIVILEGES.TABLE_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return TablePrivileges.TABLE_PRIVILEGES.TABLE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return TablePrivileges.TABLE_PRIVILEGES.PRIVILEGE_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return TablePrivileges.TABLE_PRIVILEGES.IS_GRANTABLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getGrantee();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getTableCatalog();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getTableSchema();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getTableName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getPrivilegeType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getIsGrantable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getGrantee();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getTableCatalog();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getTableSchema();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getTableName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getPrivilegeType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getIsGrantable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablePrivilegesRecord value1(String value) {
        setGrantee(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablePrivilegesRecord value2(String value) {
        setTableCatalog(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablePrivilegesRecord value3(String value) {
        setTableSchema(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablePrivilegesRecord value4(String value) {
        setTableName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablePrivilegesRecord value5(String value) {
        setPrivilegeType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablePrivilegesRecord value6(String value) {
        setIsGrantable(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablePrivilegesRecord values(String value1, String value2, String value3, String value4, String value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TablePrivilegesRecord
     */
    public TablePrivilegesRecord() {
        super(TablePrivileges.TABLE_PRIVILEGES);
    }

    /**
     * Create a detached, initialised TablePrivilegesRecord
     */
    public TablePrivilegesRecord(String grantee, String tableCatalog, String tableSchema, String tableName, String privilegeType, String isGrantable) {
        super(TablePrivileges.TABLE_PRIVILEGES);

        set(0, grantee);
        set(1, tableCatalog);
        set(2, tableSchema);
        set(3, tableName);
        set(4, privilegeType);
        set(5, isGrantable);
    }
}
