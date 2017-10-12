package bid.xiaocha.xxt.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bid.xiaocha.xxt.R;

public class OrderFragment extends Fragment {


    private Handler uiHandler;
    private Handler asyncHandler;

    public static OrderFragment getFragment(Handler uiHandler, Handler asyncHandler){
        OrderFragment fragment = new OrderFragment();
        fragment.setFragment(uiHandler, asyncHandler);

        return fragment;
    }

    private void setFragment(Handler uiHandler, Handler asyncHandler) {
        this.uiHandler = uiHandler;
        this.asyncHandler = asyncHandler;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false);
    }
}
