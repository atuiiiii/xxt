package bid.xiaocha.xxt.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bid.xiaocha.xxt.R;

public class MainFragment extends Fragment {

    private Handler uiHandler;
    private Handler asyncHandler;

    public static MainFragment getFragment(Handler uiHandler, Handler asyncHandler){
        MainFragment fragment = new MainFragment();
        fragment.setFragment(uiHandler, asyncHandler);

        return fragment;
    }

    private void setFragment(Handler uiHandler, Handler asyncHandler) {
        this.uiHandler = uiHandler;
        this.asyncHandler = asyncHandler;
    }

    public MainFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
