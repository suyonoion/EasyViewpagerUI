package com.suyonoion.easyviewpagerui;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suyono on 5/26/2015.
 * Copyright (c) 2015 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */
public class ViewPagerBonus extends LinearLayout {
    private List<View> tampildaftarHalaman;
    private ViewPager viewpager;
    private View Satu;
    private View Dua;
    private View Tiga;
    private View Empat;

    private TextView judul;

    private ImageButton fotoImg0;
    private ImageButton fotoImg1;
    private ImageButton fotoImg2;
    private ImageButton fotoImg3;

    private PopupWindow pesan;
    private ImageView ion;
    private Button tutup;

    public int setResource(String name, String Type)
    {
        return getContext().getResources().getIdentifier(name, Type, getContext().getPackageName());
    }

    public ViewPagerBonus(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root = inflater.inflate(setResource("vp_bonus","layout"), this, true);
        TampilViewPager();
        ion = (ImageView) root.findViewById(setResource("author","id"));
        ion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                LayoutInflater inflater=(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View popup;
                popup = inflater.inflate(setResource("author","layout"), null, true);
                pesan = new PopupWindow(popup,450,600,true);
                pesan.setBackgroundDrawable(getContext().getResources().getDrawable(setResource("popup_window","drawable")));
                pesan.showAsDropDown(ion);
                pesan.showAtLocation(ion, Gravity.CENTER,0,0);
                tutup = (Button) popup.findViewById(setResource("menutup","id"));
                tutup.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pesan.dismiss();
                    }
                });
            }
        });


    }

    private void TampilViewPager()
    {
        LayoutInflater inflaterr = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View roott = inflaterr.inflate(setResource("vp_bonus","layout"), this, true);
        viewpager = (ViewPager) roott.findViewById(setResource("view_pager_bonus","id"));
        HalamanAdapter localHalamanAdapter = new HalamanAdapter();
        LayoutInflater localLayoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Satu = localLayoutInflater.inflate(getContext().getResources().getLayout(setResource("halaman_bonus_1","layout")), null, true);
        Dua = localLayoutInflater.inflate(getContext().getResources().getLayout(setResource("halaman_bonus_2","layout")), null, true);
        Tiga = localLayoutInflater.inflate(getContext().getResources().getLayout(setResource("halaman_bonus_3","layout")), null, true);
        Empat = localLayoutInflater.inflate(getContext().getResources().getLayout(setResource("halaman_bonus_4","layout")), null, true);



        tampildaftarHalaman = new ArrayList<View>();
        tampildaftarHalaman.add(Satu);
        tampildaftarHalaman.add(Dua);
        tampildaftarHalaman.add(Tiga);
        tampildaftarHalaman.add(Empat);

        viewpager.setAdapter(localHalamanAdapter);
        viewpager.setPageTransformer(true, new CubeOutTransformer());

        fotoImg0 = (ImageButton) findViewById(setResource("vppublic_img0","id"));
        fotoImg1 = (ImageButton) findViewById(setResource("vppublic_img1","id"));
        fotoImg2 = (ImageButton) findViewById(setResource("vppublic_img2","id"));
        fotoImg3 = (ImageButton) findViewById(setResource("vppublic_img3","id"));

        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()

        {
            public void onPageScrollStateChanged(int paramAnonymousInt)
            {
            }

            public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
            {
            }

            public void onPageSelected(int paramAnonymousInt)
            {   judul = (TextView) findViewById(setResource("judul","id"));
                setImg();
                switch (paramAnonymousInt)
                {
                    case 0:
                        fotoImg0.setImageResource(setResource("number_1_icon","drawable"));
                        judul.setText(setResource("judul_bonus1","string"));
                        break;
                    case 1:
                        fotoImg1.setImageResource(setResource("number_2_icon","drawable"));
                        judul.setText(setResource("judul_bonus2","string"));
                        break;
                    case 2:
                        fotoImg2.setImageResource(setResource("number_3_icon","drawable"));
                        judul.setText(setResource("judul_bonus3","string"));
                        break;
                    case 3:
                        fotoImg3.setImageResource(setResource("number_4_icon","drawable"));
                        judul.setText(setResource("judul_bonus4","string"));
                        break;

                }
            }



        });
        viewpager.setCurrentItem(0);
        viewpager.setBackgroundResource(setResource("background","drawable"));
    }

    private void setImg() {
        fotoImg0.setImageResource(setResource("number_1_icon_deselected","drawable"));
        fotoImg1.setImageResource(setResource("number_2_icon_deselected","drawable"));
        fotoImg2.setImageResource(setResource("number_3_icon_deselected","drawable"));
        fotoImg3.setImageResource(setResource("number_4_icon_deselected","drawable"));
       }


    private class HalamanAdapter extends PagerAdapter
    {
        private HalamanAdapter()
        {
        }

        public void destroyItem(View paramView, int paramInt, Object paramObject)
        {
            ((ViewPager) paramView).removeView(tampildaftarHalaman.get(paramInt));
        }

        public void finishUpdate(View paramView)
        {
        }

        public int getCount()
        {
            return tampildaftarHalaman.size();
        }


        public Object instantiateItem(View paramView, int paramInt)
        {
            ((ViewPager) paramView).addView(tampildaftarHalaman.get(paramInt));
            return tampildaftarHalaman.get(paramInt);
        }

        public boolean isViewFromObject(View paramView, Object paramObject)
        {
            return paramView == paramObject;
        }

        public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
        {
        }

        public Parcelable saveState()
        {
            return null;
        }

        public void startUpdate(View paramView)
        {
        }
    }


}

