package com.teste.converter;

/*
@Converter
public class ListConverter implements AttributeConverter<List<String>, String> {

    private static final String SPLIT = ";";


    @Override
    public String convertToDatabaseColumn(List<String> list){
        return CollectionUtils.isNotEmpty(list) ? String.join(SPLIT,list) : "";
    }

    @Override
    public List<String> convertToEntityAttribute(String string){
        return StringUtils.isNotBlank(string) ? Arrays.asList(string.split(SPLIT)) : emptyList();
    }

} */