package it.saimao.springmvc.controllers;

import it.saimao.springmvc.dto.ClubDto;
import it.saimao.springmvc.services.ClubService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        ClubDto club = new ClubDto();
        model.addAttribute("club", club);
        return "clubs-create";
    }

    @PostMapping("/new")
    public String saveClub(@ModelAttribute @Valid ClubDto clubDto, BindingResult bindingResult) {

        clubService.save(clubDto);
        return "redirect:/clubs";
    }

    @GetMapping("/{clubId}/edit")
    public String edit(@PathVariable("clubId") Long id, Model model) {
        ClubDto clubDto = clubService.findById(id);
        model.addAttribute("club", clubDto);
        return "clubs-edit";
    }

    @PostMapping("/{clubId}/edit")
    public String updateClub(@PathVariable Long clubId, @ModelAttribute @Valid ClubDto clubDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "clubs-edit";
        }

        clubDto.setId(clubId);
        clubService.updateClub(clubDto);
        return "redirect:/clubs";

    }

}
