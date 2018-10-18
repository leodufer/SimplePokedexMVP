package py.edu.facitec.simplepokedex.view;

import java.util.List;

public interface MView<T> {
    void showSuccess(List<T> results);
    void showSuccess(T result);
    void showError(String error);
}
