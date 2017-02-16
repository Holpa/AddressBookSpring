package hello;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class GreetingController {

    private final GreetingService service;

    public GreetingController(GreetingService service) {
        this.service = service;
    }

    @RequestMapping("/greeting")
    public @ResponseBody String greeting() throws JSONException {
        String message;
        JSONObject json = new JSONObject();
        json.put("id", "content");
        JSONArray array = new JSONArray();
        JSONObject item = new JSONObject();
        item.put("id", 3);
        item.put("content", "course1");
        array.put(item);

        message = json.toString();

        // fail
        return message;
    }

}