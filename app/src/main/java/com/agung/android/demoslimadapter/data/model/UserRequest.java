package com.agung.android.demoslimadapter.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by agung on 27/03/18.
 */

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

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getAvatarRes() {
        return avatarRes;
    }

    public String getPhone() {
        return phone;
    }
}
