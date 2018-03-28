package com.agung.android.demoslimadapter.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by agung on 27/03/18.
 */

public class SectionHeaderRequest {
    private String title;

    public SectionHeaderRequest(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
