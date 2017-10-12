package bid.xiaocha.xxt.presenter;

import java.util.logging.Handler;

import bid.xiaocha.xxt.iview.ILoginView;
import bid.xiaocha.xxt.model.LoginResult;

/**
 * Created by 55039 on 2017/10/12.
 */

public class LoginPresenter implements ILoginPresenter {

    private ILoginView view;
    private android.os.Handler asyncHandler;

    public LoginPresenter(ILoginView loginView, android.os.Handler asycHandler){
        this.asyncHandler = asycHandler;
        this.view = loginView;
    }

    @Override
    public void loginByPassword(String userId, String password) {
        view.showLoading();


        LoginResult result = LoginResult.FAILED_NETWORK_ERROR;

        view.dismissLoading();
        view.showLoginResult(result);
    }

    @Override
    public void loginByVerificationCode(String userId, String verificationCode) {

    }

}
