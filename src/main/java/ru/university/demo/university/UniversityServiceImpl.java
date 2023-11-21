package ru.university.demo.university;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.university.demo.university.dto.CreateUniversityDTO;
import ru.university.demo.university.dto.UpdateUniversityDTO;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UniversityServiceImpl implements UniversityService {
  private final UniversityRepository repository;

  @Override
  public List<UniversityModel> getUniversityList() {
    return repository.findAll();
  };

  @Override
  public Optional<UniversityModel> getUniversity(Long id) {
    return repository.findById(id);
  };

  @Override
  public UniversityModel createUniversity(CreateUniversityDTO dto) {
    UniversityModel model = new UniversityModel();
    model.setName(dto.name());
    model.setFoundationDate(dto.foundationDate());

    return repository.save(model);
  };

  @Override
  public UniversityModel updateUniversity(Long id, UpdateUniversityDTO dto) {
    UniversityModel existingUniversity = repository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("University not found with id: " + id));

    existingUniversity.setName(dto.newName());

    return repository.save(existingUniversity);
  };

  @Override
  public void deleteUniversity(Long id) {
    repository.deleteById(id);
  };
}
