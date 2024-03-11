package dev.vasconcelos.contaskapi.v1.organization.dtos;

import dev.vasconcelos.contaskapi.v1.organization.Organization;

public record OrganizationResponseDTO(Long id, String name, String cnpj, String image_url) {
    public OrganizationResponseDTO(Organization organization) {
        this(organization.getId(), organization.getName(), organization.getCnpj(), organization.getImageUrl());
    }   
}