package it.saimao.springmvc.services;

import it.saimao.springmvc.dto.ClubDto;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
}
