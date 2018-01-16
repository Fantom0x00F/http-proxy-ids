/*
 * This file is generated by jOOQ.
*/
package storage.entities.reverse_proxy.tables;


import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import storage.entities.reverse_proxy.ReverseProxy;
import storage.entities.reverse_proxy.tables.records.ResponseCodeDistributionRecord;

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
public class ResponseCodeDistribution extends TableImpl<ResponseCodeDistributionRecord> {

    private static final long serialVersionUID = -1165419025;

    /**
     * The reference instance of <code>reverse-proxy.response-code-distribution</code>
     */
    public static final ResponseCodeDistribution RESPONSE_CODE_DISTRIBUTION = new ResponseCodeDistribution();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ResponseCodeDistributionRecord> getRecordType() {
        return ResponseCodeDistributionRecord.class;
    }

    /**
     * The column <code>reverse-proxy.response-code-distribution.request</code>.
     */
    public final TableField<ResponseCodeDistributionRecord, String> REQUEST = createField("request", org.jooq.impl.SQLDataType.VARCHAR(1024).nullable(false), this, "");

    /**
     * The column <code>reverse-proxy.response-code-distribution.value</code>.
     */
    public final TableField<ResponseCodeDistributionRecord, Integer> VALUE = createField("value", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>reverse-proxy.response-code-distribution.probability</code>.
     */
    public final TableField<ResponseCodeDistributionRecord, Double> PROBABILITY = createField("probability", org.jooq.impl.SQLDataType.DOUBLE.nullable(false), this, "");

    /**
     * Create a <code>reverse-proxy.response-code-distribution</code> table reference
     */
    public ResponseCodeDistribution() {
        this(DSL.name("response-code-distribution"), null);
    }

    /**
     * Create an aliased <code>reverse-proxy.response-code-distribution</code> table reference
     */
    public ResponseCodeDistribution(String alias) {
        this(DSL.name(alias), RESPONSE_CODE_DISTRIBUTION);
    }

    /**
     * Create an aliased <code>reverse-proxy.response-code-distribution</code> table reference
     */
    public ResponseCodeDistribution(Name alias) {
        this(alias, RESPONSE_CODE_DISTRIBUTION);
    }

    private ResponseCodeDistribution(Name alias, Table<ResponseCodeDistributionRecord> aliased) {
        this(alias, aliased, null);
    }

    private ResponseCodeDistribution(Name alias, Table<ResponseCodeDistributionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return ReverseProxy.REVERSE_PROXY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseCodeDistribution as(String alias) {
        return new ResponseCodeDistribution(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseCodeDistribution as(Name alias) {
        return new ResponseCodeDistribution(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ResponseCodeDistribution rename(String name) {
        return new ResponseCodeDistribution(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ResponseCodeDistribution rename(Name name) {
        return new ResponseCodeDistribution(name, null);
    }
}