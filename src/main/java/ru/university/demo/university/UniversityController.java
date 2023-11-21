package ru.university.demo.university;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.university.demo.university.dto.CreateUniversityDTO;
import ru.university.demo.university.dto.UpdateUniversityDTO;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/universities")
public class UniversityController {
  private final UniversityService service;

  @GetMapping()
  List<UniversityModel> getUniversityList() {
    return service.getUniversityList();
  }

  @GetMapping("/{id}")
  Optional<UniversityModel> getUniversity(@PathVariable Long id) {
    return service.getUniversity(id);
  }

  @PostMapping()
  UniversityModel createUniversity(@Valid @RequestBody CreateUniversityDTO dto) {
    return service.createUniversity(dto);
  }

  @PatchMapping("/{id}")
  UniversityModel updateUniversity(@PathVariable Long id, @Valid @RequestBody UpdateUniversityDTO dto) {
    return service.updateUniversity(id, dto);
  }

  @DeleteMapping("/{id}")
  void deleteUniversity(@PathVariable Long id) {
    service.deleteUniversity(id);
  }
}
