package demo.lugq.serverdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * @Description
 * @Author Lu Guoqiang
 * @Time 2019/4/12 17:18
 */
public class MyService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    class MyBinder extends IMyAidlInterface.Stub {

        @Override
        public String getName() throws RemoteException {
            return "路路路";
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }
    }
}
