package com.example.mirucasey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;


import com.example.mirucasey.adapter.BannerAnimePagerAdapter;
import com.example.mirucasey.adapter.MainRecyclerAdapter;
import com.example.mirucasey.model.AllGenres;
import com.example.mirucasey.model.GenreItem;
import com.example.mirucasey.model.HeaderAnimes;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    BannerAnimePagerAdapter bannerAnimePagerAdapter;
    TabLayout indicatorTab, screenTab;
    ViewPager bannerAnimeViewPager;
    Timer slideTimer;
    List<HeaderAnimes> headerAnimesList;
    List<HeaderAnimes> awardWinningAnimesList;
    List<HeaderAnimes> dramaAnimesList;
    List<HeaderAnimes> actionAnimesList;
    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecycler;
    List<AllGenres> allGenresList;
    //ViewPager_2 headerAnimeViewPager;
    //NestedScrollView scrollView;
    //AppBarLayout appBarLayout;
    //Handler handler;
    //Runnable runnable;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchViewItem = menu.findItem(R.id.app_bar_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
             /*   if(list.contains(query)){
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(MainActivity.this, "No Match found",Toast.LENGTH_LONG).show();
                }*/
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        indicatorTab = findViewById(R.id.tab_indicator);
        screenTab = findViewById(R.id.tabLayoutTop);


        headerAnimesList = new ArrayList<>();
        headerAnimesList.add(new HeaderAnimes(1, "Naruto", "https://cdn.myanimelist.net/images/anime/1493/116732.jpg", "" ));
        headerAnimesList.add(new HeaderAnimes(2, "One Piece", "https://cdn.myanimelist.net/images/anime/1939/97699.jpg", "" ));


        awardWinningAnimesList = new ArrayList<>();
        awardWinningAnimesList.add(new HeaderAnimes(1, "Naruto", "https://cdn.myanimelist.net/images/anime/1493/116732.jpg", "" ));
        awardWinningAnimesList.add(new HeaderAnimes(2, "One Piece", "https://cdn.myanimelist.net/images/anime/1939/97699.jpg", "" ));

        dramaAnimesList = new ArrayList<>();
        dramaAnimesList.add(new HeaderAnimes(1, "Naruto", "https://cdn.myanimelist.net/images/anime/1493/116732.jpg", "" ));
        dramaAnimesList.add(new HeaderAnimes(2, "One Piece", "https://cdn.myanimelist.net/images/anime/1939/97699.jpg", "" ));

        actionAnimesList = new ArrayList<>();
        actionAnimesList.add(new HeaderAnimes(1, "Naruto", "https://cdn.myanimelist.net/images/anime/1493/116732.jpg", "" ));
        actionAnimesList.add(new HeaderAnimes(2, "One Piece", "https://cdn.myanimelist.net/images/anime/1939/97699.jpg", "" ));

        setBannerAnimePagerAdapter(headerAnimesList);

        screenTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 1:
                        setBannerAnimePagerAdapter(awardWinningAnimesList);
                        return;

                    case 2:
                        setBannerAnimePagerAdapter(dramaAnimesList);
                        return;

                    case 3:
                        setBannerAnimePagerAdapter(actionAnimesList);
                        return;

                    default:
                        setBannerAnimePagerAdapter(headerAnimesList);

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        List<GenreItem> mainCategoryList = new ArrayList<>();

        mainCategoryList.add(new GenreItem(1, "Naruto", "https://m.media-amazon.com/images/S/pv-target-images/45fa87b65b1f9f0e66a23111f778ba198710f3520fc8f9ecde24885b3eca5218._UR1920,1080_UX400_UY225_.jpg", ""));
        mainCategoryList.add(new GenreItem(2, "Beyblade Burst", "https://m.media-amazon.com/images/S/pv-target-images/c02450f675aef50667e49705d74483e68dea0deb74333ed644b794edd45214eb._UR1920,1080_UX400_UY225_.jpg", ""));
        mainCategoryList.add(new GenreItem(3, "Sonic the Hedgehog", "https://m.media-amazon.com/images/S/pv-target-images/84a52ecdf1cf6843d14e4d3b64b4ea0a89ea7111ef8efab4d8eabe16106fba59._UR1920,1080_UX400_UY225_.jpg", ""));

        allGenresList = new ArrayList<>();
        allGenresList.add(new AllGenres(1, "Award Winning", mainCategoryList));
        allGenresList.add(new AllGenres(2, "Action", mainCategoryList));
        allGenresList.add(new AllGenres(3, "Drama", mainCategoryList));

        setMainRecycler(allGenresList);
        
    }

    private void setBannerAnimePagerAdapter(List<HeaderAnimes> headerAnimesList){
        bannerAnimePagerAdapter = new BannerAnimePagerAdapter(this, headerAnimesList);
        bannerAnimeViewPager = findViewById(R.id.banner_viewPager);
        bannerAnimeViewPager.setAdapter(bannerAnimePagerAdapter);
        indicatorTab.setupWithViewPager(bannerAnimeViewPager);

        Timer slideTimer = new Timer();
        slideTimer.scheduleAtFixedRate(new AutoSlider(), 4000, 6000);
        indicatorTab.setupWithViewPager(bannerAnimeViewPager, true);
    }

    class AutoSlider extends TimerTask{

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (bannerAnimeViewPager.getCurrentItem() < headerAnimesList.size() - 1) {
                        bannerAnimeViewPager.setCurrentItem(bannerAnimeViewPager.getCurrentItem() + 1);
                    } else {
                        bannerAnimeViewPager.setCurrentItem(0);
                    }
                }
            });
        }

    }

    public void setMainRecycler(List<AllGenres> allGenresList){
        mainRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mainRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this, allGenresList);
        mainRecycler.setAdapter(mainRecyclerAdapter);
    }

    public void setGenreRecycler(List<AllGenres> allGenresList){
        mainRecycler = findViewById(R.id.item_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mainRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this, allGenresList);
        mainRecycler.setAdapter(mainRecyclerAdapter);
    }



}