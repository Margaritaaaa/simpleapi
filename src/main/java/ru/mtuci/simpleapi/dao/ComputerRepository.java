package ru.mtuci.simpleapi.dao;

import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.mtuci.simpleapi.model.Computers;

@Transactional(readOnly = true) //все необъявленные методы по умолчанию не будут ничего изменять в бд
public interface ComputerRepository extends JpaRepository<Computers, Long> {

    @Transactional //чтобы изменения прошли в бд
    @Modifying
    @Query("DELETE FROM Computers c WHERE c.id=:id")
    int delete(@Param("id") Long id);

}
