package io.realm;


public interface PaymentGatewayRealmProxyInterface {
    public int realmGet$id();
    public void realmSet$id(int value);
    public String realmGet$payment();
    public void realmSet$payment(String value);
    public String realmGet$image();
    public void realmSet$image(String value);
    public String realmGet$description();
    public void realmSet$description(String value);
    public RealmList<com.droideve.apps.sugoi.booking.modals.Fee> realmGet$fees();
    public void realmSet$fees(RealmList<com.droideve.apps.sugoi.booking.modals.Fee> value);
}
