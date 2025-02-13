package org.todo.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.todo.api.model.Todo;
import org.todo.api.payload.TodoRequest;
import org.todo.api.payload.TodoResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TodoMapper {
    Todo toEntity(TodoRequest todoRequest);
    TodoResponse toResponse(Todo todo);
}
