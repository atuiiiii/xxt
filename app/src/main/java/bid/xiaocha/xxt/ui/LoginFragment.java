package bid.xiaocha.xxt.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


public class LoginFragment extends Fragment implements ILoginView, View.OnClickListener,IVerificationCodeView{

    private Handler asyncHandler;
    private EditText edtUserId;
    private EditText edtVerificationCode;
    private Button btnLogin;
    private Button btnGetVerificationCode;


    public static LoginFragment getFragment(Handler asyncHandler){
        LoginFragment fragment = new LoginFragment();
        fragment.setFragment(asyncHandler);

        return fragment;
    }

    private void setFragment(Handler asyncHandler) {
        this.asyncHandler = asyncHandler;
    }



    private ILoginPresenter loginPresenter;
    private IVerificationPresenter verificationPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginPresenter = new LoginPresenter(this, asyncHandler);
        verificationPresenter = new VerificationPresenter(this,asyncHandler);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        edtUserId = (EditText) view.findViewById(R.id.edt_user_id);
        edtVerificationCode = (EditText) view.findViewById(R.id.edt_verification_code);
        btnLogin = (Button) view.findViewById(R.id.btn_login);
        btnGetVerificationCode = (Button) view.findViewById(R.id.btn_get_verification_code);
        btnLogin.setOnClickListener(this);
        btnGetVerificationCode.setOnClickListener(this);
        return view;
    }



    @Override
    public void showLoading() {
        Toast.makeText(getActivity(), "showLoading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginResult(LoginResult result) {
        Toast.makeText(getActivity(), result.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dismissLoading() {
        Toast.makeText(getActivity(), "dismissLoading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_login){
            String userId = edtUserId.getText().toString().trim();
            String verificationCode = edtVerificationCode.getText().toString().trim();
            if ("".equals(userId)||"".equals(verificationCode)){
                Toast.makeText(getActivity(), "请输入手机号或验证码", Toast.LENGTH_SHORT).show();
                return;
            }
            loginPresenter.loginByVerificationCode(userId, verificationCode);
        }else if(v.getId() == R.id.btn_get_verification_code){
            String userId = edtUserId.getText().toString().trim();
            if ("".equals(userId)){
                Toast.makeText(getActivity(), "请输入手机号", Toast.LENGTH_SHORT).show();
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
}
