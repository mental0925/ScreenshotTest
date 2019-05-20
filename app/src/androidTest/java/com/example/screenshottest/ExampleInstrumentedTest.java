package com.example.screenshottest;



import org.junit.Test;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.screenshottest.R;
import com.facebook.testing.screenshot.Screenshot;
import com.facebook.testing.screenshot.ViewHelpers;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class ExampleInstrumentedTest {
    @Test
    public void testRendering() throws Throwable {
        LayoutInflater inflater = LayoutInflater.from(getInstrumentation().getTargetContext());
        View view = inflater.inflate(R.layout.search_bar, null, false);

        ViewHelpers.setupView(view)
                .setExactWidthDp(300)
                .layout();

        Screenshot.snap(view)
                .record();
    }
    @Test
    public void testLongText() throws Throwable {
        LayoutInflater inflater = LayoutInflater.from(getInstrumentation().getTargetContext());
        View view = inflater.inflate(R.layout.search_bar, null, false);

        TextView tv = (TextView) view.findViewById(R.id.search_box);

        tv.setText("This is a really long text and should overflow");
        ViewHelpers.setupView(view)
                .setExactWidthDp(300)
                .layout();

        Screenshot.snap(view)
                .record();
    }
    @Test
    public void testChinese() throws Throwable {
        LayoutInflater inflater = LayoutInflater.from(getInstrumentation().getTargetContext());
        View view = inflater.inflate(R.layout.search_bar, null, false);

        TextView tv = (TextView) view.findViewById(R.id.search_box);
        TextView btn = (TextView) view.findViewById(R.id.button);

        tv.setHint("搜索世界");
        btn.setText("搜索");


        ViewHelpers.setupView(view)
                .setExactWidthDp(800)
                .layout();


        Screenshot.snap(view)
                .record();
    }


}