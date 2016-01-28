package lou.kings.com.oneapp.fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import lou.kings.com.oneapp.R;

/**
 * Created by jin on 2016.01.26.
 */
public class OneFragment extends BaseFragment {

    private View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(rootview==null){
            rootview = inflater.inflate(R.layout.onfragment, container, false);
            lazyLoad();
        }
        ViewGroup parent = (ViewGroup)rootview.getParent();
        if(parent!=null){
            parent.removeView(rootview);
        }
        return rootview;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void onInvisible() {
        super.onInvisible();
    }

    @Override
    protected void onVisible() {
        super.onVisible();
    }
}
