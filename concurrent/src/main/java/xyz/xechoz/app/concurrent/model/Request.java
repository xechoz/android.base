package xyz.xechoz.app.concurrent.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xechoz.zheng on 03/04/2017.
 * Email: zheng1733@gmail.com
 * 功能:
 * 文档:
 */

public class Request implements Parcelable {
    public int id;
    public int apiCode;
    public boolean isOneTime; // 结果只会会调一次
    public String data;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.apiCode);
        dest.writeByte(this.isOneTime ? (byte) 1 : (byte) 0);
        dest.writeString(this.data);
    }

    public Request() {
    }

    protected Request(Parcel in) {
        this.id = in.readInt();
        this.apiCode = in.readInt();
        this.isOneTime = in.readByte() != 0;
        this.data = in.readString();
    }

    public static final Parcelable.Creator<Request> CREATOR = new Parcelable.Creator<Request>() {
        @Override
        public Request createFromParcel(Parcel source) {
            return new Request(source);
        }

        @Override
        public Request[] newArray(int size) {
            return new Request[size];
        }
    };
}
