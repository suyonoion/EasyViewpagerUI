package com.suyonoion.easyviewpagerui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Suyono on 5/26/2015.
 * Copyright (c) 2015 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */
@SuppressWarnings("ALL")
public class ConvertIntToHext extends LinearLayout {

    int sdk = android.os.Build.VERSION.SDK_INT;
    private EditText editText_int, editText_hex;

    public ConvertIntToHext(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root = inflater.inflate(setResource("layout_convert_int_to_hex", "layout"), this, true);
        Button btn_convert = (Button) root.findViewById(setResource("btn_convert", "id"));
        Button btn_kopi = (Button) root.findViewById(setResource("btn_kopi", "id"));
        editText_int = (EditText) root.findViewById(setResource("editText_angka", "id"));
        editText_hex = (EditText) root.findViewById(setResource("editText_hex", "id"));
        btn_convert.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int anu = Integer.valueOf(editText_int.getText().toString());
                editText_hex.setText(String.format("0x%s", Integer.toHexString(anu)));
            }
        });
        btn_kopi.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                    int anu = Integer.valueOf(editText_int.getText().toString());
                    String st = String.format("0x%s", Integer.toHexString(anu));
                    android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                    clipboard.setText(st);
                    Toast.makeText(getContext(), "Text Telah Ter-Copy ke Clipboard", Toast.LENGTH_SHORT).show();
                } else {
                    int anu = Integer.valueOf(editText_int.getText().toString());
                    String st = String.format("0x%s", Integer.toHexString(anu));
                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData.newPlainText("Clip", st);
                    Toast.makeText(getContext(), "Text Telah Ter-Copy ke Clipboard", Toast.LENGTH_SHORT).show();
                    clipboard.setPrimaryClip(clip);
                }
            }
        });
    }

    public int setResource(String name, String Type) {
        return getContext().getResources().getIdentifier(name, Type, getContext().getPackageName());
    }
}

