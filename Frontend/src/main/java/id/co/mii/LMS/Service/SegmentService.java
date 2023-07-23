package id.co.mii.LMS.Service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import id.co.mii.LMS.Model.Segment;
import id.co.mii.LMS.Utils.BasicHeader;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SegmentService {
    private RestTemplate restTemplate;

    public List<Segment> getAll(Authentication authentication){
        List<Segment> segments = new ArrayList<>();

    if (hasRole(authentication, "ROLE_LECTURE")) {
        segments = restTemplate.exchange(
                "http://localhost:8080/segment",
                HttpMethod.GET,
                new HttpEntity(BasicHeader.getHeader()),
                new ParameterizedTypeReference<List<Segment>>() {}
        ).getBody();
    } else if (hasRole(authentication, "ROLE_STUDENT")) {
        segments = restTemplate.exchange(
                "http://localhost:8080/segment/student",
                HttpMethod.GET,
                new HttpEntity(BasicHeader.getHeader()),
                new ParameterizedTypeReference<List<Segment>>() {}
        ).getBody();
    }

    return segments;
    }

    private boolean hasRole(Authentication authentication, String roleName) {
    if (authentication != null) {
        // Mendapatkan informasi peran dari autentikasi pengguna
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // Mencetak peran yang dimiliki oleh pengguna
        System.out.println("User Roles: " + authorities);

        // Memeriksa apakah pengguna memiliki peran yang diberikan
        return authorities.stream()
                .anyMatch(authority -> authority.getAuthority().equals(roleName));
    }
    return false;
}

}
