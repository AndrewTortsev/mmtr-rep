package tutorial;

import com.google.gson.Gson;

import java.util.List;

public class AjaxResponseBody {

    private String stackTrace;
    private int status;

    public String getStackTrace() {
        return stackTrace;
    }

    public int getStatus() {
        return status;
    }

    public String getJson() {
        return new Gson().toJson(this).toString();
    }

    public AjaxResponseBody(String stackTrace, int status) {

        this.stackTrace = stackTrace;
        this.status = status;
    }
}
