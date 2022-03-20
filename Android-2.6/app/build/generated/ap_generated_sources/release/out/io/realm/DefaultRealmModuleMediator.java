package io.realm;


import android.util.JsonReader;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(33);
        modelClasses.add(com.droideve.apps.sugoi.classes.Banner.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.Store.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.User.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.Event.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.Currency.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.OfferContent.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.Category.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.Bookmark.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.Discussion.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.Guest.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.Review.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.Module.class);
        modelClasses.add(com.droideve.apps.sugoi.booking.modals.Option.class);
        modelClasses.add(com.droideve.apps.sugoi.booking.modals.Reservation.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.Offer.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.Inbox.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.Setting.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.CountriesModel.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.Message.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.SavedStores.class);
        modelClasses.add(com.droideve.apps.sugoi.booking.modals.Item.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.UpComingEvent.class);
        modelClasses.add(com.droideve.apps.sugoi.booking.modals.Service.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.OpeningTime.class);
        modelClasses.add(com.droideve.apps.sugoi.booking.modals.CF.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.Notification.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.WhichList.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.Images.class);
        modelClasses.add(com.droideve.apps.sugoi.booking.modals.Cart.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.Session.class);
        modelClasses.add(com.droideve.apps.sugoi.booking.modals.Fee.class);
        modelClasses.add(com.droideve.apps.sugoi.classes.EventNotification.class);
        modelClasses.add(com.droideve.apps.sugoi.booking.modals.PaymentGateway.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(33);
        infoMap.put(com.droideve.apps.sugoi.classes.Banner.class, io.realm.BannerRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.Store.class, io.realm.StoreRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.User.class, io.realm.UserRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.Event.class, io.realm.EventRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.Currency.class, io.realm.CurrencyRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.OfferContent.class, io.realm.OfferContentRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.Category.class, io.realm.CategoryRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.Bookmark.class, io.realm.BookmarkRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.Discussion.class, io.realm.DiscussionRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.Guest.class, io.realm.GuestRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.Review.class, io.realm.ReviewRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.Module.class, io.realm.ModuleRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.booking.modals.Option.class, io.realm.OptionRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.booking.modals.Reservation.class, io.realm.ReservationRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.Offer.class, io.realm.OfferRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.Inbox.class, io.realm.InboxRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.Setting.class, io.realm.SettingRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.CountriesModel.class, io.realm.CountriesModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.Message.class, io.realm.MessageRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.SavedStores.class, io.realm.SavedStoresRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.booking.modals.Item.class, io.realm.ItemRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.UpComingEvent.class, io.realm.UpComingEventRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.booking.modals.Service.class, io.realm.ServiceRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.OpeningTime.class, io.realm.OpeningTimeRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.booking.modals.CF.class, io.realm.CFRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.Notification.class, io.realm.NotificationRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.WhichList.class, io.realm.WhichListRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.Images.class, io.realm.ImagesRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.booking.modals.Cart.class, io.realm.CartRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.Session.class, io.realm.SessionRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.booking.modals.Fee.class, io.realm.FeeRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.classes.EventNotification.class, io.realm.EventNotificationRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.droideve.apps.sugoi.booking.modals.PaymentGateway.class, io.realm.PaymentGatewayRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(com.droideve.apps.sugoi.classes.Banner.class)) {
            return io.realm.BannerRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Store.class)) {
            return io.realm.StoreRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.User.class)) {
            return io.realm.UserRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Event.class)) {
            return io.realm.EventRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Currency.class)) {
            return io.realm.CurrencyRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.OfferContent.class)) {
            return io.realm.OfferContentRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Category.class)) {
            return io.realm.CategoryRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Bookmark.class)) {
            return io.realm.BookmarkRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Discussion.class)) {
            return io.realm.DiscussionRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Guest.class)) {
            return io.realm.GuestRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Review.class)) {
            return io.realm.ReviewRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Module.class)) {
            return io.realm.ModuleRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Option.class)) {
            return io.realm.OptionRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Reservation.class)) {
            return io.realm.ReservationRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Offer.class)) {
            return io.realm.OfferRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Inbox.class)) {
            return io.realm.InboxRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Setting.class)) {
            return io.realm.SettingRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.CountriesModel.class)) {
            return io.realm.CountriesModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Message.class)) {
            return io.realm.MessageRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.SavedStores.class)) {
            return io.realm.SavedStoresRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Item.class)) {
            return io.realm.ItemRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.UpComingEvent.class)) {
            return io.realm.UpComingEventRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Service.class)) {
            return io.realm.ServiceRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.OpeningTime.class)) {
            return io.realm.OpeningTimeRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.CF.class)) {
            return io.realm.CFRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Notification.class)) {
            return io.realm.NotificationRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.WhichList.class)) {
            return io.realm.WhichListRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Images.class)) {
            return io.realm.ImagesRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Cart.class)) {
            return io.realm.CartRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Session.class)) {
            return io.realm.SessionRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Fee.class)) {
            return io.realm.FeeRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.EventNotification.class)) {
            return io.realm.EventNotificationRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.PaymentGateway.class)) {
            return io.realm.PaymentGatewayRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.droideve.apps.sugoi.classes.Banner.class)) {
            return io.realm.BannerRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Store.class)) {
            return io.realm.StoreRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.User.class)) {
            return io.realm.UserRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Event.class)) {
            return io.realm.EventRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Currency.class)) {
            return io.realm.CurrencyRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.OfferContent.class)) {
            return io.realm.OfferContentRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Category.class)) {
            return io.realm.CategoryRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Bookmark.class)) {
            return io.realm.BookmarkRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Discussion.class)) {
            return io.realm.DiscussionRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Guest.class)) {
            return io.realm.GuestRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Review.class)) {
            return io.realm.ReviewRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Module.class)) {
            return io.realm.ModuleRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Option.class)) {
            return io.realm.OptionRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Reservation.class)) {
            return io.realm.ReservationRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Offer.class)) {
            return io.realm.OfferRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Inbox.class)) {
            return io.realm.InboxRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Setting.class)) {
            return io.realm.SettingRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.CountriesModel.class)) {
            return io.realm.CountriesModelRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Message.class)) {
            return io.realm.MessageRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.SavedStores.class)) {
            return io.realm.SavedStoresRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Item.class)) {
            return io.realm.ItemRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.UpComingEvent.class)) {
            return io.realm.UpComingEventRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Service.class)) {
            return io.realm.ServiceRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.OpeningTime.class)) {
            return io.realm.OpeningTimeRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.CF.class)) {
            return io.realm.CFRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Notification.class)) {
            return io.realm.NotificationRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.WhichList.class)) {
            return io.realm.WhichListRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Images.class)) {
            return io.realm.ImagesRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Cart.class)) {
            return io.realm.CartRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Session.class)) {
            return io.realm.SessionRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Fee.class)) {
            return io.realm.FeeRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.EventNotification.class)) {
            return io.realm.EventNotificationRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.PaymentGateway.class)) {
            return io.realm.PaymentGatewayRealmProxy.getFieldNames();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.droideve.apps.sugoi.classes.Banner.class)) {
            return io.realm.BannerRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Store.class)) {
            return io.realm.StoreRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.User.class)) {
            return io.realm.UserRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Event.class)) {
            return io.realm.EventRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Currency.class)) {
            return io.realm.CurrencyRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.OfferContent.class)) {
            return io.realm.OfferContentRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Category.class)) {
            return io.realm.CategoryRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Bookmark.class)) {
            return io.realm.BookmarkRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Discussion.class)) {
            return io.realm.DiscussionRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Guest.class)) {
            return io.realm.GuestRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Review.class)) {
            return io.realm.ReviewRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Module.class)) {
            return io.realm.ModuleRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Option.class)) {
            return io.realm.OptionRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Reservation.class)) {
            return io.realm.ReservationRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Offer.class)) {
            return io.realm.OfferRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Inbox.class)) {
            return io.realm.InboxRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Setting.class)) {
            return io.realm.SettingRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.CountriesModel.class)) {
            return io.realm.CountriesModelRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Message.class)) {
            return io.realm.MessageRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.SavedStores.class)) {
            return io.realm.SavedStoresRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Item.class)) {
            return io.realm.ItemRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.UpComingEvent.class)) {
            return io.realm.UpComingEventRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Service.class)) {
            return io.realm.ServiceRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.OpeningTime.class)) {
            return io.realm.OpeningTimeRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.CF.class)) {
            return io.realm.CFRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Notification.class)) {
            return io.realm.NotificationRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.WhichList.class)) {
            return io.realm.WhichListRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Images.class)) {
            return io.realm.ImagesRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Cart.class)) {
            return io.realm.CartRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Session.class)) {
            return io.realm.SessionRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Fee.class)) {
            return io.realm.FeeRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.EventNotification.class)) {
            return io.realm.EventNotificationRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.PaymentGateway.class)) {
            return io.realm.PaymentGatewayRealmProxy.getSimpleClassName();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.droideve.apps.sugoi.classes.Banner.class)) {
                return clazz.cast(new io.realm.BannerRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.Store.class)) {
                return clazz.cast(new io.realm.StoreRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.User.class)) {
                return clazz.cast(new io.realm.UserRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.Event.class)) {
                return clazz.cast(new io.realm.EventRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.Currency.class)) {
                return clazz.cast(new io.realm.CurrencyRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.OfferContent.class)) {
                return clazz.cast(new io.realm.OfferContentRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.Category.class)) {
                return clazz.cast(new io.realm.CategoryRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.Bookmark.class)) {
                return clazz.cast(new io.realm.BookmarkRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.Discussion.class)) {
                return clazz.cast(new io.realm.DiscussionRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.Guest.class)) {
                return clazz.cast(new io.realm.GuestRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.Review.class)) {
                return clazz.cast(new io.realm.ReviewRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.Module.class)) {
                return clazz.cast(new io.realm.ModuleRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Option.class)) {
                return clazz.cast(new io.realm.OptionRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Reservation.class)) {
                return clazz.cast(new io.realm.ReservationRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.Offer.class)) {
                return clazz.cast(new io.realm.OfferRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.Inbox.class)) {
                return clazz.cast(new io.realm.InboxRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.Setting.class)) {
                return clazz.cast(new io.realm.SettingRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.CountriesModel.class)) {
                return clazz.cast(new io.realm.CountriesModelRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.Message.class)) {
                return clazz.cast(new io.realm.MessageRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.SavedStores.class)) {
                return clazz.cast(new io.realm.SavedStoresRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Item.class)) {
                return clazz.cast(new io.realm.ItemRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.UpComingEvent.class)) {
                return clazz.cast(new io.realm.UpComingEventRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Service.class)) {
                return clazz.cast(new io.realm.ServiceRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.OpeningTime.class)) {
                return clazz.cast(new io.realm.OpeningTimeRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.booking.modals.CF.class)) {
                return clazz.cast(new io.realm.CFRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.Notification.class)) {
                return clazz.cast(new io.realm.NotificationRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.WhichList.class)) {
                return clazz.cast(new io.realm.WhichListRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.Images.class)) {
                return clazz.cast(new io.realm.ImagesRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Cart.class)) {
                return clazz.cast(new io.realm.CartRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.Session.class)) {
                return clazz.cast(new io.realm.SessionRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Fee.class)) {
                return clazz.cast(new io.realm.FeeRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.classes.EventNotification.class)) {
                return clazz.cast(new io.realm.EventNotificationRealmProxy());
            }
            if (clazz.equals(com.droideve.apps.sugoi.booking.modals.PaymentGateway.class)) {
                return clazz.cast(new io.realm.PaymentGatewayRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.droideve.apps.sugoi.classes.Banner.class)) {
            return clazz.cast(io.realm.BannerRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.Banner) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Store.class)) {
            return clazz.cast(io.realm.StoreRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.Store) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.User.class)) {
            return clazz.cast(io.realm.UserRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.User) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Event.class)) {
            return clazz.cast(io.realm.EventRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.Event) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Currency.class)) {
            return clazz.cast(io.realm.CurrencyRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.Currency) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.OfferContent.class)) {
            return clazz.cast(io.realm.OfferContentRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.OfferContent) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Category.class)) {
            return clazz.cast(io.realm.CategoryRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.Category) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Bookmark.class)) {
            return clazz.cast(io.realm.BookmarkRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.Bookmark) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Discussion.class)) {
            return clazz.cast(io.realm.DiscussionRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.Discussion) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Guest.class)) {
            return clazz.cast(io.realm.GuestRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.Guest) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Review.class)) {
            return clazz.cast(io.realm.ReviewRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.Review) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Module.class)) {
            return clazz.cast(io.realm.ModuleRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.Module) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Option.class)) {
            return clazz.cast(io.realm.OptionRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.Option) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Reservation.class)) {
            return clazz.cast(io.realm.ReservationRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.Reservation) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Offer.class)) {
            return clazz.cast(io.realm.OfferRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.Offer) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Inbox.class)) {
            return clazz.cast(io.realm.InboxRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.Inbox) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Setting.class)) {
            return clazz.cast(io.realm.SettingRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.Setting) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.CountriesModel.class)) {
            return clazz.cast(io.realm.CountriesModelRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.CountriesModel) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Message.class)) {
            return clazz.cast(io.realm.MessageRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.Message) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.SavedStores.class)) {
            return clazz.cast(io.realm.SavedStoresRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.SavedStores) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Item.class)) {
            return clazz.cast(io.realm.ItemRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.Item) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.UpComingEvent.class)) {
            return clazz.cast(io.realm.UpComingEventRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.UpComingEvent) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Service.class)) {
            return clazz.cast(io.realm.ServiceRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.Service) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.OpeningTime.class)) {
            return clazz.cast(io.realm.OpeningTimeRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.OpeningTime) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.CF.class)) {
            return clazz.cast(io.realm.CFRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.CF) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Notification.class)) {
            return clazz.cast(io.realm.NotificationRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.Notification) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.WhichList.class)) {
            return clazz.cast(io.realm.WhichListRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.WhichList) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Images.class)) {
            return clazz.cast(io.realm.ImagesRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.Images) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Cart.class)) {
            return clazz.cast(io.realm.CartRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.Cart) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Session.class)) {
            return clazz.cast(io.realm.SessionRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.Session) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Fee.class)) {
            return clazz.cast(io.realm.FeeRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.Fee) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.EventNotification.class)) {
            return clazz.cast(io.realm.EventNotificationRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.classes.EventNotification) obj, update, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.PaymentGateway.class)) {
            return clazz.cast(io.realm.PaymentGatewayRealmProxy.copyOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.PaymentGateway) obj, update, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.droideve.apps.sugoi.classes.Banner.class)) {
            io.realm.BannerRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Banner) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Store.class)) {
            io.realm.StoreRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Store) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.User.class)) {
            io.realm.UserRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.User) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Event.class)) {
            io.realm.EventRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Event) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Currency.class)) {
            io.realm.CurrencyRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Currency) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.OfferContent.class)) {
            io.realm.OfferContentRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.OfferContent) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Category.class)) {
            io.realm.CategoryRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Category) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Bookmark.class)) {
            io.realm.BookmarkRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Bookmark) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Discussion.class)) {
            io.realm.DiscussionRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Discussion) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Guest.class)) {
            io.realm.GuestRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Guest) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Review.class)) {
            io.realm.ReviewRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Review) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Module.class)) {
            io.realm.ModuleRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Module) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Option.class)) {
            io.realm.OptionRealmProxy.insert(realm, (com.droideve.apps.sugoi.booking.modals.Option) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Reservation.class)) {
            io.realm.ReservationRealmProxy.insert(realm, (com.droideve.apps.sugoi.booking.modals.Reservation) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Offer.class)) {
            io.realm.OfferRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Offer) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Inbox.class)) {
            io.realm.InboxRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Inbox) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Setting.class)) {
            io.realm.SettingRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Setting) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.CountriesModel.class)) {
            io.realm.CountriesModelRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.CountriesModel) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Message.class)) {
            io.realm.MessageRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Message) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.SavedStores.class)) {
            io.realm.SavedStoresRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.SavedStores) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Item.class)) {
            io.realm.ItemRealmProxy.insert(realm, (com.droideve.apps.sugoi.booking.modals.Item) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.UpComingEvent.class)) {
            io.realm.UpComingEventRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.UpComingEvent) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Service.class)) {
            io.realm.ServiceRealmProxy.insert(realm, (com.droideve.apps.sugoi.booking.modals.Service) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.OpeningTime.class)) {
            io.realm.OpeningTimeRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.OpeningTime) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.CF.class)) {
            io.realm.CFRealmProxy.insert(realm, (com.droideve.apps.sugoi.booking.modals.CF) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Notification.class)) {
            io.realm.NotificationRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Notification) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.WhichList.class)) {
            io.realm.WhichListRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.WhichList) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Images.class)) {
            io.realm.ImagesRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Images) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Cart.class)) {
            io.realm.CartRealmProxy.insert(realm, (com.droideve.apps.sugoi.booking.modals.Cart) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Session.class)) {
            io.realm.SessionRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Session) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Fee.class)) {
            io.realm.FeeRealmProxy.insert(realm, (com.droideve.apps.sugoi.booking.modals.Fee) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.EventNotification.class)) {
            io.realm.EventNotificationRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.EventNotification) object, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.PaymentGateway.class)) {
            io.realm.PaymentGatewayRealmProxy.insert(realm, (com.droideve.apps.sugoi.booking.modals.PaymentGateway) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.droideve.apps.sugoi.classes.Banner.class)) {
                io.realm.BannerRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Banner) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Store.class)) {
                io.realm.StoreRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Store) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.User.class)) {
                io.realm.UserRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.User) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Event.class)) {
                io.realm.EventRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Event) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Currency.class)) {
                io.realm.CurrencyRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Currency) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.OfferContent.class)) {
                io.realm.OfferContentRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.OfferContent) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Category.class)) {
                io.realm.CategoryRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Category) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Bookmark.class)) {
                io.realm.BookmarkRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Bookmark) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Discussion.class)) {
                io.realm.DiscussionRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Discussion) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Guest.class)) {
                io.realm.GuestRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Guest) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Review.class)) {
                io.realm.ReviewRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Review) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Module.class)) {
                io.realm.ModuleRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Module) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Option.class)) {
                io.realm.OptionRealmProxy.insert(realm, (com.droideve.apps.sugoi.booking.modals.Option) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Reservation.class)) {
                io.realm.ReservationRealmProxy.insert(realm, (com.droideve.apps.sugoi.booking.modals.Reservation) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Offer.class)) {
                io.realm.OfferRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Offer) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Inbox.class)) {
                io.realm.InboxRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Inbox) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Setting.class)) {
                io.realm.SettingRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Setting) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.CountriesModel.class)) {
                io.realm.CountriesModelRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.CountriesModel) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Message.class)) {
                io.realm.MessageRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Message) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.SavedStores.class)) {
                io.realm.SavedStoresRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.SavedStores) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Item.class)) {
                io.realm.ItemRealmProxy.insert(realm, (com.droideve.apps.sugoi.booking.modals.Item) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.UpComingEvent.class)) {
                io.realm.UpComingEventRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.UpComingEvent) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Service.class)) {
                io.realm.ServiceRealmProxy.insert(realm, (com.droideve.apps.sugoi.booking.modals.Service) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.OpeningTime.class)) {
                io.realm.OpeningTimeRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.OpeningTime) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.CF.class)) {
                io.realm.CFRealmProxy.insert(realm, (com.droideve.apps.sugoi.booking.modals.CF) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Notification.class)) {
                io.realm.NotificationRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Notification) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.WhichList.class)) {
                io.realm.WhichListRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.WhichList) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Images.class)) {
                io.realm.ImagesRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Images) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Cart.class)) {
                io.realm.CartRealmProxy.insert(realm, (com.droideve.apps.sugoi.booking.modals.Cart) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Session.class)) {
                io.realm.SessionRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.Session) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Fee.class)) {
                io.realm.FeeRealmProxy.insert(realm, (com.droideve.apps.sugoi.booking.modals.Fee) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.EventNotification.class)) {
                io.realm.EventNotificationRealmProxy.insert(realm, (com.droideve.apps.sugoi.classes.EventNotification) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.PaymentGateway.class)) {
                io.realm.PaymentGatewayRealmProxy.insert(realm, (com.droideve.apps.sugoi.booking.modals.PaymentGateway) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.droideve.apps.sugoi.classes.Banner.class)) {
                    io.realm.BannerRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Store.class)) {
                    io.realm.StoreRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.User.class)) {
                    io.realm.UserRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Event.class)) {
                    io.realm.EventRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Currency.class)) {
                    io.realm.CurrencyRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.OfferContent.class)) {
                    io.realm.OfferContentRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Category.class)) {
                    io.realm.CategoryRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Bookmark.class)) {
                    io.realm.BookmarkRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Discussion.class)) {
                    io.realm.DiscussionRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Guest.class)) {
                    io.realm.GuestRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Review.class)) {
                    io.realm.ReviewRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Module.class)) {
                    io.realm.ModuleRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Option.class)) {
                    io.realm.OptionRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Reservation.class)) {
                    io.realm.ReservationRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Offer.class)) {
                    io.realm.OfferRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Inbox.class)) {
                    io.realm.InboxRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Setting.class)) {
                    io.realm.SettingRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.CountriesModel.class)) {
                    io.realm.CountriesModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Message.class)) {
                    io.realm.MessageRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.SavedStores.class)) {
                    io.realm.SavedStoresRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Item.class)) {
                    io.realm.ItemRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.UpComingEvent.class)) {
                    io.realm.UpComingEventRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Service.class)) {
                    io.realm.ServiceRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.OpeningTime.class)) {
                    io.realm.OpeningTimeRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.CF.class)) {
                    io.realm.CFRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Notification.class)) {
                    io.realm.NotificationRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.WhichList.class)) {
                    io.realm.WhichListRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Images.class)) {
                    io.realm.ImagesRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Cart.class)) {
                    io.realm.CartRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Session.class)) {
                    io.realm.SessionRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Fee.class)) {
                    io.realm.FeeRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.EventNotification.class)) {
                    io.realm.EventNotificationRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.PaymentGateway.class)) {
                    io.realm.PaymentGatewayRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.droideve.apps.sugoi.classes.Banner.class)) {
            io.realm.BannerRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Banner) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Store.class)) {
            io.realm.StoreRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Store) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.User.class)) {
            io.realm.UserRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.User) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Event.class)) {
            io.realm.EventRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Event) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Currency.class)) {
            io.realm.CurrencyRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Currency) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.OfferContent.class)) {
            io.realm.OfferContentRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.OfferContent) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Category.class)) {
            io.realm.CategoryRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Category) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Bookmark.class)) {
            io.realm.BookmarkRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Bookmark) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Discussion.class)) {
            io.realm.DiscussionRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Discussion) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Guest.class)) {
            io.realm.GuestRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Guest) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Review.class)) {
            io.realm.ReviewRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Review) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Module.class)) {
            io.realm.ModuleRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Module) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Option.class)) {
            io.realm.OptionRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.Option) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Reservation.class)) {
            io.realm.ReservationRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.Reservation) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Offer.class)) {
            io.realm.OfferRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Offer) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Inbox.class)) {
            io.realm.InboxRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Inbox) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Setting.class)) {
            io.realm.SettingRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Setting) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.CountriesModel.class)) {
            io.realm.CountriesModelRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.CountriesModel) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Message.class)) {
            io.realm.MessageRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Message) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.SavedStores.class)) {
            io.realm.SavedStoresRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.SavedStores) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Item.class)) {
            io.realm.ItemRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.Item) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.UpComingEvent.class)) {
            io.realm.UpComingEventRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.UpComingEvent) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Service.class)) {
            io.realm.ServiceRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.Service) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.OpeningTime.class)) {
            io.realm.OpeningTimeRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.OpeningTime) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.CF.class)) {
            io.realm.CFRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.CF) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Notification.class)) {
            io.realm.NotificationRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Notification) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.WhichList.class)) {
            io.realm.WhichListRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.WhichList) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Images.class)) {
            io.realm.ImagesRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Images) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Cart.class)) {
            io.realm.CartRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.Cart) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.Session.class)) {
            io.realm.SessionRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Session) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Fee.class)) {
            io.realm.FeeRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.Fee) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.classes.EventNotification.class)) {
            io.realm.EventNotificationRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.EventNotification) obj, cache);
        } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.PaymentGateway.class)) {
            io.realm.PaymentGatewayRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.PaymentGateway) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.droideve.apps.sugoi.classes.Banner.class)) {
                io.realm.BannerRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Banner) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Store.class)) {
                io.realm.StoreRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Store) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.User.class)) {
                io.realm.UserRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.User) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Event.class)) {
                io.realm.EventRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Event) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Currency.class)) {
                io.realm.CurrencyRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Currency) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.OfferContent.class)) {
                io.realm.OfferContentRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.OfferContent) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Category.class)) {
                io.realm.CategoryRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Category) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Bookmark.class)) {
                io.realm.BookmarkRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Bookmark) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Discussion.class)) {
                io.realm.DiscussionRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Discussion) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Guest.class)) {
                io.realm.GuestRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Guest) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Review.class)) {
                io.realm.ReviewRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Review) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Module.class)) {
                io.realm.ModuleRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Module) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Option.class)) {
                io.realm.OptionRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.Option) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Reservation.class)) {
                io.realm.ReservationRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.Reservation) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Offer.class)) {
                io.realm.OfferRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Offer) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Inbox.class)) {
                io.realm.InboxRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Inbox) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Setting.class)) {
                io.realm.SettingRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Setting) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.CountriesModel.class)) {
                io.realm.CountriesModelRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.CountriesModel) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Message.class)) {
                io.realm.MessageRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Message) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.SavedStores.class)) {
                io.realm.SavedStoresRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.SavedStores) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Item.class)) {
                io.realm.ItemRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.Item) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.UpComingEvent.class)) {
                io.realm.UpComingEventRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.UpComingEvent) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Service.class)) {
                io.realm.ServiceRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.Service) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.OpeningTime.class)) {
                io.realm.OpeningTimeRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.OpeningTime) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.CF.class)) {
                io.realm.CFRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.CF) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Notification.class)) {
                io.realm.NotificationRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Notification) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.WhichList.class)) {
                io.realm.WhichListRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.WhichList) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Images.class)) {
                io.realm.ImagesRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Images) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Cart.class)) {
                io.realm.CartRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.Cart) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.Session.class)) {
                io.realm.SessionRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.Session) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Fee.class)) {
                io.realm.FeeRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.Fee) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.classes.EventNotification.class)) {
                io.realm.EventNotificationRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.classes.EventNotification) object, cache);
            } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.PaymentGateway.class)) {
                io.realm.PaymentGatewayRealmProxy.insertOrUpdate(realm, (com.droideve.apps.sugoi.booking.modals.PaymentGateway) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.droideve.apps.sugoi.classes.Banner.class)) {
                    io.realm.BannerRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Store.class)) {
                    io.realm.StoreRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.User.class)) {
                    io.realm.UserRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Event.class)) {
                    io.realm.EventRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Currency.class)) {
                    io.realm.CurrencyRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.OfferContent.class)) {
                    io.realm.OfferContentRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Category.class)) {
                    io.realm.CategoryRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Bookmark.class)) {
                    io.realm.BookmarkRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Discussion.class)) {
                    io.realm.DiscussionRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Guest.class)) {
                    io.realm.GuestRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Review.class)) {
                    io.realm.ReviewRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Module.class)) {
                    io.realm.ModuleRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Option.class)) {
                    io.realm.OptionRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Reservation.class)) {
                    io.realm.ReservationRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Offer.class)) {
                    io.realm.OfferRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Inbox.class)) {
                    io.realm.InboxRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Setting.class)) {
                    io.realm.SettingRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.CountriesModel.class)) {
                    io.realm.CountriesModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Message.class)) {
                    io.realm.MessageRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.SavedStores.class)) {
                    io.realm.SavedStoresRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Item.class)) {
                    io.realm.ItemRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.UpComingEvent.class)) {
                    io.realm.UpComingEventRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Service.class)) {
                    io.realm.ServiceRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.OpeningTime.class)) {
                    io.realm.OpeningTimeRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.CF.class)) {
                    io.realm.CFRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Notification.class)) {
                    io.realm.NotificationRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.WhichList.class)) {
                    io.realm.WhichListRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Images.class)) {
                    io.realm.ImagesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Cart.class)) {
                    io.realm.CartRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.Session.class)) {
                    io.realm.SessionRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Fee.class)) {
                    io.realm.FeeRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.classes.EventNotification.class)) {
                    io.realm.EventNotificationRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.droideve.apps.sugoi.booking.modals.PaymentGateway.class)) {
                    io.realm.PaymentGatewayRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.droideve.apps.sugoi.classes.Banner.class)) {
            return clazz.cast(io.realm.BannerRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Store.class)) {
            return clazz.cast(io.realm.StoreRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.User.class)) {
            return clazz.cast(io.realm.UserRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Event.class)) {
            return clazz.cast(io.realm.EventRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Currency.class)) {
            return clazz.cast(io.realm.CurrencyRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.OfferContent.class)) {
            return clazz.cast(io.realm.OfferContentRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Category.class)) {
            return clazz.cast(io.realm.CategoryRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Bookmark.class)) {
            return clazz.cast(io.realm.BookmarkRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Discussion.class)) {
            return clazz.cast(io.realm.DiscussionRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Guest.class)) {
            return clazz.cast(io.realm.GuestRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Review.class)) {
            return clazz.cast(io.realm.ReviewRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Module.class)) {
            return clazz.cast(io.realm.ModuleRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Option.class)) {
            return clazz.cast(io.realm.OptionRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Reservation.class)) {
            return clazz.cast(io.realm.ReservationRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Offer.class)) {
            return clazz.cast(io.realm.OfferRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Inbox.class)) {
            return clazz.cast(io.realm.InboxRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Setting.class)) {
            return clazz.cast(io.realm.SettingRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.CountriesModel.class)) {
            return clazz.cast(io.realm.CountriesModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Message.class)) {
            return clazz.cast(io.realm.MessageRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.SavedStores.class)) {
            return clazz.cast(io.realm.SavedStoresRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Item.class)) {
            return clazz.cast(io.realm.ItemRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.UpComingEvent.class)) {
            return clazz.cast(io.realm.UpComingEventRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Service.class)) {
            return clazz.cast(io.realm.ServiceRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.OpeningTime.class)) {
            return clazz.cast(io.realm.OpeningTimeRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.CF.class)) {
            return clazz.cast(io.realm.CFRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Notification.class)) {
            return clazz.cast(io.realm.NotificationRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.WhichList.class)) {
            return clazz.cast(io.realm.WhichListRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Images.class)) {
            return clazz.cast(io.realm.ImagesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Cart.class)) {
            return clazz.cast(io.realm.CartRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Session.class)) {
            return clazz.cast(io.realm.SessionRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Fee.class)) {
            return clazz.cast(io.realm.FeeRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.EventNotification.class)) {
            return clazz.cast(io.realm.EventNotificationRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.PaymentGateway.class)) {
            return clazz.cast(io.realm.PaymentGatewayRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.droideve.apps.sugoi.classes.Banner.class)) {
            return clazz.cast(io.realm.BannerRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Store.class)) {
            return clazz.cast(io.realm.StoreRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.User.class)) {
            return clazz.cast(io.realm.UserRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Event.class)) {
            return clazz.cast(io.realm.EventRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Currency.class)) {
            return clazz.cast(io.realm.CurrencyRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.OfferContent.class)) {
            return clazz.cast(io.realm.OfferContentRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Category.class)) {
            return clazz.cast(io.realm.CategoryRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Bookmark.class)) {
            return clazz.cast(io.realm.BookmarkRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Discussion.class)) {
            return clazz.cast(io.realm.DiscussionRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Guest.class)) {
            return clazz.cast(io.realm.GuestRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Review.class)) {
            return clazz.cast(io.realm.ReviewRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Module.class)) {
            return clazz.cast(io.realm.ModuleRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Option.class)) {
            return clazz.cast(io.realm.OptionRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Reservation.class)) {
            return clazz.cast(io.realm.ReservationRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Offer.class)) {
            return clazz.cast(io.realm.OfferRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Inbox.class)) {
            return clazz.cast(io.realm.InboxRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Setting.class)) {
            return clazz.cast(io.realm.SettingRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.CountriesModel.class)) {
            return clazz.cast(io.realm.CountriesModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Message.class)) {
            return clazz.cast(io.realm.MessageRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.SavedStores.class)) {
            return clazz.cast(io.realm.SavedStoresRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Item.class)) {
            return clazz.cast(io.realm.ItemRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.UpComingEvent.class)) {
            return clazz.cast(io.realm.UpComingEventRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Service.class)) {
            return clazz.cast(io.realm.ServiceRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.OpeningTime.class)) {
            return clazz.cast(io.realm.OpeningTimeRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.CF.class)) {
            return clazz.cast(io.realm.CFRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Notification.class)) {
            return clazz.cast(io.realm.NotificationRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.WhichList.class)) {
            return clazz.cast(io.realm.WhichListRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Images.class)) {
            return clazz.cast(io.realm.ImagesRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Cart.class)) {
            return clazz.cast(io.realm.CartRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Session.class)) {
            return clazz.cast(io.realm.SessionRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Fee.class)) {
            return clazz.cast(io.realm.FeeRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.EventNotification.class)) {
            return clazz.cast(io.realm.EventNotificationRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.PaymentGateway.class)) {
            return clazz.cast(io.realm.PaymentGatewayRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.droideve.apps.sugoi.classes.Banner.class)) {
            return clazz.cast(io.realm.BannerRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.Banner) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Store.class)) {
            return clazz.cast(io.realm.StoreRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.Store) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.User.class)) {
            return clazz.cast(io.realm.UserRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.User) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Event.class)) {
            return clazz.cast(io.realm.EventRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.Event) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Currency.class)) {
            return clazz.cast(io.realm.CurrencyRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.Currency) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.OfferContent.class)) {
            return clazz.cast(io.realm.OfferContentRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.OfferContent) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Category.class)) {
            return clazz.cast(io.realm.CategoryRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.Category) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Bookmark.class)) {
            return clazz.cast(io.realm.BookmarkRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.Bookmark) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Discussion.class)) {
            return clazz.cast(io.realm.DiscussionRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.Discussion) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Guest.class)) {
            return clazz.cast(io.realm.GuestRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.Guest) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Review.class)) {
            return clazz.cast(io.realm.ReviewRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.Review) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Module.class)) {
            return clazz.cast(io.realm.ModuleRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.Module) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Option.class)) {
            return clazz.cast(io.realm.OptionRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.booking.modals.Option) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Reservation.class)) {
            return clazz.cast(io.realm.ReservationRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.booking.modals.Reservation) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Offer.class)) {
            return clazz.cast(io.realm.OfferRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.Offer) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Inbox.class)) {
            return clazz.cast(io.realm.InboxRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.Inbox) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Setting.class)) {
            return clazz.cast(io.realm.SettingRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.Setting) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.CountriesModel.class)) {
            return clazz.cast(io.realm.CountriesModelRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.CountriesModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Message.class)) {
            return clazz.cast(io.realm.MessageRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.Message) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.SavedStores.class)) {
            return clazz.cast(io.realm.SavedStoresRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.SavedStores) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Item.class)) {
            return clazz.cast(io.realm.ItemRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.booking.modals.Item) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.UpComingEvent.class)) {
            return clazz.cast(io.realm.UpComingEventRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.UpComingEvent) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Service.class)) {
            return clazz.cast(io.realm.ServiceRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.booking.modals.Service) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.OpeningTime.class)) {
            return clazz.cast(io.realm.OpeningTimeRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.OpeningTime) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.CF.class)) {
            return clazz.cast(io.realm.CFRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.booking.modals.CF) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Notification.class)) {
            return clazz.cast(io.realm.NotificationRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.Notification) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.WhichList.class)) {
            return clazz.cast(io.realm.WhichListRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.WhichList) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Images.class)) {
            return clazz.cast(io.realm.ImagesRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.Images) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Cart.class)) {
            return clazz.cast(io.realm.CartRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.booking.modals.Cart) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.Session.class)) {
            return clazz.cast(io.realm.SessionRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.Session) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.Fee.class)) {
            return clazz.cast(io.realm.FeeRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.booking.modals.Fee) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.classes.EventNotification.class)) {
            return clazz.cast(io.realm.EventNotificationRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.classes.EventNotification) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.droideve.apps.sugoi.booking.modals.PaymentGateway.class)) {
            return clazz.cast(io.realm.PaymentGatewayRealmProxy.createDetachedCopy((com.droideve.apps.sugoi.booking.modals.PaymentGateway) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
