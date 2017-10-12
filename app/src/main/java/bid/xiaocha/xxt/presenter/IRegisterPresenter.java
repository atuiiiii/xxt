package bid.xiaocha.xxt.presenter;

import bid.xiaocha.xxt.model.RegisterResult;

/**
 * Created by 55039 on 2017/10/12.
 */

public interface IRegisterPresenter {
    RegisterResult register(String userId,String verificationCode);
}
