package ru.university.demo.business.university;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.university.demo.business.university.dto.CreateUniversityDTO;
import ru.university.demo.business.university.dto.UpdateUniversityDTO;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UniversityServiceImpl implements UniversityService {
  private final UniversityRepository repository;

  @Override
  public Page<UniversityModel> getUniversityList(Pageable pageable) {
    return repository.findAll(pageable);
  };

  @Override
  public Optional<UniversityModel> getUniversity(Long id) {
    return repository.findById(id);
  };

  @Override
  public UniversityModel createUniversity(CreateUniversityDTO dto) {
    UniversityModel model = new UniversityModel();
    model.setName(dto.getName());
    model.setFoundationDate(dto.getFoundationDate());

    return repository.save(model);
  };

  @Override
  public UniversityModel updateUniversity(Long id, UpdateUniversityDTO dto) {
    UniversityModel existingUniversity = repository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("University not found with id: " + id));

    existingUniversity.setName(dto.getNewName());

    return repository.save(existingUniversity);
  };

  @Override
  public void deleteUniversity(Long id) {
    repository.deleteById(id);
  };
}
