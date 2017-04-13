package ulyne.com.bottomnavigationbardemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.lang.reflect.Array;

/**
 * 运用谷歌提供的底部栏
 * @author fanwei
 */
public class MainActivity extends AppCompatActivity {

    private HomeFragment homeFragment;
    private DashFragment dashFragment;
    private NotifyFragment notifyFragment;
    private FragmentManager fragmentManager ;

    /**
     * 底部导航监听
     */
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            /**
             * 开启事务
             */
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            hideFragment(fragmentTransaction);

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if (homeFragment == null)
                    {
                        homeFragment = new HomeFragment();
                        fragmentTransaction.add(R.id.content, homeFragment);
                    } else
                    {
                        fragmentTransaction.show(homeFragment);
                    }
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_dashboard:
                    if (dashFragment == null)
                    {
                        dashFragment = new DashFragment();
                        fragmentTransaction.add(R.id.content, dashFragment);
                    }else
                    {
                        fragmentTransaction.show(dashFragment);
                    }
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_notifications:
                    if (notifyFragment == null)
                    {
                        notifyFragment = new NotifyFragment();
                        fragmentTransaction.add(R.id.content, notifyFragment);
                    }else
                    {
                        fragmentTransaction.show(notifyFragment);
                    }
                    fragmentTransaction.commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        homeFragment = new HomeFragment();
        fragmentTransaction.add(R.id.content, homeFragment);
        fragmentTransaction.commit();
    }

    void initView()
    {

    }

    void hideFragment(FragmentTransaction fragmentTransaction)
    {
        if (homeFragment != null)
        {
            fragmentTransaction.hide(homeFragment);
        }
        if (dashFragment != null)
        {
            fragmentTransaction.hide(dashFragment);
        }
        if (notifyFragment != null)
        {
            fragmentTransaction.hide(notifyFragment);
        }
    }
}
