package ru.university.demo.business.university;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import ru.university.demo.business.university.dto.CreateUniversityDTO;
import ru.university.demo.business.university.dto.UpdateUniversityDTO;

import java.util.List;
import java.util.Optional;

// swagger

@RestController
@AllArgsConstructor
@RequestMapping("/universities")
public class UniversityController {
  private final UniversityService service;

  @GetMapping()
  Page<UniversityModel> getUniversityList(
    @RequestParam(value = "page", defaultValue = "1") @Min(1) Integer page,
    @RequestParam(value = "limit", defaultValue = "10") @Min(1) @Max(100) Integer limit,
    @RequestParam(value = "sort", defaultValue = "ID_ASC") UniversitySort sort
  ) {
    return service.getUniversityList(PageRequest.of(page - 1, limit, sort.getSortValue()));
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
