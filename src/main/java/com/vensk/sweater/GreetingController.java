package com.vensk.sweater;

import com.vensk.sweater.domain.Message;
import com.vensk.sweater.repos.MessageRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessageRepos messageRepos;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String,Object> model
    )
    {

        model.put("name", name);
        return "greeting";
    }
    @GetMapping
    public String main(Map<String,Object> model){
        Iterable<Message> messages = messageRepos.findAll();

        model.put("massages",messages);
        return "main";
    }
    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag,Map<String, Object> model){
        Message message =  new Message(text, tag);
        messageRepos.save(message);

        Iterable<Message> messages = messageRepos.findAll();

        model.put("massages",messages);

        return "main";
    }

}