package bid.xiaocha.xxt.iview;

import bid.xiaocha.xxt.model.LoginResult;
import bid.xiaocha.xxt.model.RegisterResult;

/**
 * Created by 55039 on 2017/10/12.
 */

public interface IRegisterView {
    void showLoading();

    void showRegisterResult(RegisterResult result);

    void dismissLoading();
}
