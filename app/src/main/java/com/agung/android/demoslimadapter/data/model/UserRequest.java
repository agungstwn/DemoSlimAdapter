package com.agung.android.demoslimadapter.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by agung on 27/03/18.
 */

@Getter
@AllArgsConstructor
public class UserRequest {
    private String name;
    private int age;
    private int avatarRes;
    private String phone;

    public UserRequest(String name, int age, int avatarRes, String phone) {
        this.name = name;
        this.age = age;
        this.avatarRes = avatarRes;
        this.phone = phone;
    }
}
