package bid.xiaocha.xxt.ui;

import android.os.Bundle;
import android.os.HandlerThread;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.logging.Handler;

import bid.xiaocha.xxt.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private MainFragment mainFragment;
    private OrderFragment orderFragment;
    private ChatFragment chatFragment;
    private ServiceManagerFragment serviceManagerFragment;
    private MyFragment myFragment;



    private android.os.Handler uiHandler = new android.os.Handler();
    private android.os.Handler asyncHandler;
    private HandlerThread handlerThread;

    {
        handlerThread = new HandlerThread("asyncWorkerThread");
        handlerThread.start();
        asyncHandler = new android.os.Handler(handlerThread.getLooper());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();


        initView();
    }

    private void initView() {
        View view = findViewById(R.id.ly_main);
        view.setOnClickListener(this);
        view = findViewById(R.id.ly_chat);
        view.setOnClickListener(this);
        view = findViewById(R.id.ly_order);
        view.setOnClickListener(this);
        view = findViewById(R.id.ly_service_manager);
        view.setOnClickListener(this);
        view = findViewById(R.id.ly_my);
        view.setOnClickListener(this);

        initFragment();

        setFragment(mainFragment);
    }

    private void initFragment() {
        //TODO:init
        mainFragment = MainFragment.getFragment(uiHandler, asyncHandler);
        orderFragment = OrderFragment.getFragment(uiHandler, asyncHandler);
        chatFragment = ChatFragment.getFragment(uiHandler, asyncHandler);
        serviceManagerFragment = ServiceManagerFragment.getFragment(uiHandler, asyncHandler);
        myFragment = MyFragment.getFragment(uiHandler, asyncHandler);

    }

    @Override
    public void onClick(View v) {




        switch (v.getId()){
            case R.id.ly_main:
                reset();
                //set ly_main style
                setFragment(mainFragment);

                break;
            case R.id.ly_order:
                reset();
                //set ly_order style
                setFragment(orderFragment);
                break;
            case R.id.ly_chat:
                reset();
                //set ly_chat style
                setFragment(chatFragment);
                break;
            case R.id.ly_service_manager:
                reset();
                //set ly_service_manager style
                setFragment(serviceManagerFragment);
                break;
            case R.id.ly_my:
                reset();
                //set ly_my style
                setFragment(myFragment);
                break;
            default:
                break;
        }
    }


    private void reset(){
        //TODO:重置按钮样式为初始状态
    }

    private void setFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.v_content, fragment);

        transaction.commit();
    }
}
