package com.droideve.apps.sugoi.booking.modals;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Option extends RealmObject {

    @PrimaryKey
    private int id;
    private int store_id;
    private String label;
    private String description;
    private Double value;
    private int parent_id;
    private int _order;
    private String option_type;
    private String updated_at;
    private String created_at;
    private String parsed_value;
    private int hidden;
    private String parsed_quantity;
    private String parsed_time;
    private String timePost_Start;
    private String timePost_End;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int get_order() {
        return _order;
    }

    public void set_order(int _order) {
        this._order = _order;
    }

    public String getOption_type() {
        return option_type;
    }

    public void setOption_type(String option_type) {
        this.option_type = option_type;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getParsed_value() {
        return parsed_value;
    }

    public void setParsed_value(String parsed_value) {
        this.parsed_value = parsed_value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getHidden() {
        return hidden;
    }

    public void setHidden(int hidden) {
        this.hidden = hidden;
    }

    public String getParsed_quantity() {
        return parsed_quantity;
    }

    public void setParsed_quantity(String parsed_quantity) { this.parsed_quantity = parsed_quantity; }

    public String getParsed_time() {
        return parsed_time;
    }

    public void setParsed_time(String parsed_time) { this.parsed_time = parsed_time; }

    public String gettimePost_Start() {
        return timePost_Start;
    }

    public void settimePost_Start(String timePost_Start) { this.timePost_Start = timePost_Start; }

    public String gettimePost_End() {
        return timePost_End;
    }

    public void settimePost_End(String timePost_End) { this.timePost_End = timePost_End; }
}
