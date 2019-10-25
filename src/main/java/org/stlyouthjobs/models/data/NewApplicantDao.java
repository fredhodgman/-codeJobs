package org.stlyouthjobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.stlyouthjobs.models.NewApplicant;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface NewApplicantDao extends CrudRepository<NewApplicant, Integer> {
}
