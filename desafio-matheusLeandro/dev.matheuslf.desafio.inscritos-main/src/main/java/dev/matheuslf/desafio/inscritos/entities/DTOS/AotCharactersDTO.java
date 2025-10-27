package dev.matheuslf.desafio.inscritos.entities.DTOS;

public record AotCharactersDTO(String name, String gender, String age, String height, String status) {
    public AotCharactersDTO(AotCharactersDTO aotCharactersDTO) {
        this(
                aotCharactersDTO.name(), aotCharactersDTO.gender(), aotCharactersDTO.age(), aotCharactersDTO.height(), aotCharactersDTO.status()
        );
    }
}
