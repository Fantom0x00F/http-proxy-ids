/*
 * This file is generated by jOOQ.
*/
package storage.entities.information_schema.tables.records;


import org.jooq.Field;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.TableRecordImpl;
import storage.entities.information_schema.tables.Plugins;

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
public class PluginsRecord extends TableRecordImpl<PluginsRecord> implements Record11<String, String, String, String, String, String, String, String, String, String, String> {

    private static final long serialVersionUID = 1368291813;

    /**
     * Setter for <code>information_schema.PLUGINS.PLUGIN_NAME</code>.
     */
    public void setPluginName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>information_schema.PLUGINS.PLUGIN_NAME</code>.
     */
    public String getPluginName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>information_schema.PLUGINS.PLUGIN_VERSION</code>.
     */
    public void setPluginVersion(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>information_schema.PLUGINS.PLUGIN_VERSION</code>.
     */
    public String getPluginVersion() {
        return (String) get(1);
    }

    /**
     * Setter for <code>information_schema.PLUGINS.PLUGIN_STATUS</code>.
     */
    public void setPluginStatus(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>information_schema.PLUGINS.PLUGIN_STATUS</code>.
     */
    public String getPluginStatus() {
        return (String) get(2);
    }

    /**
     * Setter for <code>information_schema.PLUGINS.PLUGIN_TYPE</code>.
     */
    public void setPluginType(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>information_schema.PLUGINS.PLUGIN_TYPE</code>.
     */
    public String getPluginType() {
        return (String) get(3);
    }

    /**
     * Setter for <code>information_schema.PLUGINS.PLUGIN_TYPE_VERSION</code>.
     */
    public void setPluginTypeVersion(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>information_schema.PLUGINS.PLUGIN_TYPE_VERSION</code>.
     */
    public String getPluginTypeVersion() {
        return (String) get(4);
    }

    /**
     * Setter for <code>information_schema.PLUGINS.PLUGIN_LIBRARY</code>.
     */
    public void setPluginLibrary(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>information_schema.PLUGINS.PLUGIN_LIBRARY</code>.
     */
    public String getPluginLibrary() {
        return (String) get(5);
    }

    /**
     * Setter for <code>information_schema.PLUGINS.PLUGIN_LIBRARY_VERSION</code>.
     */
    public void setPluginLibraryVersion(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>information_schema.PLUGINS.PLUGIN_LIBRARY_VERSION</code>.
     */
    public String getPluginLibraryVersion() {
        return (String) get(6);
    }

    /**
     * Setter for <code>information_schema.PLUGINS.PLUGIN_AUTHOR</code>.
     */
    public void setPluginAuthor(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>information_schema.PLUGINS.PLUGIN_AUTHOR</code>.
     */
    public String getPluginAuthor() {
        return (String) get(7);
    }

    /**
     * Setter for <code>information_schema.PLUGINS.PLUGIN_DESCRIPTION</code>.
     */
    public void setPluginDescription(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>information_schema.PLUGINS.PLUGIN_DESCRIPTION</code>.
     */
    public String getPluginDescription() {
        return (String) get(8);
    }

    /**
     * Setter for <code>information_schema.PLUGINS.PLUGIN_LICENSE</code>.
     */
    public void setPluginLicense(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>information_schema.PLUGINS.PLUGIN_LICENSE</code>.
     */
    public String getPluginLicense() {
        return (String) get(9);
    }

    /**
     * Setter for <code>information_schema.PLUGINS.LOAD_OPTION</code>.
     */
    public void setLoadOption(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>information_schema.PLUGINS.LOAD_OPTION</code>.
     */
    public String getLoadOption() {
        return (String) get(10);
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<String, String, String, String, String, String, String, String, String, String, String> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<String, String, String, String, String, String, String, String, String, String, String> valuesRow() {
        return (Row11) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Plugins.PLUGINS.PLUGIN_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Plugins.PLUGINS.PLUGIN_VERSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Plugins.PLUGINS.PLUGIN_STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Plugins.PLUGINS.PLUGIN_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Plugins.PLUGINS.PLUGIN_TYPE_VERSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Plugins.PLUGINS.PLUGIN_LIBRARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Plugins.PLUGINS.PLUGIN_LIBRARY_VERSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Plugins.PLUGINS.PLUGIN_AUTHOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Plugins.PLUGINS.PLUGIN_DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return Plugins.PLUGINS.PLUGIN_LICENSE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return Plugins.PLUGINS.LOAD_OPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getPluginName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getPluginVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getPluginStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getPluginType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getPluginTypeVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getPluginLibrary();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getPluginLibraryVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getPluginAuthor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getPluginDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getPluginLicense();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component11() {
        return getLoadOption();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getPluginName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getPluginVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getPluginStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getPluginType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getPluginTypeVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getPluginLibrary();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getPluginLibraryVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getPluginAuthor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getPluginDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getPluginLicense();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getLoadOption();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PluginsRecord value1(String value) {
        setPluginName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PluginsRecord value2(String value) {
        setPluginVersion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PluginsRecord value3(String value) {
        setPluginStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PluginsRecord value4(String value) {
        setPluginType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PluginsRecord value5(String value) {
        setPluginTypeVersion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PluginsRecord value6(String value) {
        setPluginLibrary(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PluginsRecord value7(String value) {
        setPluginLibraryVersion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PluginsRecord value8(String value) {
        setPluginAuthor(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PluginsRecord value9(String value) {
        setPluginDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PluginsRecord value10(String value) {
        setPluginLicense(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PluginsRecord value11(String value) {
        setLoadOption(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PluginsRecord values(String value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9, String value10, String value11) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PluginsRecord
     */
    public PluginsRecord() {
        super(Plugins.PLUGINS);
    }

    /**
     * Create a detached, initialised PluginsRecord
     */
    public PluginsRecord(String pluginName, String pluginVersion, String pluginStatus, String pluginType, String pluginTypeVersion, String pluginLibrary, String pluginLibraryVersion, String pluginAuthor, String pluginDescription, String pluginLicense, String loadOption) {
        super(Plugins.PLUGINS);

        set(0, pluginName);
        set(1, pluginVersion);
        set(2, pluginStatus);
        set(3, pluginType);
        set(4, pluginTypeVersion);
        set(5, pluginLibrary);
        set(6, pluginLibraryVersion);
        set(7, pluginAuthor);
        set(8, pluginDescription);
        set(9, pluginLicense);
        set(10, loadOption);
    }
}