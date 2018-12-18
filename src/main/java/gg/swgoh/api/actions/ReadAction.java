package gg.swgoh.api.actions;

public interface ReadAction<T, U> {
    T read(U id);
}
