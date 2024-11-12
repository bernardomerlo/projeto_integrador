package br.com.bernardo.projeto_integrador_ii.entity;

import br.com.bernardo.projeto_integrador_ii.dto.PermissaoPerfilRecursoDTO;
import org.springframework.beans.BeanUtils;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "NPL_PERMISSAO_PERFIL_RECURSO")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PermissaoPerfilRecursoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_PERFIL")
	private PerfilEntity perfil;
	
	@ManyToOne
	@JoinColumn(name = "ID_RECURSO")
	private RecursoEntity recurso;
	
	public PermissaoPerfilRecursoEntity(PermissaoPerfilRecursoDTO permissaoPerfilRecurso) {

		}	
	}

