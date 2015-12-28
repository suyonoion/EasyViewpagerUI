package com.suyonoion.easyviewpagerui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suyono on 12/29/2015
 * Copyright (c) 2015 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */

@SuppressWarnings("ALL")
public class ExpandedViewpagerUI extends ViewPager {
    public int setResource(String name, String Type)
    {
        return getContext().getResources().getIdentifier(name, Type, getContext().getPackageName());
    }

    public static int Jumlah_Page = 3;
    int sdk = android.os.Build.VERSION.SDK_INT;

    public ExpandedViewpagerUI (Context context, AttributeSet attrs) {
        super(context, attrs);

        List<String> mengisi_Tempat_judul = new ArrayList<>();
        final List<String> kodestringsxml_str = new ArrayList<>();
        final List<String> kodeutama_str = new ArrayList<>();

        for (int i=1;i<=Jumlah_Page;i++){
            try {
                mengisi_Tempat_judul.add(getResources().getString(setResource("judul_halaman_"+i, "string")));
            }

            catch (Throwable e){

                if (Jumlah_Page>25){
                    mengisi_Tempat_judul.add("Judul "+i+" belum ditambahkan di strings.xml");
                    AlertDialog.Builder b = new AlertDialog.Builder(getContext());
                    final String st = "<LinearLayout android:background=\"@drawable/a3\" android:id=\"@+id/id_halaman_4\" android:layout_width=\"match_parent\" android:layout_height=\"match_parent\" android:orientation=\"vertical\" android:gravity=\"center\">\n" +
                            "<TextView android:textSize=\"70sp\" android:layout_gravity=\"center\" android:layout_width=\"wrap_content\" android:layout_height=\"wrap_content\" android:text=\"3\" android:textColor=\"#ff473eff\"/>\n" +
                            "</LinearLayout>";

                    b.setMessage("Berbahaya Jumlah_Page terlalu banyak lebih dari 25 pages, penambahan kode utama tidak akan ditampilkan...!! Dan" +
                            "Kodeutama->strings.xml->smali belum sinkron (tidak sama). Mengedit 0x3 saja tidak cukup, anda juga perlu mengedit kodeutama dan strings.xml, agar sama. \n \n" +
                            "Jika anda telah mengubah/mengedit/menambah/menghapus Jumlah_Page = 3 (0x3) menjadi Jumlah_Page = " + Jumlah_Page + ", kodeutama, dan strings.xml maka, \n \n Tolong cek dan edit kembali kode utama di expanded anda dan strings.xml di value , sesuaikan dengan jumlah page yaitu " + Jumlah_Page + " dalam smali. dan tambahkan ini sejumlah pages yang anda mau :\n \n" +
                            st+"\n\n"+
                            "sesuaikan dengan id_halaman");
                    b.setCancelable(true);
                    b.setNeutralButton("Copy to Clipboard", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                                android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                                clipboard.setText(st);
                                Toast.makeText(getContext(), "Text Telah Ter-Copy ke Clipboard", Toast.LENGTH_SHORT).show();
                            } else {
                                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                                android.content.ClipData clip = android.content.ClipData.newPlainText("Clip", st);
                                Toast.makeText(getContext(), "Text Telah Ter-Copy ke Clipboard", Toast.LENGTH_SHORT).show();
                                clipboard.setPrimaryClip(clip);
                            }
                            dialog.dismiss();
                        }
                    });
                    b.setTitle("Pesan Saya...!!!");
                    AlertDialog ad = b.create();
                    ad.show();
                } else {
                    mengisi_Tempat_judul.add("Judul "+i+" belum ditambahkan di strings.xml");
                    AlertDialog.Builder b = new AlertDialog.Builder(getContext());
                    kodeutama_str.add(
                            "<LinearLayout android:background=\"@drawable/a3\" android:id=\"@+id/id_halaman_"+i+"\" android:layout_width=\"match_parent\" android:layout_height=\"match_parent\" android:orientation=\"vertical\" android:gravity=\"center\">\n" +
                                    " <TextView android:textSize=\"70sp\" android:layout_gravity=\"center\" android:layout_width=\"wrap_content\" android:layout_height=\"wrap_content\" android:text=\""+i+"\" android:textColor=\"#ff473eff\"/>\n" +
                                    "</LinearLayout> \n \n");

                    b.setMessage("Kodeutama->strings.xml->smali belum sinkron (tidak sama). Mengedit 0x3 saja tidak cukup, anda juga perlu mengedit kodeutama dan strings.xml, agar sama. \n \n" +
                            "Jika anda telah mengubah/mengedit/menambah/menghapus Jumlah_Page = 3 (0x3) menjadi Jumlah_Page = " + Jumlah_Page + ", kodeutama, dan strings.xml maka, \n \n Tolong cek dan edit kembali kode utama di expanded anda dan strings.xml di value , sesuaikan dengan jumlah page yaitu " + Jumlah_Page + " dalam smali atau perhatikan kode utama dibawah ini silahkan dicontek dan tambahkan ke expanded:\n \n" + kodeutama_str+"\n \n" +
                            "Copy to Clipboard dan oh iyah Hapus koma(,) kurung buka dan tutup [ ] yah :)");
                    b.setCancelable(true);
                    b.setNeutralButton("Copy to Clipboard", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                                android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                                clipboard.setText(kodeutama_str.toString());
                                Toast.makeText(getContext(), "Text Telah Ter-Copy ke Clipboard", Toast.LENGTH_SHORT).show();
                            } else {
                                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                                android.content.ClipData clip = android.content.ClipData.newPlainText("Clip", kodeutama_str.toString());
                                Toast.makeText(getContext(), "Text Telah Ter-Copy ke Clipboard", Toast.LENGTH_SHORT).show();
                                clipboard.setPrimaryClip(clip);
                            }
                            dialog.dismiss();
                        }
                    });
                    b.setTitle("Pesan Saya...!!!");
                    AlertDialog ad = b.create();
                    ad.show();
                }

            }
        }

        AdapterExpandedViewpagerUI adapter = new AdapterExpandedViewpagerUI(mengisi_Tempat_judul);
        final ViewPager EasyExpandedViewPagerUI = (ViewPager) this.findViewById(setResource("id_viewpager","id"));
        EasyExpandedViewPagerUI.setPageTransformer(true, new CubeOutTransformer());
        EasyExpandedViewPagerUI.setAdapter(adapter);
        EasyExpandedViewPagerUI.setOffscreenPageLimit(Jumlah_Page);
        if (EasyExpandedViewPagerUI.getWidth()>0){
            Bitmap image = JadikanBlur.blur(EasyExpandedViewPagerUI);
            EasyExpandedViewPagerUI.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), image));
        } else {
            EasyExpandedViewPagerUI.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    Bitmap image = JadikanBlur.blur(EasyExpandedViewPagerUI);
                    EasyExpandedViewPagerUI.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), image));
                }
            });
        }

        adapter.notifyDataSetChanged();
    }

    public class AdapterExpandedViewpagerUI extends PagerAdapter {
        private List<String> adapterMengisi_Tempat_judul;
        public AdapterExpandedViewpagerUI(List<String> adapterMengisi_Tempat_judul) {
            this.adapterMengisi_Tempat_judul = adapterMengisi_Tempat_judul;
        }
        @Override
        public int getCount () {
            return adapterMengisi_Tempat_judul.size();
        }

        @Override
        public Object instantiateItem (ViewGroup container,int position){
            int tampilkanMenurutId = 0;
            try {
                for (int i = 0; i <= Jumlah_Page; i++) {
                    if (position == i) {
                        int x = i + 1;
                        tampilkanMenurutId = setResource("id_halaman_" + x, "id");
                    }
                }
            } catch (Throwable e){
                e.getMessage();
            }
            final View blurPage = findViewById(tampilkanMenurutId);

            if (blurPage.getWidth()>0){
                Bitmap image = JadikanBlur.blur(blurPage);
                blurPage.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), image));
            } else {
                blurPage.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        Bitmap image = JadikanBlur.blur(blurPage);
                        blurPage.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), image));
                    }
                });
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
