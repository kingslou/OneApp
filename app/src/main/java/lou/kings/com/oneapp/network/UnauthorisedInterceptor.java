package lou.kings.com.oneapp.network;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Response;
import java.io.IOException;


public class UnauthorisedInterceptor implements Interceptor {

    public UnauthorisedInterceptor(Context context) {

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        if (response.code() == 401) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
        return response;
    }
}
