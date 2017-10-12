package bid.xiaocha.xxt.presenter;

import bid.xiaocha.xxt.iview.ILoginView;
import bid.xiaocha.xxt.iview.IVerificationCodeView;
import bid.xiaocha.xxt.util.VerificationCodeUtil;

/**
 * Created by 55039 on 2017/10/13.
 */

public class VerificationPresenter implements IVerificationPresenter {

    private IVerificationCodeView view;
    private android.os.Handler asyncHandler;

    public VerificationPresenter(IVerificationCodeView view, android.os.Handler asycHandler){
        this.asyncHandler = asycHandler;
        this.view = view;
    }

    @Override
    public void requestVerificationCode(final String userId) {
        asyncHandler.post(new Runnable() {
            @Override
            public void run() {
                view.onRequestVerification();
                if (VerificationCodeUtil.requestVerificationCode(userId)){
                    view.requestVerificationSucceeded();
                }else{
                    view.requestVerificationFailed();
                }
            }
        });
    }
}
