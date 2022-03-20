package io.realm;


public interface CartRealmProxyInterface {
    public int realmGet$id();
    public void realmSet$id(int value);
    public String realmGet$module();
    public void realmSet$module(String value);
    public int realmGet$module_id();
    public void realmSet$module_id(int value);
    public double realmGet$amount();
    public void realmSet$amount(double value);
    public RealmList<com.droideve.apps.sugoi.booking.modals.Service> realmGet$selectedService();
    public void realmSet$selectedService(RealmList<com.droideve.apps.sugoi.booking.modals.Service> value);
    public com.droideve.apps.sugoi.classes.Offer realmGet$offer();
    public void realmSet$offer(com.droideve.apps.sugoi.classes.Offer value);
    public RealmList<com.droideve.apps.sugoi.booking.modals.Service> realmGet$services();
    public void realmSet$services(RealmList<com.droideve.apps.sugoi.booking.modals.Service> value);
    public int realmGet$qte();
    public void realmSet$qte(int value);
    public int realmGet$status();
    public void realmSet$status(int value);
    public int realmGet$user_id();
    public void realmSet$user_id(int value);
    public int realmGet$parent_id();
    public void realmSet$parent_id(int value);
}
