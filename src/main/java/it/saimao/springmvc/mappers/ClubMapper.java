package it.saimao.springmvc.mappers;

import it.saimao.springmvc.dto.ClubDto;
import it.saimao.springmvc.models.Club;
import org.mapstruct.Mapper;

@Mapper
public interface ClubMapper {
    Club clubDtoToClub(ClubDto clubDto);
    ClubDto clubToClubDto(Club club);
}
