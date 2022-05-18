package edu.eci.cvds;

import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.services.ProyectoServices;
import edu.eci.cvds.services.ProyectoServicesFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProyectoTest {

    ProyectoServices serviciosProyecto;
    ProyectoServices serviciosProyectoTest;

    public ProyectoTest() {
        serviciosProyecto = ProyectoServicesFactory.getInstance().getServiciosProyecto();
        serviciosProyectoTest = ProyectoServicesFactory.getInstance().getServiciosProyectoTesting();
    }

    @Before
    public void setUp() {
        serviciosProyecto = ProyectoServicesFactory.getInstance().getServiciosProyecto();
        serviciosProyectoTest = ProyectoServicesFactory.getInstance().getServiciosProyectoTesting();
    }

    @Test
    public void deberiaEncontrarRol() {
        try {
            Assert.assertEquals("Administrador", serviciosProyecto.getRol(1));
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void deberiaEncontrarRecurso() {
        try {
            Assert.assertEquals("Asus", serviciosProyecto.getRecurso("Asus").getNombre());
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void deberiaEncontrarUsuRecuRese() {
        try {
            Assert.assertEquals("Asus", serviciosProyecto.getUsuRecuRese(2).getNombreRecurso());
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void deberiaEncontrarRecursos() {
        try {
            Assert.assertTrue(serviciosProyecto.getRecursosDisponibles().size() > 0);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void deberiaEncontrarHorario() {
        try {
            Assert.assertEquals(1, serviciosProyecto.getHorariosDisponibles(1).size());
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void deberiaEncontrarReservaPorId() {
        try {
            Assert.assertEquals(2, serviciosProyecto.getReservaPorId(2).getId());
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void deberiaEncontrarReservas() {
        try {
            Assert.assertTrue(serviciosProyecto.getReservas().size() > 0);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void deberiaEncontrarReservaIdRecurso() {
        try {
            Assert.assertTrue(serviciosProyecto.getReservasRecurso(1).size() > 0);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void deberiaEncontrarReservaIdUsuario() {
        try {
            Assert.assertTrue(serviciosProyecto.getReservasUsuario(2).size() > 0);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void deberiaEncontrarTodosLosRecursos() {
        try {
            Assert.assertTrue(serviciosProyecto.getRecursos().size() > 0);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void deberiaEncontrarHorarioPorIds() {
        try {
            Horario horario = serviciosProyecto.getHorarioDia(1, 1);
            Assert.assertEquals(7, horario.getDesde().toLocalTime().getHour());
            Assert.assertEquals(19, horario.getHasta().toLocalTime().getHour());
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }
}