package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ahmadholpa on 2/9/2017.
 */



/*
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
    d.
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


    @GetMapping("/addtictactoe")
    public String addTicTacToe(Model model) {
        //attach the object with the model to be used on the .html
        model.addAttribute("TicTacToeInstance",new TicTacToe());
        return "addtictactoe";

    }
}

