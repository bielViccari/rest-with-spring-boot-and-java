package com.gabriel.mapper;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por fornecer métodos para mapeamento de objetos utilizando o ModelMapper.
 */
public class DozerMapper {
    private static ModelMapper mapper = new ModelMapper();


    /**
     * Método para mapear um objeto de origem para um objeto de destino.
     * @param origin Objeto de origem a ser mapeado.
     * @param destination Classe de destino para o mapeamento.
     * @param <O> Tipo do objeto de origem.
     * @param <D> Tipo do objeto de destino.
     * @return Objeto de destino mapeado.
     */
    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }


    /**
     * Método para mapear uma lista de objetos de origem para uma lista de objetos de destino.
     * @param origin Lista de objetos de origem a serem mapeados.
     * @param destination Classe de destino para o mapeamento.
     * @param <O> Tipo dos objetos de origem.
     * @param <D> Tipo dos objetos de destino.
     * @return Lista de objetos de destino mapeados.
     */
    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
        List<D> destinationObjects = new ArrayList<D>(); // Cria uma lista para armazenar os objetos de destino mapeados.
        for (O o : origin) {
            destinationObjects.add(mapper.map(o, destination)); // Mapeia cada objeto de origem e o adiciona à lista de destino.
        }
        return destinationObjects;
    }

}
