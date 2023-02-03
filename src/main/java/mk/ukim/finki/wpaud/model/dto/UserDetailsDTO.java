package mk.ukim.finki.wpaud.model.dto;

import lombok.Data;
import mk.ukim.finki.wpaud.model.Role;
import mk.ukim.finki.wpaud.model.User;

@Data
public class UserDetailsDTO
{
    private String username;
    private Role role;

    public static UserDetailsDTO of(User user)
    {
        UserDetailsDTO detailsDTO = new UserDetailsDTO();
        detailsDTO.username = user.getUsername();
        detailsDTO.role = user.getRole();
        return detailsDTO;
    }
}
