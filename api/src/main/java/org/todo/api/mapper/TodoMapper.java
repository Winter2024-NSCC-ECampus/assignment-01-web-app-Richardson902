package org.todo.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.todo.api.model.Todo;
import org.todo.api.payload.TodoDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TodoMapper {

    TodoDto toDto(Todo todo);

    Todo toEntity(TodoDto todoDto);
}
