package guru.springframework.spring5jokesappv2.controllers;

import guru.springframework.spring5jokesappv2.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The constructor will initialize the joke service
 * We used an interface for the JokeService for Dependency Injection
 */
@Controller
public class JokeController {
    private final JokeService jokeService; // Cannot be changed

    // No real need in this case for @Autowired as there is only one controller.
    // We know that Spring will do it automatically
    @Autowired // Spring will automatically inject the JokeController
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    /**
     * Passing the model
     */
    @RequestMapping({"/", ""})
    public String showJoke(Model model){
        // model is a map implementation
        // Addin a property with the string "joke", and then the joke String so that we can reference it
        model.addAttribute("joke", jokeService.getJoke());

        return "index"; // tells Spring MVC that we want to do the index view from template folder in /resources
    }
}
