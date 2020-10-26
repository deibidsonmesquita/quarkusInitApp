
package org.acme.commandmode.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author deibi
 */

@Entity
public class Produto extends PanacheEntity{
    private String nome;
    private BigDecimal valor;
    
    @CreationTimestamp
    private Date criacaoDT;
    
    @CreationTimestamp
    private Date updateDT;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    
}
