package io.movietracker.core.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SuppressWarnings("unused")
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
