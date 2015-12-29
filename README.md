#EasyViewpagerUI_loopFor
#EasyAddRemovePage
#Java & Smali
#by Suyonoion

- simple add remove page
- blur background
- Demo Sample : https://raw.githubusercontent.com/suyonoion/EasyViewpagerUI/master/app/easyviewpagerui_demo.apk
- Guide (smali) : https://raw.githubusercontent.com/suyonoion/EasyViewpagerUI/master/app/easyviewpagerui_simple_addremove_pages.zip

Screenshoot 1 :

![alt tag](https://raw.githubusercontent.com/suyonoion/EasyViewpagerUI/master/app/ss/Screenshot_20151229-070438.png)

Screenshoot 2 :

![alt tag](https://raw.githubusercontent.com/suyonoion/EasyViewpagerUI/master/app/ss/Screenshot_20151229-070445.png)


1. MENAMBAH PAGES

a. Buka ExpandedViewpagerUI.smali
 - Cari const/4 v0, 0x3
	*)0x3 untuk angka 3 (jumlah page 3)
 - Ganti 0x3 dengan jumlah page sesuai keinginanmu
	contoh : 0x5 untuk angka 5 (jumlah page 5)
	*) gunakan Int to Hex untuk convert angka ke hex smali
	*) kalau java edit Jumlah_Page = 5;
b. Buka kode_utama.xml
 - tambahkan LinearLayout id, sesuai jumlah page yang kamu edit/ganti
 contoh : 0x5, berarti 2 LinearLayout id yang harus kamu tambahkan.
 urutkan saja id_halaman_x nya.
```
 <com.suyonoion.easyviewpagerui.ExpandedViewpagerUI android:id="@+id/id_viewpager" android:layout_width="match_parent" android:layout_height="match_parent" android:theme="@style/transparan">
		<android.support.v4.view.PagerTabStrip android:id="@+id/id_judul" android:layout_width="wrap_content" android:layout_height="wrap_content" android:layout_gravity="top" android:background="#80159e58" android:textColor="#ffffffff"/>
		<LinearLayout android:id="@+id/id_halaman_1" android:layout_width="match_parent" android:layout_height="match_parent" android:background="@drawable/a2" android:gravity="center" android:orientation="vertical">
			<TextView android:layout_width="wrap_content" android:layout_height="wrap_content" android:layout_gravity="center" android:text="Notif" android:textColor="#ff473eff" android:textSize="70sp"/>
		</LinearLayout>
		<LinearLayout android:id="@+id/id_halaman_2" android:layout_width="match_parent" android:layout_height="match_parent" android:background="@drawable/a3" android:gravity="center" android:orientation="vertical">
			<com.suyonoion.easyviewpagerui.ConvertIntToHext android:layout_width="fill_parent" android:layout_height="fill_parent"/>
		</LinearLayout>
		<LinearLayout android:id="@+id/id_halaman_3" android:layout_width="match_parent" android:layout_height="match_parent" android:background="@drawable/a4" android:gravity="center" android:orientation="vertical">
			<TextView android:layout_width="wrap_content" android:layout_height="wrap_content" android:layout_gravity="center" android:text="3" android:textColor="#ff473eff" android:textSize="70sp"/>
		</LinearLayout>
		---------------------------------------------------
		<LinearLayout android:gravity="center" android:orientation="vertical" android:id="@+id/id_halaman_4" android:background="@drawable/a4" android:layout_width="fill_parent" android:layout_height="fill_parent">
			<TextView android:textSize="70.0sp" android:textColor="#ff473eff" android:layout_gravity="center" android:layout_width="wrap_content" android:layout_height="wrap_content" android:text="4" />
		</LinearLayout>
		<LinearLayout android:gravity="center" android:orientation="vertical" android:id="@+id/id_halaman_5" android:background="@drawable/a4" android:layout_width="fill_parent" android:layout_height="fill_parent">
			<TextView android:textSize="70.0sp" android:textColor="#ff473eff" android:layout_gravity="center" android:layout_width="wrap_content" android:layout_height="wrap_content" android:text="5" />
		</LinearLayout>
		----------------------------------------------------
 </com.suyonoion.easyviewpagerui.ExpandedViewpagerUI>
```
c. Buka strings-evp.xml / strings.xml
 - Tambahkan id string selanjutnya.
 contoh : 0x5, berarti tambahkan 2 id string baru.
 ```<resources>
 <string name="judul_halaman_1">Page 1</string>
 <string name="judul_halaman_2">Page 2</string>
 <string name="judul_halaman_3">Page 3</string>
 --------------
 <string name="judul_halaman_4">Page 4</string>
 <string name="judul_halaman_5">Page 5</string>
 --------------
 </resources>```

2. MENGURANGI PAGE
Sesuaikan Saja. tapi untuk strings jangan dikurangi. karena id string gakboleh dihapus, nanti error undefined.
Sudah begitu saja.

#SourceCode : http://github.com/suyonoion/EasyViewpagerUI
#Credit : suyonoion
#Contact me on :
 - Facebook, http://fb.com/suyono.ion
 - Github, http://github.com/suyonoion
 - BBM, 5b45891d
 - No. +62 85 6190 5369
#Donate : seikhlasnya.

Full Thanks:
- Allah.

Credit+Referensi :

- CubeOutTransformer.java , teredit untuk fix dan menyesuaikan. ( https://github.com/geftimov/android-viewpager-transformers/blob/master/android-viewpager-transformers/src/main/java/com/eftimoff/viewpagertransformers/CubeOutTransformer.java )
- Alwiens Musthofa ( https://facebook.com/dindingberhala?fref=ts ) for Tips getIdentifier, simple tapi sangat bermanfaat, terimakasih.
- All Admin and Members MaaadOn Group ( https://facebook.com/groups/maaadreborn/ )
- Suyono (ion)

Credit source :
- suyonoion ( https://facebook.com/suyono.ion )

Terimakasih.


Notes :

- Please Respect My efforts.
- Include credit properly.
- Salam.
- Thank You.
