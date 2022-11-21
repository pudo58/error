package com.insmart.app.service;

import com.insmart.app.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.insmart.app.model.Organization;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    public Organization save(Organization organization) {
        return organizationRepository.save(organization);
    }
    public Organization findById(Long id) {
        return organizationRepository.findById(id).get();
    }
    public void deleteById(Long id) {
        organizationRepository.deleteById(id);
    }
    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }
    public Organization update(Organization organization,Long id) {
        Organization organization1 = organizationRepository.findById(id).get();
        organization1.setName(organization.getName());
        organization1.setCode(organization.getCode());
        organization1.setDescription(organization.getDescription());
        return organizationRepository.save(organization);
    }
}
