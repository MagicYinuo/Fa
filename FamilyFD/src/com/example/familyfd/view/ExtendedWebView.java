package com.example.familyfd.view;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * Created with IntelliJ IDEA.
 * User: sash0k
 * Date: 07.06.13
 * Time: 11:15
 * 袛谢褟 胁芯蟹屑芯卸薪芯褋褌懈 胁械褉褌懈泻邪谢褜薪芯谐芯 褋泻褉芯谢谢邪 薪邪 Android 2.x
 * see http://stackoverflow.com/a/9925980
 */
public class ExtendedWebView extends WebView {
    public ExtendedWebView(Context context) {
        super(context);
    }

    public ExtendedWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean canScrollVertical(int direction) {
        final int offset = computeVerticalScrollOffset();
        final int range = computeVerticalScrollRange() - computeVerticalScrollExtent();
        if (range == 0) return false;
        else return (direction < 0) ? (offset > 0) : (offset < range - 1);
    }
}

