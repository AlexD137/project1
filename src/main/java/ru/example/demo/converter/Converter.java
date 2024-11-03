package ru.example.demo.converter;

public interface Converter<Dto, Model> {
    Dto toDto(Model model);

    Model toModel(Dto dto);
}
