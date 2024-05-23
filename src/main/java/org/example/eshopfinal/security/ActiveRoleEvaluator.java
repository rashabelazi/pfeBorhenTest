package org.example.eshopfinal.security;

import org.example.eshopfinal.service.impl.RoleService;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ActiveRoleEvaluator implements PermissionEvaluator {

    private final RoleService roleService;

    public ActiveRoleEvaluator(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        String[] roles = (String[]) permission;
        for (String role : roles) {
            if (hasRole(authentication, role) && roleService.isRoleActive(role)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }

    private boolean hasRole(Authentication authentication, String roleName) {
        return authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(roleName));
    }
}