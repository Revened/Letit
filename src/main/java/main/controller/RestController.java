package main.controller;

import main.dto.PanelDTO;
import main.service.factory.PanelFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RestController {
    @Autowired
    PanelFactory panelFactory;
    @GetMapping("/all")
    public PanelDTO showAll() {
        return new PanelDTO();
    }
    @GetMapping("/test")
    public PanelDTO test() {
        panelFactory.init();
        return new PanelDTO();
    }

    @PostMapping("/all")
    public PanelDTO add() {
        return new PanelDTO();
    }
}
