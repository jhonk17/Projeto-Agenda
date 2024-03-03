package Agenda.api.corretor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//Erdando a interface do JPA Repository
public interface CorretorRepository extends JpaRepository<Corretor, Long> {
    Page<Corretor> findAllByAtivoTrue(Pageable paginacao);
}
