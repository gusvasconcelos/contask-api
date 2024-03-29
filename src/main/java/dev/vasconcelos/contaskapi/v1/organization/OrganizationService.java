package dev.vasconcelos.contaskapi.v1.organization;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import dev.vasconcelos.contaskapi.v1.organization.dtos.OrganizationRequestDTO;
import dev.vasconcelos.contaskapi.v1.organization.dtos.OrganizationResponseDTO;

@Service
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public List<OrganizationResponseDTO> findAll() {
        return organizationRepository.findAll().stream().map(OrganizationResponseDTO::new).collect(Collectors.toList());
    }

    public Organization findById(Long id) {
        return organizationRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Organization not found with id " + id));
    }

    public OrganizationRequestDTO save(Organization organization) {
        return new OrganizationRequestDTO(organizationRepository.save(organization));
    }

    public OrganizationRequestDTO update(Long id, Organization organization) {
        return organizationRepository.findById(id)
            .map(entity -> {
            entity.setName(organization.getName());
            entity.setEmail(organization.getEmail());
            entity.setPhoneNumber(organization.getPhoneNumber());
            entity.setCnpj(organization.getCnpj());
            entity.setImageUrl(organization.getImageUrl());
            return new OrganizationRequestDTO(organizationRepository.save(entity));
            })
            .orElseThrow(() -> new ResourceNotFoundException("Organization not found with id " + id));
    }

    public void delete(Long id) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organization not found with id " + id));
        organizationRepository.delete(organization);
    }
}
