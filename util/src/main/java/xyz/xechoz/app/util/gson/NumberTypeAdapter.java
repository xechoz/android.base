package xyz.xechoz.app.util.gson;


import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by xechoz.zheng on 07/05/2017.
 * Email: xechoz.zheng@gmail.com
 * 功能:
 * 文档:
 */

public abstract class  NumberTypeAdapter<T extends Number> extends TypeAdapter<T> {

    @Override
    public void write(JsonWriter out, T value) throws IOException {
        out.value(value);
    }

    @Override
    public T read(JsonReader in) throws IOException {
        JsonToken jsonToken = in.peek();
        switch (jsonToken) {
            case NULL:
                in.nextNull();
                return null;
            case NUMBER:
            case STRING:
                String value = in.nextString();

                if (value != null) {
                    value = value.trim();
                }

                if (value == null || value.isEmpty()) {
                    return null;
                } else {
                    return read(value);
                }
            default:
                throw new JsonSyntaxException("Expecting number, got: " + jsonToken);
        }
    }

    abstract protected T read(String value);
}
