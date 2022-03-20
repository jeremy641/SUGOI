package io.realm;


public interface ServiceRealmProxyInterface {
    public int realmGet$group_id();
    public void realmSet$group_id(int value);
    public String realmGet$group_label();
    public void realmSet$group_label(String value);
    public String realmGet$type();
    public void realmSet$type(String value);
    public RealmList<com.droideve.apps.sugoi.booking.modals.Option> realmGet$options();
    public void realmSet$options(RealmList<com.droideve.apps.sugoi.booking.modals.Option> value);
    public com.droideve.apps.sugoi.classes.Currency realmGet$currency();
    public void realmSet$currency(com.droideve.apps.sugoi.classes.Currency value);
}
