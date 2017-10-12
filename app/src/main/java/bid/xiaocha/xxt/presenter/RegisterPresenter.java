package bid.xiaocha.xxt.presenter;

import android.os.Handler;

import bid.xiaocha.xxt.iview.IRegisterView;
import bid.xiaocha.xxt.model.RegisterResult;
import bid.xiaocha.xxt.util.VerificationCodeUtil;

/**
 * Created by 55039 on 2017/10/12.
 */

public class RegisterPresenter implements IRegisterPresenter {
    private IRegisterView view;

    private Handler asyncHandler;

    RegisterPresenter(IRegisterView view, Handler asyncHandler){
        this.view = view;
        this.asyncHandler = asyncHandler;
    }
    @Override
    public RegisterResult register(final String userId, final String verificationCode) {
        asyncHandler.post(new Runnable() {
            @Override
            public void run() {
                RegisterResult registerResult = RegisterResult.FAILED_CHECK_OUT_ERROR;
                view.showLoading();

                //http request

                if(VerificationCodeUtil.checkOutVerificationCode(userId, verificationCode)){
                    registerResult = RegisterResult.SUCCESS;
                }else{
                    registerResult = RegisterResult.FAILED_CHECK_OUT_ERROR;
                }

                view.dismissLoading();
                view.showRegisterResult(registerResult);
            }
        });

        return null;
    }
}
