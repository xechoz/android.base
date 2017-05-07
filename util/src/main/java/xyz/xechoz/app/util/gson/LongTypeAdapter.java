package xyz.xechoz.app.util.gson;

import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapters;

/**
 * Created by xechoz.zheng on 07/05/2017.
 * Email: xechoz.zheng@gmail.com
 * 功能:
 * 文档:
 */

public class LongTypeAdapter extends NumberTypeAdapter<Long> {
    public final static TypeAdapterFactory FACTORY = TypeAdapters.newFactory(long.class, Long.class, new LongTypeAdapter());

    @Override
    protected Long read(String value) {
        return Long.parseLong(value);
    }
}
