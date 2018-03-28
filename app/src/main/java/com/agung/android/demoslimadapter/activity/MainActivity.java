package com.agung.android.demoslimadapter.activity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.agung.android.demoslimadapter.R;
import com.agung.android.demoslimadapter.data.model.DummyData;
import com.agung.android.demoslimadapter.data.model.ImageRequest;
import com.agung.android.demoslimadapter.data.model.MusicRequest;
import com.agung.android.demoslimadapter.data.model.SectionHeaderRequest;
import com.agung.android.demoslimadapter.data.model.UserRequest;
import com.bumptech.glide.Glide;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.ex.loadmore.SimpleLoadMoreViewCreator;
import net.idik.lib.slimadapter.ex.loadmore.SlimMoreLoader;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private List<Object> dummies = DummyData.getDataDummy();
    private List<Object> otherDummies = DummyData.getOtherDummiesData();
    private List<Object> currentData;

    private SlimAdapter slimAdapter;

    private Random random = new Random(System.currentTimeMillis());
    private int loadTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        currentData = new ArrayList<>(dummies);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return slimAdapter.getItem(position) instanceof Image ? 1 : 3;
            }
        });

        mRecyclerView.setLayoutManager(gridLayoutManager);

        slimAdapter = SlimAdapter.create()
                .register(R.layout.item_user, new SlimInjector<UserRequest>() {
                    @Override
                    public void onInject(UserRequest data, IViewInjector injector) {
                        injector.text(R.id.tv_name, data.getName())
                                .image(R.id.iv_avatar, data.getAvatarRes())
                                .text(R.id.tv_phone, data.getPhone())
                                .textColor(R.id.tv_phone, Color.RED)
                                .textSize(R.id.tv_phone, 12);
                    }
                })
                .register(R.layout.item_section_header, new SlimInjector<SectionHeaderRequest>() {
                    @Override
                    public void onInject(SectionHeaderRequest data, IViewInjector injector) {
                        injector.text(R.id.tv_section_title, data.getTitle());
                    }
                })
                .register(R.layout.item_image, new SlimInjector<ImageRequest>() {
                    @Override
                    public void onInject(ImageRequest data, IViewInjector injector) {
                        injector.with(R.id.imageView, new IViewInjector.Action<ImageView>() {

                            @Override
                            public void action(ImageView view) {
                                Glide.with(MainActivity.this).load(data.getRes()).into(view);
                            }
                        });
                    }
                })
                .register(R.layout.item_music, new SlimInjector<MusicRequest>() {
                    @Override
                    public void onInject(MusicRequest data, IViewInjector injector) {
                        injector.text(R.id.tv_name, data.getName())
                                .image(R.id.iv_cover, data.getCoverRes());
                    }
                })
                .enableDiff()
                .enableLoadMore(new SlimMoreLoader(this, new SimpleLoadMoreViewCreator(
                        this).setNoMoreHint("No " + "More Data").setErrorHint("Error")) {
                    @Override
                    protected void onLoadMore(Handler handler) {
                        SystemClock.sleep(3_000);
                        if (random.nextInt(10) > 7) handler.error();
                        else {
                            handler.loadCompleted(otherDummies);
                            loadTime++;
                        }
                    }

                    @Override
                    protected boolean hasMore() {
                        return loadTime < 5;
                    }
                }).attachTo(mRecyclerView);

        slimAdapter.updateData(currentData);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_change_data:
                loadTime = 0;
                currentData = currentData == dummies ? new ArrayList<>(otherDummies)
                        : new ArrayList<>(dummies);
                slimAdapter.updateData(currentData);
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }
}
