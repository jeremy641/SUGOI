package io.realm;


public interface ReservationRealmProxyInterface {
    public int realmGet$id();
    public void realmSet$id(int value);
    public int realmGet$user_id();
    public void realmSet$user_id(int value);
    public int realmGet$id_store();
    public void realmSet$id_store(int value);
    public String realmGet$name();
    public void realmSet$name(String value);
    public int realmGet$req_cf_id();
    public void realmSet$req_cf_id(int value);
    public int realmGet$status_id();
    public void realmSet$status_id(int value);
    public String realmGet$status();
    public void realmSet$status(String value);
    public String realmGet$module();
    public void realmSet$module(String value);
    public String realmGet$cart();
    public void realmSet$cart(String value);
    public String realmGet$req_cf_data();
    public void realmSet$req_cf_data(String value);
    public String realmGet$updated_at();
    public void realmSet$updated_at(String value);
    public String realmGet$created_at();
    public void realmSet$created_at(String value);
    public RealmList<com.droideve.apps.sugoi.booking.modals.Item> realmGet$items();
    public void realmSet$items(RealmList<com.droideve.apps.sugoi.booking.modals.Item> value);
    public double realmGet$amount();
    public void realmSet$amount(double value);
    public RealmList<com.droideve.apps.sugoi.booking.modals.Service> realmGet$services();
    public void realmSet$services(RealmList<com.droideve.apps.sugoi.booking.modals.Service> value);
    public String realmGet$extras();
    public void realmSet$extras(String value);
    public String realmGet$payment_status_data();
    public void realmSet$payment_status_data(String value);
    public String realmGet$payment_status();
    public void realmSet$payment_status(String value);
}
