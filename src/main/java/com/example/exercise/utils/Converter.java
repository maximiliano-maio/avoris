package com.example.exercise.utils;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Converter<T, U> {

    private final Function<T, U> fromDto;
    private final Function<U, T> fromEntity;
  
    public Converter(final Function<T, U> fromDto, final Function<U, T> fromEntity) {
      this.fromDto = fromDto;
      this.fromEntity = fromEntity;
    }
  
    public final U convertFromDto(final T model) {
      return fromDto.apply(model);
    }
  
    public final T convertFromEntity(final U entity) {
      return fromEntity.apply(entity);
    }
  
    public final List<U> createFromDto(final Collection<T> dtos) {
      return dtos.stream().map(this::convertFromDto).collect(Collectors.toList());
    }
  
    public final List<T> createFromEntities(final Collection<U> entities) {
      return entities.stream().map(this::convertFromEntity).collect(Collectors.toList());
    }
  }
  