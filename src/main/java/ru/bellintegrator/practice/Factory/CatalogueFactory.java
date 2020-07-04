package ru.bellintegrator.practice.Factory;

import org.springframework.stereotype.Component;
import ru.bellintegrator.practice.dto.CitizenshipDto;
import ru.bellintegrator.practice.dto.DocumentDto;
import ru.bellintegrator.practice.model.Citizenship;
import ru.bellintegrator.practice.model.Document;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CatalogueFactory {

    public static DocumentDto convert(Document obj) {
        return DocumentDto.builder()
                .name(obj.getName())
                .code(obj.getCode())
                .build();
    }

    public static CitizenshipDto convert(Citizenship obj) {
        return CitizenshipDto.builder()
                .name(obj.getName())
                .code(obj.getCode())
                .build();
    }

    public List<DocumentDto> convertAllDocs(List<Document> list) {
        return list.stream().map(CatalogueFactory::convert).collect(Collectors.toList());
    }

    public List<CitizenshipDto> convertAllCitips(List<Citizenship> list) {
        return list.stream().map(CatalogueFactory::convert).collect(Collectors.toList());
    }

}
