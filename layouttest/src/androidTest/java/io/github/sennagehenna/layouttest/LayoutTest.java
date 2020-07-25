package io.github.sennagehenna.layouttest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class LayoutTest {

    public static Long inflateAndMeasure(int layoutRes) {
        LayoutInflater inflater = LayoutInflater.from(InstrumentationRegistry.getInstrumentation().getTargetContext());
        long startTime = System.nanoTime();
        for (int i = 0; i < 999; i++) {
            View inflatedView = inflater.inflate(layoutRes, null);
            inflatedView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
            inflatedView.measure(
                    View.MeasureSpec.makeMeasureSpec(
                            1000,
                            View.MeasureSpec.EXACTLY
                    ),
                    View.MeasureSpec.makeMeasureSpec(
                            0,
                            View.MeasureSpec.UNSPECIFIED
                    )
            );
            inflatedView.layout(0, 0, inflatedView.getMeasuredWidth(), inflatedView.getMeasuredHeight());
        }

        return System.nanoTime() - startTime;
    }

}
