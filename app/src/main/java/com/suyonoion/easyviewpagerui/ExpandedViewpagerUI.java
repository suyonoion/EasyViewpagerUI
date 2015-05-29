package com.suyonoion.easyviewpagerui;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suyono on 5/26/2015.
 * Copyright (c) 2015 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */
public class ExpandedViewpagerUI extends ViewPager {
    private PagerTitleStrip Tempat_Judul;
    private List<String> Mengisi_Tempat_judul;
    private ImageButton homepage;
    public int setResource(String name, String Type)
    {
        return getContext().getResources().getIdentifier(name, Type, getContext().getPackageName());
    }

    public ExpandedViewpagerUI (Context context, AttributeSet attrs) {
        super(context, attrs);

        Tempat_Judul = (PagerTitleStrip) findViewById(setResource("id_judul","id"));
        Mengisi_Tempat_judul = new ArrayList<String>();
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_1","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_2","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_3","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_4","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_5","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_6","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_7","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_8","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_9","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_10","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_11","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_12","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_13","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_14","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_15","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_16","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_17","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_18","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_19","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_20","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_21","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_22","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_23","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_24","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_25","string")));


        AdapterExpandedViewpagerUI adapter = new AdapterExpandedViewpagerUI(Mengisi_Tempat_judul);
        final ViewPager EasyExpandedViewPagerUI = (ViewPager) this.findViewById(setResource("id_viewpager","id"));
        EasyExpandedViewPagerUI.setPageTransformer(true, new CubeOutTransformer());
        EasyExpandedViewPagerUI.setAdapter(adapter);
        EasyExpandedViewPagerUI.setOffscreenPageLimit(25);
        EasyExpandedViewPagerUI.setBackgroundResource(setResource("background","drawable"));
    }

    public class AdapterExpandedViewpagerUI extends PagerAdapter {
        private List<String> adapterMengisi_Tempat_judul;
        public AdapterExpandedViewpagerUI(List<String> adapterMengisi_Tempat_judul) {
            this.adapterMengisi_Tempat_judul = adapterMengisi_Tempat_judul;
        }
        @Override
        public int getCount () {
            return 25;
        }

        @Override
        public Object instantiateItem (ViewGroup container,int position){
            int tampilkanMenurutId = 0;
            switch (position) {
                case 0:
                    tampilkanMenurutId = setResource("id_halaman_1","id");

                    break;
                case 1:
                    tampilkanMenurutId = setResource("id_halaman_2","id");
                    break;
                case 2:
                    tampilkanMenurutId = setResource("id_halaman_3","id");
                    break;
                case 3:
                    tampilkanMenurutId = setResource("id_halaman_4","id");
                    break;
                case 4:
                    tampilkanMenurutId = setResource("id_halaman_5","id");
                    break;
                case 5:
                    tampilkanMenurutId = setResource("id_halaman_6","id");
                    break;
                case 6:
                    tampilkanMenurutId = setResource("id_halaman_7","id");
                    break;
                case 7:
                    tampilkanMenurutId = setResource("id_halaman_8","id");
                    break;
                case 8:
                    tampilkanMenurutId = setResource("id_halaman_9","id");
                    break;
                case 9:
                    tampilkanMenurutId = setResource("id_halaman_10","id");
                    break;
                case 10:
                    tampilkanMenurutId = setResource("id_halaman_11","id");
                    break;
                case 11:
                    tampilkanMenurutId = setResource("id_halaman_12","id");
                    break;
                case 12:
                    tampilkanMenurutId = setResource("id_halaman_13","id");
                    break;
                case 13:
                    tampilkanMenurutId = setResource("id_halaman_14","id");
                    break;
                case 14:
                    tampilkanMenurutId = setResource("id_halaman_15","id");
                    break;
                case 15:
                    tampilkanMenurutId = setResource("id_halaman_16","id");
                    break;
                case 16:
                    tampilkanMenurutId = setResource("id_halaman_17","id");
                    break;
                case 17:
                    tampilkanMenurutId = setResource("id_halaman_18","id");
                    break;
                case 18:
                    tampilkanMenurutId = setResource("id_halaman_19","id");
                    break;
                case 19:
                    tampilkanMenurutId = setResource("id_halaman_20","id");
                    break;
                case 20:
                    tampilkanMenurutId = setResource("id_halaman_21","id");
                    break;
                case 21:
                    tampilkanMenurutId = setResource("id_halaman_22","id");
                    break;
                case 22:
                    tampilkanMenurutId = setResource("id_halaman_23","id");
                    break;
                case 23:
                    tampilkanMenurutId = setResource("id_halaman_24","id");
                    break;
                case 24:
                    tampilkanMenurutId = setResource("id_halaman_25","id");
                    break;
            }

            return findViewById(tampilkanMenurutId);

        }

        @Override
        public CharSequence getPageTitle ( int position){
            return adapterMengisi_Tempat_judul.get(position);
        }

        @Override
        public boolean isViewFromObject (View arg0, Object arg1){
            return arg0 ==  arg1;
        }

        @Override
        public Parcelable saveState () {
            return null;
        }
    }
}
