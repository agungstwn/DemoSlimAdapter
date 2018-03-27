package com.agung.android.demoslimadapter.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by agung on 27/03/18.
 */

@Getter
@AllArgsConstructor
public class MusicRequest {
    private String name;
    private int coverRes;

    public MusicRequest(String name, int coverRes) {
        this.name = name;
        this.coverRes = coverRes;
    }
}
