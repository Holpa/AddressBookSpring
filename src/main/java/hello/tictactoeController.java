package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ahmadholpa on 2/9/2017.
 */



/*
// in lab 6 this will be treated as Greeting classs
    // Greeting.html will be treated as TicTacToeGreeting.html

STATIC PAGE:
Simply mage static folder inside resources and make index.html , NO routing required!!~
tactics:
1- add @Controller
2- add @getMapping or @postMapping with the LINK that COMING from the internet, that link might not be the same HTML
might be loaded later
3- put the HTML required !
    a. if it was the home page then "/" and put the index.html in the static folder
    b. if it was any other html then make templates folder and put your htmls with the following structure

    <!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Getting Started: Handling Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<form action="#" th:action="@{/HERE IS WHAT THIS HTML WILL BE CALLED FROM OUTSIDE, must be same as the .html file name}"
 th:object="${incase we are passing an object}" method="get OR MUST CHOSE post">
.
.DO YOUR HTML
.
</form>
</body>
</html>

4- write a public function, "public String/int/whatever Functionname(XXXXvariablesxxx,xxxx){
return if you are redirecting to .html page}
    a. IF you are not redirecting to a html page then do the folloiwng:
        i.public >>>>>@ResponseBody<<<< String noHTML() {
        return "HADOKEN";
    }
5- Passing Objects...
    a. First passing the model and attach values to it then PASS it to HTML For using 3rd function, you must indicate
        that variable name and it must be THE same in HTML as th:object="${TicTacToeInstance}" in <Form> Tag
        case sensitive !!!!
    b. calling a method from passed Object inside the HTML.... NEED TO ASK????????????????????
        DO *{getRvalue()}
    c. HOW BuddyinfoController invoked the POST method ??????????????????? is it from "Submit" ?????
6- DATABASE !!!!!!! Follow this guide
https://spring.io/guides/gs/handling-form-submission/
https://spring.io/guides/gs/accessing-data-jpa/
    a.Customer will be Buddy info
    b. REAd the BEAN IDEA !!!

7- JS into the BUSINESS !!!!! follow this guide https://spring.io/guides/gs/consuming-rest-jquery/
    a. Jquery and AJAX
    b. make public folder then add the File.js
 */
@Controller
public class tictactoeController {



    @GetMapping("/tictactoe")
    public String startTicTacToe() {
        //buddyInfo will be looked at in the templates and see if it matches th:object="${buddyInfo}"
        return "tictactoe";
    }

// this method will only print no HTML REQ THANKS TO @ResponseBody
    @GetMapping("/tictactoeNOHTML")
    public @ResponseBody String noHTMLtictactoe(){
        return "Hadoken";    }


    @GetMapping("/addtictactoe1")
    public String addTicTacToe(Model model) {
        //attach the object with the model to be used on the .html
        model.addAttribute("TicTacToeInstance",new TicTacToe());
        return "addtictactoe";
    }

    //Lab 6
    // here we are making object TicTacToeObject and will be used in TicTacToeGreeting
    // website then we will get it by having, th:action="@{/TicTacToeGreeting}" th:object"${TicTacToeObject}"
    @GetMapping("/TicTacToeGreeting")
    public String TicTacToeGreetingForm(Model model) {
        model.addAttribute("TicTacToeObject", new TicTacToe());
        return "TicTacToeGreeting";
    }
//this method it will take the body of the request and use it i n the return SITE and that OBJECT will be called
// ticTacToe NOT TicTacToe, However we modified the Objected to be called>> lol<<
    @PostMapping("/TicTacToeGreeting")
    public String TicTacToeGreetingSubmit(@ModelAttribute("lol") TicTacToe TicTacToeGreeting) {
        return "result";
    }

    // this method will connect to the repo and return the value as json that by support of @RequestMapping
    //we will call TicInfo and pass id to get the Tic value from the repo

    @Autowired
    TicTacToeRepository Ticrepo;

    @RequestMapping("TicInfo/{id}")
    public @ResponseBody TicTacToe TicTacToeREPOJson(@PathVariable int id)
    {
        return Ticrepo.findById(id);
    }


    //this method will call a template with an object that will be stored in TicTacToe Repo by POST METHOD
    // tactics:
    // 1- first call to addTicTacToe will invoke tictactoeForm.html and that will get the values from the site and
    //      use addTicTacToe post method to invoke the @PostMapping and there we save that Object into the repo
    @GetMapping("/addtictactoe")
    public String addTictacToe(Model model) {
        //buddyInfo will be looked at in the templates and see if it matches th:object="${buddyInfo}"
        model.addAttribute("tictactoe",new TicTacToe());
        return "tictactoeForm";

    }

    @PostMapping("/addtictactoe")
    public @ResponseBody String newTicTacToe(@ModelAttribute TicTacToe tictac) {
        Ticrepo.save(tictac);
        return tictac.toString();
    }


}

