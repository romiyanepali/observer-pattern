package be.ucll.craftmanship.DDDDemo.library.catalog.copies.infrastructure;

import be.ucll.craftmanship.DDDDemo.library.catalog.copies.domain.Copy;
import be.ucll.craftmanship.DDDDemo.library.catalog.copies.domain.CopyId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CopyRepository extends JpaRepository<Copy, CopyId> {
}
