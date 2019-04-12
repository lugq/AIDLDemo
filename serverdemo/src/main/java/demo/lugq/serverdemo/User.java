package demo.lugq.serverdemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Description
 * @Author Lu Guoqiang
 * @Time 2019/4/12 16:44
 */
public class User implements Parcelable {

    private String name;

    protected User(Parcel in) {
        name = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
}
