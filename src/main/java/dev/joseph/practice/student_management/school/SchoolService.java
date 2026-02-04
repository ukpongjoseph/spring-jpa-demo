package dev.joseph.practice.student_management.school;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SchoolService {
    
    private SchoolRepository repository;
    private SchoolMapper mapper;

    public SchoolService(SchoolRepository repository, SchoolMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public SchoolResponseDto createSchool(SchoolDto dto){
        School receivedSchool = mapper.dtoToSchool(dto);
        School createdSchool = repository.save(receivedSchool);
        SchoolResponseDto returnSchool = mapper.schoolToSchoolResponseDto(createdSchool);
        return returnSchool;
    }

    public List<SchoolResponseDto> getAllSchools(){
        return repository
            .findAll()
            .stream()
            .map((item)->mapper.schoolToSchoolResponseDto(item))
            .collect(Collectors.toList());
    }

    // This function is to update a school. First we need to find the school. After finding the school we will edit its details with what we have in the request body. save this updated version and send it as response as a schoolRespnseDto with th aid of the mapper.
    public SchoolResponseDto updateASchool(SchoolDto dto, Integer Id){
        School foundSchool = repository.findById(Id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "School not found"));
        foundSchool.setId(Id);
        foundSchool.setName(dto.name());
        School updatedSchool = repository.save(foundSchool);
        SchoolResponseDto schoolResponseDto = mapper.schoolToSchoolResponseDto(updatedSchool);
        return schoolResponseDto;
    }

    public SchoolResponseDto getASchool(Integer id){
        return mapper.schoolToSchoolResponseDto(repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "School not found")));
    }

    public void deleteAchool(Integer id){
        repository.deleteById(id);
    }

}
