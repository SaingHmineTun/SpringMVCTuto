package it.saimao.springmvc.controllers;

import it.saimao.springmvc.dto.ClubDto;
import it.saimao.springmvc.models.Club;
import it.saimao.springmvc.services.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/clubs")
public class ClubController {
    private final ClubService clubService;

    @GetMapping
    public String listClubs(Model model) {
        List<ClubDto> clubDtos = clubService.findAllClubs();
        model.addAttribute("clubs", clubDtos);
        return "clubs-list";
    }

    @GetMapping("/new")
    public String createClubForm(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";
    }
}
