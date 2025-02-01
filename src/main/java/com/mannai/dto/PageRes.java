package com.mannai.dto;

import lombok.Builder;

import java.util.Collection;


@Builder
public record PageRes<T>(Collection<T> content, Long totalElements, Integer totalPages, Integer number) {
}
