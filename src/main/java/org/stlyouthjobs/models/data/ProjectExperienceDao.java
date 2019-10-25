package org.stlyouthjobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.stlyouthjobs.models.ProjectExperience;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ProjectExperienceDao extends CrudRepository<ProjectExperience, Integer> {
}
