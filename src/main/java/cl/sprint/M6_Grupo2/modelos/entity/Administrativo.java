package cl.sprint.M6_Grupo2.modelos.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="administrativo")
@PrimaryKeyJoinColumn(name = "id")
public class Administrativo extends Usuario {

	@Column(name="nombre_a")
	private String nombreAdmin;
	private String area;
	@Column(name="experiencia_previa")
	private String experienciaPrevia;

	public Administrativo() {
		super();
	}
	
	public Administrativo(int id, String nombreUsuario, String contraseña, RolUsuario tipo) {
		super(id,nombreUsuario,contraseña,tipo);
	}
	
	public Administrativo(int id, String nombreUsuario,String nombreAdmin, String area, String experienciaPrevia) {
		super(id,nombreUsuario);
		this.nombreAdmin= nombreAdmin;
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
		
	}


	public Administrativo(int id, String nombreUsuario,String contraseña,String nombreAdmin, String area, String experienciaPrevia) {
		super(id, nombreUsuario,contraseña, RolUsuario.Administrativo);
		this.nombreAdmin= nombreAdmin;
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
	}
	
	
	
	public String getNombreAdmin() {
		return nombreAdmin;
	}

	public void setNombreAdmin(String nombre) {
		this.nombreAdmin = nombre;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getExperienciaPrevia() {
		return experienciaPrevia;
	}

	public void setExperienciaPrevia(String experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
	}

	@Override
	public String toString() {
		return super.toString() +" [nombre=" + nombreAdmin + ", area=" + area + ", experienciaPrevia=" + experienciaPrevia + "]";
	}

}
