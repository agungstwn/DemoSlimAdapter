package com.agung.android.demoslimadapter.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by agung on 27/03/18.
 */


@Getter
@AllArgsConstructor
public class ImageRequest {
    private int res;

    public ImageRequest(int res) {
        this.res = res;
    }
}
