package lou.kings.com.oneapp.network;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import java.util.List;

import lou.kings.com.oneapp.BuildConfig;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

public interface ApiService {

    String ENDPOINT = "https://api.ribot.io/";
    String AUTH_HEADER = "Authorization";

    @POST("auth/sign-in")
    Observable<SignInResponse> signIn(@Body SignInRequest signInRequest);

    /******** Factory class that sets up a new ribot services *******/
    class Factory {

        public static ApiService makeRibotService(Context context) {
            OkHttpClient okHttpClient = new OkHttpClient();
            okHttpClient.interceptors().add(new UnauthorisedInterceptor(context));
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(BuildConfig.DEBUG? HttpLoggingInterceptor.Level.BODY
                    : HttpLoggingInterceptor.Level.NONE);
            okHttpClient.interceptors().add(logging);

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiService.ENDPOINT)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(ApiService.class);
        }

    }

    class Util {
        // Build API authorization string from a given access token.
        public static String buildAuthorization(String accessToken) {
            return "Bearer " + accessToken;
        }
    }

    /******** Specific request and response models ********/
    class SignInRequest {
        public String googleAuthorizationCode;

        public SignInRequest(String googleAuthorizationCode) {
            this.googleAuthorizationCode = googleAuthorizationCode;
        }
    }

    class SignInResponse {
        public String accessToken;
//        public Ribot ribot;
    }

    class UpdateCheckInRequest {
        public boolean isCheckedOut;

        public UpdateCheckInRequest(boolean isCheckedOut) {
            this.isCheckedOut = isCheckedOut;
        }
    }

}
