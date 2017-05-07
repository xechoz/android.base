package xyz.xechoz.app.util.gson;

import com.google.gson.GsonBuilder;

/**
 * Created by xechoz.zheng on 07/05/2017.
 * Email: xechoz.zheng@gmail.com
 * 功能:
 * 文档:
 */

public class NumberBuilder {

    public static GsonBuilder with(GsonBuilder builder) {
        builder.registerTypeAdapterFactory(DoubleTypeAdapter.FACTORY)
        .registerTypeAdapterFactory(FloatTypeAdapter.FACTORY)
        .registerTypeAdapterFactory(IntegerTypeAdapter.FACTORY)
        .registerTypeAdapterFactory(LongTypeAdapter.FACTORY);
        return builder;
    }
}
