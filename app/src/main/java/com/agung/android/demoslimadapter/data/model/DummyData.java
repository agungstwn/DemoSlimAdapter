package com.agung.android.demoslimadapter.data.model;

import com.agung.android.demoslimadapter.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agung on 27/03/18.
 */

public class DummyData {

    private DummyData() {
    }

    public static List<Object> getDataDummy(){
        List<Object> dummiesData = new ArrayList<>();
        dummiesData.add(new SectionHeaderRequest("My Friends"));
        dummiesData.add(new UserRequest("Sakuragi", 23, R.drawable.icon1, "12345678910"));
        dummiesData.add(new UserRequest("Rukawa", 22, R.drawable.icon2, "11234567891"));

        dummiesData.add(new SectionHeaderRequest("My Images"));
        dummiesData.add(new ImageRequest(R.drawable.cover1));
        dummiesData.add(new ImageRequest(R.drawable.cover2));
        dummiesData.add(new ImageRequest(R.drawable.cover3));
        dummiesData.add(new ImageRequest(R.drawable.cover4));
        dummiesData.add(new ImageRequest(R.drawable.cover5));
        dummiesData.add(new ImageRequest(R.drawable.cover6));
        dummiesData.add(new ImageRequest(R.drawable.cover7));
        dummiesData.add(new ImageRequest(R.drawable.cover8));
        dummiesData.add(new ImageRequest(R.drawable.cover9));
        dummiesData.add(new ImageRequest(R.drawable.cover10));
        dummiesData.add(new ImageRequest(R.drawable.cover11));

        dummiesData.add(new SectionHeaderRequest("My Music"));
        dummiesData.add(new MusicRequest("I want to shout my love", R.drawable.icon3));
        dummiesData.add(new MusicRequest("Do a dunk shot", R.drawable.icon4));
        dummiesData.add(new MusicRequest("Come on", R.drawable.icon5));

        return dummiesData;
    }

    public static List<Object> getOtherDummiesData(){
        List<Object> dummiesOther = new ArrayList<>();
        dummiesOther.addAll(getDataDummy());
        dummiesOther.remove(1);
        dummiesOther.remove(5);
        dummiesOther.remove(6);

        return dummiesOther;
    }
}
