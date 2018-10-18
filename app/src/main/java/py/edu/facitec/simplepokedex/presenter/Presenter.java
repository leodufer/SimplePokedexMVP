package py.edu.facitec.simplepokedex.presenter;

import py.edu.facitec.simplepokedex.view.MView;
import retrofit.RestAdapter;

public class Presenter {
    private MView mView;
    private RestAdapter restAdapter;

    public Presenter(MView mView, String endPoint){
        this.mView = mView;
        this.restAdapter = new RestAdapter
                .Builder()
                .setEndpoint(endPoint)
                .build();
    }

    public MView getmView() {
        return mView;
    }

    public void setmView(MView mView) {
        this.mView = mView;
    }

    public RestAdapter getRestAdapter() {
        return restAdapter;
    }

    public void setRestAdapter(RestAdapter restAdapter) {
        this.restAdapter = restAdapter;
    }
}
