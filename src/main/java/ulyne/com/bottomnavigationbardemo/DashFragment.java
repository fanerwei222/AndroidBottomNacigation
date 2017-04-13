package ulyne.com.bottomnavigationbardemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fanwei on 2017/4/13.
 */

public class DashFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View dashView = inflater.inflate(R.layout.layout_dash, container, false);
        return dashView;
    }
}
