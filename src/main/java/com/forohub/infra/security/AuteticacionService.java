package com.forohub.infra.security;

import com.forohub.infra.security.usuario.UsuarioRepository;
import com.forohub.infra.security.usuario.DatosRegistroUsuario;
import com.forohub.infra.security.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuteticacionService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuteticacionService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder){
        this.usuarioRepository=usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario registrarUsuario(DatosRegistroUsuario datosRegistroUsuario){
        var password = passwordEncoder.encode(datosRegistroUsuario.clave());
        var usuario = new Usuario(datosRegistroUsuario,password);
        usuarioRepository.save(usuario);
        return usuario;
    }
}
