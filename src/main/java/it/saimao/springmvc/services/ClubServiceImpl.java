package it.saimao.springmvc.services;

import it.saimao.springmvc.dto.ClubDto;
import it.saimao.springmvc.mappers.ClubMapper;
import it.saimao.springmvc.models.Club;
import it.saimao.springmvc.repositories.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;
    private final ClubMapper clubMapper;

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map(clubMapper::clubToClubDto).toList();
    }

    @Override
    public ClubDto save(ClubDto club) {
        Club savedClub = clubRepository.save(clubMapper.clubDtoToClub(club));
        return clubMapper.clubToClubDto(savedClub);
    }

    @Override
    public ClubDto findById(Long id) {
        Club club = clubRepository.findById(id).get();
        ClubDto clubDto = clubMapper.clubToClubDto(club);
        return clubDto;
    }
}
