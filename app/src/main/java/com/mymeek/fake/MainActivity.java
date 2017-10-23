package com.mymeek.fake;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private List<String> mItems;

    private TabLayout tabLayout;
    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    private int pageModelsSize;

    FragmentManager fm = getSupportFragmentManager();

    {
        mItems = Arrays.asList("PracticeDraw1", "PracticeDraw2", "PracticeDraw3", "PracticeDraw4", "PracticeDraw5", "PracticeDraw6", "PracticeDraw7");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("onItemSelected...", "onItemSelected: "+i+"/"+l);
                pagerAdapter = new PagerAdapter(getSupportFragmentManager(), practiceDrawChapter(0));
                pager.setAdapter(pagerAdapter);
                //pagerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new PagerAdapter(fm, practiceDrawChapter(0));
        pager.setAdapter(pagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);




    }

    private List<PageModel> practiceDrawChapter(int chapter) {
        List<PageModel> pageModels = new ArrayList<>();

        switch (chapter) {
            //PracticeDraw1
            case 0:
                pageModels.add(new PageModel(R.layout.sample_color, R.string.title_draw_color, R.layout.practice_color));
                pageModels.add(new PageModel(R.layout.sample_circle, R.string.title_draw_circle, R.layout.practice_circle));
                pageModels.add(new PageModel(R.layout.sample_rect, R.string.title_draw_rect, R.layout.practice_rect));
                pageModels.add(new PageModel(R.layout.sample_point, R.string.title_draw_point, R.layout.practice_point));
                pageModels.add(new PageModel(R.layout.sample_oval, R.string.title_draw_oval, R.layout.practice_oval));
                pageModels.add(new PageModel(R.layout.sample_line, R.string.title_draw_line, R.layout.practice_line));
                pageModels.add(new PageModel(R.layout.sample_round_rect, R.string.title_draw_round_rect, R.layout.practice_round_rect));
                pageModels.add(new PageModel(R.layout.sample_arc, R.string.title_draw_arc, R.layout.practice_arc));
                pageModels.add(new PageModel(R.layout.sample_path, R.string.title_draw_path, R.layout.practice_path));
                pageModels.add(new PageModel(R.layout.sample_histogram, R.string.title_draw_histogram, R.layout.practice_histogram));
                pageModels.add(new PageModel(R.layout.sample_pie_chart, R.string.title_draw_pie_chart, R.layout.practice_pie_chart));
                break;
            case 1:
                pageModels.add(new PageModel(R.layout.sample_linear_gradient, R.string.title_linear_gradient, R.layout.practice_linear_gradient));
                pageModels.add(new PageModel(R.layout.sample_radial_gradient, R.string.title_radial_gradient, R.layout.practice_radial_gradient));
                pageModels.add(new PageModel(R.layout.sample_sweep_gradient, R.string.title_sweep_gradient, R.layout.practice_sweep_gradient));
                pageModels.add(new PageModel(R.layout.sample_bitmap_shader, R.string.title_bitmap_shader, R.layout.practice_bitmap_shader));
                pageModels.add(new PageModel(R.layout.sample_compose_shader, R.string.title_compose_shader, R.layout.practice_compose_shader));
                pageModels.add(new PageModel(R.layout.sample_lighting_color_filter, R.string.title_lighting_color_filter, R.layout.practice_lighting_color_filter));
                pageModels.add(new PageModel(R.layout.sample_color_mask_color_filter, R.string.title_color_matrix_color_filter, R.layout.practice_color_matrix_color_filter));
                pageModels.add(new PageModel(R.layout.sample_xfermode, R.string.title_xfermode, R.layout.practice_xfermode));
                pageModels.add(new PageModel(R.layout.sample_stroke_cap, R.string.title_stroke_cap, R.layout.practice_stroke_cap));
                pageModels.add(new PageModel(R.layout.sample_stroke_join, R.string.title_stroke_join, R.layout.practice_stroke_join));
                pageModels.add(new PageModel(R.layout.sample_stroke_miter, R.string.title_stroke_miter, R.layout.practice_stroke_miter));
                pageModels.add(new PageModel(R.layout.sample_path_effect, R.string.title_path_effect, R.layout.practice_path_effect));
                pageModels.add(new PageModel(R.layout.sample_shadow_layer, R.string.title_shader_layer, R.layout.practice_shadow_layer));
                pageModels.add(new PageModel(R.layout.sample_mask_filter, R.string.title_mask_filter, R.layout.practice_mask_filter));
                pageModels.add(new PageModel(R.layout.sample_fill_path, R.string.title_fill_path, R.layout.practice_fill_path));
                pageModels.add(new PageModel(R.layout.sample_text_path, R.string.title_text_path, R.layout.practice_text_path));
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
        }
        return pageModels;
    }

    private class PagerAdapter extends FragmentPagerAdapter {

        private List<PageModel> pages;

        public PagerAdapter(FragmentManager fm, List<PageModel> pageModels) {
            super(fm);
            pages = pageModels;
        }

        @Override
        public Fragment getItem(int position) {
            PageModel pageModel = pages.get(position);
            return PageFragment.newInstance(pageModel.sampleLayoutRes, pageModel.practiceLayoutRes);
        }

        @Override
        public int getCount() {
            return pages.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return getString(pages.get(position).titleRes);
        }

        @Override
        public int getItemPosition(Object object) {
            // 最简单解决 notifyDataSetChanged() 页面不刷新问题的方法
            return POSITION_NONE;
        }
    }

    private class PageModel {

        @LayoutRes
        int sampleLayoutRes;
        @StringRes
        int titleRes;
        @LayoutRes
        int practiceLayoutRes;

        PageModel(@LayoutRes int sampleLayoutRes, @StringRes int titleRes, @LayoutRes int practiceLayoutRes) {
            this.sampleLayoutRes = sampleLayoutRes;
            this.titleRes = titleRes;
            this.practiceLayoutRes = practiceLayoutRes;
        }
    }
}
