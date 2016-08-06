package com.example.matthew.componentsandroid.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.example.matthew.componentsandroid.Controller.Adapters.AdapterViewPager;
import com.example.matthew.componentsandroid.R;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

/**
 * Created by matthew on 03/08/2016.
 */
public class FragmentViewPager extends Fragment {
    private View v;

    public MaterialViewPager getPager() {
        return pager;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_view_pager, container, false);
        setResources();
        return v;
    }

    private void setResources() {
        pager = (MaterialViewPager) v.findViewById(R.id.materialViewPager);
        pager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,
                                "http://cdn1.tnwcdn.com/wp-content/blogs.dir/1/files/2014/06/wallpaper_51.jpg");
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.green,
                                "http://i.imgur.com/wt4NRqA.jpg");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.cyan,
                                "http://orig11.deviantart.net/20eb/f/2015/030/6/f/_minflat__dark_material_design_wallpaper__4k__by_dakoder-d8fjqzu.jpg");
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.red,
                                "https://newevolutiondesigns.com/images/freebies/google-material-design-wallpaper-9.jpg");
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        pager.setToolbar(toolbar);
        ViewPager viewPager = pager.getViewPager();
        viewPager.setAdapter(new AdapterViewPager(getFragmentManager()));
//After set an adapter to the ViewPager
        pager.getPagerTitleStrip().setViewPager(viewPager);
        //  // Bind the tabs to the ViewPager
        //   PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) v.findViewById(R.id.materialviewpager_pagerTitleStrip);
        // tabs.setViewPager(viewPager);

    }

    private MaterialViewPager pager;

}
