package io.realm;


public interface ItemRealmProxyInterface {
    public String realmGet$id();
    public void realmSet$id(String value);
    public String realmGet$name();
    public void realmSet$name(String value);
    public String realmGet$image();
    public void realmSet$image(String value);
    public String realmGet$module();
    public void realmSet$module(String value);
    public int realmGet$qty();
    public void realmSet$qty(int value);
    public double realmGet$amount();
    public void realmSet$amount(double value);
    public String realmGet$service();
    public void realmSet$service(String value);
    public String realmGet$options();
    public void realmSet$options(String value);
    public com.droideve.apps.sugoi.classes.Currency realmGet$currency();
    public void realmSet$currency(com.droideve.apps.sugoi.classes.Currency value);
}
