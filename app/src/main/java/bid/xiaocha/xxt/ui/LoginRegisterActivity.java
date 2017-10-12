package bid.xiaocha.xxt.ui;

import android.os.Bundle;
import android.os.HandlerThread;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import bid.xiaocha.xxt.R;

public class LoginRegisterActivity extends AppCompatActivity {
    private android.os.Handler uiHandler = new android.os.Handler();
    private android.os.Handler asyncHandler;
    private HandlerThread handlerThread;
    private LoginFragment loginFragment;

    {
        handlerThread = new HandlerThread("asyncWorkerThread");
        handlerThread.start();
        asyncHandler = new android.os.Handler(handlerThread.getLooper());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initFragment();
    }

    private void initFragment() {
        loginFragment = LoginFragment.getFragment(asyncHandler);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ly_content,loginFragment);
        fragmentTransaction.commit();
    }

}
