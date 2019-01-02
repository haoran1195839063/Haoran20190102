package haoran.bwie.com.haoran20190102.view;

public interface View<T> {
    void success(T data);

    void error(String error);
}
