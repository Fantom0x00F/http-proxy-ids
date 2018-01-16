/*
 * This file is generated by jOOQ.
*/
package storage.entities.information_schema.tables.records;


import org.jooq.Field;
import org.jooq.Record21;
import org.jooq.Row21;
import org.jooq.impl.TableRecordImpl;
import org.jooq.types.ULong;
import storage.entities.information_schema.tables.Tables;

import javax.annotation.Generated;
import java.sql.Timestamp;


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
public class TablesRecord extends TableRecordImpl<TablesRecord> implements Record21<String, String, String, String, String, ULong, String, ULong, ULong, ULong, ULong, ULong, ULong, ULong, Timestamp, Timestamp, Timestamp, String, ULong, String, String> {

    private static final long serialVersionUID = 1237888301;

    /**
     * Setter for <code>information_schema.TABLES.TABLE_CATALOG</code>.
     */
    public void setTableCatalog(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>information_schema.TABLES.TABLE_CATALOG</code>.
     */
    public String getTableCatalog() {
        return (String) get(0);
    }

    /**
     * Setter for <code>information_schema.TABLES.TABLE_SCHEMA</code>.
     */
    public void setTableSchema(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>information_schema.TABLES.TABLE_SCHEMA</code>.
     */
    public String getTableSchema() {
        return (String) get(1);
    }

    /**
     * Setter for <code>information_schema.TABLES.TABLE_NAME</code>.
     */
    public void setTableName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>information_schema.TABLES.TABLE_NAME</code>.
     */
    public String getTableName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>information_schema.TABLES.TABLE_TYPE</code>.
     */
    public void setTableType(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>information_schema.TABLES.TABLE_TYPE</code>.
     */
    public String getTableType() {
        return (String) get(3);
    }

    /**
     * Setter for <code>information_schema.TABLES.ENGINE</code>.
     */
    public void setEngine(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>information_schema.TABLES.ENGINE</code>.
     */
    public String getEngine() {
        return (String) get(4);
    }

    /**
     * Setter for <code>information_schema.TABLES.VERSION</code>.
     */
    public void setVersion(ULong value) {
        set(5, value);
    }

    /**
     * Getter for <code>information_schema.TABLES.VERSION</code>.
     */
    public ULong getVersion() {
        return (ULong) get(5);
    }

    /**
     * Setter for <code>information_schema.TABLES.ROW_FORMAT</code>.
     */
    public void setRowFormat(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>information_schema.TABLES.ROW_FORMAT</code>.
     */
    public String getRowFormat() {
        return (String) get(6);
    }

    /**
     * Setter for <code>information_schema.TABLES.TABLE_ROWS</code>.
     */
    public void setTableRows(ULong value) {
        set(7, value);
    }

    /**
     * Getter for <code>information_schema.TABLES.TABLE_ROWS</code>.
     */
    public ULong getTableRows() {
        return (ULong) get(7);
    }

    /**
     * Setter for <code>information_schema.TABLES.AVG_ROW_LENGTH</code>.
     */
    public void setAvgRowLength(ULong value) {
        set(8, value);
    }

    /**
     * Getter for <code>information_schema.TABLES.AVG_ROW_LENGTH</code>.
     */
    public ULong getAvgRowLength() {
        return (ULong) get(8);
    }

    /**
     * Setter for <code>information_schema.TABLES.DATA_LENGTH</code>.
     */
    public void setDataLength(ULong value) {
        set(9, value);
    }

    /**
     * Getter for <code>information_schema.TABLES.DATA_LENGTH</code>.
     */
    public ULong getDataLength() {
        return (ULong) get(9);
    }

    /**
     * Setter for <code>information_schema.TABLES.MAX_DATA_LENGTH</code>.
     */
    public void setMaxDataLength(ULong value) {
        set(10, value);
    }

    /**
     * Getter for <code>information_schema.TABLES.MAX_DATA_LENGTH</code>.
     */
    public ULong getMaxDataLength() {
        return (ULong) get(10);
    }

    /**
     * Setter for <code>information_schema.TABLES.INDEX_LENGTH</code>.
     */
    public void setIndexLength(ULong value) {
        set(11, value);
    }

    /**
     * Getter for <code>information_schema.TABLES.INDEX_LENGTH</code>.
     */
    public ULong getIndexLength() {
        return (ULong) get(11);
    }

    /**
     * Setter for <code>information_schema.TABLES.DATA_FREE</code>.
     */
    public void setDataFree(ULong value) {
        set(12, value);
    }

    /**
     * Getter for <code>information_schema.TABLES.DATA_FREE</code>.
     */
    public ULong getDataFree() {
        return (ULong) get(12);
    }

    /**
     * Setter for <code>information_schema.TABLES.AUTO_INCREMENT</code>.
     */
    public void setAutoIncrement(ULong value) {
        set(13, value);
    }

    /**
     * Getter for <code>information_schema.TABLES.AUTO_INCREMENT</code>.
     */
    public ULong getAutoIncrement() {
        return (ULong) get(13);
    }

    /**
     * Setter for <code>information_schema.TABLES.CREATE_TIME</code>.
     */
    public void setCreateTime(Timestamp value) {
        set(14, value);
    }

    /**
     * Getter for <code>information_schema.TABLES.CREATE_TIME</code>.
     */
    public Timestamp getCreateTime() {
        return (Timestamp) get(14);
    }

    /**
     * Setter for <code>information_schema.TABLES.UPDATE_TIME</code>.
     */
    public void setUpdateTime(Timestamp value) {
        set(15, value);
    }

    /**
     * Getter for <code>information_schema.TABLES.UPDATE_TIME</code>.
     */
    public Timestamp getUpdateTime() {
        return (Timestamp) get(15);
    }

    /**
     * Setter for <code>information_schema.TABLES.CHECK_TIME</code>.
     */
    public void setCheckTime(Timestamp value) {
        set(16, value);
    }

    /**
     * Getter for <code>information_schema.TABLES.CHECK_TIME</code>.
     */
    public Timestamp getCheckTime() {
        return (Timestamp) get(16);
    }

    /**
     * Setter for <code>information_schema.TABLES.TABLE_COLLATION</code>.
     */
    public void setTableCollation(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>information_schema.TABLES.TABLE_COLLATION</code>.
     */
    public String getTableCollation() {
        return (String) get(17);
    }

    /**
     * Setter for <code>information_schema.TABLES.CHECKSUM</code>.
     */
    public void setChecksum(ULong value) {
        set(18, value);
    }

    /**
     * Getter for <code>information_schema.TABLES.CHECKSUM</code>.
     */
    public ULong getChecksum() {
        return (ULong) get(18);
    }

    /**
     * Setter for <code>information_schema.TABLES.CREATE_OPTIONS</code>.
     */
    public void setCreateOptions(String value) {
        set(19, value);
    }

    /**
     * Getter for <code>information_schema.TABLES.CREATE_OPTIONS</code>.
     */
    public String getCreateOptions() {
        return (String) get(19);
    }

    /**
     * Setter for <code>information_schema.TABLES.TABLE_COMMENT</code>.
     */
    public void setTableComment(String value) {
        set(20, value);
    }

    /**
     * Getter for <code>information_schema.TABLES.TABLE_COMMENT</code>.
     */
    public String getTableComment() {
        return (String) get(20);
    }

    // -------------------------------------------------------------------------
    // Record21 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row21<String, String, String, String, String, ULong, String, ULong, ULong, ULong, ULong, ULong, ULong, ULong, Timestamp, Timestamp, Timestamp, String, ULong, String, String> fieldsRow() {
        return (Row21) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row21<String, String, String, String, String, ULong, String, ULong, ULong, ULong, ULong, ULong, ULong, ULong, Timestamp, Timestamp, Timestamp, String, ULong, String, String> valuesRow() {
        return (Row21) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Tables.TABLES.TABLE_CATALOG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Tables.TABLES.TABLE_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Tables.TABLES.TABLE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Tables.TABLES.TABLE_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Tables.TABLES.ENGINE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field6() {
        return Tables.TABLES.VERSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Tables.TABLES.ROW_FORMAT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field8() {
        return Tables.TABLES.TABLE_ROWS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field9() {
        return Tables.TABLES.AVG_ROW_LENGTH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field10() {
        return Tables.TABLES.DATA_LENGTH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field11() {
        return Tables.TABLES.MAX_DATA_LENGTH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field12() {
        return Tables.TABLES.INDEX_LENGTH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field13() {
        return Tables.TABLES.DATA_FREE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field14() {
        return Tables.TABLES.AUTO_INCREMENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field15() {
        return Tables.TABLES.CREATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field16() {
        return Tables.TABLES.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field17() {
        return Tables.TABLES.CHECK_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field18() {
        return Tables.TABLES.TABLE_COLLATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field19() {
        return Tables.TABLES.CHECKSUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field20() {
        return Tables.TABLES.CREATE_OPTIONS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field21() {
        return Tables.TABLES.TABLE_COMMENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getTableCatalog();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getTableSchema();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getTableName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getTableType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getEngine();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component6() {
        return getVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getRowFormat();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component8() {
        return getTableRows();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component9() {
        return getAvgRowLength();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component10() {
        return getDataLength();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component11() {
        return getMaxDataLength();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component12() {
        return getIndexLength();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component13() {
        return getDataFree();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component14() {
        return getAutoIncrement();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component15() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component16() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component17() {
        return getCheckTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component18() {
        return getTableCollation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component19() {
        return getChecksum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component20() {
        return getCreateOptions();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component21() {
        return getTableComment();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getTableCatalog();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getTableSchema();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getTableName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getTableType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getEngine();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value6() {
        return getVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getRowFormat();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value8() {
        return getTableRows();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value9() {
        return getAvgRowLength();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value10() {
        return getDataLength();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value11() {
        return getMaxDataLength();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value12() {
        return getIndexLength();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value13() {
        return getDataFree();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value14() {
        return getAutoIncrement();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value15() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value16() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value17() {
        return getCheckTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value18() {
        return getTableCollation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value19() {
        return getChecksum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value20() {
        return getCreateOptions();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value21() {
        return getTableComment();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value1(String value) {
        setTableCatalog(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value2(String value) {
        setTableSchema(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value3(String value) {
        setTableName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value4(String value) {
        setTableType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value5(String value) {
        setEngine(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value6(ULong value) {
        setVersion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value7(String value) {
        setRowFormat(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value8(ULong value) {
        setTableRows(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value9(ULong value) {
        setAvgRowLength(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value10(ULong value) {
        setDataLength(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value11(ULong value) {
        setMaxDataLength(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value12(ULong value) {
        setIndexLength(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value13(ULong value) {
        setDataFree(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value14(ULong value) {
        setAutoIncrement(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value15(Timestamp value) {
        setCreateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value16(Timestamp value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value17(Timestamp value) {
        setCheckTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value18(String value) {
        setTableCollation(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value19(ULong value) {
        setChecksum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value20(String value) {
        setCreateOptions(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value21(String value) {
        setTableComment(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord values(String value1, String value2, String value3, String value4, String value5, ULong value6, String value7, ULong value8, ULong value9, ULong value10, ULong value11, ULong value12, ULong value13, ULong value14, Timestamp value15, Timestamp value16, Timestamp value17, String value18, ULong value19, String value20, String value21) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        value19(value19);
        value20(value20);
        value21(value21);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TablesRecord
     */
    public TablesRecord() {
        super(Tables.TABLES);
    }

    /**
     * Create a detached, initialised TablesRecord
     */
    public TablesRecord(String tableCatalog, String tableSchema, String tableName, String tableType, String engine, ULong version, String rowFormat, ULong tableRows, ULong avgRowLength, ULong dataLength, ULong maxDataLength, ULong indexLength, ULong dataFree, ULong autoIncrement, Timestamp createTime, Timestamp updateTime, Timestamp checkTime, String tableCollation, ULong checksum, String createOptions, String tableComment) {
        super(Tables.TABLES);

        set(0, tableCatalog);
        set(1, tableSchema);
        set(2, tableName);
        set(3, tableType);
        set(4, engine);
        set(5, version);
        set(6, rowFormat);
        set(7, tableRows);
        set(8, avgRowLength);
        set(9, dataLength);
        set(10, maxDataLength);
        set(11, indexLength);
        set(12, dataFree);
        set(13, autoIncrement);
        set(14, createTime);
        set(15, updateTime);
        set(16, checkTime);
        set(17, tableCollation);
        set(18, checksum);
        set(19, createOptions);
        set(20, tableComment);
    }
}
