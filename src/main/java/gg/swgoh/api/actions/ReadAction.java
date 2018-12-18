package gg.swgoh.api.actions;

public interface ReadAction<T> {
    T read(String id);

    default T read(int id) {
        return read(Integer.toString(id));
    }
}
