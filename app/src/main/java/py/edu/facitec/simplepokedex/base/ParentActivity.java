package py.edu.facitec.simplepokedex.base;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import java.util.List;

import py.edu.facitec.simplepokedex.base.MView;
import py.edu.facitec.simplepokedex.base.Presenter;

public class ParentActivity<T> extends AppCompatActivity implements MView<T> {

    public Presenter presenter;

    public RelativeLayout errorStatus;
    public ProgressBar progressBar;
    public ListView resultListView;
    public SwipeRefreshLayout swipeRefreshLayout;
    @Override
    public void showSuccess(List<T> results) {

    }

    @Override
    public void showSuccess(T result) {

    }

    @Override
    public void showError(String error) {
        swipeRefreshLayout.setRefreshing(false);
        progressBar.setVisibility(View.GONE);
        errorStatus.setVisibility(View.VISIBLE);
        resultListView.setVisibility(View.GONE);
    }
}
