package br.com.bernardo.projeto_integrador_ii.entity;

import br.com.bernardo.projeto_integrador_ii.dto.PerfilUsuarioDTO;
import org.springframework.beans.BeanUtils;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "NPL_PERFIL_USUARIO")
@Getter
@Setter
@NoArgsConstructor
public class PerfilUsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private UsuarioEntity usuario;
	
	@ManyToOne
	@JoinColumn(name = "ID_PERFIL")
	private PerfilEntity perfil;
	
	public PerfilUsuarioEntity(PerfilUsuarioDTO perfilUsuario) {

	}
	
}
