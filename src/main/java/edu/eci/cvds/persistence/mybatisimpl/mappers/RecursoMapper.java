package edu.eci.cvds.persistence.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Recurso;

public interface RecursoMapper {
    public List<Recurso> getRecursosDisponibles(@Param("estado") boolean estado);

    public Recurso getRecurso(@Param("nombre") String nombre);

    public void insertarRecurso(@Param("r") Recurso r);

    public List<Recurso> getRecursosFromTipo(@Param("tipo") String tipo);

    public List<Recurso> getRecursoFromUbicacion(@Param("ubicacion") String ubicacion);

    public List<Recurso> getRecursoFromCapacidad(@Param("ubicacion") int ubicacion);
}
