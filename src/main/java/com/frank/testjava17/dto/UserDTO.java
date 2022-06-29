package com.frank.testjava17.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "USER")
public class UserDTO {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 100, nullable = true)
    private String lastName;
    @Column(length = 50, nullable = false, unique = true)
    private String nickName;
    @Column(length = 75, nullable = false, unique = true)
    private String email;
    @Column(length = 500, nullable = false)
    private String password;

    //ANOTACIONES
    //@Transient -> indica que el valor no se almacenara en la base de datos, solo existira durante la ejecucion del programa
    //@Embeddable -> permite crear un objeto sin que este sea entidad: clase -> add @emblemeable -> entidad nada ->db crea las columnas correspondientes
    /* RELACIONES
        @OneToOne //un objeto pertenece a un objeto -> un estudiante tiene una laptop ->db se crea en el lado de donde se coloca la etiqueta
        private Object objectName;
        //no se crea tabla
    
        @OneToMany(mappedBy = "objectRef") //Un objeto tiene varios objetos -> un estudiande tiene muchas computadoras  ->db crea una tabla extra para almacenar la informacion
        private List<Object> referenceObjectName = new ArrayList<>();
        @ManyToOne // se crea la referencia en la otra tabla
        private Object objectRef;
        //se crea una tabla
        //una primary key
    
        @ManyToMany(mappedBy = "refObjectSecondName") //muchos objetos contienen muchos objetos -> muchos estudiantes tienen muchas computadoras ->db crea una tabla con el nombre_segundo
        private List<Object> refObjectOneName = new ArrayList<>();
        @ManyToMany //muchos objetos contienen muchos objetos -> muchos estudiantes tienen muchas computadoras ->db crea una tabla con el nombre_primero
        private List<Object> refObjectSecondName = new ArrayList<>();
        //se crean 1 tablas
        //2 primary key
     */
    //constructors
    public UserDTO() {
    }

    public UserDTO(Long id, String name, String lastName, String nickName, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
    }

    //GettersAndSetters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //tostring
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", lastName=" + lastName + ", nickName=" + nickName + ", email=" + email + ", password=" + password + '}';
    }
}
