package lou.kings.com.oneapp;
import android.os.Bundle;
import com.github.paolorotolo.appintro.AppIntro2;
import lou.kings.com.oneapp.fragment.OneFragment;
import lou.kings.com.oneapp.fragment.TwoFragment;

/**
 * app说明页
 * Created by jin on 2016.01.27.
 */
public class MyIntro extends AppIntro2 {

    @Override
    public void init(Bundle bundle) {
        addSlide(new OneFragment());
        addSlide(new TwoFragment());
        addSlide(new TwoFragment());
        addSlide(new TwoFragment());
    }

    @Override
    public void onNextPressed() {

    }

    @Override
    public void onDonePressed() {

    }

    @Override
    public void onSlideChanged() {

    }
}
