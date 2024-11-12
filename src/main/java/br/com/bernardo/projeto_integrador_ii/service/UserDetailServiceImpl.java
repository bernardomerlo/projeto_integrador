package br.com.bernardo.projeto_integrador_ii.service;

import br.com.bernardo.projeto_integrador_ii.entity.UsuarioEntity;
import br.com.bernardo.projeto_integrador_ii.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class UserDetailServiceImpl implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity usuario = usuarioRepository.findByLogin(username).get();
        return UserDetailsImpl.build(usuario);
    }

}
