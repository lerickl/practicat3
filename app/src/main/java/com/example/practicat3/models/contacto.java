package com.example.practicat3.models;

public class contacto {
    public int id;
    public String names;
    public String phone;

    public String getNames() {
        return names;
    }


    public String getPhone() {
        return phone;
    }
    public contacto(String names, String phone) {
        this.names = names;
        this.phone = phone;
    }

}
