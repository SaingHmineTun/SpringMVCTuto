package it.saimao.springmvc.services;

import it.saimao.springmvc.dto.ClubDto;
import it.saimao.springmvc.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();

    ClubDto save(ClubDto club);

    ClubDto findById(Long id);
}
