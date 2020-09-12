package com.example.apiGarbageSimulation.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {

	 private static final long serialVersionUID = 1L;
	    @Id
	    @Basic(optional = false)
	    @Column(name = "id")
	    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	    //@SequenceGenerator(name = "sequenceGenerator")
	    private Integer id;
	    
	    @Size(max = 2147483647)
	    @Column(name = "username")
	    private String username;
	    
	    @Size(max = 2147483647)
	    @Column(name = "password")
	    private String password;
	    
	    private String token;
	    
	    public Usuario(){
	    	
	    }

		public Usuario(Integer id) {
			this.id = id;
		}



		public Usuario(Integer id, @Size(max = 2147483647) String username, @Size(max = 2147483647) String password) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		
		
		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		@Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (id != null ? id.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Usuario)) {
	            return false;
	        }
	        Usuario other = (Usuario) object;
	        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	            return false;
	        }
	        return true;
	    }

		@Override
		public String toString() {
			return "com.example.apiGarbageSimulation.entities.Usuario [id=" + id + "]";
		}
}
