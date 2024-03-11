package dev.vasconcelos.contaskapi.v1.organization.dtos;

import dev.vasconcelos.contaskapi.v1.organization.Organization;

public record OrganizationRequestDTO(Long id, String name, String email, String phoneNumber, String cnpj, String imageUrl) {
    public OrganizationRequestDTO(Organization organization) {
        this(
            organization.getId(), 
            organization.getName(), 
            organization.getEmail(), 
            organization.getPhoneNumber(), 
            organization.getCnpj(), 
            organization.getImageUrl()
        );
    }
}
