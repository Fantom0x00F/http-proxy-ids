/*
 * This file is generated by jOOQ.
*/
package storage.entities.information_schema.tables;


import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import storage.entities.information_schema.InformationSchema;
import storage.entities.information_schema.tables.records.InnodbFtDefaultStopwordRecord;

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
public class InnodbFtDefaultStopword extends TableImpl<InnodbFtDefaultStopwordRecord> {

    private static final long serialVersionUID = 1704416864;

    /**
     * The reference instance of <code>information_schema.INNODB_FT_DEFAULT_STOPWORD</code>
     */
    public static final InnodbFtDefaultStopword INNODB_FT_DEFAULT_STOPWORD = new InnodbFtDefaultStopword();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<InnodbFtDefaultStopwordRecord> getRecordType() {
        return InnodbFtDefaultStopwordRecord.class;
    }

    /**
     * The column <code>information_schema.INNODB_FT_DEFAULT_STOPWORD.value</code>.
     */
    public final TableField<InnodbFtDefaultStopwordRecord, String> VALUE = createField("value", org.jooq.impl.SQLDataType.VARCHAR(18).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>information_schema.INNODB_FT_DEFAULT_STOPWORD</code> table reference
     */
    public InnodbFtDefaultStopword() {
        this(DSL.name("INNODB_FT_DEFAULT_STOPWORD"), null);
    }

    /**
     * Create an aliased <code>information_schema.INNODB_FT_DEFAULT_STOPWORD</code> table reference
     */
    public InnodbFtDefaultStopword(String alias) {
        this(DSL.name(alias), INNODB_FT_DEFAULT_STOPWORD);
    }

    /**
     * Create an aliased <code>information_schema.INNODB_FT_DEFAULT_STOPWORD</code> table reference
     */
    public InnodbFtDefaultStopword(Name alias) {
        this(alias, INNODB_FT_DEFAULT_STOPWORD);
    }

    private InnodbFtDefaultStopword(Name alias, Table<InnodbFtDefaultStopwordRecord> aliased) {
        this(alias, aliased, null);
    }

    private InnodbFtDefaultStopword(Name alias, Table<InnodbFtDefaultStopwordRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return InformationSchema.INFORMATION_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbFtDefaultStopword as(String alias) {
        return new InnodbFtDefaultStopword(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbFtDefaultStopword as(Name alias) {
        return new InnodbFtDefaultStopword(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public InnodbFtDefaultStopword rename(String name) {
        return new InnodbFtDefaultStopword(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public InnodbFtDefaultStopword rename(Name name) {
        return new InnodbFtDefaultStopword(name, null);
    }
}
