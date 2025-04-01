package br.com.fiap.apisecurity.controller;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return ResponseEntity.ok(usuarios);
    }
}