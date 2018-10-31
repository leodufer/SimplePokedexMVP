package py.edu.facitec.simplepokedex.view;

import android.support.v7.app.AppCompatActivity;

import java.util.List;

public class ParentActivity<T> extends AppCompatActivity implements MView<T>{

    @Override
    public void showSuccess(List<T> results) {

    }

    @Override
    public void showSuccess(T result) {

    }

    @Override
    public void showError(String error) {

    }
}
