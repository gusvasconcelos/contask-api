package dev.vasconcelos.contaskapi.v1.organization;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.vasconcelos.contaskapi.v1.organization.dtos.OrganizationRequestDTO;
import dev.vasconcelos.contaskapi.v1.organization.dtos.OrganizationResponseDTO;

@RestController
@RequestMapping("/api/v1/organizations")
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping
    public List<OrganizationResponseDTO> findAll() {
        return organizationService.findAll();
    }

    @GetMapping(value = "/{id}")
    public OrganizationResponseDTO findById(Long id) {
        return organizationService.findById(id);
    }

    @PostMapping
    public OrganizationRequestDTO save(@RequestBody Organization organization) {
        return organizationService.save(organization);
    }

    @PutMapping(value = "/{id}")
    public OrganizationRequestDTO update(@PathVariable("id") Long id, @RequestBody Organization organization) {
        return organizationService.update(id, organization);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        organizationService.delete(id);
    }
}
