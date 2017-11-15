package com.gmail.afonsotrepa.pocketgopher.gopherclient;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.TextView;

import com.gmail.afonsotrepa.pocketgopher.R;

/**
 *
 */

public class UnknownLine extends Line {
    private static final Integer IMAGE_TAG = R.drawable.ic_error_white;

    private Character type_tag;

    UnknownLine(String text) {
        super(text, null, 0, '3', "");
    }

    public void render(final TextView textView, final Context context) {
        final Handler handler = new Handler(Looper.getMainLooper());
        final SpannableStringBuilder text = new SpannableStringBuilder("  " + this.text + "\n");

        handler.post(new Runnable() {
            @Override
            public void run() {
                //set the image tag behind (left of) the text
                text.setSpan(new ImageSpan(context, IMAGE_TAG), 0, 1, 0);
                textView.append(text);
            }
        });
    }
}