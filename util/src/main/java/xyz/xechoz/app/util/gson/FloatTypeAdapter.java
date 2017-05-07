package xyz.xechoz.app.util.gson;

import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapters;

/**
 * Created by xechoz.zheng on 07/05/2017.
 * Email: xechoz.zheng@gmail.com
 * 功能:
 * 文档:
 */

@GsonAdapter(unbox = float.class, box = Float.class)
public class FloatTypeAdapter extends NumberTypeAdapter<Float> {
    public final static TypeAdapterFactory FACTORY = TypeAdapters.newFactory(float.class, Float.class, new FloatTypeAdapter());

    @Override
    protected Float read(String value) {
        return Float.parseFloat(value);
    }
}
