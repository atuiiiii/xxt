package bid.xiaocha.xxt.util;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 55039 on 2017/10/13.
 */

public class VerificationCodeUtil {
    public static boolean requestVerificationCode(String userId){
        final Lock lock = new ReentrantLock();
        final Boolean result = new Boolean(false);
        //调用bmob方法申请验证码， 在callback里面调用lock.unlock();
        lock.lock();

        return result;
    }


    public static boolean checkOutVerificationCode(String userId, String verificationCode){
        final Lock lock = new ReentrantLock();
        final Boolean result = new Boolean(false);
        //调用bmob方法校检验证码， 在callback里面调用lock.unlock();
        lock.lock();

        return result;
    }

}
