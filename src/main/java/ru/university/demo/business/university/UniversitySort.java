package ru.university.demo.business.university;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;

@Getter
@RequiredArgsConstructor
public enum UniversitySort {
  ID_ASC(Sort.by(Sort.Direction.ASC, "id")),
  ID_DESC(Sort.by(Sort.Direction.DESC, "id")),
  DATE_ASC(Sort.by(Sort.Direction.ASC, "foundationDate")),
  DATE_DESC(Sort.by(Sort.Direction.DESC, "foundationDate"));

  private final Sort sortValue;
}
