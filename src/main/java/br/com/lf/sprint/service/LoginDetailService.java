package br.com.lf.sprint.service;

import br.com.lf.sprint.model.Login;
import br.com.lf.sprint.repository.LoginRepository;
import br.com.lf.sprint.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LoginDetailService implements UserDetailsService {
    private final LoginRepository loginRepository; //Para fazer a busca do usuário no banco

    @Autowired
    public LoginDetailService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override //Verifica se o usuário existe e qual seu nível de permissão
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = Optional.ofNullable(loginRepository.findByUsername(username))
                .orElseThrow(()->new UsernameNotFoundException(Messages.USER_NOT_FOUND_PT.getMessage()));

        List<GrantedAuthority> authorityAdmin = AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");
        List<GrantedAuthority> authorityUser = AuthorityUtils.createAuthorityList("ROLE_USER");
        return new User(login.getUsername(),
                        login.getPassword(),
                        login.isAdmin() ? authorityAdmin : authorityUser);
    }
}
