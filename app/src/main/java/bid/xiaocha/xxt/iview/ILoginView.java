package bid.xiaocha.xxt.iview;

import bid.xiaocha.xxt.model.LoginResult;

/**
 * Created by 55039 on 2017/10/12.
 */

public interface ILoginView {
    void showLoading();

    void showLoginResult(LoginResult result);

    void dismissLoading();

}
