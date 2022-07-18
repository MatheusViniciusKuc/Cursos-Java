package service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

public class BonusServiceTest {

    @Test
    public void bonusDeveriaSerZeroComSalarioAlto() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Carlos", LocalDate.now(), new BigDecimal("25000")));

        assertEquals(BigDecimal.ZERO, bonus);
    }

    @Test
    public void bonusDeveriaSer10PorcentoComSalarioAlto() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Carlos", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.0"), bonus);
    }

    @Test
    public void bonusDeveriaSerComSalariomilzao() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Carlos", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.0"), bonus);
    }
}
