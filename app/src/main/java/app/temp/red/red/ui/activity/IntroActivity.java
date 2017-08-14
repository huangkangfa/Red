package app.temp.red.red.ui.activity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hkf.coffee.phone.DensityUtil;
import com.hkf.coffee.ui.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import app.temp.red.red.R;
import app.temp.red.red.global.cache.AppCache;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 引导页
 * Created by huangkangfa on 2017/8/6.
 */
public class IntroActivity extends BaseActivity {
    @Bind(R.id.viewpager)
    ViewPager viewPager;
    @Bind(R.id.round1)
    ImageView round1Iv;
    @Bind(R.id.round2)
    ImageView round2Iv;
    @Bind(R.id.round3)
    ImageView round3Iv;
    @Bind(R.id.round4)
    ImageView round4Iv;
    @Bind(R.id.tag)
    ImageView tagIv;
    @Bind(R.id.tag_layout)
    RelativeLayout tagLayout;

    private List<View> views;

    private static final int[] pictures = {
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        ButterKnife.bind(this);
        initView();
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(pageChangeListener);
    }

    private void initView() {
        views = new ArrayList<View>();
        for (int i = 0; i < pictures.length; i++) {
            ImageView imageView = new ImageView(mActivity);
            imageView.setBackgroundResource(pictures[i]);
            views.add(imageView);
        }
    }

    private PagerAdapter pagerAdapter = new PagerAdapter() {
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position));
            return views.get(position);
        }
        @Override
        public int getCount() {
            return views.size();
        }
    };

    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {
            float toX = 0;
            if(position == 0){
                toX = round1Iv.getLeft()- DensityUtil.dp2px(2);
            }else if(position == 1){
                toX = round2Iv.getLeft()-DensityUtil.dp2px(2);
            }else if(position == 2) {
                toX = round3Iv.getLeft() - DensityUtil.dp2px(2);
            }else{
                toX = round4Iv.getLeft()-DensityUtil.dp2px(2);
            }
            ObjectAnimator translationUp = ObjectAnimator.ofFloat(tagIv, "translationX",tagIv.getTranslationX(),toX);
            translationUp.setInterpolator(new DecelerateInterpolator());
            translationUp.setDuration(500);
            translationUp.start();
            if (position == 3) {
                views.get(position).setOnClickListener(clickListener);
                ObjectAnimator.ofFloat(tagLayout, "alpha",1,0).setDuration(500).start();
            }else{
                if(tagLayout.getAlpha() == 0){
                    ObjectAnimator.ofFloat(tagLayout, "alpha",0,1).setDuration(500).start();
                }
            }
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageScrollStateChanged(int position) {
        }
    };

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AppCache.setFirstUsedThisApp(false);
            setResult(RESULT_OK);
            finish();
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            setResult(RESULT_OK);
            finish();
        }
        return false;
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}












