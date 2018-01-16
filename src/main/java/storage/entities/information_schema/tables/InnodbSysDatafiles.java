/*
 * This file is generated by jOOQ.
*/
package storage.entities.information_schema.tables;


import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.UInteger;
import storage.entities.information_schema.InformationSchema;
import storage.entities.information_schema.tables.records.InnodbSysDatafilesRecord;

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
public class InnodbSysDatafiles extends TableImpl<InnodbSysDatafilesRecord> {

    private static final long serialVersionUID = -53812145;

    /**
     * The reference instance of <code>information_schema.INNODB_SYS_DATAFILES</code>
     */
    public static final InnodbSysDatafiles INNODB_SYS_DATAFILES = new InnodbSysDatafiles();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<InnodbSysDatafilesRecord> getRecordType() {
        return InnodbSysDatafilesRecord.class;
    }

    /**
     * The column <code>information_schema.INNODB_SYS_DATAFILES.SPACE</code>.
     */
    public final TableField<InnodbSysDatafilesRecord, UInteger> SPACE = createField("SPACE", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGERUNSIGNED)), this, "");

    /**
     * The column <code>information_schema.INNODB_SYS_DATAFILES.PATH</code>.
     */
    public final TableField<InnodbSysDatafilesRecord, String> PATH = createField("PATH", org.jooq.impl.SQLDataType.VARCHAR(4000).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>information_schema.INNODB_SYS_DATAFILES</code> table reference
     */
    public InnodbSysDatafiles() {
        this(DSL.name("INNODB_SYS_DATAFILES"), null);
    }

    /**
     * Create an aliased <code>information_schema.INNODB_SYS_DATAFILES</code> table reference
     */
    public InnodbSysDatafiles(String alias) {
        this(DSL.name(alias), INNODB_SYS_DATAFILES);
    }

    /**
     * Create an aliased <code>information_schema.INNODB_SYS_DATAFILES</code> table reference
     */
    public InnodbSysDatafiles(Name alias) {
        this(alias, INNODB_SYS_DATAFILES);
    }

    private InnodbSysDatafiles(Name alias, Table<InnodbSysDatafilesRecord> aliased) {
        this(alias, aliased, null);
    }

    private InnodbSysDatafiles(Name alias, Table<InnodbSysDatafilesRecord> aliased, Field<?>[] parameters) {
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
    public InnodbSysDatafiles as(String alias) {
        return new InnodbSysDatafiles(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbSysDatafiles as(Name alias) {
        return new InnodbSysDatafiles(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public InnodbSysDatafiles rename(String name) {
        return new InnodbSysDatafiles(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public InnodbSysDatafiles rename(Name name) {
        return new InnodbSysDatafiles(name, null);
    }
}
