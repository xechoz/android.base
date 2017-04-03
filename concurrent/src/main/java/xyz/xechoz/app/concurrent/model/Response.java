package xyz.xechoz.app.concurrent.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xechoz.zheng on 03/04/2017.
 * Email: zheng1733@gmail.com
 * 功能:
 * 文档:
 */

public class Response implements Parcelable {
    public int code;
    public String msg;
    public String data;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.code);
        dest.writeString(this.msg);
        dest.writeString(this.data);
    }

    public Response() {
    }

    protected Response(Parcel in) {
        this.code = in.readInt();
        this.msg = in.readString();
        this.data = in.readString();
    }

    public static final Parcelable.Creator<Response> CREATOR = new Parcelable.Creator<Response>() {
        @Override
        public Response createFromParcel(Parcel source) {
            return new Response(source);
        }

        @Override
        public Response[] newArray(int size) {
            return new Response[size];
        }
    };
}
