package com.grupo_1.grupo_1.Modelo;

        import jakarta.persistence.*;
        import lombok.Getter;
        import lombok.Setter;


@Entity
@Getter
@Setter
public class EntidadBancaria {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    
    private String direccion;
    private int nroSucursal;
    private String razonSocial;
   
   @OneToOne
    private CuentaBancaria cuentaBancaria;

    public EntidadBancaria() {
    }

    public EntidadBancaria(Long id, String direccion, int nroSucursal, String razonSocial, CuentaBancaria cuentaBancaria) {
        this.id = id;
        this.direccion = direccion;
        this.nroSucursal = nroSucursal;
        this.razonSocial = razonSocial;
        this.cuentaBancaria = cuentaBancaria;
    }
   

}
