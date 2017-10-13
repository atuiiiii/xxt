package bid.xiaocha.xxt.ui;

import android.os.Bundle;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bid.xiaocha.xxt.R;
import bid.xiaocha.xxt.iview.ILoginView;
import bid.xiaocha.xxt.iview.IVerificationCodeView;
import bid.xiaocha.xxt.model.LoginResult;
import bid.xiaocha.xxt.presenter.ILoginPresenter;
import bid.xiaocha.xxt.presenter.IVerificationPresenter;
import bid.xiaocha.xxt.presenter.LoginPresenter;
import bid.xiaocha.xxt.presenter.VerificationPresenter;

public class LoginRegisterActivity extends AppCompatActivity implements ILoginView, View.OnClickListener,IVerificationCodeView {
    private android.os.Handler uiHandler = new android.os.Handler();
    private android.os.Handler asyncHandler;
    private HandlerThread handlerThread;
    private LoginFragment loginFragment;
    private EditText edtUserId;
    private EditText edtVerificationCode;
    private Button btnLogin;
    private Button btnGetVerificationCode;
    private ILoginPresenter loginPresenter;
    private IVerificationPresenter verificationPresenter;

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
        loginPresenter = new LoginPresenter(this, asyncHandler);
        verificationPresenter = new VerificationPresenter(this,asyncHandler);
        edtUserId = (EditText) this.findViewById(R.id.edt_user_id);
        edtVerificationCode = (EditText) this.findViewById(R.id.edt_verification_code);
        btnLogin = (Button) this.findViewById(R.id.btn_login);
        btnGetVerificationCode = (Button) this.findViewById(R.id.btn_get_verification_code);
        btnLogin.setOnClickListener(this);
        btnGetVerificationCode.setOnClickListener(this);

       // initFragment();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_login){
            String userId = edtUserId.getText().toString().trim();
            String verificationCode = edtVerificationCode.getText().toString().trim();
            if ("".equals(userId)||"".equals(verificationCode)){
                Toast.makeText(this, "请输入手机号或验证码", Toast.LENGTH_SHORT).show();
                return;
            }
            loginPresenter.loginByVerificationCode(userId, verificationCode);
        }else if(v.getId() == R.id.btn_get_verification_code){
            String userId = edtUserId.getText().toString().trim();
            if ("".equals(userId)){
                Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
                return;
            }else {
                verificationPresenter.requestVerificationCode(userId);
            }
        }
    }

    @Override
    public void onRequestVerification() {

    }

    @Override
    public void requestVerificationSucceeded() {

    }

    @Override
    public void requestVerificationFailed() {

    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "showLoading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginResult(LoginResult result) {
        Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dismissLoading() {

    }

//    private void initFragment() {
//        loginFragment = LoginFragment.getFragment(asyncHandler);
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.ly_content,loginFragment);
//        fragmentTransaction.commit();
//    }

}
