package org.todo.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.todo.api.model.Todo;
import org.todo.api.payload.TodoRequest;
import org.todo.api.payload.TodoResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TodoMapper {

    Todo toEntity(TodoRequest todoRequest);

    @Mapping(target = "id", source = "id") // For some reason, id doesn't map without this???????????? literally why.
    @Mapping(target = "title", source = "title")
    TodoResponse toResponse(Todo todo);
}
