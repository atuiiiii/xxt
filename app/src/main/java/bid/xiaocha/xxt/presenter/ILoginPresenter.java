package bid.xiaocha.xxt.presenter;

/**
 * Created by 55039 on 2017/10/12.
 */

public interface ILoginPresenter {
    void loginByPassword(String userId, String password);

    void loginByVerificationCode(String userId, String verificationCode);
}
