package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.ProxyUtils;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class ReservationRealmProxy extends com.droideve.apps.sugoi.booking.modals.Reservation
    implements RealmObjectProxy, ReservationRealmProxyInterface {

    static final class ReservationColumnInfo extends ColumnInfo {
        long idIndex;
        long user_idIndex;
        long id_storeIndex;
        long nameIndex;
        long req_cf_idIndex;
        long status_idIndex;
        long statusIndex;
        long moduleIndex;
        long cartIndex;
        long req_cf_dataIndex;
        long updated_atIndex;
        long created_atIndex;
        long itemsIndex;
        long amountIndex;
        long servicesIndex;
        long extrasIndex;
        long payment_status_dataIndex;
        long payment_statusIndex;

        ReservationColumnInfo(OsSchemaInfo schemaInfo) {
            super(18);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Reservation");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.user_idIndex = addColumnDetails("user_id", objectSchemaInfo);
            this.id_storeIndex = addColumnDetails("id_store", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", objectSchemaInfo);
            this.req_cf_idIndex = addColumnDetails("req_cf_id", objectSchemaInfo);
            this.status_idIndex = addColumnDetails("status_id", objectSchemaInfo);
            this.statusIndex = addColumnDetails("status", objectSchemaInfo);
            this.moduleIndex = addColumnDetails("module", objectSchemaInfo);
            this.cartIndex = addColumnDetails("cart", objectSchemaInfo);
            this.req_cf_dataIndex = addColumnDetails("req_cf_data", objectSchemaInfo);
            this.updated_atIndex = addColumnDetails("updated_at", objectSchemaInfo);
            this.created_atIndex = addColumnDetails("created_at", objectSchemaInfo);
            this.itemsIndex = addColumnDetails("items", objectSchemaInfo);
            this.amountIndex = addColumnDetails("amount", objectSchemaInfo);
            this.servicesIndex = addColumnDetails("services", objectSchemaInfo);
            this.extrasIndex = addColumnDetails("extras", objectSchemaInfo);
            this.payment_status_dataIndex = addColumnDetails("payment_status_data", objectSchemaInfo);
            this.payment_statusIndex = addColumnDetails("payment_status", objectSchemaInfo);
        }

        ReservationColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ReservationColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ReservationColumnInfo src = (ReservationColumnInfo) rawSrc;
            final ReservationColumnInfo dst = (ReservationColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.user_idIndex = src.user_idIndex;
            dst.id_storeIndex = src.id_storeIndex;
            dst.nameIndex = src.nameIndex;
            dst.req_cf_idIndex = src.req_cf_idIndex;
            dst.status_idIndex = src.status_idIndex;
            dst.statusIndex = src.statusIndex;
            dst.moduleIndex = src.moduleIndex;
            dst.cartIndex = src.cartIndex;
            dst.req_cf_dataIndex = src.req_cf_dataIndex;
            dst.updated_atIndex = src.updated_atIndex;
            dst.created_atIndex = src.created_atIndex;
            dst.itemsIndex = src.itemsIndex;
            dst.amountIndex = src.amountIndex;
            dst.servicesIndex = src.servicesIndex;
            dst.extrasIndex = src.extrasIndex;
            dst.payment_status_dataIndex = src.payment_status_dataIndex;
            dst.payment_statusIndex = src.payment_statusIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(18);
        fieldNames.add("id");
        fieldNames.add("user_id");
        fieldNames.add("id_store");
        fieldNames.add("name");
        fieldNames.add("req_cf_id");
        fieldNames.add("status_id");
        fieldNames.add("status");
        fieldNames.add("module");
        fieldNames.add("cart");
        fieldNames.add("req_cf_data");
        fieldNames.add("updated_at");
        fieldNames.add("created_at");
        fieldNames.add("items");
        fieldNames.add("amount");
        fieldNames.add("services");
        fieldNames.add("extras");
        fieldNames.add("payment_status_data");
        fieldNames.add("payment_status");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private ReservationColumnInfo columnInfo;
    private ProxyState<com.droideve.apps.sugoi.booking.modals.Reservation> proxyState;
    private RealmList<com.droideve.apps.sugoi.booking.modals.Item> itemsRealmList;
    private RealmList<com.droideve.apps.sugoi.booking.modals.Service> servicesRealmList;

    ReservationRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ReservationColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.droideve.apps.sugoi.booking.modals.Reservation>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$user_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.user_idIndex);
    }

    @Override
    public void realmSet$user_id(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.user_idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.user_idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id_store() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.id_storeIndex);
    }

    @Override
    public void realmSet$id_store(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.id_storeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.id_storeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$req_cf_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.req_cf_idIndex);
    }

    @Override
    public void realmSet$req_cf_id(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.req_cf_idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.req_cf_idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$status_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.status_idIndex);
    }

    @Override
    public void realmSet$status_id(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.status_idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.status_idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$status() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.statusIndex);
    }

    @Override
    public void realmSet$status(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.statusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.statusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.statusIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.statusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$module() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.moduleIndex);
    }

    @Override
    public void realmSet$module(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.moduleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.moduleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.moduleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.moduleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$cart() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cartIndex);
    }

    @Override
    public void realmSet$cart(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.cartIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cartIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cartIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cartIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$req_cf_data() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.req_cf_dataIndex);
    }

    @Override
    public void realmSet$req_cf_data(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.req_cf_dataIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.req_cf_dataIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.req_cf_dataIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.req_cf_dataIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$updated_at() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.updated_atIndex);
    }

    @Override
    public void realmSet$updated_at(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.updated_atIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.updated_atIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.updated_atIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.updated_atIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$created_at() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.created_atIndex);
    }

    @Override
    public void realmSet$created_at(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.created_atIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.created_atIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.created_atIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.created_atIndex, value);
    }

    @Override
    public RealmList<com.droideve.apps.sugoi.booking.modals.Item> realmGet$items() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (itemsRealmList != null) {
            return itemsRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.itemsIndex);
            itemsRealmList = new RealmList<com.droideve.apps.sugoi.booking.modals.Item>(com.droideve.apps.sugoi.booking.modals.Item.class, osList, proxyState.getRealm$realm());
            return itemsRealmList;
        }
    }

    @Override
    public void realmSet$items(RealmList<com.droideve.apps.sugoi.booking.modals.Item> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("items")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.droideve.apps.sugoi.booking.modals.Item> original = value;
                value = new RealmList<com.droideve.apps.sugoi.booking.modals.Item>();
                for (com.droideve.apps.sugoi.booking.modals.Item item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.itemsIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.droideve.apps.sugoi.booking.modals.Item linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.droideve.apps.sugoi.booking.modals.Item linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$amount() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.amountIndex);
    }

    @Override
    public void realmSet$amount(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.amountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.amountIndex, value);
    }

    @Override
    public RealmList<com.droideve.apps.sugoi.booking.modals.Service> realmGet$services() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (servicesRealmList != null) {
            return servicesRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.servicesIndex);
            servicesRealmList = new RealmList<com.droideve.apps.sugoi.booking.modals.Service>(com.droideve.apps.sugoi.booking.modals.Service.class, osList, proxyState.getRealm$realm());
            return servicesRealmList;
        }
    }

    @Override
    public void realmSet$services(RealmList<com.droideve.apps.sugoi.booking.modals.Service> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("services")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.droideve.apps.sugoi.booking.modals.Service> original = value;
                value = new RealmList<com.droideve.apps.sugoi.booking.modals.Service>();
                for (com.droideve.apps.sugoi.booking.modals.Service item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.servicesIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.droideve.apps.sugoi.booking.modals.Service linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.droideve.apps.sugoi.booking.modals.Service linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$extras() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.extrasIndex);
    }

    @Override
    public void realmSet$extras(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.extrasIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.extrasIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.extrasIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.extrasIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$payment_status_data() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.payment_status_dataIndex);
    }

    @Override
    public void realmSet$payment_status_data(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.payment_status_dataIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.payment_status_dataIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.payment_status_dataIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.payment_status_dataIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$payment_status() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.payment_statusIndex);
    }

    @Override
    public void realmSet$payment_status(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.payment_statusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.payment_statusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.payment_statusIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.payment_statusIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Reservation", 18, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("user_id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("id_store", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("req_cf_id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("status_id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("status", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("module", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("cart", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("req_cf_data", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("updated_at", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("created_at", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("items", RealmFieldType.LIST, "Item");
        builder.addPersistedProperty("amount", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedLinkProperty("services", RealmFieldType.LIST, "Service");
        builder.addPersistedProperty("extras", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("payment_status_data", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("payment_status", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ReservationColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ReservationColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Reservation";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.droideve.apps.sugoi.booking.modals.Reservation createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(2);
        com.droideve.apps.sugoi.booking.modals.Reservation obj = null;
        if (update) {
            Table table = realm.getTable(com.droideve.apps.sugoi.booking.modals.Reservation.class);
            ReservationColumnInfo columnInfo = (ReservationColumnInfo) realm.getSchema().getColumnInfo(com.droideve.apps.sugoi.booking.modals.Reservation.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.droideve.apps.sugoi.booking.modals.Reservation.class), false, Collections.<String> emptyList());
                    obj = new io.realm.ReservationRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("items")) {
                excludeFields.add("items");
            }
            if (json.has("services")) {
                excludeFields.add("services");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.ReservationRealmProxy) realm.createObjectInternal(com.droideve.apps.sugoi.booking.modals.Reservation.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.ReservationRealmProxy) realm.createObjectInternal(com.droideve.apps.sugoi.booking.modals.Reservation.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final ReservationRealmProxyInterface objProxy = (ReservationRealmProxyInterface) obj;
        if (json.has("user_id")) {
            if (json.isNull("user_id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'user_id' to null.");
            } else {
                objProxy.realmSet$user_id((int) json.getInt("user_id"));
            }
        }
        if (json.has("id_store")) {
            if (json.isNull("id_store")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id_store' to null.");
            } else {
                objProxy.realmSet$id_store((int) json.getInt("id_store"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("req_cf_id")) {
            if (json.isNull("req_cf_id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'req_cf_id' to null.");
            } else {
                objProxy.realmSet$req_cf_id((int) json.getInt("req_cf_id"));
            }
        }
        if (json.has("status_id")) {
            if (json.isNull("status_id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'status_id' to null.");
            } else {
                objProxy.realmSet$status_id((int) json.getInt("status_id"));
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                objProxy.realmSet$status(null);
            } else {
                objProxy.realmSet$status((String) json.getString("status"));
            }
        }
        if (json.has("module")) {
            if (json.isNull("module")) {
                objProxy.realmSet$module(null);
            } else {
                objProxy.realmSet$module((String) json.getString("module"));
            }
        }
        if (json.has("cart")) {
            if (json.isNull("cart")) {
                objProxy.realmSet$cart(null);
            } else {
                objProxy.realmSet$cart((String) json.getString("cart"));
            }
        }
        if (json.has("req_cf_data")) {
            if (json.isNull("req_cf_data")) {
                objProxy.realmSet$req_cf_data(null);
            } else {
                objProxy.realmSet$req_cf_data((String) json.getString("req_cf_data"));
            }
        }
        if (json.has("updated_at")) {
            if (json.isNull("updated_at")) {
                objProxy.realmSet$updated_at(null);
            } else {
                objProxy.realmSet$updated_at((String) json.getString("updated_at"));
            }
        }
        if (json.has("created_at")) {
            if (json.isNull("created_at")) {
                objProxy.realmSet$created_at(null);
            } else {
                objProxy.realmSet$created_at((String) json.getString("created_at"));
            }
        }
        if (json.has("items")) {
            if (json.isNull("items")) {
                objProxy.realmSet$items(null);
            } else {
                objProxy.realmGet$items().clear();
                JSONArray array = json.getJSONArray("items");
                for (int i = 0; i < array.length(); i++) {
                    com.droideve.apps.sugoi.booking.modals.Item item = ItemRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$items().add(item);
                }
            }
        }
        if (json.has("amount")) {
            if (json.isNull("amount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'amount' to null.");
            } else {
                objProxy.realmSet$amount((double) json.getDouble("amount"));
            }
        }
        if (json.has("services")) {
            if (json.isNull("services")) {
                objProxy.realmSet$services(null);
            } else {
                objProxy.realmGet$services().clear();
                JSONArray array = json.getJSONArray("services");
                for (int i = 0; i < array.length(); i++) {
                    com.droideve.apps.sugoi.booking.modals.Service item = ServiceRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$services().add(item);
                }
            }
        }
        if (json.has("extras")) {
            if (json.isNull("extras")) {
                objProxy.realmSet$extras(null);
            } else {
                objProxy.realmSet$extras((String) json.getString("extras"));
            }
        }
        if (json.has("payment_status_data")) {
            if (json.isNull("payment_status_data")) {
                objProxy.realmSet$payment_status_data(null);
            } else {
                objProxy.realmSet$payment_status_data((String) json.getString("payment_status_data"));
            }
        }
        if (json.has("payment_status")) {
            if (json.isNull("payment_status")) {
                objProxy.realmSet$payment_status(null);
            } else {
                objProxy.realmSet$payment_status((String) json.getString("payment_status"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.droideve.apps.sugoi.booking.modals.Reservation createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.droideve.apps.sugoi.booking.modals.Reservation obj = new com.droideve.apps.sugoi.booking.modals.Reservation();
        final ReservationRealmProxyInterface objProxy = (ReservationRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("user_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$user_id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'user_id' to null.");
                }
            } else if (name.equals("id_store")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id_store((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id_store' to null.");
                }
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("req_cf_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$req_cf_id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'req_cf_id' to null.");
                }
            } else if (name.equals("status_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$status_id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'status_id' to null.");
                }
            } else if (name.equals("status")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$status((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$status(null);
                }
            } else if (name.equals("module")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$module((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$module(null);
                }
            } else if (name.equals("cart")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$cart((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$cart(null);
                }
            } else if (name.equals("req_cf_data")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$req_cf_data((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$req_cf_data(null);
                }
            } else if (name.equals("updated_at")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$updated_at((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$updated_at(null);
                }
            } else if (name.equals("created_at")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$created_at((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$created_at(null);
                }
            } else if (name.equals("items")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$items(null);
                } else {
                    objProxy.realmSet$items(new RealmList<com.droideve.apps.sugoi.booking.modals.Item>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.droideve.apps.sugoi.booking.modals.Item item = ItemRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$items().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("amount")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$amount((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'amount' to null.");
                }
            } else if (name.equals("services")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$services(null);
                } else {
                    objProxy.realmSet$services(new RealmList<com.droideve.apps.sugoi.booking.modals.Service>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.droideve.apps.sugoi.booking.modals.Service item = ServiceRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$services().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("extras")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$extras((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$extras(null);
                }
            } else if (name.equals("payment_status_data")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$payment_status_data((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$payment_status_data(null);
                }
            } else if (name.equals("payment_status")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$payment_status((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$payment_status(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.droideve.apps.sugoi.booking.modals.Reservation copyOrUpdate(Realm realm, com.droideve.apps.sugoi.booking.modals.Reservation object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.droideve.apps.sugoi.booking.modals.Reservation) cachedRealmObject;
        }

        com.droideve.apps.sugoi.booking.modals.Reservation realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.droideve.apps.sugoi.booking.modals.Reservation.class);
            ReservationColumnInfo columnInfo = (ReservationColumnInfo) realm.getSchema().getColumnInfo(com.droideve.apps.sugoi.booking.modals.Reservation.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((ReservationRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.droideve.apps.sugoi.booking.modals.Reservation.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.ReservationRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.droideve.apps.sugoi.booking.modals.Reservation copy(Realm realm, com.droideve.apps.sugoi.booking.modals.Reservation newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.droideve.apps.sugoi.booking.modals.Reservation) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.droideve.apps.sugoi.booking.modals.Reservation realmObject = realm.createObjectInternal(com.droideve.apps.sugoi.booking.modals.Reservation.class, ((ReservationRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        ReservationRealmProxyInterface realmObjectSource = (ReservationRealmProxyInterface) newObject;
        ReservationRealmProxyInterface realmObjectCopy = (ReservationRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$user_id(realmObjectSource.realmGet$user_id());
        realmObjectCopy.realmSet$id_store(realmObjectSource.realmGet$id_store());
        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectCopy.realmSet$req_cf_id(realmObjectSource.realmGet$req_cf_id());
        realmObjectCopy.realmSet$status_id(realmObjectSource.realmGet$status_id());
        realmObjectCopy.realmSet$status(realmObjectSource.realmGet$status());
        realmObjectCopy.realmSet$module(realmObjectSource.realmGet$module());
        realmObjectCopy.realmSet$cart(realmObjectSource.realmGet$cart());
        realmObjectCopy.realmSet$req_cf_data(realmObjectSource.realmGet$req_cf_data());
        realmObjectCopy.realmSet$updated_at(realmObjectSource.realmGet$updated_at());
        realmObjectCopy.realmSet$created_at(realmObjectSource.realmGet$created_at());

        RealmList<com.droideve.apps.sugoi.booking.modals.Item> itemsList = realmObjectSource.realmGet$items();
        if (itemsList != null) {
            RealmList<com.droideve.apps.sugoi.booking.modals.Item> itemsRealmList = realmObjectCopy.realmGet$items();
            itemsRealmList.clear();
            for (int i = 0; i < itemsList.size(); i++) {
                com.droideve.apps.sugoi.booking.modals.Item itemsItem = itemsList.get(i);
                com.droideve.apps.sugoi.booking.modals.Item cacheitems = (com.droideve.apps.sugoi.booking.modals.Item) cache.get(itemsItem);
                if (cacheitems != null) {
                    itemsRealmList.add(cacheitems);
                } else {
                    itemsRealmList.add(ItemRealmProxy.copyOrUpdate(realm, itemsItem, update, cache));
                }
            }
        }

        realmObjectCopy.realmSet$amount(realmObjectSource.realmGet$amount());

        RealmList<com.droideve.apps.sugoi.booking.modals.Service> servicesList = realmObjectSource.realmGet$services();
        if (servicesList != null) {
            RealmList<com.droideve.apps.sugoi.booking.modals.Service> servicesRealmList = realmObjectCopy.realmGet$services();
            servicesRealmList.clear();
            for (int i = 0; i < servicesList.size(); i++) {
                com.droideve.apps.sugoi.booking.modals.Service servicesItem = servicesList.get(i);
                com.droideve.apps.sugoi.booking.modals.Service cacheservices = (com.droideve.apps.sugoi.booking.modals.Service) cache.get(servicesItem);
                if (cacheservices != null) {
                    servicesRealmList.add(cacheservices);
                } else {
                    servicesRealmList.add(ServiceRealmProxy.copyOrUpdate(realm, servicesItem, update, cache));
                }
            }
        }

        realmObjectCopy.realmSet$extras(realmObjectSource.realmGet$extras());
        realmObjectCopy.realmSet$payment_status_data(realmObjectSource.realmGet$payment_status_data());
        realmObjectCopy.realmSet$payment_status(realmObjectSource.realmGet$payment_status());
        return realmObject;
    }

    public static long insert(Realm realm, com.droideve.apps.sugoi.booking.modals.Reservation object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.droideve.apps.sugoi.booking.modals.Reservation.class);
        long tableNativePtr = table.getNativePtr();
        ReservationColumnInfo columnInfo = (ReservationColumnInfo) realm.getSchema().getColumnInfo(com.droideve.apps.sugoi.booking.modals.Reservation.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((ReservationRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ReservationRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((ReservationRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((ReservationRealmProxyInterface) object).realmGet$user_id(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.id_storeIndex, rowIndex, ((ReservationRealmProxyInterface) object).realmGet$id_store(), false);
        String realmGet$name = ((ReservationRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.req_cf_idIndex, rowIndex, ((ReservationRealmProxyInterface) object).realmGet$req_cf_id(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.status_idIndex, rowIndex, ((ReservationRealmProxyInterface) object).realmGet$status_id(), false);
        String realmGet$status = ((ReservationRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        }
        String realmGet$module = ((ReservationRealmProxyInterface) object).realmGet$module();
        if (realmGet$module != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.moduleIndex, rowIndex, realmGet$module, false);
        }
        String realmGet$cart = ((ReservationRealmProxyInterface) object).realmGet$cart();
        if (realmGet$cart != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cartIndex, rowIndex, realmGet$cart, false);
        }
        String realmGet$req_cf_data = ((ReservationRealmProxyInterface) object).realmGet$req_cf_data();
        if (realmGet$req_cf_data != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.req_cf_dataIndex, rowIndex, realmGet$req_cf_data, false);
        }
        String realmGet$updated_at = ((ReservationRealmProxyInterface) object).realmGet$updated_at();
        if (realmGet$updated_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
        }
        String realmGet$created_at = ((ReservationRealmProxyInterface) object).realmGet$created_at();
        if (realmGet$created_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
        }

        RealmList<com.droideve.apps.sugoi.booking.modals.Item> itemsList = ((ReservationRealmProxyInterface) object).realmGet$items();
        if (itemsList != null) {
            OsList itemsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.itemsIndex);
            for (com.droideve.apps.sugoi.booking.modals.Item itemsItem : itemsList) {
                Long cacheItemIndexitems = cache.get(itemsItem);
                if (cacheItemIndexitems == null) {
                    cacheItemIndexitems = ItemRealmProxy.insert(realm, itemsItem, cache);
                }
                itemsOsList.addRow(cacheItemIndexitems);
            }
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.amountIndex, rowIndex, ((ReservationRealmProxyInterface) object).realmGet$amount(), false);

        RealmList<com.droideve.apps.sugoi.booking.modals.Service> servicesList = ((ReservationRealmProxyInterface) object).realmGet$services();
        if (servicesList != null) {
            OsList servicesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.servicesIndex);
            for (com.droideve.apps.sugoi.booking.modals.Service servicesItem : servicesList) {
                Long cacheItemIndexservices = cache.get(servicesItem);
                if (cacheItemIndexservices == null) {
                    cacheItemIndexservices = ServiceRealmProxy.insert(realm, servicesItem, cache);
                }
                servicesOsList.addRow(cacheItemIndexservices);
            }
        }
        String realmGet$extras = ((ReservationRealmProxyInterface) object).realmGet$extras();
        if (realmGet$extras != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.extrasIndex, rowIndex, realmGet$extras, false);
        }
        String realmGet$payment_status_data = ((ReservationRealmProxyInterface) object).realmGet$payment_status_data();
        if (realmGet$payment_status_data != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.payment_status_dataIndex, rowIndex, realmGet$payment_status_data, false);
        }
        String realmGet$payment_status = ((ReservationRealmProxyInterface) object).realmGet$payment_status();
        if (realmGet$payment_status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.payment_statusIndex, rowIndex, realmGet$payment_status, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.droideve.apps.sugoi.booking.modals.Reservation.class);
        long tableNativePtr = table.getNativePtr();
        ReservationColumnInfo columnInfo = (ReservationColumnInfo) realm.getSchema().getColumnInfo(com.droideve.apps.sugoi.booking.modals.Reservation.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.droideve.apps.sugoi.booking.modals.Reservation object = null;
        while (objects.hasNext()) {
            object = (com.droideve.apps.sugoi.booking.modals.Reservation) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((ReservationRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ReservationRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((ReservationRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((ReservationRealmProxyInterface) object).realmGet$user_id(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.id_storeIndex, rowIndex, ((ReservationRealmProxyInterface) object).realmGet$id_store(), false);
            String realmGet$name = ((ReservationRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.req_cf_idIndex, rowIndex, ((ReservationRealmProxyInterface) object).realmGet$req_cf_id(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.status_idIndex, rowIndex, ((ReservationRealmProxyInterface) object).realmGet$status_id(), false);
            String realmGet$status = ((ReservationRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
            }
            String realmGet$module = ((ReservationRealmProxyInterface) object).realmGet$module();
            if (realmGet$module != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.moduleIndex, rowIndex, realmGet$module, false);
            }
            String realmGet$cart = ((ReservationRealmProxyInterface) object).realmGet$cart();
            if (realmGet$cart != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.cartIndex, rowIndex, realmGet$cart, false);
            }
            String realmGet$req_cf_data = ((ReservationRealmProxyInterface) object).realmGet$req_cf_data();
            if (realmGet$req_cf_data != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.req_cf_dataIndex, rowIndex, realmGet$req_cf_data, false);
            }
            String realmGet$updated_at = ((ReservationRealmProxyInterface) object).realmGet$updated_at();
            if (realmGet$updated_at != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
            }
            String realmGet$created_at = ((ReservationRealmProxyInterface) object).realmGet$created_at();
            if (realmGet$created_at != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
            }

            RealmList<com.droideve.apps.sugoi.booking.modals.Item> itemsList = ((ReservationRealmProxyInterface) object).realmGet$items();
            if (itemsList != null) {
                OsList itemsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.itemsIndex);
                for (com.droideve.apps.sugoi.booking.modals.Item itemsItem : itemsList) {
                    Long cacheItemIndexitems = cache.get(itemsItem);
                    if (cacheItemIndexitems == null) {
                        cacheItemIndexitems = ItemRealmProxy.insert(realm, itemsItem, cache);
                    }
                    itemsOsList.addRow(cacheItemIndexitems);
                }
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.amountIndex, rowIndex, ((ReservationRealmProxyInterface) object).realmGet$amount(), false);

            RealmList<com.droideve.apps.sugoi.booking.modals.Service> servicesList = ((ReservationRealmProxyInterface) object).realmGet$services();
            if (servicesList != null) {
                OsList servicesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.servicesIndex);
                for (com.droideve.apps.sugoi.booking.modals.Service servicesItem : servicesList) {
                    Long cacheItemIndexservices = cache.get(servicesItem);
                    if (cacheItemIndexservices == null) {
                        cacheItemIndexservices = ServiceRealmProxy.insert(realm, servicesItem, cache);
                    }
                    servicesOsList.addRow(cacheItemIndexservices);
                }
            }
            String realmGet$extras = ((ReservationRealmProxyInterface) object).realmGet$extras();
            if (realmGet$extras != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.extrasIndex, rowIndex, realmGet$extras, false);
            }
            String realmGet$payment_status_data = ((ReservationRealmProxyInterface) object).realmGet$payment_status_data();
            if (realmGet$payment_status_data != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.payment_status_dataIndex, rowIndex, realmGet$payment_status_data, false);
            }
            String realmGet$payment_status = ((ReservationRealmProxyInterface) object).realmGet$payment_status();
            if (realmGet$payment_status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.payment_statusIndex, rowIndex, realmGet$payment_status, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.droideve.apps.sugoi.booking.modals.Reservation object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.droideve.apps.sugoi.booking.modals.Reservation.class);
        long tableNativePtr = table.getNativePtr();
        ReservationColumnInfo columnInfo = (ReservationColumnInfo) realm.getSchema().getColumnInfo(com.droideve.apps.sugoi.booking.modals.Reservation.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((ReservationRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ReservationRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((ReservationRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((ReservationRealmProxyInterface) object).realmGet$user_id(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.id_storeIndex, rowIndex, ((ReservationRealmProxyInterface) object).realmGet$id_store(), false);
        String realmGet$name = ((ReservationRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.req_cf_idIndex, rowIndex, ((ReservationRealmProxyInterface) object).realmGet$req_cf_id(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.status_idIndex, rowIndex, ((ReservationRealmProxyInterface) object).realmGet$status_id(), false);
        String realmGet$status = ((ReservationRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
        }
        String realmGet$module = ((ReservationRealmProxyInterface) object).realmGet$module();
        if (realmGet$module != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.moduleIndex, rowIndex, realmGet$module, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.moduleIndex, rowIndex, false);
        }
        String realmGet$cart = ((ReservationRealmProxyInterface) object).realmGet$cart();
        if (realmGet$cart != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cartIndex, rowIndex, realmGet$cart, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cartIndex, rowIndex, false);
        }
        String realmGet$req_cf_data = ((ReservationRealmProxyInterface) object).realmGet$req_cf_data();
        if (realmGet$req_cf_data != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.req_cf_dataIndex, rowIndex, realmGet$req_cf_data, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.req_cf_dataIndex, rowIndex, false);
        }
        String realmGet$updated_at = ((ReservationRealmProxyInterface) object).realmGet$updated_at();
        if (realmGet$updated_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.updated_atIndex, rowIndex, false);
        }
        String realmGet$created_at = ((ReservationRealmProxyInterface) object).realmGet$created_at();
        if (realmGet$created_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.created_atIndex, rowIndex, false);
        }

        OsList itemsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.itemsIndex);
        RealmList<com.droideve.apps.sugoi.booking.modals.Item> itemsList = ((ReservationRealmProxyInterface) object).realmGet$items();
        if (itemsList != null && itemsList.size() == itemsOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = itemsList.size();
            for (int i = 0; i < objects; i++) {
                com.droideve.apps.sugoi.booking.modals.Item itemsItem = itemsList.get(i);
                Long cacheItemIndexitems = cache.get(itemsItem);
                if (cacheItemIndexitems == null) {
                    cacheItemIndexitems = ItemRealmProxy.insertOrUpdate(realm, itemsItem, cache);
                }
                itemsOsList.setRow(i, cacheItemIndexitems);
            }
        } else {
            itemsOsList.removeAll();
            if (itemsList != null) {
                for (com.droideve.apps.sugoi.booking.modals.Item itemsItem : itemsList) {
                    Long cacheItemIndexitems = cache.get(itemsItem);
                    if (cacheItemIndexitems == null) {
                        cacheItemIndexitems = ItemRealmProxy.insertOrUpdate(realm, itemsItem, cache);
                    }
                    itemsOsList.addRow(cacheItemIndexitems);
                }
            }
        }

        Table.nativeSetDouble(tableNativePtr, columnInfo.amountIndex, rowIndex, ((ReservationRealmProxyInterface) object).realmGet$amount(), false);

        OsList servicesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.servicesIndex);
        RealmList<com.droideve.apps.sugoi.booking.modals.Service> servicesList = ((ReservationRealmProxyInterface) object).realmGet$services();
        if (servicesList != null && servicesList.size() == servicesOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = servicesList.size();
            for (int i = 0; i < objects; i++) {
                com.droideve.apps.sugoi.booking.modals.Service servicesItem = servicesList.get(i);
                Long cacheItemIndexservices = cache.get(servicesItem);
                if (cacheItemIndexservices == null) {
                    cacheItemIndexservices = ServiceRealmProxy.insertOrUpdate(realm, servicesItem, cache);
                }
                servicesOsList.setRow(i, cacheItemIndexservices);
            }
        } else {
            servicesOsList.removeAll();
            if (servicesList != null) {
                for (com.droideve.apps.sugoi.booking.modals.Service servicesItem : servicesList) {
                    Long cacheItemIndexservices = cache.get(servicesItem);
                    if (cacheItemIndexservices == null) {
                        cacheItemIndexservices = ServiceRealmProxy.insertOrUpdate(realm, servicesItem, cache);
                    }
                    servicesOsList.addRow(cacheItemIndexservices);
                }
            }
        }

        String realmGet$extras = ((ReservationRealmProxyInterface) object).realmGet$extras();
        if (realmGet$extras != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.extrasIndex, rowIndex, realmGet$extras, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.extrasIndex, rowIndex, false);
        }
        String realmGet$payment_status_data = ((ReservationRealmProxyInterface) object).realmGet$payment_status_data();
        if (realmGet$payment_status_data != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.payment_status_dataIndex, rowIndex, realmGet$payment_status_data, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.payment_status_dataIndex, rowIndex, false);
        }
        String realmGet$payment_status = ((ReservationRealmProxyInterface) object).realmGet$payment_status();
        if (realmGet$payment_status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.payment_statusIndex, rowIndex, realmGet$payment_status, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.payment_statusIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.droideve.apps.sugoi.booking.modals.Reservation.class);
        long tableNativePtr = table.getNativePtr();
        ReservationColumnInfo columnInfo = (ReservationColumnInfo) realm.getSchema().getColumnInfo(com.droideve.apps.sugoi.booking.modals.Reservation.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.droideve.apps.sugoi.booking.modals.Reservation object = null;
        while (objects.hasNext()) {
            object = (com.droideve.apps.sugoi.booking.modals.Reservation) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((ReservationRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ReservationRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((ReservationRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((ReservationRealmProxyInterface) object).realmGet$user_id(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.id_storeIndex, rowIndex, ((ReservationRealmProxyInterface) object).realmGet$id_store(), false);
            String realmGet$name = ((ReservationRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.req_cf_idIndex, rowIndex, ((ReservationRealmProxyInterface) object).realmGet$req_cf_id(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.status_idIndex, rowIndex, ((ReservationRealmProxyInterface) object).realmGet$status_id(), false);
            String realmGet$status = ((ReservationRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
            }
            String realmGet$module = ((ReservationRealmProxyInterface) object).realmGet$module();
            if (realmGet$module != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.moduleIndex, rowIndex, realmGet$module, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.moduleIndex, rowIndex, false);
            }
            String realmGet$cart = ((ReservationRealmProxyInterface) object).realmGet$cart();
            if (realmGet$cart != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.cartIndex, rowIndex, realmGet$cart, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.cartIndex, rowIndex, false);
            }
            String realmGet$req_cf_data = ((ReservationRealmProxyInterface) object).realmGet$req_cf_data();
            if (realmGet$req_cf_data != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.req_cf_dataIndex, rowIndex, realmGet$req_cf_data, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.req_cf_dataIndex, rowIndex, false);
            }
            String realmGet$updated_at = ((ReservationRealmProxyInterface) object).realmGet$updated_at();
            if (realmGet$updated_at != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.updated_atIndex, rowIndex, false);
            }
            String realmGet$created_at = ((ReservationRealmProxyInterface) object).realmGet$created_at();
            if (realmGet$created_at != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.created_atIndex, rowIndex, false);
            }

            OsList itemsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.itemsIndex);
            RealmList<com.droideve.apps.sugoi.booking.modals.Item> itemsList = ((ReservationRealmProxyInterface) object).realmGet$items();
            if (itemsList != null && itemsList.size() == itemsOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = itemsList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.droideve.apps.sugoi.booking.modals.Item itemsItem = itemsList.get(i);
                    Long cacheItemIndexitems = cache.get(itemsItem);
                    if (cacheItemIndexitems == null) {
                        cacheItemIndexitems = ItemRealmProxy.insertOrUpdate(realm, itemsItem, cache);
                    }
                    itemsOsList.setRow(i, cacheItemIndexitems);
                }
            } else {
                itemsOsList.removeAll();
                if (itemsList != null) {
                    for (com.droideve.apps.sugoi.booking.modals.Item itemsItem : itemsList) {
                        Long cacheItemIndexitems = cache.get(itemsItem);
                        if (cacheItemIndexitems == null) {
                            cacheItemIndexitems = ItemRealmProxy.insertOrUpdate(realm, itemsItem, cache);
                        }
                        itemsOsList.addRow(cacheItemIndexitems);
                    }
                }
            }

            Table.nativeSetDouble(tableNativePtr, columnInfo.amountIndex, rowIndex, ((ReservationRealmProxyInterface) object).realmGet$amount(), false);

            OsList servicesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.servicesIndex);
            RealmList<com.droideve.apps.sugoi.booking.modals.Service> servicesList = ((ReservationRealmProxyInterface) object).realmGet$services();
            if (servicesList != null && servicesList.size() == servicesOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = servicesList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.droideve.apps.sugoi.booking.modals.Service servicesItem = servicesList.get(i);
                    Long cacheItemIndexservices = cache.get(servicesItem);
                    if (cacheItemIndexservices == null) {
                        cacheItemIndexservices = ServiceRealmProxy.insertOrUpdate(realm, servicesItem, cache);
                    }
                    servicesOsList.setRow(i, cacheItemIndexservices);
                }
            } else {
                servicesOsList.removeAll();
                if (servicesList != null) {
                    for (com.droideve.apps.sugoi.booking.modals.Service servicesItem : servicesList) {
                        Long cacheItemIndexservices = cache.get(servicesItem);
                        if (cacheItemIndexservices == null) {
                            cacheItemIndexservices = ServiceRealmProxy.insertOrUpdate(realm, servicesItem, cache);
                        }
                        servicesOsList.addRow(cacheItemIndexservices);
                    }
                }
            }

            String realmGet$extras = ((ReservationRealmProxyInterface) object).realmGet$extras();
            if (realmGet$extras != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.extrasIndex, rowIndex, realmGet$extras, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.extrasIndex, rowIndex, false);
            }
            String realmGet$payment_status_data = ((ReservationRealmProxyInterface) object).realmGet$payment_status_data();
            if (realmGet$payment_status_data != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.payment_status_dataIndex, rowIndex, realmGet$payment_status_data, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.payment_status_dataIndex, rowIndex, false);
            }
            String realmGet$payment_status = ((ReservationRealmProxyInterface) object).realmGet$payment_status();
            if (realmGet$payment_status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.payment_statusIndex, rowIndex, realmGet$payment_status, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.payment_statusIndex, rowIndex, false);
            }
        }
    }

    public static com.droideve.apps.sugoi.booking.modals.Reservation createDetachedCopy(com.droideve.apps.sugoi.booking.modals.Reservation realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.droideve.apps.sugoi.booking.modals.Reservation unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.droideve.apps.sugoi.booking.modals.Reservation();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.droideve.apps.sugoi.booking.modals.Reservation) cachedObject.object;
            }
            unmanagedObject = (com.droideve.apps.sugoi.booking.modals.Reservation) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        ReservationRealmProxyInterface unmanagedCopy = (ReservationRealmProxyInterface) unmanagedObject;
        ReservationRealmProxyInterface realmSource = (ReservationRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$user_id(realmSource.realmGet$user_id());
        unmanagedCopy.realmSet$id_store(realmSource.realmGet$id_store());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$req_cf_id(realmSource.realmGet$req_cf_id());
        unmanagedCopy.realmSet$status_id(realmSource.realmGet$status_id());
        unmanagedCopy.realmSet$status(realmSource.realmGet$status());
        unmanagedCopy.realmSet$module(realmSource.realmGet$module());
        unmanagedCopy.realmSet$cart(realmSource.realmGet$cart());
        unmanagedCopy.realmSet$req_cf_data(realmSource.realmGet$req_cf_data());
        unmanagedCopy.realmSet$updated_at(realmSource.realmGet$updated_at());
        unmanagedCopy.realmSet$created_at(realmSource.realmGet$created_at());

        // Deep copy of items
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$items(null);
        } else {
            RealmList<com.droideve.apps.sugoi.booking.modals.Item> manageditemsList = realmSource.realmGet$items();
            RealmList<com.droideve.apps.sugoi.booking.modals.Item> unmanageditemsList = new RealmList<com.droideve.apps.sugoi.booking.modals.Item>();
            unmanagedCopy.realmSet$items(unmanageditemsList);
            int nextDepth = currentDepth + 1;
            int size = manageditemsList.size();
            for (int i = 0; i < size; i++) {
                com.droideve.apps.sugoi.booking.modals.Item item = ItemRealmProxy.createDetachedCopy(manageditemsList.get(i), nextDepth, maxDepth, cache);
                unmanageditemsList.add(item);
            }
        }
        unmanagedCopy.realmSet$amount(realmSource.realmGet$amount());

        // Deep copy of services
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$services(null);
        } else {
            RealmList<com.droideve.apps.sugoi.booking.modals.Service> managedservicesList = realmSource.realmGet$services();
            RealmList<com.droideve.apps.sugoi.booking.modals.Service> unmanagedservicesList = new RealmList<com.droideve.apps.sugoi.booking.modals.Service>();
            unmanagedCopy.realmSet$services(unmanagedservicesList);
            int nextDepth = currentDepth + 1;
            int size = managedservicesList.size();
            for (int i = 0; i < size; i++) {
                com.droideve.apps.sugoi.booking.modals.Service item = ServiceRealmProxy.createDetachedCopy(managedservicesList.get(i), nextDepth, maxDepth, cache);
                unmanagedservicesList.add(item);
            }
        }
        unmanagedCopy.realmSet$extras(realmSource.realmGet$extras());
        unmanagedCopy.realmSet$payment_status_data(realmSource.realmGet$payment_status_data());
        unmanagedCopy.realmSet$payment_status(realmSource.realmGet$payment_status());

        return unmanagedObject;
    }

    static com.droideve.apps.sugoi.booking.modals.Reservation update(Realm realm, com.droideve.apps.sugoi.booking.modals.Reservation realmObject, com.droideve.apps.sugoi.booking.modals.Reservation newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ReservationRealmProxyInterface realmObjectTarget = (ReservationRealmProxyInterface) realmObject;
        ReservationRealmProxyInterface realmObjectSource = (ReservationRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$user_id(realmObjectSource.realmGet$user_id());
        realmObjectTarget.realmSet$id_store(realmObjectSource.realmGet$id_store());
        realmObjectTarget.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectTarget.realmSet$req_cf_id(realmObjectSource.realmGet$req_cf_id());
        realmObjectTarget.realmSet$status_id(realmObjectSource.realmGet$status_id());
        realmObjectTarget.realmSet$status(realmObjectSource.realmGet$status());
        realmObjectTarget.realmSet$module(realmObjectSource.realmGet$module());
        realmObjectTarget.realmSet$cart(realmObjectSource.realmGet$cart());
        realmObjectTarget.realmSet$req_cf_data(realmObjectSource.realmGet$req_cf_data());
        realmObjectTarget.realmSet$updated_at(realmObjectSource.realmGet$updated_at());
        realmObjectTarget.realmSet$created_at(realmObjectSource.realmGet$created_at());
        RealmList<com.droideve.apps.sugoi.booking.modals.Item> itemsList = realmObjectSource.realmGet$items();
        RealmList<com.droideve.apps.sugoi.booking.modals.Item> itemsRealmList = realmObjectTarget.realmGet$items();
        if (itemsList != null && itemsList.size() == itemsRealmList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = itemsList.size();
            for (int i = 0; i < objects; i++) {
                com.droideve.apps.sugoi.booking.modals.Item itemsItem = itemsList.get(i);
                com.droideve.apps.sugoi.booking.modals.Item cacheitems = (com.droideve.apps.sugoi.booking.modals.Item) cache.get(itemsItem);
                if (cacheitems != null) {
                    itemsRealmList.set(i, cacheitems);
                } else {
                    itemsRealmList.set(i, ItemRealmProxy.copyOrUpdate(realm, itemsItem, true, cache));
                }
            }
        } else {
            itemsRealmList.clear();
            if (itemsList != null) {
                for (int i = 0; i < itemsList.size(); i++) {
                    com.droideve.apps.sugoi.booking.modals.Item itemsItem = itemsList.get(i);
                    com.droideve.apps.sugoi.booking.modals.Item cacheitems = (com.droideve.apps.sugoi.booking.modals.Item) cache.get(itemsItem);
                    if (cacheitems != null) {
                        itemsRealmList.add(cacheitems);
                    } else {
                        itemsRealmList.add(ItemRealmProxy.copyOrUpdate(realm, itemsItem, true, cache));
                    }
                }
            }
        }
        realmObjectTarget.realmSet$amount(realmObjectSource.realmGet$amount());
        RealmList<com.droideve.apps.sugoi.booking.modals.Service> servicesList = realmObjectSource.realmGet$services();
        RealmList<com.droideve.apps.sugoi.booking.modals.Service> servicesRealmList = realmObjectTarget.realmGet$services();
        if (servicesList != null && servicesList.size() == servicesRealmList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = servicesList.size();
            for (int i = 0; i < objects; i++) {
                com.droideve.apps.sugoi.booking.modals.Service servicesItem = servicesList.get(i);
                com.droideve.apps.sugoi.booking.modals.Service cacheservices = (com.droideve.apps.sugoi.booking.modals.Service) cache.get(servicesItem);
                if (cacheservices != null) {
                    servicesRealmList.set(i, cacheservices);
                } else {
                    servicesRealmList.set(i, ServiceRealmProxy.copyOrUpdate(realm, servicesItem, true, cache));
                }
            }
        } else {
            servicesRealmList.clear();
            if (servicesList != null) {
                for (int i = 0; i < servicesList.size(); i++) {
                    com.droideve.apps.sugoi.booking.modals.Service servicesItem = servicesList.get(i);
                    com.droideve.apps.sugoi.booking.modals.Service cacheservices = (com.droideve.apps.sugoi.booking.modals.Service) cache.get(servicesItem);
                    if (cacheservices != null) {
                        servicesRealmList.add(cacheservices);
                    } else {
                        servicesRealmList.add(ServiceRealmProxy.copyOrUpdate(realm, servicesItem, true, cache));
                    }
                }
            }
        }
        realmObjectTarget.realmSet$extras(realmObjectSource.realmGet$extras());
        realmObjectTarget.realmSet$payment_status_data(realmObjectSource.realmGet$payment_status_data());
        realmObjectTarget.realmSet$payment_status(realmObjectSource.realmGet$payment_status());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Reservation = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{user_id:");
        stringBuilder.append(realmGet$user_id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id_store:");
        stringBuilder.append(realmGet$id_store());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{req_cf_id:");
        stringBuilder.append(realmGet$req_cf_id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status_id:");
        stringBuilder.append(realmGet$status_id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status() != null ? realmGet$status() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{module:");
        stringBuilder.append(realmGet$module() != null ? realmGet$module() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cart:");
        stringBuilder.append(realmGet$cart() != null ? realmGet$cart() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{req_cf_data:");
        stringBuilder.append(realmGet$req_cf_data() != null ? realmGet$req_cf_data() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{updated_at:");
        stringBuilder.append(realmGet$updated_at() != null ? realmGet$updated_at() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{created_at:");
        stringBuilder.append(realmGet$created_at() != null ? realmGet$created_at() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{items:");
        stringBuilder.append("RealmList<Item>[").append(realmGet$items().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{amount:");
        stringBuilder.append(realmGet$amount());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{services:");
        stringBuilder.append("RealmList<Service>[").append(realmGet$services().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{extras:");
        stringBuilder.append(realmGet$extras() != null ? realmGet$extras() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{payment_status_data:");
        stringBuilder.append(realmGet$payment_status_data() != null ? realmGet$payment_status_data() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{payment_status:");
        stringBuilder.append(realmGet$payment_status() != null ? realmGet$payment_status() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationRealmProxy aReservation = (ReservationRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aReservation.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aReservation.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aReservation.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
