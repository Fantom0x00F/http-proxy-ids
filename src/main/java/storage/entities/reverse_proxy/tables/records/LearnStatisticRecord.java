/*
 * This file is generated by jOOQ.
*/
package storage.entities.reverse_proxy.tables.records;


import org.jooq.Field;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.TableRecordImpl;
import storage.entities.reverse_proxy.tables.LearnStatistic;

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
public class LearnStatisticRecord extends TableRecordImpl<LearnStatisticRecord> implements Record5<String, Integer, Integer, Integer, Integer> {

    private static final long serialVersionUID = 1200374790;

    /**
     * Setter for <code>reverse-proxy.learn-statistic.request</code>.
     */
    public void setRequest(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>reverse-proxy.learn-statistic.request</code>.
     */
    public String getRequest() {
        return (String) get(0);
    }

    /**
     * Setter for <code>reverse-proxy.learn-statistic.code</code>.
     */
    public void setCode(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>reverse-proxy.learn-statistic.code</code>.
     */
    public Integer getCode() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>reverse-proxy.learn-statistic.size</code>.
     */
    public void setSize(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>reverse-proxy.learn-statistic.size</code>.
     */
    public Integer getSize() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>reverse-proxy.learn-statistic.html_tags_count</code>.
     */
    public void setHtmlTagsCount(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>reverse-proxy.learn-statistic.html_tags_count</code>.
     */
    public Integer getHtmlTagsCount() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>reverse-proxy.learn-statistic.latency</code>.
     */
    public void setLatency(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>reverse-proxy.learn-statistic.latency</code>.
     */
    public Integer getLatency() {
        return (Integer) get(4);
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<String, Integer, Integer, Integer, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<String, Integer, Integer, Integer, Integer> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return LearnStatistic.LEARN_STATISTIC.REQUEST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return LearnStatistic.LEARN_STATISTIC.CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return LearnStatistic.LEARN_STATISTIC.SIZE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return LearnStatistic.LEARN_STATISTIC.HTML_TAGS_COUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return LearnStatistic.LEARN_STATISTIC.LATENCY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getRequest();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getHtmlTagsCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component5() {
        return getLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getRequest();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getHtmlTagsCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LearnStatisticRecord value1(String value) {
        setRequest(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LearnStatisticRecord value2(Integer value) {
        setCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LearnStatisticRecord value3(Integer value) {
        setSize(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LearnStatisticRecord value4(Integer value) {
        setHtmlTagsCount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LearnStatisticRecord value5(Integer value) {
        setLatency(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LearnStatisticRecord values(String value1, Integer value2, Integer value3, Integer value4, Integer value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LearnStatisticRecord
     */
    public LearnStatisticRecord() {
        super(LearnStatistic.LEARN_STATISTIC);
    }

    /**
     * Create a detached, initialised LearnStatisticRecord
     */
    public LearnStatisticRecord(String request, Integer code, Integer size, Integer htmlTagsCount, Integer latency) {
        super(LearnStatistic.LEARN_STATISTIC);

        set(0, request);
        set(1, code);
        set(2, size);
        set(3, htmlTagsCount);
        set(4, latency);
    }
}
