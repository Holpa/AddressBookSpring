package hello;

/**
 * Created by ahmadholpa on 2/9/2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class BuddyinfoController {

    @Autowired
    private BuddyInfoRepository birepo;

    @GetMapping("/addbuddy")
    public String addBuddyInfo(Model model) {
        //buddyInfo will be looked at in the templates and see if it matches th:object="${buddyInfo}"
        model.addAttribute("buddyInfo",new BuddyInfo());
        return "buddyform";

    }

    @PostMapping("/addbuddy")
    public @ResponseBody String newBuddy(@ModelAttribute BuddyInfo buddyInfo) {
        birepo.save(buddyInfo);
        return buddyInfo.toString();
    }

    @RequestMapping("buddyInfo/{id}")
    public @ResponseBody String buddy(@PathVariable int id)
    {
        return birepo.findById(id).toString();
    }
}